package pe.edu.upc.ServiceImpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Dao.IModeloDao;
import pe.edu.upc.Entities.Modelo;
import pe.edu.upc.Service.IModeloService;

@Named
@RequestScoped
public class ModeloServiceImpl implements IModeloService {
	
	@Inject
	private IModeloDao moDao;

	@Override
	public void insert(Modelo mo) {
		// TODO Auto-generated method stub
		moDao.insert(mo);
	}

	@Override
	public List<Modelo> list() {
		// TODO Auto-generated method stub
		return moDao.list();
	}

	@Override
	public void eliminar(int Cmodelo) {
		// TODO Auto-generated method stub
		moDao.eliminar(Cmodelo);
	}

	@Override
	public void modificar(Modelo mo) {
		// TODO Auto-generated method stub
		moDao.modificar(mo);
	}

	@Override
	public List<Modelo> buscarpornombre(Modelo mo) {
		// TODO Auto-generated method stub
		return moDao.buscarpornombre(mo);
	}
	
	
	

}
