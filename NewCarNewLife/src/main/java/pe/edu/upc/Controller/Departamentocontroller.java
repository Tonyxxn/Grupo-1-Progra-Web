package pe.edu.upc.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Entities.Departamento;
import pe.edu.upc.Service.IDepartamentoService;

@Named
@RequestScoped
public class Departamentocontroller {

	@Inject
	private IDepartamentoService dService;

	private Departamento departamento;
	
	List<Departamento> listaDepartamentos;
	
	@PostConstruct
	private void init() {
		this.listaDepartamentos = new ArrayList<Departamento>();
		this.departamento = new Departamento();
		this.list();
	}
	
	public String newDepartamento() {
		this.setDepartamento(new Departamento());
		return "departamento.xhtml";
	}
	
	public void insert() {
		try {
			dService.insert(departamento);
			this.list();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void list() {
		listaDepartamentos = dService.list();
	}
	
	//eliminar buscar
	
	public void eliminar(Departamento dep) {
		try {
			dService.eliminar(dep.getCdepartamento());
			list();
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
			if (departamento.getNdepartamento().isEmpty()) {
				this.list();
			} else {
				listaDepartamentos = this.dService.findByNameDepartamento(this.getDepartamento());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	//modificar
	
	public void modificar() {
		try {
			dService.modificar(this.departamento);
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public String Modifpre(Departamento dep) {
		this.setDepartamento(dep);
		return "departamentoMod.xhtml";
	}
	
	//setter y getters
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Departamento> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}

	// get y set
	

}
