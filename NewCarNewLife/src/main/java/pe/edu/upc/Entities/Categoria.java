package pe.edu.upc.Entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ccategoria;
	
	@Column(name = "Ncategoria", length = 100, nullable = false)
	private String ncategoria;
	
	@Column(name = "Nglosa", length = 10, nullable = false)
	private String nglosa;
	
	@Column(name = "Qvaloracion", length = 10, nullable = false)
	private int qvaloracion;

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(int ccategoria, String ncategoria, String nglosa, int qvaloracion) {
		super();
		this.ccategoria = ccategoria;
		this.ncategoria = ncategoria;
		this.nglosa = nglosa;
		this.qvaloracion = qvaloracion;
	}

	public int getCcategoria() {
		return ccategoria;
	}

	public void setCcategoria(int ccategoria) {
		this.ccategoria = ccategoria;
	}

	public String getNcategoria() {
		return ncategoria;
	}

	public void setNcategoria(String ncategoria) {
		this.ncategoria = ncategoria;
	}

	public String getNglosa() {
		return nglosa;
	}

	public void setNglosa(String nglosa) {
		this.nglosa = nglosa;
	}

	public int getQvaloracion() {
		return qvaloracion;
	}

	public void setQvaloracion(int qvaloracion) {
		this.qvaloracion = qvaloracion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ccategoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return ccategoria == other.ccategoria;
	}
	
	

}
