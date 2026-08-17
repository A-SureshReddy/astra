package org.alfasoftware.astra.core.refactoring.javapattern.ambiguousmatch;

import org.alfasoftware.astra.core.refactoring.operations.javapattern.JavaPattern;
import org.alfasoftware.astra.core.refactoring.operations.javapattern.JavaPatternReplacement;

class AmbiguousMatchPattern {

  @JavaPattern
  void firstPatternToMatch(String string) {
    string.trim();
  }

  @JavaPattern
  void secondPatternToMatch(String text) {
    text.trim();
  }

  @JavaPatternReplacement
  void patternReplacement(String string) {
    string.strip();
  }
}
