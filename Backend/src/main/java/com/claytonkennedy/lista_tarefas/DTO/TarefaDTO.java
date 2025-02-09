package com.claytonkennedy.lista_tarefas.DTO;

import java.time.LocalDate;
import com.claytonkennedy.lista_tarefas.Model.Tarefa;

public class TarefaDTO {

    private String id;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataFinal;
    private LocalDate dataRealizado;
    private String prioridade;
    private Boolean realizado = false;

    public TarefaDTO() {    }

    public TarefaDTO(String id, String descricao, LocalDate dataCriacao, LocalDate dataFinal, LocalDate dataRealizado, String prioridade,
            Boolean realizado) {
        this.id = id;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataFinal = dataFinal;
        this.dataRealizado = dataRealizado;
        this.prioridade = prioridade;
        this.realizado = realizado;
    }

    public TarefaDTO(String id, String descricao, LocalDate dataFinal, LocalDate dataRealizado, String prioridade, Boolean realizado) {
        this.id = id;
        this.descricao = descricao;
        this.dataFinal = dataFinal;
        this.dataRealizado = dataRealizado;
        this.prioridade = prioridade;
        this.realizado = realizado;
    }

    public TarefaDTO(Tarefa tarefa) {
            this.id = tarefa.getId(); 
            this.descricao = tarefa.getDescricao();
            this.dataCriacao = tarefa.getDataCriacao();
            this.dataFinal = tarefa.getDataFinal();
            this.dataRealizado = tarefa.getDataRealizado();
            this.prioridade = tarefa.getPrioridade();
            this.realizado = tarefa.getRealizado();        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public LocalDate getDataRealizado() {
        return dataRealizado;
    }

    public void setDataRealizado(LocalDate dataRealizado) {
        this.dataRealizado = dataRealizado;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }

    
    
}