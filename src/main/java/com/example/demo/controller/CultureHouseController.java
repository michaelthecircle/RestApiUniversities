package com.example.demo.controller;

import com.example.demo.services.CultureHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/culture_house")
public class CultureHouseController {
    private final CultureHouseService cultureHouseService;
    @Autowired
    public CultureHouseController(CultureHouseService cultureHouse) {
        this.cultureHouseService = cultureHouse;
    }
}
