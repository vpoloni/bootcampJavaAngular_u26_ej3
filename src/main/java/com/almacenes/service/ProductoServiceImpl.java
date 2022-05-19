package com.almacenes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.almacenes.dao.IProductoDAO;
import com.almacenes.dto.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	IProductoDAO iProductoDAO;

	@Override
	public List<Producto> listarProductos() {
		return iProductoDAO.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		return iProductoDAO.save(producto);
	}

	@Override
	public Producto listarProductoXID(int id) {
		return iProductoDAO.findById(id).get();
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		return iProductoDAO.save(producto);
	}

	@Override
	public void eliminarProducto(int id) {
		iProductoDAO.deleteById(id);

	}

}
