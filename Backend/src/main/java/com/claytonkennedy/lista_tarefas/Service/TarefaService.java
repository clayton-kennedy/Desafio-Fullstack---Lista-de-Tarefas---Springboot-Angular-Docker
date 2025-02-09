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
    public List<TarefaDTO> adicionar (Tarefa tarefa) {
        try {
            if (tarefaValidador.ValidadorAdicionar(tarefa)) {
                tarefaRepository.save(tarefa);
                return listar();
            }
            System.out.println("Erro ao adicionar");
            return listar();
        } catch (Exception erro) {
            System.out.println("Erro: "+ erro.getMessage());
            return listar();
        }
    }

    //remover
    public List<TarefaDTO> remover (String id) {
        try {
            if (tarefaValidador.ValidadorRemover(id)) {
                tarefaRepository.deleteById(id);
                return listar();
            }
            System.out.println("Erro ao remover");
            return listar();
        } catch (Exception erro) {
            System.out.println("Erro: "+ erro.getMessage());
            return listar();
        }
    }

    //atualizar
    @Transactional
    public List<TarefaDTO> atualizar (Tarefa tarefa) {
        try {
            if (tarefaValidador.ValidadorAtualizar(tarefa)) {
                tarefaRepository.save(tarefa);
                return listar();
            }
            System.out.println("Erro: Tarefa não encontrada.");
            return listar();        
        } catch (Exception erro) {
            System.out.println("Erro: "+ erro.getMessage());
            return listar();
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
