package org.alfasoftware.astra.core.refactoring.javapattern.nojavapattern;

import org.alfasoftware.astra.core.refactoring.operations.javapattern.JavaPatternReplacement;

/**
 * A matcher file with a @JavaPatternReplacement method but no @JavaPattern method at all,
 * so there is nothing to match against.
 */
class NoJavaPatternMethodsPattern {

  void notAPattern(String string) {
    string.trim();
  }

  @JavaPatternReplacement
  void replacement(String string) {
    string.strip();
  }
}
