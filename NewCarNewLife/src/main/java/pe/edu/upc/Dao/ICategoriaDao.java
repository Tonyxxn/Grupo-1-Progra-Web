package pe.edu.upc.Dao;

import java.util.List;

import pe.edu.upc.Entities.Categoria;

public interface ICategoriaDao {
	
	public void insert(Categoria c);
	
	public List<Categoria> list();

}
