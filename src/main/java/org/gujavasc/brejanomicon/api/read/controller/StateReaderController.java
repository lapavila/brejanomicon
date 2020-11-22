package org.gujavasc.brejanomicon.api.read.controller;

import org.gujavasc.brejanomicon.api.model.State;
import org.gujavasc.brejanomicon.api.read.service.StateReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/state")
public class StateReaderController {

    @Autowired
    StateReaderService service;

    @GetMapping
    public List<State> findAll() {
        return service.findAll();
    }
}
