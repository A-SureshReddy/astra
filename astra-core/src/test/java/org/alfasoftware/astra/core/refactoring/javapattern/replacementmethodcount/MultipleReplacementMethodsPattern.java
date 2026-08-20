package org.alfasoftware.astra.core.refactoring.javapattern.replacementmethodcount;

import org.alfasoftware.astra.core.refactoring.operations.javapattern.JavaPattern;
import org.alfasoftware.astra.core.refactoring.operations.javapattern.JavaPatternReplacement;

/**
 * A matcher file with a @JavaPattern method and two @JavaPatternReplacement methods,
 * which is ambiguous as to which replacement should be used.
 */
class MultipleReplacementMethodsPattern {

  @JavaPattern
  void patternToMatch(String string) {
    string.trim();
  }

  @JavaPatternReplacement
  void firstReplacement(String string) {
    string.strip();
  }

  @JavaPatternReplacement
  void secondReplacement(String string) {
    string.strip();
  }
}
