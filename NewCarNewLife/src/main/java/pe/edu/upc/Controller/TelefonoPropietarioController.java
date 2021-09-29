package pe.edu.upc.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Entities.Propietario;
import pe.edu.upc.Entities.TelefonoPropietario;
import pe.edu.upc.Service.IPropietarioService;
import pe.edu.upc.Service.ITelefonoPropietarioService;

@Named
@RequestScoped
public class TelefonoPropietarioController {

	@Inject
	private ITelefonoPropietarioService telpropService;

	@Inject
	private IPropietarioService prService;

	private Propietario propietario;
	private TelefonoPropietario telprop;

	List<TelefonoPropietario> listatelprop;
	List<Propietario> listapropietarios;

	@PostConstruct
	public void init() throws Exception {
		this.listapropietarios = new ArrayList<Propietario>();
		this.listatelprop = new ArrayList<TelefonoPropietario>();
		this.propietario = new Propietario();
		this.telprop = new TelefonoPropietario();
		this.listTelefonoPropietario();
		this.listPropietario();
	}

	public String newTelefonoPropietario() {
		this.setTelprop(new TelefonoPropietario());

		return "Telefono.xhtml";
	}

	public void listTelefonoPropietario() {
		listatelprop = telpropService.list();
	}

	public void insertTelefonoPropietario() {
		telpropService.insert(telprop);
	}

	public void listPropietario() throws Exception {
		listapropietarios = prService.list();
	}

	public void eliminar(TelefonoPropietario tele) {
		try {
			telpropService.eliminar(tele.getCtelefonoprop());
			listTelefonoPropietario();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clean() throws Exception {
		this.init();
	}

	public void findByName() {
		try {
			if (telprop.getTtelefono().isEmpty()) {
				this.listTelefonoPropietario();
			} else {
				listatelprop = this.telpropService.findByNameTelefono(this.getTelprop());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	//modificar
	
	public void modificar() {
		try {
			telpropService.modificar(this.telprop);
			this.listTelefonoPropietario();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public String Modifpre(TelefonoPropietario telef) {
		this.setTelprop(telef);
		return "TelefonoMod.xhtml";
	}

	// set y get

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public TelefonoPropietario getTelprop() {
		return telprop;
	}

	public void setTelprop(TelefonoPropietario telprop) {
		this.telprop = telprop;
	}

	public List<TelefonoPropietario> getListatelprop() {
		return listatelprop;
	}

	public void setListatelprop(List<TelefonoPropietario> listatelprop) {
		this.listatelprop = listatelprop;
	}

	public List<Propietario> getListapropietarios() {
		return listapropietarios;
	}

	public void setListapropietarios(List<Propietario> listapropietarios) {
		this.listapropietarios = listapropietarios;
	}

}
