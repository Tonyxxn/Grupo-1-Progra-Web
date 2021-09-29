package pe.edu.upc.Service;

import java.util.List;

import pe.edu.upc.Entities.Categoria;

public interface ICategoriaService {

	public void insert(Categoria c);

	public List<Categoria> list();
	
	public void eliminar(int ccategoria);
	
	public List<Categoria> findByNameCategoria(Categoria cat);
	
	public void modificar(Categoria cat);

}
