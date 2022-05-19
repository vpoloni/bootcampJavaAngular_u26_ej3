package com.almacenes.service;

import java.util.List;
import com.almacenes.dto.Venta;

public interface IVentaService {
	
	// READ todas ventas
	public List<Venta> listarVentas();

	// CREATE nueva venta
	public Venta guardarVenta(Venta venta);

	// READ venta por id
	public Venta listarVentaXID(int id);

	// UPDATE venta
	public Venta actualizarVenta(Venta venta);

	// DELETE venta
	public void eliminarVenta(int id);

}
