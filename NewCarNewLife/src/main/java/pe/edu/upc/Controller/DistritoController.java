package pe.edu.upc.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Entities.Distrito;
import pe.edu.upc.Entities.Provincia;
import pe.edu.upc.Service.IDistritoService;
import pe.edu.upc.Service.IProvinciaService;

@Named
@RequestScoped
public class DistritoController {

	@Inject
	private IDistritoService dService;

	@Inject
	private IProvinciaService pService;

	private Distrito distrito;
	private Provincia provincia;

	List<Distrito> listaDistrito;
	List<Provincia> listaProvincia;

	@PostConstruct
	public void init() {
		this.listaDistrito = new ArrayList<Distrito>();
		this.listaProvincia = new ArrayList<Provincia>();
		this.distrito = new Distrito();
		this.provincia = new Provincia();
		this.listDistrito();
		this.listProvincia();
	}

	public String newDistrito() {
		this.setDistrito(new Distrito());
		return "Distrito.xhtml";
	}

	public void insertDistrito() {
		try {
			dService.insert(distrito);
			this.listDistrito();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	public void listDistrito() {
		listaDistrito = dService.list();
	}

	public void listProvincia() {
		listaProvincia = pService.list();
	}

	public void eliminar(Distrito d) {
		try {
			dService.eliminar(d.getCdistrito());
			listDistrito();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void clean() {
		this.init();
	}
	
	public void findByName() {
		try {
			if (distrito.getNdistrito().isEmpty()) {
				this.listDistrito();
			}else {
				listaDistrito=this.dService.findByNameDistrito(this.getDistrito());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	//modificar
	
	public void modificar() {
		try {
			dService.modificar(this.distrito);
			this.listDistrito();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public String Modifpre(Distrito dis) {
		this.setDistrito(dis);
		return "DistritoMod.xhtml";
	}
	
	//setters y getters
	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Distrito> getListaDistrito() {
		return listaDistrito;
	}

	public void setListaDistrito(List<Distrito> listaDistrito) {
		this.listaDistrito = listaDistrito;
	}

	public List<Provincia> getListaProvincia() {
		return listaProvincia;
	}

	public void setListaProvincia(List<Provincia> listaProvincia) {
		this.listaProvincia = listaProvincia;
	}

}
