package org.gujavasc.brejanomicon.core.jdbc.language;


import org.gujavasc.brejanomicon.core.jdbc.SqlQuery;
import org.gujavasc.brejanomicon.core.jdbc.language.dml.Delete;
import org.gujavasc.brejanomicon.core.jdbc.language.dml.Insert;
import org.gujavasc.brejanomicon.core.jdbc.language.dml.Update;
import org.gujavasc.brejanomicon.core.jdbc.language.dql.Select;

public interface Sql {
    Select select();
    Insert insert(String tabela);
    Update update(String tabela);
    Delete delete(String tabela);
    SqlQuery sql(String sql);
}
