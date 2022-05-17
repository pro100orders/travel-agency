package com.pro100user.travelagencybackend.service;

import com.pro100user.travelagencybackend.dto.CityDTO;
import com.pro100user.travelagencybackend.dto.UserCreateDTO;
import com.pro100user.travelagencybackend.dto.UserDTO;
import com.pro100user.travelagencybackend.dto.UserUpdateDTO;
import com.pro100user.travelagencybackend.entity.User;

import java.util.List;

public interface UserService {

    boolean create(UserCreateDTO dto);
    UserDTO getById(Long userId);
    UserDTO update(UserUpdateDTO dto);
    boolean delete(Long userId);
    List<UserDTO> getAll();

    User findByEmail(String email);
    User findByPhone(String phone);
}
