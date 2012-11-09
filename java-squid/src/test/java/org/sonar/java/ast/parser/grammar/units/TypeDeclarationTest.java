/*
 * Sonar Java
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
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
package org.sonar.java.ast.parser.grammar.units;

import com.sonar.sslr.impl.Parser;
import org.junit.Before;
import org.junit.Test;
import org.sonar.java.ast.api.JavaGrammar;
import org.sonar.java.ast.parser.JavaParser;

import static org.sonar.sslr.tests.Assertions.assertThat;

public class TypeDeclarationTest {

  Parser<JavaGrammar> p = JavaParser.create();
  JavaGrammar g = p.getGrammar();

  @Before
  public void init() {
    p.setRootRule(g.typeDeclaration);
  }

  @Test
  public void ok() {
    g.modifier.mock();
    g.classDeclaration.mock();
    g.enumDeclaration.mock();
    g.interfaceDeclaration.mock();
    g.annotationTypeDeclaration.mock();

    assertThat(p)
        .matches("classDeclaration")
        .matches("enumDeclaration")
        .matches("interfaceDeclaration")
        .matches("annotationTypeDeclaration")
        .matches("modifier classDeclaration")
        .matches("modifier modifier classDeclaration")
        .matches(";");
  }

  @Test
  public void realLife() {
    assertThat(p)
        .matches("public static final class HelloWorld { }");
  }

}
