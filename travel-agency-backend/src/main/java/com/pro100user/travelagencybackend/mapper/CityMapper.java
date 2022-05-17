package com.pro100user.travelagencybackend.mapper;

import com.pro100user.travelagencybackend.dto.CityCreateDTO;
import com.pro100user.travelagencybackend.dto.CityDTO;
import com.pro100user.travelagencybackend.dto.CityUpdateDTO;
import com.pro100user.travelagencybackend.entity.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {CountryMapper.class})
public interface CityMapper {

    City toEntity(CityCreateDTO dto);
    City toEntity(CityUpdateDTO dto);

    CityDTO toCityDTO(City city);
    List<CityDTO> toListCityDTO(List<City> cities);
}
