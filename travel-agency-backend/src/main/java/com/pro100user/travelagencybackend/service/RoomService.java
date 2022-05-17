package com.pro100user.travelagencybackend.service;

import com.pro100user.travelagencybackend.dto.*;

import java.util.List;

public interface RoomService {

    RoomDTO create(RoomCreateDTO dto);
    RoomDTO getById(Long roomId);
    RoomDTO update(RoomUpdateDTO dto);
    boolean delete(Long roomId);
    List<RoomDTO> getAll();
}
