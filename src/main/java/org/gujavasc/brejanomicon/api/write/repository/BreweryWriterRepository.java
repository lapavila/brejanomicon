package org.gujavasc.brejanomicon.api.write.repository;

import br.com.unosolucoes.sqlquery.jdbc.SqlQuery;
import org.gujavasc.brejanomicon.api.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BreweryWriterRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public Brewery create(Brewery brewery) {
        var query = SqlQuery.create(jdbcTemplate);
        var lines = query.insert("brewery")
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
        brewery.setId(query.getKey().longValue());
        return brewery;
    }
}
