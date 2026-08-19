package org.alfasoftware.astra.core.refactoring.javapattern.replacementmethodcount;

import static org.junit.Assert.assertThrows;

import java.nio.file.Path;

import org.alfasoftware.astra.core.refactoring.AbstractRefactorTest;
import org.alfasoftware.astra.core.refactoring.operations.javapattern.JavaPatternASTOperation;
import org.junit.Test;

/**
 * Tests that a matcher file is rejected unless it has exactly one @JavaPatternReplacement method.
 *
 * See {@link ZeroReplacementMethodsPattern} and {@link MultipleReplacementMethodsPattern} for details.
 */
public class TestReplacementMethodCount extends AbstractRefactorTest {

  @Test
  public void testZeroJavaPatternReplacementMethodsThrows() {
    assertThrows(IllegalArgumentException.class, () ->
        new JavaPatternASTOperation(
            Path.of(TEST_EXAMPLES + "/" + ZeroReplacementMethodsPattern.class.getName().replaceAll("\\.", "/") + ".java")
        )
    );
  }

  @Test
  public void testMultipleJavaPatternReplacementMethodsThrows() {
    assertThrows(IllegalArgumentException.class, () ->
        new JavaPatternASTOperation(
            Path.of(TEST_EXAMPLES + "/" + MultipleReplacementMethodsPattern.class.getName().replaceAll("\\.", "/") + ".java")
        )
    );
  }

}
