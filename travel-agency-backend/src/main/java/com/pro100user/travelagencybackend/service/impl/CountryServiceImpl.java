package com.pro100user.travelagencybackend.service.impl;

import com.pro100user.travelagencybackend.dto.*;
import com.pro100user.travelagencybackend.entity.Country;
import com.pro100user.travelagencybackend.mapper.CountryMapper;
import com.pro100user.travelagencybackend.repository.CountryRepository;
import com.pro100user.travelagencybackend.service.CountryService;
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
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public CountryDTO create(CountryCreateDTO dto) {
        Country entity = countryMapper.toEntity(dto);
        return countryMapper.toCountryDTO(
                countryRepository.save(entity)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public CountryDTO getById(Long countryId) {
        return countryMapper.toCountryDTO(
                countryRepository.findById(countryId).orElseThrow()
        );
    }

    @Override
    public CountryDTO update(CountryUpdateDTO dto) {
        Country entity = countryMapper.toEntity(dto);
        return countryMapper.toCountryDTO(
                countryRepository.save(entity)
        );
    }

    @Override
    public boolean delete(Long countryId) {
        countryRepository.deleteById(countryId);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CountryDTO> getAll() {
        return countryMapper.toCountryDTO(
                countryRepository.findAll()
        );
    }
}
