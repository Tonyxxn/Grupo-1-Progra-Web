package pe.edu.upc.Service;

import java.util.List;

import pe.edu.upc.Entities.Vehiculo;

public interface IVehiculoService {

	public void insert(Vehiculo v);
	
	public void eliminar(int Cplaca);
	
	public void modificar(Vehiculo v);
	
	public List<Vehiculo> buscarpornombre(Vehiculo v);
	
	public List<Vehiculo> list();
}
