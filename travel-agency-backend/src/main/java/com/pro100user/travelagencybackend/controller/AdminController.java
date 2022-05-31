package com.pro100user.travelagencybackend.controller;

import com.pro100user.travelagencybackend.dto.HotelDTO;
import com.pro100user.travelagencybackend.dto.RoomDTO;
import com.pro100user.travelagencybackend.dto.UserCreateDTO;
import com.pro100user.travelagencybackend.dto.UserDTO;
import com.pro100user.travelagencybackend.service.HotelService;
import com.pro100user.travelagencybackend.service.RoomService;
import com.pro100user.travelagencybackend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("admin")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminController {

    private final UserService userService;
    private final HotelService hotelService;
    private final RoomService roomService;

    @GetMapping("users")
    public List<UserDTO> users() {
        return userService.getAll();
    }

    @GetMapping("hotels")
    public List<HotelDTO> hotels() {
        return hotelService.getAll();
    }

    @GetMapping("rooms")
    public List<RoomDTO> rooms() {
        return roomService.getAll();
    }
}
