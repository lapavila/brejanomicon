package org.gujavasc.brejanomicon.api.write.repository;

import org.gujavasc.brejanomicon.api.model.City;
import org.gujavasc.brejanomicon.api.read.filter.CityFilter;
import org.gujavasc.brejanomicon.core.jdbc.SqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CityWriterRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public City create(City city) {
        var query = SqlQuery.create(jdbcTemplate);
        var lines = query.insert("city")
                .value("name", city.getName())
                .value("capital", city.getCapital())
                .value("state_id", city.getState().getId())
                .execute();
        city.setId(query.getKey().longValue());
        return city;
    }
}
