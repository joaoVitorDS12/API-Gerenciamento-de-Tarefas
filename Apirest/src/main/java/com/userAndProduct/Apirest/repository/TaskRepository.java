package com.userAndProduct.Apirest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.userAndProduct.Apirest.model.ListaPessoas;
import com.userAndProduct.Apirest.model.TarefasPendentes;
import com.userAndProduct.Apirest.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	@Query(value = "SELECT new com.userAndProduct.Apirest.model.ListaPessoas(u.name, d.titulo,sum(f.duracao)) FROM Task f Join User u on u.idUser = f.idUser Join Departament d on d.idDepartamento = f.idDepartamento group by u.name,d.titulo")
	public List<ListaPessoas> getListaPessoas();
	
	
	@Query(value = "SELECT new com.userAndProduct.Apirest.model.TarefasPendentes(t.idUser, t.prazo) FROM Task t WHERE t.idUser = 0 ORDER BY t.prazo desc")
	public List<TarefasPendentes> getTarefasPendentes(); 
	
	
}
