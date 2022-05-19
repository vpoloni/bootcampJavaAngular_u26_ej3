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
import com.almacenes.dto.MaquinaRegistradora;
import com.almacenes.service.MaquinaRegistradoraServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinaRegistradoraController {

	@Autowired
	MaquinaRegistradoraServiceImpl maquinaRegistradoraServiceImpl;

	@GetMapping("/maquinasRegistradoras")
	public List<MaquinaRegistradora> listarMaquinaRegistradoras() {
		return maquinaRegistradoraServiceImpl.listarMaquinasRegistradoras();
	}

	@PostMapping("/maquinasRegistradoras")
	public MaquinaRegistradora crearMaquinaRegistradora(@RequestBody MaquinaRegistradora maquinaRegistradora) {

		return maquinaRegistradoraServiceImpl.guardarMaquinaRegistradora(maquinaRegistradora);
	}

	@GetMapping("/maquinasRegistradoras/{id}")
	public MaquinaRegistradora listarMaquinaRegistradoraXID(@PathVariable(name = "id") int id) {

		MaquinaRegistradora maquinaRegistradoraPorId = new MaquinaRegistradora();
		maquinaRegistradoraPorId = maquinaRegistradoraServiceImpl.listarMaquinaRegistradoraXID(id);

		return maquinaRegistradoraPorId;
	}

	@PutMapping("/maquinasRegistradoras/{id}")
	public MaquinaRegistradora actualizarMaquinaRegistradora(@PathVariable(name = "id") int id,
			@RequestBody MaquinaRegistradora maquinaRegistradora) {
		MaquinaRegistradora maquinaRegistradoraSeleccionada = new MaquinaRegistradora();
		MaquinaRegistradora maquinaRegistradoraActualizada = new MaquinaRegistradora();

		// obtenemos maquinaRegistradora de la DB
		maquinaRegistradoraSeleccionada = maquinaRegistradoraServiceImpl.listarMaquinaRegistradoraXID(id);

		// seteamos nuevos valores
		maquinaRegistradoraSeleccionada.setId(maquinaRegistradora.getId());
		maquinaRegistradoraSeleccionada.setPiso(maquinaRegistradora.getPiso());

		// actualizamos maquinaRegistradora en la DB
		maquinaRegistradoraActualizada = maquinaRegistradoraServiceImpl
				.actualizarMaquinaRegistradora(maquinaRegistradoraSeleccionada);

		return maquinaRegistradoraActualizada;
	}

	@DeleteMapping("/maquinasRegistradoras/{id}")
	public void eliminarMaquinaRegistradora(@PathVariable(name = "id") int id) {
		maquinaRegistradoraServiceImpl.eliminarMaquinaRegistradora(id);
	}

}
