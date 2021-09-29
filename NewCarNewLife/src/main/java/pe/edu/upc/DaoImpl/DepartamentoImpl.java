package pe.edu.upc.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.Dao.IDepartamentoDao;
import pe.edu.upc.Entities.Departamento;

public class DepartamentoImpl implements IDepartamentoDao {

	@PersistenceContext(unitName = "NewCarNewLife")
	private EntityManager em;

	@Transactional
	public void insert(Departamento d) {
		// TODO Auto-generated method stub

		try {

			em.persist(d);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al insertar");
		}

	}

	@SuppressWarnings("unchecked")
	public List<Departamento> list() {
		// TODO Auto-generated method stub

		List<Departamento> lista = new ArrayList<Departamento>();

		try {

			Query q = em.createQuery("select d from Departamento d");
			lista = (List<Departamento>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al insertar");
		}

		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int cdepartamento) {
		// TODO Auto-generated method stub
		Departamento dep = new Departamento();
		try {
			dep = em.getReference(Departamento.class, cdepartamento);
			em.remove(dep);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findByNameDepartamento(Departamento d) {
		// TODO Auto-generated method stub
		List<Departamento> lista = new ArrayList<Departamento>();
		try {
			Query q = em.createQuery("from Departamento d where c.nameDepartamento like ?1");
			q.setParameter(1, "%" + d.getNdepartamento() + "%");
			lista = (List<Departamento>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void modificar(Departamento d) {
		// TODO Auto-generated method stub
		try {
			em.merge(d);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
