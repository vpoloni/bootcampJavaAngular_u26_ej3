package com.almacenes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.almacenes.dao.IMaquinaRegistradoraDAO;
import com.almacenes.dto.MaquinaRegistradora;

@Service
public class MaquinaRegistradoraServiceImpl implements IMaquinaRegistradoraService {

	@Autowired
	IMaquinaRegistradoraDAO iMaquinaRegistradoraDAO;

	@Override
	public List<MaquinaRegistradora> listarMaquinasRegistradoras() {
		return iMaquinaRegistradoraDAO.findAll();
	}

	@Override
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		return iMaquinaRegistradoraDAO.save(maquinaRegistradora);
	}

	@Override
	public MaquinaRegistradora listarMaquinaRegistradoraXID(int id) {
		return iMaquinaRegistradoraDAO.findById(id).get();
	}

	@Override
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		return iMaquinaRegistradoraDAO.save(maquinaRegistradora);
	}

	@Override
	public void eliminarMaquinaRegistradora(int id) {
		iMaquinaRegistradoraDAO.deleteById(id);
	}

}
