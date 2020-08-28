package apo.jee.eight.web.cdi;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class ChatBean implements Serializable {
    @Inject
    private MessageSenderBean messageSenderBean;

    private String name;
    private String message;

    public void sendMessage() {
        messageSenderBean.send(String.format("%s: %s", name, message));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        String description = "text to > convert into& what we want";

        String systemParameter = "&=,>=_";

        String[] values = systemParameter.split(",");

        for (String value : values) {
            String temp[] = value.split("");
            String toReplace = temp.length == 3 ? temp[2] : "";
            description = description.replaceAll(temp[0], toReplace);
        }
        System.out.println(description);
    }
}
