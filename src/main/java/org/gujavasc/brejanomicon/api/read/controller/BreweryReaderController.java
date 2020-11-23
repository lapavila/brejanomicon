package org.gujavasc.brejanomicon.api.read.controller;

import org.gujavasc.brejanomicon.api.model.Brewery;
import org.gujavasc.brejanomicon.api.read.repository.BreweryReaderRepository;
import org.gujavasc.brejanomicon.api.read.service.BreweryReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/brewery")
public class BreweryReaderController {
    
    @Autowired
    BreweryReaderService readerService;

    @GetMapping
    public List<Brewery> findAll() {
        return readerService.findAll();
    }

}
