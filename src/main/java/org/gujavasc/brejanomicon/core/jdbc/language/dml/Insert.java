package org.gujavasc.brejanomicon.core.jdbc.language.dml;

public interface Insert extends Manipulation {
    Number getKey();
    Insert nextVal(String column);
    Insert value(String column, Object value);
}
