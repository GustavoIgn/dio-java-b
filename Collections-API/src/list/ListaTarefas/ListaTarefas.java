package list.ListaTarefas;

import java.util.ArrayList;
import java.util.List;
import list.Tarefa;

public class ListaTarefas {

    private List<Tarefa> tarefaList;

    public ListaTarefas() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasRemocao = new ArrayList<>();
        for (Tarefa t : tarefaList) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasRemocao.add(t);
            }
        }

        tarefaList.removeAll(tarefasRemocao);
    }

    public int obterNumTotalTarefas() {
        return tarefaList.size();
    }

    public void obterDescricaoTarefas() {
        for (Tarefa t : tarefaList) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        ListaTarefas listTarefa = new ListaTarefas();
        System.out.println("O número total de elementos na lista é: " + listTarefa.obterNumTotalTarefas());

        listTarefa.adicionarTarefa("Tarefa 1");
        listTarefa.adicionarTarefa("Tarefa 2");
        listTarefa.adicionarTarefa("Tarefa 2");
        System.out.println("O número total de elementos na lista é: " + listTarefa.obterNumTotalTarefas());

        listTarefa.removerTarefa("Tarefa 2");
        System.out.println("O número total de elementos na lista é: " + listTarefa.obterNumTotalTarefas());

        listTarefa.obterDescricaoTarefas();
        
        
    }
}
