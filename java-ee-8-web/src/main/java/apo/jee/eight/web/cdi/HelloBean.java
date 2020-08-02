package apo.jee.eight.web.cdi;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class HelloBean implements Serializable {

    @Inject
    FacesContext facesContext;

    private String name = "Be strong Albin!!!!";
    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void process() {
        facesContext.addMessage(null, new FacesMessage("Hello there"));
    }
}
