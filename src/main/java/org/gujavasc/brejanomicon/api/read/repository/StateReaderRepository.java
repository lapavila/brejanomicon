package org.gujavasc.brejanomicon.api.read.repository;

import org.gujavasc.brejanomicon.api.read.mapper.StateMapper;
import org.gujavasc.brejanomicon.api.model.State;
import org.gujavasc.brejanomicon.core.jdbc.SqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StateReaderRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public List<State> findAll() {
        return SqlQuery.create(jdbcTemplate)
                .sql("SELECT id,")
                .sql("       abbreviation,")
                .sql("       name")
                .sql("  FROM state")
                .query(StateMapper.createStateRowMapper());
    }

}
