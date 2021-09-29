package pe.edu.upc.Dao;

import java.util.List;

import pe.edu.upc.Entities.Estado;

public interface IEstadoDao {

	public void insert(Estado es);
	public List<Estado> list();
}
