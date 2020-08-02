package apo.jee.eight.web.qualifier;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
@BeanOneChild
public class BeanTwo extends BeanOne {

    public void doSomethingElse() {

    }
}
