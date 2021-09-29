package pe.edu.upc.Service;

import java.util.List;

import pe.edu.upc.Entities.Estado;

public interface IEstadoService {

	public void insert(Estado es);
	public List<Estado> list();
}
