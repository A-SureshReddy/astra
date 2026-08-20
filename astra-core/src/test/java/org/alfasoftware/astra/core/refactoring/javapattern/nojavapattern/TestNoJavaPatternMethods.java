package org.alfasoftware.astra.core.refactoring.javapattern.nojavapattern;

import static org.junit.Assert.assertThrows;

import java.nio.file.Path;

import org.alfasoftware.astra.core.refactoring.AbstractRefactorTest;
import org.alfasoftware.astra.core.refactoring.operations.javapattern.JavaPatternASTOperation;
import org.junit.Test;

/**
 * Tests that a matcher file is rejected when it has no @JavaPattern method to match against.
 *
 * See {@link NoJavaPatternMethodsPattern} for details.
 */
public class TestNoJavaPatternMethods extends AbstractRefactorTest {

  @Test
  public void testNoJavaPatternMethodsThrows() {
    assertThrows(IllegalStateException.class, () ->
        new JavaPatternASTOperation(
            Path.of(TEST_EXAMPLES + "/" + NoJavaPatternMethodsPattern.class.getName().replaceAll("\\.", "/") + ".java")
        )
    );
  }

}
