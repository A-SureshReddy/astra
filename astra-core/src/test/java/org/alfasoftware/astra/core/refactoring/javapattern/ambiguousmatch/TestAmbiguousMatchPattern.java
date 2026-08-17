package org.alfasoftware.astra.core.refactoring.javapattern.ambiguousmatch;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

import org.alfasoftware.astra.core.refactoring.AbstractRefactorTest;
import org.alfasoftware.astra.core.refactoring.operations.javapattern.JavaPatternASTOperation;
import org.alfasoftware.astra.core.utils.AstraCore;
import org.junit.Test;

/**
 * A matcher file may declare more than one @JavaPattern, but only ever one shared
 * @JavaPatternReplacement. If two @JavaPatterns both match the same candidate node, there is no
 * way to tell which match should be rewritten, and applying both in turn would attempt to
 * rewrite the same node twice. This now fails fast instead of leaving the rewrite in an
 * unpredictable state.
 *
 * See {@link AmbiguousMatchPattern} for the matcher file under test.
 */
public class TestAmbiguousMatchPattern extends AbstractRefactorTest {

  @Test
  public void twoPatternsMatchingTheSameNodeIsRejected() throws IOException {
    Path patternFile = Path.of(TEST_EXAMPLES + "/"
        + AmbiguousMatchPattern.class.getName().replaceAll("\\.", "/") + ".java");
    Path exampleFile = Path.of(TEST_EXAMPLES + "/"
        + AmbiguousMatchExample.class.getName().replaceAll("\\.", "/") + ".java");
    String exampleSource = new String(Files.readAllBytes(exampleFile));

    JavaPatternASTOperation operation = new JavaPatternASTOperation(patternFile);

    IllegalStateException exception = assertThrows(IllegalStateException.class,
        () -> new AstraCore().applyOperationsToFile(
            exampleFile, exampleSource, Collections.singleton(operation), new String[]{TEST_SOURCE}, new String[0]));

    assertTrue(exception.getMessage().contains("Ambiguous match"));
  }

}
