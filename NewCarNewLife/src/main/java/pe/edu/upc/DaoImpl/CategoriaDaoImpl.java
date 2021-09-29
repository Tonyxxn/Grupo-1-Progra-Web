package pe.edu.upc.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.Dao.ICategoriaDao;
import pe.edu.upc.Entities.Categoria;

public class CategoriaDaoImpl implements ICategoriaDao {

	@PersistenceContext(unitName = "NewCarNewLife")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Categoria c) {
		try {
			em.persist(c);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al insertar");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> list() {
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			Query q = em.createQuery("select c from Categoria c");
			lista = (List<Categoria>) q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int ccategoria) {
		// TODO Auto-generated method stub
		Categoria cat = new Categoria();
		try {
			cat = em.getReference(Categoria.class, ccategoria);
			em.remove(cat);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findByNameCategoria(Categoria c) {
		// TODO Auto-generated method stub
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			Query q = em.createQuery("from Categoria c where c.ncategoria like ?1");
			q.setParameter(1, "%" + c.getNcategoria() + "%");
			lista = (List<Categoria>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void modificar(Categoria cat) {
		// TODO Auto-generated method stub
		try {
			em.merge(cat);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}
