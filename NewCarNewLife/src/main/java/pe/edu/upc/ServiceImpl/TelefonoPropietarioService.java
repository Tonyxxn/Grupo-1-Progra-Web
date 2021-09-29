package pe.edu.upc.ServiceImpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Dao.ITelefonoPropietarioDao;
import pe.edu.upc.Entities.TelefonoPropietario;
import pe.edu.upc.Service.ITelefonoPropietarioService;

@Named
@RequestScoped
public class TelefonoPropietarioService implements ITelefonoPropietarioService {

	@Inject
	private ITelefonoPropietarioDao tlfpropdao;

	@Override
	public void insert(TelefonoPropietario telprop) {
		// TODO Auto-generated method stub
		tlfpropdao.insert(telprop);

	}

	@Override
	public List<TelefonoPropietario> list() {
		// TODO Auto-generated method stub
		return tlfpropdao.list();
	}

	@Override
	public void eliminar(int ctelefono) {
		// TODO Auto-generated method stub
		tlfpropdao.eliminar(ctelefono);
	}

	@Override
	public List<TelefonoPropietario> findByNameTelefono(TelefonoPropietario tele) {
		// TODO Auto-generated method stub
		return tlfpropdao.findByNameTelefono(tele);
	}

	@Override
	public void modificar(TelefonoPropietario telef) {
		// TODO Auto-generated method stub
		tlfpropdao.modificar(telef);
	}

}
