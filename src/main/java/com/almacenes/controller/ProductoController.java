package com.almacenes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.almacenes.dto.Producto;
import com.almacenes.service.ProductoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoServiceImpl productoServiceImpl;

	@GetMapping("/productos")
	public List<Producto> listarProductos() {
		return productoServiceImpl.listarProductos();
	}

	@PostMapping("/productos")
	public Producto crearProducto(@RequestBody Producto producto) {

		return productoServiceImpl.guardarProducto(producto);
	}

	@GetMapping("/productos/{id}")
	public Producto listarProductoXID(@PathVariable(name = "id") int id) {

		Producto productoPorId = new Producto();
		productoPorId = productoServiceImpl.listarProductoXID(id);

		return productoPorId;
	}

	@PutMapping("/productos/{id}")
	public Producto actualizarProducto(@PathVariable(name = "id") int id, @RequestBody Producto producto) {
		Producto productoSeleccionado = new Producto();
		Producto productoActualizado = new Producto();

		// obtenemos producto de la DB
		productoSeleccionado = productoServiceImpl.listarProductoXID(id);

		// seteamos nuevos valores
		productoSeleccionado.setId(producto.getId());
		productoSeleccionado.setNombre(producto.getNombre());
		productoSeleccionado.setPrecio(producto.getPrecio());

		// actualizamos producto en la DB
		productoActualizado = productoServiceImpl.actualizarProducto(productoSeleccionado);

		return productoActualizado;
	}

	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable(name = "id") int id) {
		productoServiceImpl.eliminarProducto(id);
	}

}
