package pe.edu.upc.Service;

import java.util.List;

import pe.edu.upc.Entities.Marca;

public interface IMarcaService {

	public void insert(Marca ma);
	
	public void eliminar(int Cmarca);
	
	public void modificar(Marca ma);
	
	public List<Marca> list();
	
	public List<Marca> buscarpornombre(Marca ma);
}
