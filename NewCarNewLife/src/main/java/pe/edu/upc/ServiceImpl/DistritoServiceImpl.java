package pe.edu.upc.ServiceImpl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.Dao.IDistritoDao;
import pe.edu.upc.Entities.Distrito;
import pe.edu.upc.Service.IDistritoService;

public class DistritoServiceImpl implements IDistritoService {

	@Inject
	private IDistritoDao dDao;

	@Override
	public void insert(Distrito d) {
		// TODO Auto-generated method stub
		dDao.insert(d);
	}

	@Override
	public List<Distrito> list() {
		// TODO Auto-generated method stub
		return dDao.list();
	}

	@Override
	public void eliminar(int cdistrito) {
		// TODO Auto-generated method stub
		dDao.eliminar(cdistrito);
	}

	@Override
	public List<Distrito> findByNameDistrito(Distrito d) {
		// TODO Auto-generated method stub
		return dDao.findByNameDistrito(d);
	}

	@Override
	public void modificar(Distrito d) {
		// TODO Auto-generated method stub
		dDao.modificar(d);
	}

}
