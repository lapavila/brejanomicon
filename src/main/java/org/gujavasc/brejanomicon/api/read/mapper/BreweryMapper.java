package org.gujavasc.brejanomicon.api.read.mapper;

import org.gujavasc.brejanomicon.api.model.Brewery;
import org.gujavasc.brejanomicon.api.model.City;
import org.gujavasc.brejanomicon.api.model.State;
import org.springframework.jdbc.core.RowMapper;

public class BreweryMapper {
    private BreweryMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static RowMapper<Brewery> createBreweryRowMapper() {
        return (rs, i) -> Brewery.builder()
                .id(rs.getLong("brewery.id"))
                .name(rs.getString("brewery.name"))
                .description(rs.getString("brewery.description"))
                .story(rs.getString("brewery.story"))
                .email(rs.getString("brewery.email"))
                .phone(rs.getString("brewery.phone"))
                .website(rs.getString("brewery.website"))
                .address(rs.getString("brewery.address"))
                .postalCode(rs.getString("brewery.postal_code"))
                .city(City.builder()
                        .id(rs.getLong("city.id"))
                        .name(rs.getString("city.name"))
                        .capital(rs.getBoolean("city.capital"))
                        .state(State.builder()
                                .id(rs.getLong("state.id"))
                                .name(rs.getString("state.name"))
                                .abbreviation(rs.getString("state.abbreviation"))
                                .build()
                        )
                        .build()
                )
                .build();
    }
}
