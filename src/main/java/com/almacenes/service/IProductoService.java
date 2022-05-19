package com.almacenes.service;

import java.util.List;
import com.almacenes.dto.Producto;

public interface IProductoService {
	
	// READ todos productos
	public List<Producto> listarProductos();

	// CREATE nuevo producto
	public Producto guardarProducto(Producto producto);

	// READ producto por id
	public Producto listarProductoXID(int id);

	// UPDATE producto
	public Producto actualizarProducto(Producto producto);

	// DELETE producto
	public void eliminarProducto(int id);

}
