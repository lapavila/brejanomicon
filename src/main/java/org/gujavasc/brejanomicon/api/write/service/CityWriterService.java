package org.gujavasc.brejanomicon.api.write.service;

import org.gujavasc.brejanomicon.api.model.City;
import org.gujavasc.brejanomicon.api.write.repository.CityWriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityWriterService {
    @Autowired
    CityWriterRepository repository;

    public City create(City city) {
        return repository.create(city);
    }

    public City update(Long id, City city) {
        return repository.update(id, city);
    }
}
