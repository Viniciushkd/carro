package br.com.server.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bo.CarroBO;
import br.com.model.Carro;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@ApiOperation(value = "Lista todos os carros", notes = "Lista todos os carros", response = Carro.class, responseContainer = "List" )
	@ApiResponses({
		@ApiResponse(code = 200, message = "Carros Listados com sucesso")
	})
	@GetMapping("/listar")
	public List<Carro> getCarros() {
		CarroBO bo = new CarroBO();
		System.out.println("Carros Listados");
		return bo.listarCarros();
	}
	
	@ApiOperation(value = "Buscar um carro", notes = "Buscar um carro", response = Carro.class, responseContainer = "List" )
	@ApiResponses({
		@ApiResponse(code = 200, message = "Carro listado com sucesso")
	})
	@GetMapping("/listar/{id}")
	public Carro getCarro(@PathVariable int id) {
		CarroBO bo = new CarroBO();
		return bo.buscarCarro(id);
	}
	
	@ApiOperation(value = "Cria carro", notes = "Cria carro", response = Carro.class, responseContainer = "Create" )
	@ApiResponses({
		@ApiResponse(code = 200, message = "Carro criado com sucesso")
	})
	@PostMapping("/criar")
	public ResponseEntity<Carro> postCarro(@RequestBody Carro carro) {
		CarroBO bo = new CarroBO();
		bo.criarCarro(carro);
		return new ResponseEntity<Carro>(carro, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Deletar carro", notes = "Deletar carro", response = Carro.class, responseContainer = "Delete" )
	@ApiResponses({
		@ApiResponse(code = 200, message = "Carro deletado com sucesso")
	})
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deleteCarro(@PathVariable int id){
		CarroBO bo = new CarroBO();
		Carro carro = bo.deleteCarro(id);
		return new ResponseEntity<>(carro, HttpStatus.OK);
	}
}
