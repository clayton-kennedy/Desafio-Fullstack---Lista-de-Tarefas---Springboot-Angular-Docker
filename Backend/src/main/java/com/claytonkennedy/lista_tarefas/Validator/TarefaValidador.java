package com.claytonkennedy.lista_tarefas.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claytonkennedy.lista_tarefas.Model.Tarefa;
import com.claytonkennedy.lista_tarefas.Repository.TarefaRepository;

@Service
public class TarefaValidador {
    @Autowired
    TarefaRepository tarefaRepository;
    
    //adicionar
    public boolean ValidadorAdicionar(Tarefa tarefa) {
        if (tarefa.getId() == null) {
            return true;
        }
        return false;
    }

    //remover
    public boolean ValidadorRemover(String id) {
        if (tarefaRepository.existsById(id)) {
            return true;
        }
        return false;
    }

    //atualizar
    public boolean ValidadorAtualizar(Tarefa tarefa) {
        if (tarefaRepository.existsById(tarefa.getId())) {
            return true;
        }
        return false;
    }
    
}
