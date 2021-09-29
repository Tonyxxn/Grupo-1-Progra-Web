package pe.edu.upc.Dao;

import java.util.List;

import pe.edu.upc.Entities.Categoria;

public interface ICategoriaDao {
	
	public void insert(Categoria c);
	
	public List<Categoria> list();
	
	public void eliminar(int ccategoria);
	
	public List<Categoria> findByNameCategoria(Categoria c);
	
	public void modificar(Categoria cat);

}
