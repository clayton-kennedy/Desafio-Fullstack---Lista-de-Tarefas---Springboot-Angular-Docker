package com.claytonkennedy.lista_tarefas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claytonkennedy.lista_tarefas.Model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, String> {
    
}
