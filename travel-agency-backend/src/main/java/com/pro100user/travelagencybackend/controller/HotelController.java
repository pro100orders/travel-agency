package com.pro100user.travelagencybackend.controller;

import com.pro100user.travelagencybackend.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("hotels")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HotelController {

    private final HotelService hotelService;
}
