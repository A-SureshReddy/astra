package org.alfasoftware.astra.core.refactoring.javapattern.multistatementreplacement;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.nio.file.Path;

import org.alfasoftware.astra.core.refactoring.AbstractRefactorTest;
import org.alfasoftware.astra.core.refactoring.operations.javapattern.JavaPatternASTOperation;
import org.junit.Test;

/**
 * A method annotated with @JavaPatternReplacement must have exactly one statement in its body.
 * Previously, any statements after the first were silently discarded when building the
 * replacement template; this now fails fast instead of producing an incomplete replacement.
 *
 * See {@link MultiStatementReplacementPattern} for the matcher file under test.
 */
public class TestMultiStatementReplacementPattern extends AbstractRefactorTest {

  @Test
  public void multiStatementReplacementBodyIsRejected() {
    Path patternFile = Path.of(TEST_EXAMPLES + "/"
        + MultiStatementReplacementPattern.class.getName().replaceAll("\\.", "/") + ".java");

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new JavaPatternASTOperation(patternFile));

    assertTrue(exception.getMessage().contains("@JavaPatternReplacement"));
  }

}
