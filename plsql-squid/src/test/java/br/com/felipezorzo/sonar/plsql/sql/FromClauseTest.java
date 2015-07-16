package br.com.felipezorzo.sonar.plsql.sql;

import static org.sonar.sslr.tests.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.felipezorzo.sonar.plsql.api.PlSqlGrammar;
import br.com.felipezorzo.sonar.plsql.api.RuleTest;

public class FromClauseTest extends RuleTest {

    @Before
    public void init() {
        setRootRule(PlSqlGrammar.FROM_CLAUSE);
    }
    
    @Test
    public void matchesTable() {
        assertThat(p).matches("tab");
    }
    
    @Test
    public void matchesTableInSchema() {
        assertThat(p).matches("sch.tab");
    }
    
    @Test
    public void matchesTableWithDbLink() {
        assertThat(p).matches("tab@link");
    }
    
    @Test
    public void matchesTableWithAlias() {
        assertThat(p).matches("tab alias");
    }

}