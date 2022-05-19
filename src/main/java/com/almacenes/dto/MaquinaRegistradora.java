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
@Table(name = "maquinas_registradoras")
public class MaquinaRegistradora {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "piso")
	private int piso;
	@OneToMany
	@JoinColumn(name = "id")
	private List<Venta> venta;

	// constructores
	public MaquinaRegistradora() {
	}

	public MaquinaRegistradora(int id, int piso, List<Venta> venta) {
		this.id = id;
		this.piso = piso;
		this.venta = venta;
	}

	// getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
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
		return "MaquinaRegistradora [id=" + id + ", piso=" + piso + "]";
	}

}
