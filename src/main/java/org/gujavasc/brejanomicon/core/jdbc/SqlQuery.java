package org.gujavasc.brejanomicon.core.jdbc;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SqlQuery {
    NamedParameterJdbcTemplate jdbcTemplate;
    MapSqlParameterSource parameters;
    private final StringBuilder sql;
    private String conjuncao;
    private KeyHolder keyHolder;
    private Integer affectedRows;

    private String insertTable;
    private String idTable;
    private StringBuilder insertFields;
    private StringBuilder insertValues;

    public static SqlQuery create(NamedParameterJdbcTemplate jdbcTemplate) {
        return new SqlQuery(jdbcTemplate);
    }

    private SqlQuery(NamedParameterJdbcTemplate jdbcTemplate) {
        this.sql = new StringBuilder();
        this.parameters = new MapSqlParameterSource();
        this.jdbcTemplate = jdbcTemplate;
    }

    public <T> List<T> query(RowMapper<T> rowMapper) {
        return this.jdbcTemplate.query(this.sql.toString(), this.parameters, rowMapper);
    }

    public <T> T query(ResultSetExtractor<T> extractor) {
        return this.jdbcTemplate.query(this.sql.toString(), this.parameters, extractor);
    }

    public <T> Page<T> page(Pageable pageable, RowMapper<T> rowMapper) {
        int total = this.count();
        this.limit(pageable.getPageSize())
                .offset(pageable.getOffset());
        List<T> list = this.query(rowMapper);
        return new PageImpl(list, pageable, total);
    }

    public <T> Optional<T> queryForObject(RowMapper<T> rowMapper) {
        return Optional.ofNullable(this.jdbcTemplate.queryForObject(this.sql.toString(), this.parameters, rowMapper));
    }

    public Integer execute() {
        if (StringUtils.containsIgnoreCase(sql, "INSERT INTO")) {
            if (StringUtils.isNotEmpty(this.idTable)) {
                value(this.idTable, nextVal(this.insertTable, this.idTable));
            }
            sql.append(" (")
                    .append(insertFields)
                    .append(")")
                    .append(" VALUES (")
                    .append(insertValues)
                    .append(")");
        }
        keyHolder = new GeneratedKeyHolder();
        this.affectedRows = this.jdbcTemplate.update(this.sql.toString(), this.parameters, keyHolder);
        if (StringUtils.isNotEmpty(this.idTable)) {
            List<Map<String, Object>> list = Stream.of(Collections.singletonMap(this.idTable, this.parameters.getValue(this.idTable)))
                    .collect(Collectors.toList());
            keyHolder = new GeneratedKeyHolder(list);
            value(this.idTable, nextVal(this.insertTable, this.idTable));
        }
        return this.affectedRows;
    }

    public Integer update() {
        return execute();
    }

    public Number getKey() {
        Objects.requireNonNull(keyHolder, "chave.nao-gerada");
        return keyHolder.getKey();
    }

    public Integer getAffectedRows() {
        Objects.requireNonNull(affectedRows, "linhas.nao-contabilizadas");
        return affectedRows;
    }

    public Integer count() {
        String queryCount = "SELECT COUNT(*) " + this.sql.substring(sql.indexOf("FROM"));
        Integer ret = this.jdbcTemplate.queryForObject(queryCount, this.parameters, Integer.class);
        return ret;
    }

    public SqlQuery sql(String sql) {
        this.sql.append(" ")
                .append(sql.trim());
        return this;
    }

    public SqlQuery update(String tabela) {
        if (StringUtils.containsIgnoreCase(sql, "UPDATE")) {
            throw new SqlQuerySintaxException("comando.duplicado");
        }
        this.sql.append("UPDATE ")
                .append(tabela);
        return this;
    }

    public SqlQuery insert(String tabela) {
        this.insertFields = new StringBuilder();
        this.insertValues = new StringBuilder();
        if (StringUtils.containsIgnoreCase(sql, "INSERT INTO")) {
            throw new SqlQuerySintaxException("comando.duplicado");
        }
        this.sql.append("INSERT INTO ")
                .append(tabela);
        this.insertTable = tabela;
        return this;
    }

    public SqlQuery delete(String tabela) {
        this.sql.append("DELETE FROM ")
                .append(tabela);
        return this;
    }

    public SqlQuery value(String campo, Object value) {
        if (Objects.isNull(value)) {
            return this;
        }
        if (StringUtils.isNotEmpty(insertFields)) {
            insertFields.append(", ");
        }
        insertFields.append(campo);

        if (StringUtils.isNotEmpty(insertValues)) {
            insertValues.append(", ");
        }
        insertValues.append(":").append(campo);
        parameters.addValue(campo, value);
        return this;
    }

    public SqlQuery nextVal(String field) {
        this.idTable = field;
        return this;
    }

    public SqlQuery where() {
        if (StringUtils.containsIgnoreCase(sql, "WHERE")) {
            throw new SqlQuerySintaxException("comando.duplicado");
        }
        this.conjuncao = "WHERE";
        return this;
    }

    public SqlQuery or() {
        this.applyConjuncao("OR");
        return this;
    }

    public SqlQuery set(String campo, Object value) {
        String setComand = ", ";
        if (!StringUtils.containsIgnoreCase(sql, "SET")) {
            setComand = "SET ";
        }
        sql.append(String.format(" %s%s %s :%s", setComand, campo, "=", campo));
        addValue(campo, value);
        return this;
    }

    public SqlQuery and() {
        this.applyConjuncao("AND");
        return this;
    }

    public SqlQuery eq(String campo, Object value) {
        applyExpression("=", campo, value);
        return this;
    }

    public SqlQuery lt(String campo, Object value) {
        applyExpression("<", campo, value);
        return this;
    }

    public SqlQuery lte(String campo, Object value) {
        applyExpression("<=", campo, value);
        return this;
    }

    public SqlQuery rt(String campo, Object value) {
        applyExpression(">", campo, value);
        return this;
    }

    public SqlQuery rte(String campo, Object value) {
        applyExpression(">=", campo, value);
        return this;
    }

    public SqlQuery neq(String campo, Object value) {
        applyExpression("<>", campo, value);
        return this;
    }

    public SqlQuery isNull(String campo) {
        sql.append(String.format(" %s %s IS NULL", this.conjuncao, campo));
        return this;
    }

    public SqlQuery isNotNull(String campo) {
        sql.append(String.format(" %s %s IS NOT NULL", this.conjuncao, campo));
        return this;
    }

    public SqlQuery like(String campo, Object value) {
        if (Objects.nonNull(value)) {
            value = value + "%";
        }
        applyExpression("like", campo, value);
        return this;
    }

    //TODO estudar melhor
    public SqlQuery addValue(String campo, Object value) {
        if (Objects.nonNull(value)) {
            this.parameters.addValue(campo, value);
        }
        return this;
    }

    public Number nextVal(String table, String field) {
        String sql = String.format("SELECT MAX(COALESCE(%s, 0)) + 1 FROM %s", field, table);
        return jdbcTemplate.queryForObject(sql, Collections.emptyMap(), Number.class);
    }

    private void applyExpression(String operator, String campo, Object value) {
        if (!Objects.isNull(value)) {
            sql.append(String.format(" %s %s %s :%s", this.conjuncao, campo, operator, campo));
            parameters.addValue(campo, value);
        }
    }

    private void applyConjuncao(String conjuncao) {
        if (!StringUtils.containsIgnoreCase(sql, "WHERE")) {
            this.conjuncao = "WHERE";
            return;
        }
        this.conjuncao = conjuncao;
    }

    private SqlQuery limit(Integer limit) {
        this.sql.append(" ")
                .append("LIMIT ")
                .append(limit);
        return this;
    }

    private SqlQuery offset(Long offset) {
        this.sql.append(" ")
                .append("OFFSET ")
                .append(offset);
        return this;
    }
}
