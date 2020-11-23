package org.gujavasc.brejanomicon.api.read.repository;

import br.com.unosolucoes.sqlquery.jdbc.SqlQuery;
import org.gujavasc.brejanomicon.api.model.Brewery;
import org.gujavasc.brejanomicon.api.read.mapper.BreweryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BreweryReaderRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public List<Brewery> findAll() {
        return SqlQuery.create(jdbcTemplate)
                .sql("SELECT brewery.id,")
                .sql("       brewery.name,")
                .sql("       brewery.description,")
                .sql("       brewery.story,")
                .sql("       brewery.email,")
                .sql("       brewery.phone,")
                .sql("       brewery.website,")
                .sql("       brewery.address,")
                .sql("       brewery.postal_code,")
                .sql("       city.id,")
                .sql("       city.name,")
                .sql("       city.capital,")
                .sql("       state.id,")
                .sql("       state.abbreviation,")
                .sql("       state.name")
                .sql("  FROM brewery")
                .sql("       LEFT OUTER JOIN city on city.id = brewery.city_id")
                .sql("       LEFT OUTER JOIN state on state.id = city.state_id")
                .query(BreweryMapper.createBreweryRowMapper());
    }

}
