package com.pro100user.travelagencybackend.service.impl;

import com.pro100user.travelagencybackend.dto.CityCreateDTO;
import com.pro100user.travelagencybackend.dto.CityDTO;
import com.pro100user.travelagencybackend.dto.CityUpdateDTO;
import com.pro100user.travelagencybackend.entity.City;
import com.pro100user.travelagencybackend.mapper.CityMapper;
import com.pro100user.travelagencybackend.repository.CityRepository;
import com.pro100user.travelagencybackend.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    public CityDTO create(CityCreateDTO dto) {
        City entity = cityMapper.toEntity(dto);
        return cityMapper.toCityDTO(
                cityRepository.save(entity)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public CityDTO getById(Long cityId) {
        return cityMapper.toCityDTO(
                cityRepository.findById(cityId).orElseThrow()
        );
    }

    @Override
    public CityDTO update(CityUpdateDTO dto) {
        City entity = cityMapper.toEntity(dto);
        return cityMapper.toCityDTO(
                cityRepository.save(entity)
        );
    }

    @Override
    public boolean delete(Long cityId) {
        cityRepository.deleteById(cityId);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CityDTO> getAll() {
        return cityMapper.toListCityDTO(
                cityRepository.findAll()
        );
    }
}
