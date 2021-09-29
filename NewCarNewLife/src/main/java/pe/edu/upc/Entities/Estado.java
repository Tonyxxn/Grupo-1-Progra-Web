package pe.edu.upc.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Estado")
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cestado;
	
	@Column(name = "nameEstado",length = 20,nullable = false)
	private String Nestado;
	//construct
	
	public Estado() {
		super();
	}
	
	public Estado(int cestado, String nestado) {
		super();
		Cestado = cestado;
		Nestado = nestado;
	}

	public int getCestado() {
		return Cestado;
	}

	public void setCestado(int cestado) {
		Cestado = cestado;
	}

	public String getNestado() {
		return Nestado;
	}

	public void setNestado(String nestado) {
		Nestado = nestado;
	}

}
