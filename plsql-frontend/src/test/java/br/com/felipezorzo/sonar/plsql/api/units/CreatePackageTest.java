/*
 * Sonar PL/SQL Plugin (Community)
 * Copyright (C) 2015 Felipe Zorzo
 * felipe.b.zorzo@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package br.com.felipezorzo.sonar.plsql.api.units;

import static org.sonar.sslr.tests.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.felipezorzo.sonar.plsql.api.PlSqlGrammar;
import br.com.felipezorzo.sonar.plsql.api.RuleTest;

public class CreatePackageTest extends RuleTest {

    @Before
    public void init() {
        setRootRule(PlSqlGrammar.CREATE_PACKAGE);
    }

    @Test
    public void matchesSimplePackage() {
        assertThat(p).matches(""
                + "create package test is\n"
                + "end;");
    }
    
    @Test
    public void matchesSimplePackageAlternative() {
        assertThat(p).matches(""
                + "create package test as\n"
                + "end;");
    }
    
    @Test
    public void matchesSimplePackageWithNameAtEnd() {
        assertThat(p).matches(""
                + "create package test is\n"
                + "end test;");
    }
    
    @Test
    public void matchesSimpleCreateOrReplacePackage() {
        assertThat(p).matches(""
                + "create or replace package test is\n"
                + "end;");
    }
    
    @Test
    public void matchesPackageWithSchema() {
        assertThat(p).matches(""
                + "create package schema.test is\n"
                + "end;");
    }
    
    @Test
    public void matchesPackageWithAuthidCurrentUser() {
        assertThat(p).matches(""
                + "create package test authid current_user is\n"
                + "end;");
    }
    
    @Test
    public void matchesPackageWithAuthidDefiner() {
        assertThat(p).matches(""
                + "create package test authid definer is\n"
                + "end;");
    }
    
    @Test
    public void matchesPackageWithProcedure() {
        assertThat(p).matches(""
                + "create package test is\n"
                + "procedure proc;\n"
                + "end;");
    }
    
    @Test
    public void matchesPackageWithFunction() {
        assertThat(p).matches(""
                + "create package test is\n"
                + "function func return number;\n"
                + "end;");
    }
    
    @Test
    public void matchesPackageWithTimestamp() {
        assertThat(p).matches(""
                + "create package test timestamp '2015-01-01' is\n"
                + "end;");
    }

}