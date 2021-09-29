package pe.edu.upc.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Entities.Estado;
import pe.edu.upc.Service.IEstadoService;

@Named
@RequestScoped
public class EstadoController implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IEstadoService eService; 
	
	private Estado estado;
	
	List<Estado> listaEstados;
	
	@PostConstruct
	public void init() {
		this.listaEstados = new ArrayList<Estado>();
		this.estado= new Estado();
		this.list();
		
	}

	
	public String newEstado(){
		this.setEstado(new Estado());
		return "estado.xhtml";
	}
	
	public void insert() {
		
		try {
			eService.insert(estado);
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	private void list() {
		// TODO Auto-generated method stub
		listaEstados=eService.list();
	}


	public IEstadoService geteService() {
		return eService;
	}


	public void seteService(IEstadoService eService) {
		this.eService = eService;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public List<Estado> getListaEstados() {
		return listaEstados;
	}


	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}



	
}
