package org.gujavasc.brejanomicon.api.read.mapper;

import org.gujavasc.brejanomicon.api.model.City;
import org.gujavasc.brejanomicon.api.model.State;
import org.springframework.jdbc.core.RowMapper;

public class CityMapper {
    private CityMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static RowMapper<City> createCityRowMapper() {
        return (rs, i) -> City.builder()
                .id(rs.getLong("city.id"))
                .name(rs.getString("city.name"))
                .capital(rs.getBoolean("city.capital"))
                .state(State.builder()
                        .id(rs.getLong("state.id"))
                        .name(rs.getString("state.name"))
                        .abbreviation(rs.getString("state.abbreviation"))
                        .build()
                )
                .build();
    }
}
