package com.pro100user.travelagencybackend.mapper;

import com.pro100user.travelagencybackend.dto.HotelCreateDTO;
import com.pro100user.travelagencybackend.dto.HotelDTO;
import com.pro100user.travelagencybackend.dto.HotelUpdateDTO;
import com.pro100user.travelagencybackend.entity.Hotel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {CityMapper.class})
public interface HotelMapper {

    Hotel toEntity(HotelCreateDTO dto);
    Hotel toEntity(HotelUpdateDTO dto);

    HotelDTO toHotelDTO(Hotel hotel);
    List<HotelDTO> toListHotelDTO(List<Hotel> hotels);
}
