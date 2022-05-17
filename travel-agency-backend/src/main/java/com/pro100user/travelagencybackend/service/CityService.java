package com.pro100user.travelagencybackend.service;

import com.pro100user.travelagencybackend.dto.*;

import java.util.List;

public interface CityService {

    CityDTO create(CityCreateDTO dto);
    CityDTO getById(Long cityId);
    CityDTO update(CityUpdateDTO dto);
    boolean delete(Long cityId);
    List<CityDTO> getAll();
}
