package pe.edu.upc.ServiceImpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Dao.IVehiculoDao;
import pe.edu.upc.Entities.Vehiculo;
import pe.edu.upc.Service.IVehiculoService;

@Named
@RequestScoped
public class VehiculoServiceImpl implements IVehiculoService{

	@Inject
	private IVehiculoDao vDao;

	@Override
	public void insert(Vehiculo v) {
		// TODO Auto-generated method stub
		vDao.insert(v);
	}

	@Override
	public List<Vehiculo> list() {
		// TODO Auto-generated method stub
		return vDao.list();
	}

	@Override
	public void eliminar(int Cplaca) {
		// TODO Auto-generated method stub
		vDao.elminar(Cplaca);
	}

	@Override
	public void modificar(Vehiculo v) {
		// TODO Auto-generated method stub
		vDao.modificar(v);
	}

	@Override
	public List<Vehiculo> buscarpornombre(Vehiculo v) {
		// TODO Auto-generated method stub
		return vDao.buscarpornombre(v);
	}
	
}
