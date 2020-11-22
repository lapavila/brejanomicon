package org.gujavasc.brejanomicon.core.jdbc.language.dql;

import org.gujavasc.brejanomicon.core.jdbc.language.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

public interface Select extends Restrictions {
    Integer count();
    <T> List<T> query(RowMapper<T> rowMapper);
    <T> T query(ResultSetExtractor<T> extractor);
    <T> Optional<T> queryForObject(RowMapper<T> rowMapper);
    <T> Page<T> page(Pageable pageable, RowMapper<T> rowMapper);
}
