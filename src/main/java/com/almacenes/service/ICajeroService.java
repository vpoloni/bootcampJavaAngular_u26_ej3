package com.almacenes.service;

import java.util.List;
import com.almacenes.dto.Cajero;

public interface ICajeroService {
	
	// READ todos cajeros
	public List<Cajero> listarCajeros();

	// CREATE nuevo cajero
	public Cajero guardarCajero(Cajero cajero);

	// READ cajero por id
	public Cajero listarCajeroXID(int id);

	// UPDATE cajero
	public Cajero actualizarCajero(Cajero cajero);

	// DELETE cajero
	public void eliminarCajero(int id);

}
