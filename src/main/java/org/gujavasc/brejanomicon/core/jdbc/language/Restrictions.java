package org.gujavasc.brejanomicon.core.jdbc.language;

public interface Restrictions {
    Sql where();
    Sql and();
    Sql or();
    Sql eq(String campo, Object value);
    Sql lt(String campo, Object value);
    Sql lte(String campo, Object value);
    Sql rt(String campo, Object value);
    Sql rte(String campo, Object value);
    Sql neq(String campo, Object value);
    Sql isNull(String campo);
    Sql isNotNull(String campo);
    Sql like(String campo, Object value);
}
