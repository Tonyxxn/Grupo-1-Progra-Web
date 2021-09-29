package pe.edu.upc.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Entities.Modelo;
import pe.edu.upc.Entities.Propietario;
import pe.edu.upc.Entities.Vehiculo;
import pe.edu.upc.Service.IModeloService;
import pe.edu.upc.Service.IPropietarioService;
import pe.edu.upc.Service.IVehiculoService;

@Named
@RequestScoped
public class VehiculoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IVehiculoService vService;
	
	@Inject
	private IModeloService moService;
	
	@Inject
	private IPropietarioService pService;
	
	private Vehiculo vehiculo;
	private Modelo modelo;
	private Propietario propietario;
	
	List<Vehiculo> listaVehiculos;
	List<Modelo> listaModelos;
	List<Propietario> listaPropietarios;
	
	@PostConstruct
	public void init() throws Exception {
		this.listaVehiculos= new ArrayList<Vehiculo>();
		this.listaModelos= new ArrayList<Modelo>();
		this.listaPropietarios = new ArrayList<Propietario>();
		this.vehiculo= new Vehiculo();
		this.modelo= new Modelo();
		this.propietario= new Propietario();
		this.listModelo();
		this.listPropietario();
		this.listVehiculo();
		
	}

	public String newVehiculo() {
		this.setVehiculo(new Vehiculo());
		return "vehiculo.xhtml";
				
	}
	
	public void listModelo() {
		listaModelos= moService.list();
	}
	
	public void listPropietario() throws Exception {
		listaPropietarios= pService.list();
	}
	
	public void insertVehiculo() {
		vService.insert(vehiculo);
		this.listVehiculo();
		
	}
	
	public void listVehiculo() {
		listaVehiculos= vService.list();
	}
	
	public void eliminar(Vehiculo v) {
		try {
			vService.eliminar(v.getCplaca());
			listVehiculo();
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
			
			listaVehiculos = this.vService.buscarpornombre(this.getVehiculo());
				
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	//modificar
	
	public void modificar() {
		try {
			vService.modificar(this.vehiculo);
			this.listVehiculo();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public String Modifpre(Vehiculo v) {
		
		this.setVehiculo(v);
		return "vehiculoMod.xhtml";
		
		
	}
	
	
	
	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public List<Propietario> getListaPropietarios() {
		return listaPropietarios;
	}

	public void setListaPropietarios(List<Propietario> listaPropietarios) {
		this.listaPropietarios = listaPropietarios;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public List<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	public List<Modelo> getListaModelos() {
		return listaModelos;
	}

	public void setListaModelos(List<Modelo> listaModelos) {
		this.listaModelos = listaModelos;
	}
	
}
