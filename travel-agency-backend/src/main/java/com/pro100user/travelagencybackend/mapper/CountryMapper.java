package com.pro100user.travelagencybackend.mapper;

import com.pro100user.travelagencybackend.dto.*;
import com.pro100user.travelagencybackend.entity.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {

    Country toEntity(CountryCreateDTO dto);
    Country toEntity(CountryUpdateDTO dto);

    CountryDTO toCountryDTO(Country country);
    List<CountryDTO> toListCountryDTO(List<Country> countries);
}
