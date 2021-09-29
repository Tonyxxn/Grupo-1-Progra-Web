package pe.edu.upc.Entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Provincia")

public class Provincia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cprovincia;

	@Column(name = "nameProvincia", length = 50, nullable = false)
	private String Nprovincia;

	@ManyToOne
	@JoinColumn(name = "Cdepartamento", nullable = false)
	private Departamento departamento;

	// constructores
	public Provincia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Provincia(int cprovincia, String nprovincia, Departamento departamento) {
		super();
		this.Cprovincia = cprovincia;
		this.Nprovincia = nprovincia;
		this.departamento = departamento;
	}

	// get y set
	public int getCprovincia() {
		return Cprovincia;
	}

	public void setCprovincia(int cprovincia) {
		Cprovincia = cprovincia;
	}

	public String getNprovincia() {
		return Nprovincia;
	}

	public void setNprovincia(String nprovincia) {
		Nprovincia = nprovincia;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Cprovincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Provincia other = (Provincia) obj;
		return Cprovincia == other.Cprovincia;
	}

}
