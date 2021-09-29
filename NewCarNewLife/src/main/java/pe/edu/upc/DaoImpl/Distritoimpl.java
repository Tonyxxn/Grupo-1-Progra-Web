package pe.edu.upc.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.Dao.IDistritoDao;
import pe.edu.upc.Entities.Distrito;

public class Distritoimpl implements IDistritoDao {

	@PersistenceContext(unitName = "NewCarNewLife")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Distrito d) {
		// TODO Auto-generated method stub
		try {

			em.persist(d);

		} catch (Exception e) {
			System.out.println("Error al insertar");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Distrito> list() {
		// TODO Auto-generated method stub

		List<Distrito> lista = new ArrayList<Distrito>();

		try {

			Query q = em.createQuery("select d from Distrito d");
			lista = (List<Distrito>) q.getResultList();

		} catch (Exception e) {
			System.out.println("Error al insertar");
		}

		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int cdistrito) {
		// TODO Auto-generated method stub
		Distrito dis = new Distrito();
		try {
			dis = em.getReference(Distrito.class, cdistrito);
			em.remove(dis);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Distrito> findByNameDistrito(Distrito d) {
		// TODO Auto-generated method stub
		List<Distrito> lista = new ArrayList<Distrito>();
		try {
			Query q = em.createQuery("from Distrito d where d.ndistrito like ?1");
			q.setParameter(1, "%" + d.getNdistrito() + "%");
			lista=(List<Distrito>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void modificar(Distrito d) {
		// TODO Auto-generated method stub
		try {
			em.merge(d);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
