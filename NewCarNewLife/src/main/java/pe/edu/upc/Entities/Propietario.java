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
@Table(name = "Propietario")
public class Propietario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cpropietario;

	@Column(name = "Npropietario", length = 100, nullable = false)
	private String npropietario;

	@Column(name = "Napellido", length = 100, nullable = false)
	private String napellido;

	@Column(name = "Tcorreo", length = 200, nullable = false)
	private String correo;

	@Column(name = "Tclave", length = 200, nullable = false)
	private String clave;
	
	@ManyToOne
	@JoinColumn(name="ccategoria", nullable=false)
	private Categoria categoria;

	public Propietario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Propietario(int cpropietario, String npropietario, String napellido, String correo, String clave,
			Categoria categoria) {
		super();
		this.cpropietario = cpropietario;
		this.npropietario = npropietario;
		this.napellido = napellido;
		this.correo = correo;
		this.clave = clave;
		this.categoria = categoria;
	}

	public int getCpropietario() {
		return cpropietario;
	}

	public void setCpropietario(int cpropietario) {
		this.cpropietario = cpropietario;
	}

	public String getNpropietario() {
		return npropietario;
	}

	public void setNpropietario(String npropietario) {
		this.npropietario = npropietario;
	}

	public String getNapellido() {
		return napellido;
	}

	public void setNapellido(String napellido) {
		this.napellido = napellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	

	

}
