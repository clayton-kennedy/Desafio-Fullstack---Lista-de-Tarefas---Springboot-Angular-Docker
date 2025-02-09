package com.claytonkennedy.lista_tarefas.Model;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Tarefa {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(name = "descricao", nullable = false, length = 500)
    private String descricao;

    @CreatedDate
    @Column (name = "dataCriacao", nullable = false, updatable = false)
    private LocalDate dataCriacao;

    @Column (name = "dataFinal", nullable = false)
    private LocalDate dataFinal;

    @Column (name = "dataRealizado", nullable = true)
    private LocalDate dataRealizado;

    @Column (name = "prioridade", nullable = false)
    private String prioridade;

    @Column (name = "realizado", nullable = false)
    private Boolean realizado = false;

    public Tarefa() {    }

    public Tarefa(String id, String descricao, LocalDate dataCriacao, LocalDate dataFinal, LocalDate dataRealizado, String prioridade,
            Boolean realizado) {
        this.id = id;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataFinal = dataFinal;
        this.dataRealizado = dataRealizado;
        this.prioridade = prioridade;
        this.realizado = realizado;
    }

    public Tarefa(String id, String descricao, LocalDate dataFinal, LocalDate dataRealizado, String prioridade, Boolean realizado) {
        this.id = id;
        this.descricao = descricao;
        this.dataFinal = dataFinal;
        this.dataRealizado = dataRealizado;
        this.prioridade = prioridade;
        this.realizado = realizado;
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
