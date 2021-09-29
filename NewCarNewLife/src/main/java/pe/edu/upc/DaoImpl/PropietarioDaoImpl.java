package pe.edu.upc.DaoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.Dao.IpropietarioDao;
import pe.edu.upc.Entities.Propietario;

@Named
public class PropietarioDaoImpl implements IpropietarioDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "NewCarNewLife")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Propietario pr) throws Exception{
		// TODO Auto-generated method stub
		try {
			em.persist(pr);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al insertar");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Propietario> list() throws Exception{
		// TODO Auto-generated method stub
		List<Propietario> lista = new ArrayList<Propietario>();

		try {
			Query q = em.createQuery("select pr from Propietario pr");
			lista = (List<Propietario>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}

		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int cpropietario) throws Exception{
		// TODO Auto-generated method stub
		Propietario pro = new Propietario();
		try {
			pro = em.getReference(Propietario.class, cpropietario);
			em.remove(pro);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al eliminar");
		}
	}

	@Transactional
	@Override
	public void modificar(Propietario pr) throws Exception{
		// TODO Auto-generated method stub
		try {
			em.merge(pr);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Propietario> buscarpornombre(Propietario pr) throws Exception{
		// TODO Auto-generated method stub
		List<Propietario> lista = new ArrayList<Propietario>();
		try {
			Query q = em.createQuery("from Propietario p where p.npropietario like ?1");
			q.setParameter(1, "%" + pr.getNpropietario() + "%");
			lista = (List<Propietario>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return lista;
	}

}
