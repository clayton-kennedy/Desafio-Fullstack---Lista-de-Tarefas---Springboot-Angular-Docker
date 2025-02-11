package com.claytonkennedy.lista_tarefas.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.claytonkennedy.lista_tarefas.DTO.TarefaDTO;
import com.claytonkennedy.lista_tarefas.Model.Tarefa;
import com.claytonkennedy.lista_tarefas.Repository.TarefaRepository;
import com.claytonkennedy.lista_tarefas.Validator.TarefaValidador;

import jakarta.transaction.Transactional;

@Service
public class TarefaService {
    @Autowired
    TarefaRepository tarefaRepository;
    @Autowired
    TarefaValidador tarefaValidador;
    
    //adicionar
    public void adicionar (Tarefa tarefa) {
        try {
            if (tarefaValidador.ValidadorAdicionar(tarefa)) {
                tarefaRepository.save(tarefa);
                listar();
            }
            System.out.println("Erro ao adicionar");
            listar();
        } catch (Exception erro) {
            System.out.println("Erro: "+ erro.getMessage());
            listar();
        }
    }

    //remover
    public void remover (String id) {
        try {
            if (tarefaValidador.ValidadorRemover(id)) {
                tarefaRepository.deleteById(id);
                listar();
            }
            System.out.println("Erro ao remover");
            listar();
        } catch (Exception erro) {
            System.out.println("Erro: "+ erro.getMessage());
            listar();
        }
    }

    //atualizar
    @Transactional
    public void atualizar (Tarefa tarefa) {
        try {
            if (tarefaValidador.ValidadorAtualizar(tarefa)) {
                tarefaRepository.save(tarefa);
                listar();
            }
            System.out.println("Erro: Tarefa não encontrada.");
            listar();        
        } catch (Exception erro) {
            System.out.println("Erro: "+ erro.getMessage());
            listar();
        }
    }

    //listar
    public List<TarefaDTO> listar () {
        try {
            List<Tarefa> tarefas = tarefaRepository.findAll();
            List<TarefaDTO> listaTarefas = new ArrayList<>();
            for (Tarefa tarefa : tarefas) {
                listaTarefas.add(new TarefaDTO(tarefa));
            }
            return listaTarefas;
        } catch (Exception erro) {
            System.out.println("Erro: "+ erro.getMessage());
            return List.of();
        }
    }
}
