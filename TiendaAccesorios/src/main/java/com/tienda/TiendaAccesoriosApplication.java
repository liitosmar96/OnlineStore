package com.tienda;

import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tienda.modelo.Producto;
import com.tienda.modelo.Puntuacion;
import com.tienda.repositorios.ProductoRepository;

@SpringBootApplication
public class TiendaAccesoriosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaAccesoriosApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductoRepository productoRepository) {
		return args -> {
			List<Producto> productos = productoRepository.findAll();
			Random r = new Random();
			for (Producto p : productos) {
				for (int i = 0; i < r.nextInt(10); i++)
					p.addPuntuacion(new Puntuacion(1 + r.nextInt(4)));
			}
			productoRepository.saveAll(productos);

		};
	}
}
