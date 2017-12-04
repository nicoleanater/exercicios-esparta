/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TodoApp;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nicole
 */
public class ModeloListaTarefas extends AbstractTableModel{
    private ArrayList<Tarefa> modeloListaTarefas = new ArrayList();
    private ArrayList<Tarefa> listaCompleta = new ArrayList();
    private String[] colunas = new String[]{"Status","Descrição"};
 
    public ModeloListaTarefas() {
    }

    @Override
    public int getRowCount() {
        return modeloListaTarefas.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tarefa tarefa = modeloListaTarefas.get(rowIndex);
        switch (columnIndex) {
            case 0: return tarefa.getStatus();
            case 1: return tarefa.getDescricao();
            default : return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return Boolean.class;
            case 1: return String.class;
            default : return null;
        }
    }
    
    @Override
    public String getColumnName(int index){
        return this.colunas[index];
    }
    
    public void adicionaTarefa(Tarefa tarefa, int filtro) {
        listaCompleta.add(tarefa);
        filtraTabela(filtro);
    }
    
    public void removeTarefa(Tarefa tarefa, int filtro) {        
        listaCompleta.remove(tarefa);
        filtraTabela(filtro);    
    }
    
    public Tarefa getTarefa(int linha){
        return modeloListaTarefas.get(linha);
    }
    
    public void alteraStatus(int linha, int filtro){
        modeloListaTarefas.get(linha).changeStatus();
        if (filtro == 1){
            if (modeloListaTarefas.get(linha).getStatus()){
                modeloListaTarefas.remove(modeloListaTarefas.get(linha));
            }
        }
        else if(filtro == 2){
            if (!modeloListaTarefas.get(linha).getStatus()){
                modeloListaTarefas.remove(modeloListaTarefas.get(linha));
            }
        }
        this.fireTableDataChanged(); 
    }
    
    public void filtraTabela(int filtro){
         ArrayList<Tarefa> lista = new ArrayList();
        switch (filtro){
            case 0: 
                lista = listaCompleta;
                break;
            case 1: 
                for (Tarefa tarefa : listaCompleta){
                    if (!tarefa.getStatus()) lista.add(tarefa);
                }
                break;
            case 2:
                for (Tarefa tarefa : listaCompleta){
                    if (tarefa.getStatus()) lista.add(tarefa);
                }
                break;            
        }
        
        setListaTarefas(lista);
    }
    
     public void setListaTarefas(ArrayList<Tarefa> tarefas) {
        this.modeloListaTarefas = tarefas;
        this.fireTableDataChanged();        
    }
}
