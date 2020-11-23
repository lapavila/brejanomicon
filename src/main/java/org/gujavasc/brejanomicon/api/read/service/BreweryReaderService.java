package org.gujavasc.brejanomicon.api.read.service;

import org.gujavasc.brejanomicon.api.model.Brewery;
import org.gujavasc.brejanomicon.api.read.repository.BreweryReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweryReaderService {

    @Autowired
    BreweryReaderRepository readerRepository;

    public List<Brewery> findAll() {
        return readerRepository.findAll();
    }

}
