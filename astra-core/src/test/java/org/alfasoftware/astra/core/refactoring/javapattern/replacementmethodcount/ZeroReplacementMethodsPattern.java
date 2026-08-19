package org.alfasoftware.astra.core.refactoring.javapattern.replacementmethodcount;

import org.alfasoftware.astra.core.refactoring.operations.javapattern.JavaPattern;

/**
 * A matcher file with a @JavaPattern method but no @JavaPatternReplacement method at all.
 */
class ZeroReplacementMethodsPattern {

  @JavaPattern
  void patternToMatch(String string) {
    string.trim();
  }
}
