package org.gujavasc.brejanomicon.api.read.mapper;

import org.gujavasc.brejanomicon.api.model.State;
import org.springframework.jdbc.core.RowMapper;

public class StateMapper {
    private StateMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static RowMapper<State> createStateRowMapper() {
        return (rs, i) -> State.builder()
                .id(rs.getLong("id"))
                .abbreviation(rs.getString("abbreviation"))
                .name(rs.getString("name"))
                .build();
    }
}
