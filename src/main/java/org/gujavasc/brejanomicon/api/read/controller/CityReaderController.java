package org.gujavasc.brejanomicon.api.read.controller;

import org.gujavasc.brejanomicon.api.read.filter.CityFilter;
import org.gujavasc.brejanomicon.api.model.City;
import org.gujavasc.brejanomicon.api.read.service.CityReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/city")
public class CityReaderController {

    @Autowired
    CityReaderService service;

    @GetMapping
    public List<City> findAll() {
        return service.findAll();
    }

    @GetMapping(params = "filter")
    public List<City> filter(CityFilter filter) {
        return service.filter(filter);
    }
}
