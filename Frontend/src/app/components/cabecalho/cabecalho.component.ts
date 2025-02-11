import { Component } from '@angular/core';
import { TarefaServiceService } from '../../service/tarefa-service.service';

@Component({
  selector: 'app-cabecalho',
  standalone: false,
  templateUrl: './cabecalho.component.html',
  styleUrl: './cabecalho.component.scss',
})
export class CabecalhoComponent {
  novaTarefa = {
    descricao: '',
    dataFinal: '',
    prioridade: '',
  };
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

  cadastrarTarefa() {
    if (!this.novaTarefa.descricao || !this.novaTarefa.dataFinal || !this.novaTarefa.prioridade) {
      alert('Preencha todos os campos obrigatórios!');
      return;
    }

    this.tarefaService.adicionar(this.novaTarefa).subscribe({
      next: (dados) => {
        this.novaTarefa = { descricao: '', dataFinal: '', prioridade: '' };
        this.listar();
      },
      error: (erro) => {
        console.log(erro);
        alert('Erro ao salvar a tarefa. Tente novamente.');
      },
    });
  }
}
