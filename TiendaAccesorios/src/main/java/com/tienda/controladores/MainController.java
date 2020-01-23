package com.tienda.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tienda.servicios.CategoriaService;
import com.tienda.servicios.ProductoService;

@Controller
public class MainController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("productos", productoService.obtenerProductosAleatorios(3));
		return "init";
	}
}
