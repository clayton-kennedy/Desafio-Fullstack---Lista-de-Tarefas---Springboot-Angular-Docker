package com.claytonkennedy.lista_tarefas.Test;

public class TarefaTest {

    // @InjectMocks // Injeta TarefaService, que será testado.
    // private TarefaService tarefaService;

    // @Mock // Simula TarefaRepository e TarefaValidador, evitando conexões reais com o banco.
    // private TarefaRepository tarefaRepository;

    // @Mock
    // private TarefaValidador tarefaValidador;

    // private Tarefa tarefa;

    // @BeforeEach // Inicializa os mocks antes de cada teste.
    // void setUp() {
    //     MockitoAnnotations.openMocks(this);
    //     tarefa = new Tarefa("1", "Estudar Spring Boot", LocalDate.now(), LocalDate.now().plusDays(3), 2, false);
    // }

    // @Test
    // void adicionar_TarefaValida_Sucesso() {
    //     when(tarefaValidador.validadorAdicionar(any(Tarefa.class))).thenReturn(true);
    //     when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);
    //     when(tarefaService.adicionar(any(Tarefa.class))).thenReturn(List.of(tarefa));

    //     List<Tarefa> resultado = tarefaService.adicionar(tarefa);

    //     assertFalse(resultado.isEmpty());
    //     verify(tarefaRepository, times(1)).save(any(Tarefa.class));
    // }

    // @Test
    // void adicionar_TarefaInvalida_Erro() {
    //     when(tarefaValidador.validadorAdicionar(any(Tarefa.class))).thenReturn(false);
    //     when(tarefaService.adicionar(any(Tarefa.class))).thenReturn(List.of());

    //     List<Tarefa> resultado = tarefaService.adicionar(tarefa);

    //     assertTrue(resultado.isEmpty());
    //     verify(tarefaRepository, never()).save(any(Tarefa.class));
    // }

    // @Test
    // void remover_TarefaExistente_Sucesso() {
    //     when(tarefaValidador.validadorRemover("1")).thenReturn(true);
    //     doNothing().when(tarefaRepository).deleteById("1");

    //     tarefaService.remover("1");

    //     verify(tarefaRepository, times(1)).deleteById("1");
    // }
}
