package org.gujavasc.brejanomicon.api.read.service;

import org.gujavasc.brejanomicon.api.model.State;
import org.gujavasc.brejanomicon.api.read.repository.StateReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateReaderService {
    @Autowired
    StateReaderRepository repository;

    public List<State> findAll() {
        return repository.findAll();
    }
}
