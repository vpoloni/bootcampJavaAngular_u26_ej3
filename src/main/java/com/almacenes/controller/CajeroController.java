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
import com.almacenes.dto.Cajero;
import com.almacenes.service.CajeroServiceImpl;

@RestController
@RequestMapping("/api")
public class CajeroController {
	@Autowired
	CajeroServiceImpl cajeroServiceImpl;

	@GetMapping("/cajeros")
	public List<Cajero> listarCajeros() {
		return cajeroServiceImpl.listarCajeros();
	}

	@PostMapping("/cajeros")
	public Cajero crearCajero(@RequestBody Cajero cajero) {

		return cajeroServiceImpl.guardarCajero(cajero);
	}

	@GetMapping("/cajeros/{id}")
	public Cajero listarCajeroXID(@PathVariable(name = "id") int id) {

		Cajero cajeroPorId = new Cajero();
		cajeroPorId = cajeroServiceImpl.listarCajeroXID(id);

		return cajeroPorId;
	}

	@PutMapping("/cajeros/{id}")
	public Cajero actualizarCajero(@PathVariable(name = "id") int id, @RequestBody Cajero cajero) {
		Cajero cajeroSeleccionado = new Cajero();
		Cajero cajeroActualizado = new Cajero();

		// obtenemos cajero de la DB
		cajeroSeleccionado = cajeroServiceImpl.listarCajeroXID(id);

		// seteamos nuevos valores
		cajeroSeleccionado.setId(cajero.getId());
		cajeroSeleccionado.setNombre(cajero.getNombre());

		// actualizamos cajero en la DB
		cajeroActualizado = cajeroServiceImpl.actualizarCajero(cajeroSeleccionado);

		return cajeroActualizado;
	}

	@DeleteMapping("/cajeros/{id}")
	public void eliminarCajero(@PathVariable(name = "id") int id) {
		cajeroServiceImpl.eliminarCajero(id);
	}

}
