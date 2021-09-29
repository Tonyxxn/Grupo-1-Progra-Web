package pe.edu.upc.Service;

import java.util.List;

import pe.edu.upc.Entities.Provincia;

public interface IProvinciaService {

	public void insert(Provincia p);
	public List<Provincia> list();
	
	public void eliminar(int cprovincia);
	public List<Provincia> findByNameProvincia(Provincia prov);
	
	public void modificar(Provincia prov);
	
}