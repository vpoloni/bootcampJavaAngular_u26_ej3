package com.almacenes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almacenes.dto.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Integer> {

}
