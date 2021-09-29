package pe.edu.upc.Entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Propietario")
public class Propietario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	@JoinColumn(name="ccategoria", nullable= false)
	private Categoria categoria;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "propietario")
	private User user;

	public Propietario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	@Override
	public int hashCode() {
		return Objects.hash(cpropietario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propietario other = (Propietario) obj;
		return cpropietario == other.cpropietario;
	}

	

	

}
