package com.pro100user.travelagencybackend.controller;

import com.pro100user.travelagencybackend.dto.RoomCreateDTO;
import com.pro100user.travelagencybackend.dto.RoomDTO;
import com.pro100user.travelagencybackend.dto.RoomUpdateDTO;
import com.pro100user.travelagencybackend.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public List<RoomDTO> rooms() {
        return roomService.getAll();
    }

    @GetMapping("{id}")
    public RoomDTO details(
            @PathVariable("id") Long id
    ) {
        return roomService.getById(id);
    }

    @PostMapping
    public RoomDTO create(
            @RequestBody RoomCreateDTO dto
    ) {
        return roomService.create(dto);
    }

    @PutMapping
    public RoomDTO update(
            @RequestBody RoomUpdateDTO dto
    ) {
        return roomService.update(dto);
    }

    @DeleteMapping("{id}")
    public boolean delete(
            @PathVariable("id") Long id
    ) {
        return roomService.delete(id);
    }
}
