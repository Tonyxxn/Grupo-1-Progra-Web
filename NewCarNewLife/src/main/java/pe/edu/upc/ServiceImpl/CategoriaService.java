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
	private ICategoriaDao cDao;

	@Override
	public void insert(Categoria c) {
		// TODO Auto-generated method stub
		cDao.insert(c);
	}

	@Override
	public List<Categoria> list() {
		// TODO Auto-generated method stub
		return cDao.list();
	}
	
	

}
