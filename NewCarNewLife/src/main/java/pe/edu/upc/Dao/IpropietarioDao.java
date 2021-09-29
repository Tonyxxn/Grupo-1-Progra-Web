package pe.edu.upc.Dao;

import java.util.List;

import pe.edu.upc.Entities.Propietario;

public interface IpropietarioDao {

	public void insert(Propietario pr) throws Exception;
	
	public void eliminar(int cpropietario) throws Exception;
	
	public void modificar(Propietario pr) throws Exception;
	
	public List<Propietario> buscarpornombre(Propietario pr) throws Exception;

	public List<Propietario> list() throws Exception;

}
