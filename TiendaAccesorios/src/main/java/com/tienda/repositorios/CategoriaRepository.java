package com.tienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tienda.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	@Query("select c from Categoria c where c.destacada = true")
	public List<Categoria> findDestacadas();

}
