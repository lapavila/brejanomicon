package org.gujavasc.brejanomicon.api.write.repository;

import br.com.unosolucoes.sqlquery.jdbc.fluent.Sql;
import org.gujavasc.brejanomicon.api.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BreweryWriterRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public Brewery create(Brewery brewery) {
        var insert = Sql.insert(jdbcTemplate)
                .into("brewery")
                .value("name", brewery.getName())
                .value("description", brewery.getDescription())
                .value("story", brewery.getStory())
                .value("email", brewery.getEmail())
                .value("phone", brewery.getPhone())
                .value("website", brewery.getWebsite())
                .value("address", brewery.getAddress())
                .value("postal_code", brewery.getPostalCode())
                .value("city_id", brewery.getCity().getId())
                .execute();
        brewery.setId(insert.getKey().longValue());
        return brewery;
    }
}
