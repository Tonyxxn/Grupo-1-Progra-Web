package pe.edu.upc.Service;

import java.util.List;

import pe.edu.upc.Entities.Distrito;

public interface IDistritoService {

	public void insert(Distrito d);

	public List<Distrito> list();
	
	public void eliminar(int cdistrito);
	public List<Distrito> findByNameDistrito(Distrito d);
	
	public void modificar(Distrito d);

}
