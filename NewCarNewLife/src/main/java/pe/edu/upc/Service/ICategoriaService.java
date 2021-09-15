package pe.edu.upc.Service;

import java.util.List;

import pe.edu.upc.Entities.Categoria;

public interface ICategoriaService {

	public void insert(Categoria c);

	public List<Categoria> list();

}
