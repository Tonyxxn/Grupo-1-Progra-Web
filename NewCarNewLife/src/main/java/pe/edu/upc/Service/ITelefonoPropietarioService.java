package pe.edu.upc.Service;

import java.util.List;

import pe.edu.upc.Entities.TelefonoPropietario;

public interface ITelefonoPropietarioService {
	
	public void insert(TelefonoPropietario telprop);
	
	public List<TelefonoPropietario> list();
	
	public void eliminar(int ctelefono);
	public List<TelefonoPropietario> findByNameTelefono(TelefonoPropietario tele);
	
	public void modificar(TelefonoPropietario telef);

}
