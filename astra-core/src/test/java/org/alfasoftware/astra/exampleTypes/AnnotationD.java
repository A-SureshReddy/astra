package org.alfasoftware.astra.exampleTypes;

public @interface AnnotationD {

  String value() default "";

  String othervalue() default "";

  boolean boolvalue() default false;

  int intvalue() default 0;
}
