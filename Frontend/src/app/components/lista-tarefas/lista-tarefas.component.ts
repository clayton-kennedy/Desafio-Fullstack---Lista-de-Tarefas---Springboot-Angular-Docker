import { Component, OnInit } from '@angular/core';
import { TarefaServiceService } from '../../service/tarefa-service.service';

@Component({
  selector: 'app-lista-tarefas',
  standalone: false,
  templateUrl: './lista-tarefas.component.html',
  styleUrl: './lista-tarefas.component.scss',
})
export class ListaTarefasComponent implements OnInit {
  tarefas: any[] = [];

  constructor(private tarefaService: TarefaServiceService) {}

  ngOnInit(): void {
    this.listar();
  }

  listar(): void {
    this.tarefaService.listar().subscribe({
      next: (dados) => {
        this.tarefas = dados;
      },
      error: (erro) => {
        console.error('Erro ao buscar tarefas: ', erro);
      },
    });
  }
  ordenar(event: any): void {
    const criterio = event.target.value;

    switch (criterio) {
      case 'maiorPrioridade':
        this.tarefas.sort(
          (a, b) =>
            this.converterPrioridade(b.prioridade) -
            this.converterPrioridade(a.prioridade)
        );
        break;

      case 'menorPrioridade':
        this.tarefas.sort(
          (a, b) =>
            this.converterPrioridade(a.prioridade) -
            this.converterPrioridade(b.prioridade)
        );
        break;

      case 'maisNovos':
        this.tarefas.sort(
          (a, b) =>
            new Date(b.dataCriacao).getTime() -
            new Date(a.dataCriacao).getTime()
        );
        break;

      case 'maisAntigos':
        this.tarefas.sort(
          (a, b) =>
            new Date(a.dataCriacao).getTime() -
            new Date(b.dataCriacao).getTime()
        );
        break;

      case 'realizadas':
        this.tarefas.sort((a, b) => (b.realizado ? 1 : -1));
        break;

      case 'naoRealizadas':
        this.tarefas.sort((a, b) => (a.realizado ? 1 : -1));
        break;
    }
  }

  converterPrioridade(prioridade: string): number {
    const prioridades: { [key: string]: number } = {
      Baixa: 1,
      Média: 2,
      Alta: 3,
    };
    return prioridades[prioridade] || 0;
  }

  modalAberto = false;
  abrirModal(tarefa: any) {
    this.modalAberto = true;
  }
  
  fecharModal() {
    this.modalAberto = false;
  }

  removerTarefa(id: string) {
    this.tarefaService.deletar(id).subscribe({
      next:(response) => {
        this.modalAberto = false;
        this.listar();
      }
    })
  }

  alterarRealizado(tarefa: any) {
    tarefa.realizado = !tarefa.realizado;
    if (tarefa.realizado === true) {
      tarefa.dataRealizado = new Date().toISOString().split('T')[0];
    } else {
      tarefa.dataRealizado = null;
    }

    this.tarefaService.atualizar(tarefa).subscribe({
      next: (response) => {
        this.listar();
      },
      error: (err) => {
        console.error('Erro ao atualizar a tarefa:', err);
      },
    });
  }
}
