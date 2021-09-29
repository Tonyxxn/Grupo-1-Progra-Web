package pe.edu.upc.Dao;

import java.util.List;

import pe.edu.upc.Entities.Departamento;

public interface IDepartamentoDao {

	public void insert(Departamento d);

	public List<Departamento> list();
	
	public void eliminar(int cdepartamento);
	public List<Departamento> findByNameDepartamento(Departamento d);
	
	public void modificar(Departamento d);

}
