package pe.edu.upc.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Telefonopropietario")
public class TelefonoPropietario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ctelefonoprop;
	
	@Column(name = "Ttelefono", length = 10, nullable = false)
	private String ttelefono;
	
	@ManyToOne
	@JoinColumn(name="cpropietario", nullable=false)
	private Propietario cpropietario;

	public TelefonoPropietario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public TelefonoPropietario(int ctelefonoprop, String ttelefono, Propietario cpropietario) {
		super();
		this.ctelefonoprop = ctelefonoprop;
		this.ttelefono = ttelefono;
		this.cpropietario = cpropietario;
	}


	public int getCtelefonoprop() {
		return ctelefonoprop;
	}


	public void setCtelefonoprop(int ctelefonoprop) {
		this.ctelefonoprop = ctelefonoprop;
	}


	public String getTtelefono() {
		return ttelefono;
	}


	public void setTtelefono(String ttelefono) {
		this.ttelefono = ttelefono;
	}


	public Propietario getCpropietario() {
		return cpropietario;
	}


	public void setCpropietario(Propietario cpropietario) {
		this.cpropietario = cpropietario;
	}

	
	
	

}
