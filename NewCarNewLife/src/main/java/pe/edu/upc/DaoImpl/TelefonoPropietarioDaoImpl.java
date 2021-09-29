package pe.edu.upc.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.Dao.ITelefonoPropietarioDao;
import pe.edu.upc.Entities.TelefonoPropietario;

public class TelefonoPropietarioDaoImpl implements ITelefonoPropietarioDao {

	@PersistenceContext(unitName = "NewCarNewLife")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(TelefonoPropietario tlprop) {
		// TODO Auto-generated method stub
		try {
			// System.out.println(tlprop.getCtelefonoprop()+" "+tlprop.getTtelefono()+ "
			// "+tlprop.getCpropietario().getCpropietario());

			em.persist(tlprop);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al insertar");
			System.out.println(e.toString());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TelefonoPropietario> list() {
		// TODO Auto-generated method stub
		List<TelefonoPropietario> lista = new ArrayList<TelefonoPropietario>();

		try {
			Query q = em.createQuery("select tlprop from TelefonoPropietario tlprop");
			lista = (List<TelefonoPropietario>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}

		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int ctelef) {
		// TODO Auto-generated method stub
		TelefonoPropietario telef = new TelefonoPropietario();
		try {
			telef = em.getReference(TelefonoPropietario.class, ctelef);
			em.remove(telef);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TelefonoPropietario> findByNameTelefono(TelefonoPropietario tele) {
		// TODO Auto-generated method stub
		List<TelefonoPropietario> lista = new ArrayList<TelefonoPropietario>();
		try {
			Query q = em.createQuery("from TelefonoPropietario tele where tele.ttelefono like ?1");
			q.setParameter(1, "%" + tele.getTtelefono() + "%");
			lista = (List<TelefonoPropietario>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void modificar(TelefonoPropietario telef) {
		// TODO Auto-generated method stub
		try {
			em.merge(telef);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
