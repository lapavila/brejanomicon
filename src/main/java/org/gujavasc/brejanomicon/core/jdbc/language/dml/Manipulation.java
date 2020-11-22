package org.gujavasc.brejanomicon.core.jdbc.language.dml;


import org.gujavasc.brejanomicon.core.jdbc.language.Restrictions;
import org.gujavasc.brejanomicon.core.jdbc.language.Sql;

public interface Manipulation extends Sql, Restrictions {
    Integer getAffectedRows();
    Integer execute();
}
