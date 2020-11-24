package org.gujavasc.brejanomicon.api.write.repository;

import br.com.unosolucoes.sqlquery.jdbc.fluent.Sql;
import org.gujavasc.brejanomicon.api.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CityWriterRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public City create(City city) {
        var query = Sql.insert(jdbcTemplate)
                .into("city")
                .value("name", city.getName())
                .value("capital", city.getCapital())
                .value("state_id", city.getState().getId())
                .execute();
        city.setId(query.getKey().longValue());
        return city;
    }

    public City update(Long id, City city) {
        var update =Sql.update(jdbcTemplate)
                .table("city")
                .set("name", city.getName())
                .set("capital", city.getCapital())
                .set("state_id", city.getState().getId())
                .where().eq("id", id)
                .execute();
        city.setId(id);
        return city;
    }
}
