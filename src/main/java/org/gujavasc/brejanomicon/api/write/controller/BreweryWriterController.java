package org.gujavasc.brejanomicon.api.write.controller;

import org.gujavasc.brejanomicon.api.model.Brewery;
import org.gujavasc.brejanomicon.api.write.service.BreweryWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/brewery")
public class BreweryWriterController {
    @Autowired
    BreweryWriterService service;

    @PostMapping
    public Brewery create(@RequestBody Brewery brewery) {
        return service.create(brewery);
    }
}
