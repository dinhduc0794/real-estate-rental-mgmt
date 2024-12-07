package com.javaweb.service;

import com.javaweb.model.dto.PasswordDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.exception.DataNotFoundException;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface UserService {
    ResponseDTO findStaffsByBuildingId(Long buildingId);
    ResponseDTO findStaffsByCustomerId(Long customerId);
    UserDTO findOneByUserNameAndStatus(String name, int status);
    List<UserDTO> getUsers(String searchValue, Pageable pageable);
    int getTotalItems(String searchValue);
    UserDTO findOneByUserName(String userName);
    UserDTO findUserById(long id);
    UserDTO insert(UserDTO userDTO);
    UserDTO update(Long id, UserDTO userDTO);
    void updatePassword(long id, PasswordDTO userDTO) throws DataNotFoundException;
    UserDTO resetPassword(long id);
    UserDTO updateProfileOfUser(String id, UserDTO userDTO);
    void delete(long[] ids);

    Map<Long, String> mapStaff_IdAndUsername();
    List<String> loadStaffsUsername();
//    ResponseDTO listStaff(Long buildingId);
    List<UserDTO> getAllUsers(Pageable pageable);
    int countTotalItems();
}
