package pe.edu.upc.Controller;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;


import pe.edu.upc.Entities.Propietario;
//import pe.edu.upc.Entities.Rol;
import pe.edu.upc.Entities.User;
import pe.edu.upc.Service.IPropietarioService;
//import pe.edu.upc.Service.IRolService;

@Named
@ViewScoped
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IPropietarioService pS;

	//@Inject
	//private IRolService rS;

	private Propietario propietario;
	private User user;

	@PostConstruct
	public void init() {
		this.propietario = new Propietario();
		this.user = new User();
	}

	public String registerUser() {
		String redirect = null;
		try {
			String password = this.user.getPassword();
			String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
			this.user.setPassword(passwordHash);
			this.user.setState("A");
			this.propietario.setUser(user);
			this.user.setPropietario(propietario);
			this.pS.insert(propietario);

			//List<Rol> roles = new ArrayList<Rol>();
			//int TIPO_USUARIO = 1;
			//Rol r = new Rol();
			//r.setId(TIPO_USUARIO);
			//roles.add(r);
			//rS.assignRolesToUser(user, roles);
			redirect = "index?faces-redirect=true";
		} catch (Exception e) {

		}

		return redirect;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

}
