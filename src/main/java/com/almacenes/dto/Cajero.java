package com.almacenes.dto;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cajeros")
public class Cajero {

	// atributos 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@OneToMany
	@JoinColumn(name = "id")
	private List<Venta> venta;

	// constructores
	public Cajero() {
		}

	public Cajero(int id, String nombre, List<Venta> venta) {
			this.id = id;
			this.nombre = nombre;
			this.venta = venta;
		}

	// getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	// método toString
	@Override
	public String toString() {
		return "Cajero [id=" + id + ", nombre=" + nombre + "]";
	}

}
