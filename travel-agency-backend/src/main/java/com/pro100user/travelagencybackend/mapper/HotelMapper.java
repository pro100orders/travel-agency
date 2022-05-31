package com.pro100user.travelagencybackend.mapper;

import com.pro100user.travelagencybackend.dto.HotelCreateDTO;
import com.pro100user.travelagencybackend.dto.HotelDTO;
import com.pro100user.travelagencybackend.dto.HotelUpdateDTO;
import com.pro100user.travelagencybackend.entity.Hotel;
import com.pro100user.travelagencybackend.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(uses = {CityMapper.class})
public interface HotelMapper {

    @Mapping(source = "cityId", target = "city.id")
    Hotel toEntity(HotelCreateDTO dto);
    @Mapping(source = "cityId", target = "city.id")
    Hotel toEntity(HotelUpdateDTO dto);

    @Named("price")
    default double price(List<Room> rooms) {
        if(rooms.isEmpty()) return 0;
        return rooms.stream()
                .mapToDouble(Room::getPrice)
                .average().getAsDouble();
    }

    @Mapping(source = "rooms", target = "price", qualifiedByName = "price")
    HotelDTO toHotelDTO(Hotel hotel);
    List<HotelDTO> toHotelDTO(List<Hotel> hotels);
}
