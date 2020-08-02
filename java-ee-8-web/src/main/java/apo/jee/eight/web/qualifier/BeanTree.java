package apo.jee.eight.web.qualifier;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class BeanTree {

    @Inject
    @BeanOneChild
    private BeanOne beanOne;

    public void test() {
        beanOne.doSomething();
        BeanTwo beanTwo = (BeanTwo) beanOne;
        beanTwo.doSomethingElse();
    }
}
