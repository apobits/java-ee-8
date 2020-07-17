package apo.jee.eight.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
	HtmlInputText htmlInputText = (HtmlInputText) uiComponent;
	if (!org.apache.commons.validator.EmailValidator.getInstance().isValid((String) object)) {
	    throw new ValidatorException(new FacesMessage(htmlInputText.getLabel() + " is not a valid email"));
	}
    }
}
