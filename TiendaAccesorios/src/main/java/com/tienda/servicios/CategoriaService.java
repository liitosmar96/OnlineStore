package com.tienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tienda.modelo.Categoria;
import com.tienda.repositorios.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}	
	
	public List<Categoria> findDestacadas() {
		return categoriaRepository.findDestacadas();
	}
	
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria findById(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}
	
	public Categoria delete(Categoria categoria) {
		Categoria result = findById(categoria.getId());
		categoriaRepository.delete(result);
		return result;
	}
	
	

}
