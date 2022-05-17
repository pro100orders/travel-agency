package com.pro100user.travelagencybackend.service;

import com.pro100user.travelagencybackend.dto.*;

import java.util.List;

public interface CountryService {

    CountryDTO create(CountryCreateDTO dto);
    CountryDTO getById(Long countryId);
    CountryDTO update(CountryUpdateDTO dto);
    boolean delete(Long countryId);
    List<CountryDTO> getAll();
}
