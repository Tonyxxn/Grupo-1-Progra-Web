package pe.edu.upc.ServiceImpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Dao.ICategoriaDao;
import pe.edu.upc.Entities.Categoria;
import pe.edu.upc.Service.ICategoriaService;

@Named
@RequestScoped
public class CategoriaService implements ICategoriaService {

	@Inject
	private ICategoriaDao cdao;

	@Override
	public void insert(Categoria c) {
		// TODO Auto-generated method stub
		cdao.insert(c);
	}

	@Override
	public List<Categoria> list() {
		// TODO Auto-generated method stub
		return cdao.list();
	}

	@Override
	public void eliminar(int ccategoria) {
		// TODO Auto-generated method stub
		cdao.eliminar(ccategoria);
	}

	@Override
	public List<Categoria> findByNameCategoria(Categoria cat) {
		// TODO Auto-generated method stub
		return cdao.findByNameCategoria(cat);
	}

	@Override
	public void modificar(Categoria cat) {
		// TODO Auto-generated method stub
		cdao.modificar(cat);
	}
	
	

}
