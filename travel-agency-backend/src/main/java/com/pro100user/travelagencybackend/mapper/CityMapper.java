package com.pro100user.travelagencybackend.mapper;

import com.pro100user.travelagencybackend.dto.CityCreateDTO;
import com.pro100user.travelagencybackend.dto.CityDTO;
import com.pro100user.travelagencybackend.dto.CityUpdateDTO;
import com.pro100user.travelagencybackend.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = {CountryMapper.class})
public interface CityMapper {

    @Mapping(source = "countryId", target = "country.id")
    City toEntity(CityCreateDTO dto);
    @Mapping(source = "countryId", target = "country.id")
    City toEntity(CityUpdateDTO dto);

    @Mappings({
            @Mapping(source = "country.id", target = "countryId"),
            @Mapping(source = "country.name", target = "country")
    })
    CityDTO toCityDTO(City city);
    @Mappings({
            @Mapping(source = "country.id", target = "countryId"),
            @Mapping(source = "country.name", target = "country")
    })
    List<CityDTO> toCityDTO(List<City> cities);
}
