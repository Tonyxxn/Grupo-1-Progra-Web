package pe.edu.upc.ServiceImpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Dao.IpropietarioDao;
import pe.edu.upc.Entities.Propietario;
import pe.edu.upc.Service.IPropietarioService;

@Named
@RequestScoped
public class PropietarioService implements IPropietarioService {

	@Inject
	private IpropietarioDao prDao;

	@Override
	public void insert(Propietario pr) {
		// TODO Auto-generated method stub
		prDao.insert(pr);
	}

	@Override
	public List<Propietario> list() {
		// TODO Auto-generated method stub
		return prDao.list();
	}

}
