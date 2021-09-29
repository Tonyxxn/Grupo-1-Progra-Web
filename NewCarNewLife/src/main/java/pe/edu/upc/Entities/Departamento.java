package pe.edu.upc.Entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cdepartamento;

	@Column(name = "nameDepartamento", length = 50, nullable = false)
	private String Ndepartamento;

	public Departamento(int cdepartamento, String ndepartamento) {
		super();
		Cdepartamento = cdepartamento;
		Ndepartamento = ndepartamento;
	}

	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCdepartamento() {
		return Cdepartamento;
	}

	public void setCdepartamento(int cdepartamento) {
		Cdepartamento = cdepartamento;
	}

	public String getNdepartamento() {
		return Ndepartamento;
	}

	public void setNdepartamento(String ndepartamento) {
		Ndepartamento = ndepartamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Cdepartamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Cdepartamento == other.Cdepartamento;
	}

	

	
	
	
}
