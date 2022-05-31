package com.pro100user.travelagencybackend.mapper;

import com.pro100user.travelagencybackend.dto.*;
import com.pro100user.travelagencybackend.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {HotelMapper.class})
public interface RoomMapper {

    @Mapping(source = "hotelId", target = "hotel.id")
    Room toEntity(RoomCreateDTO dto);
    @Mapping(source = "hotelId", target = "hotel.id")
    Room toEntity(RoomUpdateDTO dto);

    @Mapping(source = "hotel.id", target = "hotelId")
    RoomDTO toRoomDTO(Room room);
    @Mapping(source = "hotel.id", target = "hotelId")
    List<RoomDTO> toRoomDTO(List<Room> rooms);
}
