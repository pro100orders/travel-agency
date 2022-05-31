package com.pro100user.travelagencybackend.service.impl;

import com.pro100user.travelagencybackend.dto.HotelCreateDTO;
import com.pro100user.travelagencybackend.dto.HotelDTO;
import com.pro100user.travelagencybackend.dto.HotelUpdateDTO;
import com.pro100user.travelagencybackend.dto.RoomDTO;
import com.pro100user.travelagencybackend.entity.Hotel;
import com.pro100user.travelagencybackend.mapper.HotelMapper;
import com.pro100user.travelagencybackend.mapper.RoomMapper;
import com.pro100user.travelagencybackend.repository.HotelRepository;
import com.pro100user.travelagencybackend.service.HotelService;
import com.pro100user.travelagencybackend.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    private final RoomMapper roomMapper;

    private final ImageService imageService;

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
    public List<HotelDTO> getAll(String city) {
        if (city.equals("")) {
            return hotelMapper.toHotelDTO(
                    hotelRepository.findAll()
            );
        }
        else {
            return hotelMapper.toHotelDTO(
                    hotelRepository.findAll().stream()
                            .filter(hotel ->
                                    hotel.getCity().getName().toLowerCase(Locale.ROOT).contains(city.toLowerCase()))
                            .collect(Collectors.toList())
            );
        }
    }

    @Override
    public HotelDTO setImage(MultipartFile file, Long hotelId) {
        Hotel entity = hotelRepository.findById(hotelId).orElseThrow();
        entity.getImages().add(imageService.save(file, hotelId));
        return hotelMapper.toHotelDTO(
                hotelRepository.save(entity)
        );
    }

    @Override
    public List<RoomDTO> rooms(Long hotelId) {
        return roomMapper.toRoomDTO(
                hotelRepository.findById(hotelId).orElseThrow().getRooms()
        );
    }
}
