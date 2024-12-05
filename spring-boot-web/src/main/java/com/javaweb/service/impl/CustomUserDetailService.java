package com.javaweb.service.impl;

import com.javaweb.model.dto.MyUserDetail;
import com.javaweb.model.dto.RoleDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDTO userDTO = userService.findOneByUserNameAndStatus(name, 1);  //kiem tra xem co ton tai username hay khong
        if(userDTO == null){
            throw new UsernameNotFoundException("Username not found");  //neu khong ton tai thi throw exception
        }
        //neu ton tai thi lay ra danh sach cac role cua user do
        List<GrantedAuthority> authorities = new ArrayList<>(); //tao ra danh sach cac quyen cua user
        for(RoleDTO role: userDTO.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getCode()));    //ROLE_{STAFF} la quy dinh cua Spring Security 4 tro len
        }
            MyUserDetail myUserDetail = new MyUserDetail(name,userDTO.getPassword(),true,true,true,true,authorities);

        BeanUtils.copyProperties(userDTO, myUserDetail);    //copy cac thuoc tinh tu userDTO sang myUserDetail (id, fullName) de su dung o cac controller khac
        return myUserDetail;
    }
}
