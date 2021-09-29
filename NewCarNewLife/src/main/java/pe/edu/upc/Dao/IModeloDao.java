package pe.edu.upc.Dao;

import java.util.List;

import pe.edu.upc.Entities.Modelo;

public interface IModeloDao {

	public void insert(Modelo mo);
	
	public void eliminar(int Cmodelo);
	
	public void modificar(Modelo mo);
	
	public List<Modelo> list();
	
	public List<Modelo> buscarpornombre(Modelo mo);
}
