package pe.edu.upc.Service;

import java.util.List;

import pe.edu.upc.Entities.Propietario;

public interface IPropietarioService {

	public void insert(Propietario pr);
	public List<Propietario> list();

}
