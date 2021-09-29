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
@Table(name = "Distrito")

public class Distrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cdistrito;

	@Column(name = "nameDistrito", length = 50, nullable = false)
	private String Ndistrito;

	@ManyToOne
	@JoinColumn(name = "Cprovincia", nullable = false)
	private Provincia provincia;

	public Distrito(int cdistrito, String ndistrito, Provincia provincia) {
		super();
		Cdistrito = cdistrito;
		Ndistrito = ndistrito;
		this.provincia = provincia;
	}

	public Distrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCdistrito() {
		return Cdistrito;
	}

	public void setCdistrito(int cdistrito) {
		Cdistrito = cdistrito;
	}

	public String getNdistrito() {
		return Ndistrito;
	}

	public void setNdistrito(String ndistrito) {
		Ndistrito = ndistrito;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

}
