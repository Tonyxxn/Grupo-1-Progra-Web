package pe.edu.upc.Service;

import java.util.List;

import pe.edu.upc.Entities.Departamento;

public interface IDepartamentoService {

	public void insert(Departamento d);
	public List<Departamento> list();
	
	public void eliminar(int cdepartamento);
	public List<Departamento> findByNameDepartamento(Departamento dep);
	
	public void modificar(Departamento dep);
	
}
