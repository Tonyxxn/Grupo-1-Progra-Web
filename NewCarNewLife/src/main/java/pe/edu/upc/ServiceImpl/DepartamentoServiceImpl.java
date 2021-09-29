package pe.edu.upc.ServiceImpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Dao.IDepartamentoDao;
import pe.edu.upc.Entities.Departamento;
import pe.edu.upc.Service.IDepartamentoService;

@Named
@RequestScoped
public class DepartamentoServiceImpl implements IDepartamentoService {

	@Inject
	private IDepartamentoDao dDao;

	public void insert(Departamento d) {
		// TODO Auto-generated method stub

		dDao.insert(d);
	}

	public List<Departamento> list() {
		// TODO Auto-generated method stub
		return dDao.list();
	}

	@Override
	public void eliminar(int cdepartamento) {
		// TODO Auto-generated method stub
		dDao.eliminar(cdepartamento);
		
	}

	@Override
	public List<Departamento> findByNameDepartamento(Departamento dep) {
		// TODO Auto-generated method stub
		return dDao.findByNameDepartamento(dep);
	}

	@Override
	public void modificar(Departamento dep) {
		// TODO Auto-generated method stub
		dDao.modificar(dep);
	}

}
