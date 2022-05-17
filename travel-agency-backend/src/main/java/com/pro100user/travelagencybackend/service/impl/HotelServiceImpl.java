package com.pro100user.travelagencybackend.service.impl;

import com.pro100user.travelagencybackend.dto.HotelCreateDTO;
import com.pro100user.travelagencybackend.dto.HotelDTO;
import com.pro100user.travelagencybackend.dto.HotelUpdateDTO;
import com.pro100user.travelagencybackend.entity.Hotel;
import com.pro100user.travelagencybackend.mapper.HotelMapper;
import com.pro100user.travelagencybackend.repository.HotelRepository;
import com.pro100user.travelagencybackend.service.HotelService;
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
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Override
    public HotelDTO create(HotelCreateDTO dto) {
        Hotel entity = hotelMapper.toEntity(dto);
        return hotelMapper.toHotelDTO(
                hotelRepository.save(entity)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public HotelDTO getById(Long hotelId) {
        return hotelMapper.toHotelDTO(
                hotelRepository.findById(hotelId).orElseThrow()
        );
    }

    @Override
    public HotelDTO update(HotelUpdateDTO dto) {
        Hotel entity = hotelMapper.toEntity(dto);
        return hotelMapper.toHotelDTO(
                hotelRepository.save(entity)
        );
    }

    @Override
    public boolean delete(Long hotelId) {
        hotelRepository.deleteById(hotelId);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<HotelDTO> getAll() {
        return hotelMapper.toListHotelDTO(
                hotelRepository.findAll()
        );
    }
}
