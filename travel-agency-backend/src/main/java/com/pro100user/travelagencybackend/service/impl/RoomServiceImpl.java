package com.pro100user.travelagencybackend.service.impl;

import com.pro100user.travelagencybackend.dto.RoomCreateDTO;
import com.pro100user.travelagencybackend.dto.RoomDTO;
import com.pro100user.travelagencybackend.dto.RoomUpdateDTO;
import com.pro100user.travelagencybackend.entity.Room;
import com.pro100user.travelagencybackend.mapper.RoomMapper;
import com.pro100user.travelagencybackend.repository.RoomRepository;
import com.pro100user.travelagencybackend.service.RoomService;
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
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public RoomDTO create(RoomCreateDTO dto) {
        Room entity = roomMapper.toEntity(dto);
        return roomMapper.toRoomDTO(
                roomRepository.save(entity)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public RoomDTO getById(Long roomId) {
        return roomMapper.toRoomDTO(
                roomRepository.findById(roomId).orElseThrow()
        );
    }

    @Override
    public RoomDTO update(RoomUpdateDTO dto) {
        Room entity = roomMapper.toEntity(dto);
        return roomMapper.toRoomDTO(
                roomRepository.save(entity)
        );
    }

    @Override
    public boolean delete(Long roomId) {
        roomRepository.deleteById(roomId);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoomDTO> getAll() {
        return roomMapper.toRoomDTO(
                roomRepository.findAll()
        );
    }
}
