package com.userAndProduct.Apirest.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userAndProduct.Apirest.model.User;
import com.userAndProduct.Apirest.repository.UserRepository;

@RestController
@RequestMapping(path="/pessoas")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/")
	public List<User> consultarTodosUser(){
		return repository.findAll();	
	}
	
	@GetMapping("/{idUser}")
	public ResponseEntity<User> consultar(@PathVariable("idUser") Long idUser) {
		return repository.findById(idUser)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/salvar")
	public User salvar(@RequestBody User usuario) {
		return repository.save(usuario);
	}
	
	@PutMapping("/alterar/{idUser}")
	@Transactional
	public Optional<User> updateUser(@PathVariable(value = "idUser") Long idUser, @Validated @RequestBody User userDetails){
		return repository.findById(idUser)
				.map(user -> {
					user.setName(userDetails.getName());
					return repository.save(user);
				});
				
	}
	
	@PutMapping("/adicionarDepartamento/{idUser}")
	public Optional<User> addDepartament(@PathVariable(value = "idUser") Long idUser, @Validated @RequestBody User userDetails){
		return repository.findById(idUser)
				.map(user -> {
					user.setIdDepartamento(userDetails.getIdDepartamento());
					return repository.save(user);
				});
	}
	
	@DeleteMapping("/{idUser}")
	public void deleteUser(@PathVariable("idUser") Long idUser){
		repository.deleteById(idUser);
		
	}
	
}
