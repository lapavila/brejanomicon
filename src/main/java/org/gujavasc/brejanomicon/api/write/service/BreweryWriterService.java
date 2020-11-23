package org.gujavasc.brejanomicon.api.write.service;

import org.gujavasc.brejanomicon.api.model.Brewery;
import org.gujavasc.brejanomicon.api.write.repository.BreweryWriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreweryWriterService {
    @Autowired
    BreweryWriterRepository repository;

    public Brewery create(Brewery brewery) {
        return repository.create(brewery);
    }
}
