package com.pro100user.travelagencybackend.controller;

import com.pro100user.travelagencybackend.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("countries")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CountryController {

    private final CountryService countryService;
}
