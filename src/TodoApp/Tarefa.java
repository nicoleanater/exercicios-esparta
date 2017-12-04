/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TodoApp;

/**
 *
 * @author Nicole
 */
public class Tarefa {
    private String descricao;
    private boolean status;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.status = false;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getStatus() {
        return status;
    }

    public void changeStatus() {
        this.status = !this.status;
    }
    
    
    
}
