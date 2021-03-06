package com.userAndProduct.Apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.userAndProduct.Apirest.model.Departament;
import com.userAndProduct.Apirest.model.ListarDeptEQtdTarefas;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {
	
	@Query(value = "SELECT new com.userAndProduct.Apirest.model.ListarDeptEQtdTarefas(d.idDepartamento, d.titulo, count(t.idUser) , count(t)) FROM Task t Join Departament d on d.idDepartamento = t.idDepartamento GROUP BY t.idDepartamento, d.titulo, d.idDepartamento")
	public List<ListarDeptEQtdTarefas> getDeptTarefas();

}
