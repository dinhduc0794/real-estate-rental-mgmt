package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentCustomerDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.CustomerService;
import com.javaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerAPI {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;

    @PostMapping
    private ResponseEntity<?> createOrUpdateCustomer(@Valid @RequestBody CustomerDTO customerDTO,
                                                     BindingResult bindingResult) {
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            if (bindingResult.hasErrors()) {
                List<String> errorMessages = bindingResult.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.toList());

                responseDTO.setMessage("Validation failed");
                responseDTO.setDetail(errorMessages);
                return ResponseEntity.badRequest().body(responseDTO);
            }
            // neu dung thi //xuong service -> xuong repo -> save vao db
            responseDTO = customerService.createOrUpdate(customerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }
        catch (Exception e){
            responseDTO.setMessage("Internal server error");
            responseDTO.setDetail(Collections.singletonList(e.getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }

    @PostMapping("/{ids}")
    public ResponseDTO turnOffIsActive(@PathVariable List<Long> ids){
        return customerService.turnOffIsActive(ids);
    }

    @DeleteMapping("/{ids}")
    public ResponseEntity<?> deleteCustomer(@PathVariable List<Long> ids){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            if (ids.size() == 0){
                responseDTO.setMessage("No customers to be deleted");
                return ResponseEntity.badRequest().body(responseDTO);
            }

            else {
                customerService.deleteCustomerByIds(ids);
                return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
            }
        }
        catch (Exception e){
            responseDTO.setMessage("Internal server error");
            responseDTO.setDetail(Collections.singletonList(e.getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }

    @GetMapping("/{id}/staffs")
    private ResponseDTO loadStaffs(@PathVariable Long id) {
        ResponseDTO responseDTO = userService.findStaffsByCustomerId(id);
        return responseDTO;
    }

    @PutMapping("/assignment")
    private ResponseEntity<?> updateAssignmentCustomer(@Valid @RequestBody AssignmentCustomerDTO assignmentCustomerDTO,
                                                       BindingResult bindingResult) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            if (bindingResult.hasErrors()) {
                List<String> errorMessages = bindingResult.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.toList());

                responseDTO.setMessage("Validation failed");
                responseDTO.setDetail(errorMessages);
                return ResponseEntity.badRequest().body(responseDTO);
            }
            // neu dung thi //xuong service -> xuong repo -> save vao db
            responseDTO = customerService.updateAssignmentModal(assignmentCustomerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } catch (Exception e) {
            responseDTO.setMessage("Internal server error");
            responseDTO.setDetail(Collections.singletonList(e.getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }
}
