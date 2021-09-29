package pe.edu.upc.Controller;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Entities.User;
import pe.edu.upc.ServiceImpl.UserServiceImpl;

@Named
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserServiceImpl uS;

	private User user;

	@PostConstruct
	public void init() {
		this.user = new User();
	}

	public String authentication() {
		String redirect = null;

		try {
			Optional<User> userFound = this.uS.authentication(user);

			if (userFound.isPresent() && userFound.get().getState().equalsIgnoreCase("A")) {
				// Almacenar en la sesi�n de JSF
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userFound.get());
				redirect = "/panel?faces-redirect=true";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		return redirect;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
