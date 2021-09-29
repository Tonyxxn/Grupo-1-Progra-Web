package pe.edu.upc.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.Dao.IProvinciaDao;
import pe.edu.upc.Entities.Provincia;

public class ProvinciaImpl implements IProvinciaDao {

	@PersistenceContext(unitName = "NewCarNewLife")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Provincia p) {
		// TODO Auto-generated method stub

		try {

			em.persist(p);

		} catch (Exception e) {
			System.out.println("Error al insertar");
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> list() {
		// TODO Auto-generated method stub

		List<Provincia> lista = new ArrayList<Provincia>();

		try {

			Query q = em.createQuery("select p from Provincia p");
			lista = (List<Provincia>) q.getResultList();

		} catch (Exception e) {
			System.out.println("Error al insertar");
		}

		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int cprovincia) {
		// TODO Auto-generated method stub
		Provincia prov = new Provincia();
		try {
			prov = em.getReference(Provincia.class, cprovincia);
			em.remove(prov);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> findByNameProviancia(Provincia prov) {
		// TODO Auto-generated method stub
		List<Provincia> lista = new ArrayList<Provincia>();
		try {
			Query q = em.createQuery("from Provincia prov where prov.nprovincia like ?1");
			q.setParameter(1,"%" + prov.getNprovincia() + "%");
			lista = (List<Provincia>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void modificar(Provincia prov) {
		// TODO Auto-generated method stub
		try {
			em.merge(prov);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
