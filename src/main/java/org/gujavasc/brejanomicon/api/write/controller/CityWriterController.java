package org.gujavasc.brejanomicon.api.write.controller;

import org.gujavasc.brejanomicon.api.model.City;
import org.gujavasc.brejanomicon.api.write.service.CityWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/city")
public class CityWriterController {
    @Autowired
    CityWriterService service;

    @PostMapping
    public City create(@RequestBody City city) {
        return service.create(city);
    }

    @PutMapping("/{id}")
    public City update(@PathVariable Long id, @RequestBody City city) {
        return service.update(id, city);
    }
}
