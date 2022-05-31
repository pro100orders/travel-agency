package com.pro100user.travelagencybackend.controller;

import com.pro100user.travelagencybackend.dto.HotelCreateDTO;
import com.pro100user.travelagencybackend.dto.HotelDTO;
import com.pro100user.travelagencybackend.dto.HotelUpdateDTO;
import com.pro100user.travelagencybackend.dto.RoomDTO;
import com.pro100user.travelagencybackend.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("hotels")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HotelController {

    private final HotelService hotelService;

    @GetMapping()
    public List<HotelDTO> hotels(
            @RequestParam(defaultValue = "", name = "city") String city
    ) {
        return hotelService.getAll(city);
    }

    @GetMapping("/rooms/{id}")
    public List<RoomDTO> rooms(
            @PathVariable("id") Long id
    ) {
        return hotelService.rooms(id);
    }

    @GetMapping("{id}")
    public HotelDTO details(
            @PathVariable("id") Long id
    ) {
        return hotelService.getById(id);
    }

    @PostMapping
    public HotelDTO create(
            @RequestBody HotelCreateDTO dto
    ) {
        return hotelService.create(dto);
    }

    @PutMapping
    public HotelDTO update(
            @RequestBody HotelUpdateDTO dto
    ) {
        return hotelService.update(dto);
    }

    @DeleteMapping("{id}")
    public boolean delete(
            @PathVariable("id") Long id
    ) {
        return hotelService.delete(id);
    }

    @PostMapping("{id}")
    public HotelDTO create(
            @PathVariable("id") Long hotelId,
            @RequestParam("image") MultipartFile image
    ) {
        return hotelService.setImage(image, hotelId);
    }
}
