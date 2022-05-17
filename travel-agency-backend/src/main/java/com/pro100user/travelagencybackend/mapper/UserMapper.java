package com.pro100user.travelagencybackend.mapper;

import com.pro100user.travelagencybackend.dto.RoomDTO;
import com.pro100user.travelagencybackend.dto.UserCreateDTO;
import com.pro100user.travelagencybackend.dto.UserDTO;
import com.pro100user.travelagencybackend.dto.UserUpdateDTO;
import com.pro100user.travelagencybackend.entity.Room;
import com.pro100user.travelagencybackend.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User toEntity(UserCreateDTO dto);
    User toEntity(UserUpdateDTO dto);

    UserDTO toUserDTO(User user);
    List<UserDTO> toListUserDTO(List<User> users);
}
