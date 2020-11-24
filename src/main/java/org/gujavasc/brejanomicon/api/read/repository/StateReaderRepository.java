package org.gujavasc.brejanomicon.api.read.repository;

import br.com.unosolucoes.sqlquery.jdbc.fluent.Sql;
import org.gujavasc.brejanomicon.api.model.State;
import org.gujavasc.brejanomicon.api.read.mapper.StateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StateReaderRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public List<State> findAll() {
        return Sql.select(jdbcTemplate)
                .sql("SELECT id,")
                .sql("       abbreviation,")
                .sql("       name")
                .sql("  FROM state")
                .query(StateMapper.createStateRowMapper());
    }

}
