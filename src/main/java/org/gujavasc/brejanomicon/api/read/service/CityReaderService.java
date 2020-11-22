package org.gujavasc.brejanomicon.api.read.service;

import org.gujavasc.brejanomicon.api.read.filter.CityFilter;
import org.gujavasc.brejanomicon.api.model.City;
import org.gujavasc.brejanomicon.api.read.repository.CityReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityReaderService {
    @Autowired
    CityReaderRepository repository;

    public List<City> findAll() {
        return repository.findAll();
    }
    public List<City> filter(CityFilter filter) {
        return repository.filter(filter);
    }
}
