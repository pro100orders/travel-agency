package com.pro100user.travelagencybackend.controller;

import com.pro100user.travelagencybackend.dto.CityDTO;
import com.pro100user.travelagencybackend.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("cities")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<CityDTO> cities() {
        return cityService.getAll();
    }
}
