package pe.edu.upc.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Entities.Categoria;
import pe.edu.upc.Entities.Propietario;
import pe.edu.upc.Service.ICategoriaService;
import pe.edu.upc.Service.IPropietarioService;

@Named
@RequestScoped
public class propietarioController {

	@Inject
	private IPropietarioService prService;

	@Inject
	private ICategoriaService cService;

	private Propietario propietario;
	private Categoria categoria;

	List<Propietario> listapropietarios;
	List<Categoria> listacategorias;

	@PostConstruct
	public void init() throws Exception {
		this.listapropietarios = new ArrayList<Propietario>();
		this.listacategorias = new ArrayList<Categoria>();
		this.propietario = new Propietario();
		this.categoria = new Categoria();
		this.listCategoria();
		this.listPropietario();
	}
	
	public String newPropietario() {
		this.setPropietario(new Propietario());
		return "propietario.xhtml";
	}
	
	public void listCategoria() {
		listacategorias=cService.list();
	}
	
	public void insertPropietario() throws Exception {
		prService.insert(propietario);
		this.listPropietario();
	}
	
	public void listPropietario() throws Exception {
		listapropietarios= prService.list();
	}
	
	public void eliminar(Propietario pr) {
		try {
			prService.eliminar(pr.getCpropietario());
			listPropietario();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void clean() throws Exception {
		this.init();
	}
	
	public void buscarpornombre() {
		try {
			if (propietario.getNpropietario().isEmpty()) {
				this.listPropietario();
			}else {
				listapropietarios = this.prService.buscarpornombre(this.getPropietario());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	//modificar
	
	public void modificar() {
		try {
			prService.modificar(this.propietario);
			this.listPropietario();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public String modifpre(Propietario pr) {
		this.setPropietario(pr);
		return "propietarioMod.xhtml";
	}
	
	//set y get

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Propietario> getListapropietarios() {
		return listapropietarios;
	}

	public void setListapropietarios(List<Propietario> listapropietarios) {
		this.listapropietarios = listapropietarios;
	}

	public List<Categoria> getListacategorias() {
		return listacategorias;
	}

	public void setListacategorias(List<Categoria> listacategorias) {
		this.listacategorias = listacategorias;
	}

	
	
	

}
