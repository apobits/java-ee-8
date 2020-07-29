package apo.jee.eight.web.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ApplicationScoped
@Named
public class MessageSenderBean implements Serializable {

    @Inject
    @Push
    private PushContext pushContext;

    public void send(String message) {
	pushContext.send(message);
    }
}
