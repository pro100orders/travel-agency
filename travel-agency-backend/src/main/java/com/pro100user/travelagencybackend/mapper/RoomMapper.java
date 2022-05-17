package com.pro100user.travelagencybackend.mapper;

import com.pro100user.travelagencybackend.dto.*;
import com.pro100user.travelagencybackend.entity.Order;
import com.pro100user.travelagencybackend.entity.Room;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {HotelMapper.class})
public interface RoomMapper {

    Room toEntity(RoomCreateDTO dto);
    Room toEntity(RoomUpdateDTO dto);

    RoomDTO toRoomDTO(Room room);
    List<RoomDTO> toListRoomDTO(List<Room> rooms);
}
