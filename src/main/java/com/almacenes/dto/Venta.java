package com.almacenes.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {
	
	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	@ManyToOne
	@JoinColumn(name = "cajero")
	Cajero cajero;
	@ManyToOne
	@JoinColumn(name = "producto")
	Producto producto;
	@ManyToOne
	@JoinColumn(name = "maquina_registradora")
	MaquinaRegistradora maquinaRegistradora;

	// constructores
	public Venta() {
	}

	public Venta(int id, Producto producto, MaquinaRegistradora maquinaRegistradora, Cajero cajero) {
		this.id = id;
		this.cajero = cajero;
		this.producto = producto;
		this.maquinaRegistradora = maquinaRegistradora;
	}

	// getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Cajero getCajero() {
		return cajero;
	}


	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public MaquinaRegistradora getMaquinaRegistradora() {
		return maquinaRegistradora;
	}


	public void setMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		this.maquinaRegistradora = maquinaRegistradora;
	}

	// método toString
	@Override
	public String toString() {
		return "Venta [id=" + id + ", cajero=" + cajero + ", producto=" + producto + ", maquinaRegistradora="
				+ maquinaRegistradora + "]";
	}

}
