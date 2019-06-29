package test.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/25
 */
@Documented
@Target({FIELD, METHOD, CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnotation {

    String value();

}
