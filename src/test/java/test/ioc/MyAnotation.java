package test.ioc;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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

    String[] value();

}
