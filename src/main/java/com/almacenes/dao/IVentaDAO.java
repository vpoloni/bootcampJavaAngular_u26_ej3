package com.almacenes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almacenes.dto.Venta;

public interface IVentaDAO extends JpaRepository<Venta, Integer>{

}
