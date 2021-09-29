package pe.edu.upc.ServiceImpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Dao.IMarcaDao;
import pe.edu.upc.Entities.Marca;
import pe.edu.upc.Service.IMarcaService;

@Named
@RequestScoped
public class MarcaServiceImpl implements IMarcaService{

	@Inject
	private IMarcaDao mDao;

	public void insert(Marca ma) {
		// TODO Auto-generated method stub
		mDao.insert(ma);
	}

	public List<Marca> list() {
		// TODO Auto-generated method stub
		
		return mDao.list();
	}

	@Override
	public void eliminar(int Cmarca) {
		// TODO Auto-generated method stub
		mDao.eliminar(Cmarca);
	}

	@Override
	public List<Marca> buscarpornombre(Marca ma) {
		// TODO Auto-generated method stub
		return mDao.buscapornombre(ma);
	}

	@Override
	public void modificar(Marca ma) {
		// TODO Auto-generated method stub
		mDao.modificar(ma);
		
	}
	
	
	
}
