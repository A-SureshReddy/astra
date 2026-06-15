package org.alfasoftware.astra.core.refactoring.operations.sonar.s5785;

import java.nio.file.Paths;
import java.util.Set;

import org.alfasoftware.astra.core.refactoring.AbstractRefactorTest;
import org.junit.Test;

public class TestAssertTrueInsteadOfDedicatedAssertOperation extends AbstractRefactorTest {

  private static final String M2 =
      Paths.get(System.getProperty("user.home"), ".m2", "repository").toString();

  private static final String[] JUNIT4_CLASSPATH = {
      Paths.get(M2, "junit", "junit", "4.13.2", "junit-4.13.2.jar").toString()
  };


  private static final Set<AssertTrueInsteadOfDedicatedAssertOperation> OPERATION =
      Set.of(new AssertTrueInsteadOfDedicatedAssertOperation());

  /**
   * Core rewrites using qualified {@code Assert.*} calls (JUnit 4):
   * null checks, equals method, Objects.equals, primitive comparison,
   * object reference comparison, logical negation, and message argument.
   */
  @Test
  public void testJUnit4QualifiedCalls() {
    assertRefactorWithClassPath(AssertTrueJUnit4Example.class, OPERATION, JUNIT4_CLASSPATH);
  }

  /**
   * Statically-imported calls with a wildcard import — method name and args are rewritten,
   * no import changes needed.
   */
  @Test
  public void testStaticWildcardImport() {
    assertRefactorWithClassPath(AssertTrueStaticImportExample.class, OPERATION, JUNIT4_CLASSPATH);
  }

  /**
   * Cases that must NOT be rewritten:
   * plain boolean variables, non-equals method calls, compound boolean expressions.
   */
  @Test
  public void testNoopCases() {
    assertRefactorWithClassPath(AssertTrueNoopExample.class, OPERATION, JUNIT4_CLASSPATH);
  }
}
