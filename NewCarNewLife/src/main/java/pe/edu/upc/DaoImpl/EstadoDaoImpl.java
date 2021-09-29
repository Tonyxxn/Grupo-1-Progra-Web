package pe.edu.upc.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.Dao.IEstadoDao;
import pe.edu.upc.Entities.Estado;

public class EstadoDaoImpl implements IEstadoDao {

	@PersistenceContext(unitName = "NewCarNewLife")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Estado es) {
		// TODO Auto-generated method stub
		try {
			em.persist(es);
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("Error al insertar");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> list() {
		// TODO Auto-generated method stub
		List<Estado> lista = new ArrayList<Estado>();	
		try {
			Query q= em.createQuery("select v from Estado v");
			lista=(List<Estado>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar");
		}
		return lista;
	}

}
