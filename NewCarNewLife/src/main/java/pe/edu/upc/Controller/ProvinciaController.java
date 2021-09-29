package pe.edu.upc.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Entities.Departamento;
import pe.edu.upc.Entities.Provincia;
import pe.edu.upc.Service.IDepartamentoService;
import pe.edu.upc.Service.IProvinciaService;

@Named
@RequestScoped
public class ProvinciaController {

	// metodos
	@Inject
	private IProvinciaService pService;
	@Inject
	private IDepartamentoService dService;

	// atributos

	List<Provincia> listaProvincias;
	List<Departamento> listaDepartamentos;

	private Provincia provincia;
	private Departamento departamento;

	// constructor
	@PostConstruct
	public void init() {
		this.listaProvincias = new ArrayList<Provincia>();
		this.listaDepartamentos = new ArrayList<Departamento>();
		this.provincia = new Provincia();
		this.departamento = new Departamento();
		this.listDepartamento();
		this.listProvincia();

	}

	// metodos personalizados

	public String newProvincia() {

		this.setProvincia(new Provincia());

		return "Provincia.xhtml";
	}

	public void listDepartamento() {

		listaDepartamentos = dService.list();

	}

	public void insertProvincia() {
		pService.insert(provincia);
		this.listProvincia();
	}

	public void listProvincia() {
		listaProvincias = pService.list();
	}
	
	//eliminar
	
	public void eliminar(Provincia prov) {
		try {
			pService.eliminar(prov.getCprovincia());
			listProvincia();
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
			if (provincia.getNprovincia().isEmpty()) {
				this.listProvincia();
			} else {
				listaProvincias=this.pService.findByNameProvincia(this.getProvincia());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	//modificar
	
	public void modificar() {
		try {
			pService.modificar(this.provincia);
			this.listProvincia();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public String Modifpre(Provincia prov) {
		this.setProvincia(prov);
		return "ProvinciaMod.xhtml";
	}

	//setters y getters
	public List<Provincia> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	public List<Departamento> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	// get y set
	
	

}
