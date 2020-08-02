package apo.jee.eight.web.qualifier;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Qualifier
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface BeanOneChild {
}
