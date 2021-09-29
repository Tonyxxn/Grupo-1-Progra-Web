package pe.edu.upc.ServiceImpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Dao.IEstadoDao;
import pe.edu.upc.Entities.Estado;
import pe.edu.upc.Service.IEstadoService;

@Named
@RequestScoped
public class EstadoServiceImpl implements IEstadoService {

	@Inject
	private IEstadoDao mDao;
	
	public void insert(Estado es) {
		// TODO Auto-generated method stub
		mDao.insert(es);
	}

	public List<Estado> list() {
		// TODO Auto-generated method stub
		return mDao.list();
	}
	
}
