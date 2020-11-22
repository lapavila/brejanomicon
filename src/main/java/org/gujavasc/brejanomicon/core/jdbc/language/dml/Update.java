package org.gujavasc.brejanomicon.core.jdbc.language.dml;

public interface Update extends Manipulation {
    Integer update();
    Update set(String column, Object value);
}
