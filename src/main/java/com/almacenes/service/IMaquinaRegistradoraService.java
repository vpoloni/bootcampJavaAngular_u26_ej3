package com.almacenes.service;

import java.util.List;
import com.almacenes.dto.MaquinaRegistradora;

public interface IMaquinaRegistradoraService {
	
	// READ todas maquinasRegistradoras
	public List<MaquinaRegistradora> listarMaquinasRegistradoras();

	// CREATE nueva maquinaRegistradora
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora);

	// READ maquinaRegistradora por id
	public MaquinaRegistradora listarMaquinaRegistradoraXID(int id);

	// UPDATE maquinaRegistradora
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora);

	// DELETE maquinaRegistradora
	public void eliminarMaquinaRegistradora(int id);

}
