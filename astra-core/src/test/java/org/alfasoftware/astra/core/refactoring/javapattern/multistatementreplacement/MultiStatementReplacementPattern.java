package org.alfasoftware.astra.core.refactoring.javapattern.multistatementreplacement;

import org.alfasoftware.astra.core.refactoring.operations.javapattern.JavaPattern;
import org.alfasoftware.astra.core.refactoring.operations.javapattern.JavaPatternReplacement;

class MultiStatementReplacementPattern {

  @JavaPattern
  void patternToMatch(String string) {
    string.trim();
  }

  @JavaPatternReplacement
  void patternReplacement(String string) {
    string.trim();
    string.toUpperCase();
  }
}
