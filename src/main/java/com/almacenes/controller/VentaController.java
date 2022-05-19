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
import com.almacenes.dto.Venta;
import com.almacenes.service.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	VentaServiceImpl ventaServiceImpl;

	@GetMapping("/ventas")
	public List<Venta> listarVentas() {
		return ventaServiceImpl.listarVentas();
	}

	@PostMapping("/ventas")
	public Venta crearVenta(@RequestBody Venta venta) {

		return ventaServiceImpl.guardarVenta(venta);
	}

	@GetMapping("/ventas/{id}")
	public Venta listarVentaXID(@PathVariable(name = "id") int id) {

		Venta ventaPorId = new Venta();
		ventaPorId = ventaServiceImpl.listarVentaXID(id);

		return ventaPorId;
	}

	@PutMapping("/ventas/{id}")
	public Venta actualizarVenta(@PathVariable(name = "id") int id, @RequestBody Venta venta) {
		Venta ventaSeleccionada = new Venta();
		Venta ventaActualizada = new Venta();

		// obtenemos venta de la DB
		ventaSeleccionada = ventaServiceImpl.listarVentaXID(id);

		// seteamos nuevos valores
		ventaSeleccionada.setId(venta.getId());
		ventaSeleccionada.setProducto(venta.getProducto());
		ventaSeleccionada.setMaquinaRegistradora(venta.getMaquinaRegistradora());
		ventaSeleccionada.setCajero(venta.getCajero());

		// actualizamos venta en la DB
		ventaActualizada = ventaServiceImpl.actualizarVenta(ventaSeleccionada);

		return ventaActualizada;
	}

	@DeleteMapping("/ventas/{id}")
	public void eliminarVenta(@PathVariable(name = "id") int id) {
		ventaServiceImpl.eliminarVenta(id);
	}

}
