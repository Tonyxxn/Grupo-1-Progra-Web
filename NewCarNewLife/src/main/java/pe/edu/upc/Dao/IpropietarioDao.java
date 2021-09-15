package pe.edu.upc.Dao;

import java.util.List;

import pe.edu.upc.Entities.Propietario;

public interface IpropietarioDao {

	public void insert(Propietario pr);

	public List<Propietario> list();

}
