package task07;

import java.lang.annotation.*;

/**
 * Created by wopqw on 25.09.16.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    String language() default "Java";
    String info() default "Annotation example";
}
