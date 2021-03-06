package com.userAndProduct.Apirest.controller;

import java.util.List;
import java.util.Optional;

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

import com.userAndProduct.Apirest.model.Departament;
import com.userAndProduct.Apirest.model.ListarDeptEQtdTarefas;
import com.userAndProduct.Apirest.repository.DepartamentRepository;

@RestController
@RequestMapping(path="/departamentos")
public class DepartamentController {
	
	@Autowired
	private DepartamentRepository repository;
	
	
	@GetMapping("/")
	public List<Departament> consultarDepartamentos(){
		return repository.findAll();
	}
	
	@GetMapping(path = "/{idDepartament}")
	public ResponseEntity<Departament> consultar(@PathVariable("idDepartament") long idDepartament){
		return repository.findById(idDepartament)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/pessoasAlocadas")
	public List<ListarDeptEQtdTarefas> getDeptTarefas(){
		return repository.getDeptTarefas();
	}
	
	@PostMapping(path = "/criar")
	public Departament criarDepartamento(@RequestBody Departament departament) {
		return repository.save(departament);
	}
	
	@PutMapping(value = "/{idDepartament}")
	public Optional<Departament> updateDepartament(@PathVariable(value = "idDepartament") Long idDepartament, @Validated @RequestBody Departament departamentDetails){
		return repository.findById(idDepartament)
				.map(departament -> {
					departament.setTitulo(departamentDetails.getTitulo());
					return repository.save(departament);
				});
	}
	
	@DeleteMapping(path = "/{idDepartament}")
	public void deleteDepartament(@PathVariable("idDepartament") Long idDepartament) {
		repository.deleteById(idDepartament);
	}
}
