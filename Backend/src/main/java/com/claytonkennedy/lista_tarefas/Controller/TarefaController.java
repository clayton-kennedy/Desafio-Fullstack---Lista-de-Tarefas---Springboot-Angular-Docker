package com.claytonkennedy.lista_tarefas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claytonkennedy.lista_tarefas.DTO.TarefaDTO;
import com.claytonkennedy.lista_tarefas.Model.Tarefa;
import com.claytonkennedy.lista_tarefas.Service.TarefaService;

@RestController
@RequestMapping
public class TarefaController {
    @Autowired
    TarefaService tarefaService;

    //adicionar
    @PostMapping
    public List<TarefaDTO> adicionar(@RequestBody Tarefa tarefa) {
        try {
            tarefaService.adicionar(tarefa);
            return listar();
        } catch (Exception erro) {
            System.out.println("Erro: "+ erro.getMessage());
            return listar();
        }        
    }

    //remover
    @DeleteMapping("{id}")
    public void remover(@PathVariable  String id) {
        try {
            tarefaService.remover(id);
            listar();
        } catch (Exception erro) {
            System.out.println("Erro: "+ erro.getMessage());
        }        
    }

    //atualizar
    @PutMapping("{id}")
    public void atualizar(@PathVariable String id, @RequestBody Tarefa tarefa) {
        System.out.println("Tarefa recebida: "+ tarefa);
        try {
            tarefaService.atualizar(tarefa);
            listar();
        } catch (Exception erro) {
            System.out.println("Erro: "+ erro.getMessage());
        }        
    }

    //listar
    @GetMapping
    public List<TarefaDTO> listar() {
        try {
            return tarefaService.listar();
        } catch (Exception erro) {
            System.out.println("Erro: "+ erro.getMessage());
            return List.of();
        }        
    }
}
