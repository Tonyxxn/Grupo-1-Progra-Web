package pe.edu.upc.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Entities.Categoria;
import pe.edu.upc.Service.ICategoriaService;

@Named
@RequestScoped
public class CategoriaController {

	@Inject
	private ICategoriaService cService;

	private Categoria categoria;

	List<Categoria> listacategorias;

	@PostConstruct
	public void init() {
		this.listacategorias = new ArrayList<Categoria>();
		this.categoria = new Categoria();
		this.list();
	}

	public String newCategoria() {
		this.setCategoria(new Categoria());
		return "categoria.xhtml";
	}

	public void insert() {
		try {
			cService.insert(categoria);
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public void list() {
		listacategorias = cService.list();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListacategorias() {
		return listacategorias;
	}

	public void setListacategorias(List<Categoria> listacategorias) {
		this.listacategorias = listacategorias;
	}

	

}
