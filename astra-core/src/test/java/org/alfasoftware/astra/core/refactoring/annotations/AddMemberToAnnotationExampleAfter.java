package org.alfasoftware.astra.core.refactoring.annotations;

import org.alfasoftware.astra.exampleTypes.AnnotationD;

public class AddMemberToAnnotationExampleAfter {

  @AnnotationD(boolvalue = true, intvalue = 123, othervalue = "BAR")
  protected long someField;

  @AnnotationD(value = "Foo", boolvalue = true, intvalue = 123, othervalue = "BAR")
  protected long someOtherField;

  @AnnotationD(value="A string of no importance", boolvalue = true, intvalue = 123, othervalue = "BAR")
  protected String someStringField;
}

