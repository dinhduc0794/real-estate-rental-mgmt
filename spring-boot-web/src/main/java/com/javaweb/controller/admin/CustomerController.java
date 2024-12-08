package com.javaweb.controller.admin;


import com.javaweb.constant.SystemConstant;
import com.javaweb.converter.CustomerConverter;
import com.javaweb.enums.BuildingType;
import com.javaweb.enums.DistrictCode;
import com.javaweb.enums.StatusEnum;
import com.javaweb.enums.TransactionType;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.CustomerService;
import com.javaweb.service.TransactionService;
import com.javaweb.service.UserService;
import com.javaweb.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController(value = "customersControllerOfAdmin")
public class CustomerController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/admin/customer-list")
    public ModelAndView getCustomerList(@ModelAttribute(name = "modelSearch") CustomerSearchRequest params,
                                HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        mav.addObject("statusCode", StatusEnum.type());
        mav.addObject("staffList", userService.mapStaff_IdAndUsername());
        mav.addObject("usernameList", userService.loadUsernames());

        CustomerDTO model = new CustomerDTO();
        DisplayTagUtils.of(request, model);

        // Neu la staff thi chi xem duoc khach hang cua minh quan ly
        if(SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            params.setStaffId(SecurityUtils.getPrincipal().getId());
        }

        List<CustomerDTO> customerDTOS = customerService.findAll(params, PageRequest.of(model.getPage() - 1, model.getMaxPageItems()));
        model.setListResult(customerDTOS);
        model.setTotalItems(customerService.countTotalItems(params));

        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @GetMapping(value = "/admin/customer-edit")
    public ModelAndView addCustomer(@ModelAttribute(name="customerEdit") CustomerDTO customerDTO){
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        mav.addObject("customerEdit", customerDTO);
        mav.addObject("statusCode", StatusEnum.type());
        return mav;
    }
    @GetMapping(value = "/admin/customer-edit-{id}")
    public ModelAndView updateCustomer(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("admin/customer/edit");

        // Neu la staff thi chi xem duoc customer ma minh quan ly
        if (SecurityUtils.getAuthorities().contains(SystemConstant.STAFF_ROLE)) {
            Long staffId = SecurityUtils.getPrincipal().getId();
            if (customerService.isStaffOfCustomer(staffId, id) == false) {
                mav.setViewName("redirect:/error/404");
                return mav;
            }
        }

        mav.addObject("statusCode", StatusEnum.type());
        mav.addObject("transactionType", TransactionType.transactionType());

        CustomerDTO customerDTO = customerService.findByIdAndIsActive(id, 1);
        if (customerDTO == null) {
            mav.setViewName("redirect:/error/404");
            return mav;
        }
        mav.addObject("customerEdit", customerDTO);

        List<TransactionDTO> CSKH_Transactions = transactionService.findAllByCodeAndCustomer("CSKH", id);
        List<TransactionDTO> DDX_Transactions = transactionService.findAllByCodeAndCustomer("DDX", id);
        mav.addObject("CSKH", CSKH_Transactions);
        mav.addObject("DDX", DDX_Transactions);
        return mav;
    }
}
