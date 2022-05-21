package com.almacenes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.almacenes.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}

