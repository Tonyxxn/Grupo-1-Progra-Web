package pe.edu.upc.Dao;

import java.util.List;

import pe.edu.upc.Entities.TelefonoPropietario;

public interface ITelefonoPropietarioDao {
	
	public void insert(TelefonoPropietario tlprop);
	
	public List<TelefonoPropietario> list();
	
	public void eliminar(int ctelef);
	
	public List<TelefonoPropietario> findByNameTelefono(TelefonoPropietario tele);
	
	public void modificar(TelefonoPropietario telef);
	
}
