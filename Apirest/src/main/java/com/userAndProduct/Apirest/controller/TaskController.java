package com.userAndProduct.Apirest.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userAndProduct.Apirest.model.ListaPessoas;
import com.userAndProduct.Apirest.model.TarefasPendentes;
import com.userAndProduct.Apirest.model.Task;
import com.userAndProduct.Apirest.model.User;
import com.userAndProduct.Apirest.repository.TaskRepository;

@RestController
@RequestMapping(path="/tarefas")
public class TaskController {
	
	@Autowired
	private TaskRepository repository;
	
	@GetMapping("/")
	public List<Task> consultarTodasTarefas(){
		return repository.findAll();
	}
	
	@GetMapping("/{idTarefas}")
	public ResponseEntity<Task> consultar(@PathVariable("idTarefas") Long idTarefas){
		return repository.findById(idTarefas)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/pessoas")
	public List<ListaPessoas> GetPessoas(){
		return repository.getListaPessoas();
	}
	
	@GetMapping("/pendentes")
	public List<TarefasPendentes> pendentes(){
		return repository.getTarefasPendentes();
	}
	
	@PostMapping("/adicionar")
	public Task adicionar(@RequestBody Task tarefas) {
		return repository.save(tarefas);
	}
	
	@PutMapping("/alterar/{idTarefas}")
	public Optional<Task> alterarTarefa(@PathVariable(value = "idTarefas") Long idTarefas, @RequestBody Task taskDetails){
		return repository.findById(idTarefas)
				.map(task -> {
					task.setDescricao(taskDetails.getDescricao());
					task.setTitulo(taskDetails.getTitulo());
					task.setPrazo(taskDetails.getPrazo());
					task.setDuracao(taskDetails.getDuracao());
					task.setFinalizado(taskDetails.getFinalizado());
					task.setIdDepartamento(taskDetails.getIdDepartamento());
					return repository.save(task);
				});
	}
	
	@PutMapping("/finalizar/{idTarefas}")
	public Optional<Task> finalizarTarefa(@PathVariable(value = "idTarefas") Long idTarefas){
		return repository.findById(idTarefas)
				.map(task -> {
					task.setFinalizado(true);
					return repository.save(task);
				});
			
	}
	
	@PutMapping("/alocar/{idTarefas}")
	public Task alocar(@PathVariable(value = "idTarefas") Long idTarefas, @RequestBody User userDetails) throws Exception {
		Optional<Task> tarefa = repository.findById(idTarefas);
		if(tarefa.get().getIdDepartamento() == userDetails.getIdDepartamento()) {
			tarefa.get().setIdUser(userDetails.getIdUser());
			
		}else {
			throw new Exception("Tarefa não é do mesmo departamento do colaborador");
		}
		return repository.save(tarefa.get());
	}
	
	@DeleteMapping("/{idTarefas}")
	public void deletarTarefa(@PathVariable("idTarefas") Long idTarefas) {
		repository.deleteById(idTarefas);
	}
}
