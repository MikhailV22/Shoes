package JSF;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import java.io.Serializable;
import javax.inject.Named;
import javax.servlet.http.HttpSession;



@Named("userController")
@SessionScoped
public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userId = Long.valueOf(0);
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getSessionId()  {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(false);
        return  session.getId(); 
        
    }
	
	public String getIdentifier()  {
		return getUserId().equals(Long.valueOf(0))?getSessionId():getUserId().toString();
	}
}
