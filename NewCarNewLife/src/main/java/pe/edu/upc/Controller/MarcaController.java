	package pe.edu.upc.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Entities.Marca;
import pe.edu.upc.Service.IMarcaService;

@Named
@RequestScoped
public class MarcaController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IMarcaService mService;

	private Marca marca;
	
	List<Marca> listaMarcas;
	
	@PostConstruct
	private void init() {
		this.listaMarcas = new ArrayList<Marca>();
		this.marca = new Marca();
		this.list();
	}
	
	public String newMarca() {
		this.setMarca(new Marca());
		return "marca.xhtml";
	}
	
	public void insert() {
		try {
			mService.insert(marca);
			this.list();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void elminar(Marca ma) {
		
		try {
			mService.eliminar(ma.getCmarca());
			list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Esta en otra tabla no se puede eliminar"); 
		}
	}
	
	public void clean() {
		this.init();
	}
	
	public void buscarporNombre() {
		try {
			if (marca.getNmarca().isEmpty()) {
				this.list();
			} else {
				listaMarcas = this.mService.buscarpornombre(this.getMarca());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	//modificar
	public void modificar() {
		try {
			mService.modificar(this.marca);
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public String Modifpre(Marca ma) {
		this.setMarca(ma);
		return "marcaMod.xhtml";
		
	}
	
	public void list() {
		listaMarcas = mService.list();
	}
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Marca> getListaMarcas() {
		return listaMarcas;
	}

	public void setListaMarcas(List<Marca> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}
	
	
	

}
