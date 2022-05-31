package com.pro100user.travelagencybackend.service;

import com.pro100user.travelagencybackend.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HotelService {

    HotelDTO create(HotelCreateDTO dto);
    HotelDTO getById(Long hotelId);
    HotelDTO update(HotelUpdateDTO dto);
    boolean delete(Long hotelId);
    List<HotelDTO> getAll();

    HotelDTO setImage(MultipartFile file, Long hotelId);
    List<RoomDTO> rooms(Long hotelId);
}
