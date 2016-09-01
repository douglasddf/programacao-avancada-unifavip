/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dddf
 */
public class Empregados implements Cloneable {
    
    private List<String>listaEmpregados;

    public Empregados() {
        listaEmpregados = new ArrayList();
    }

    public Empregados(List<String> listaEmpregados) {
        this.listaEmpregados = listaEmpregados;
    }
    
    public void loadData() {
        // carrega todos os empregados do banco de dados e povoa a lista
        
        listaEmpregados.add("João");
        listaEmpregados.add("Marcos");
        listaEmpregados.add("Maria");
        listaEmpregados.add("Xuxa");
    }

    public List<String> getListaEmpregados() {
        return listaEmpregados;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        
        List<String> temp = new ArrayList<>();
        
        // copia os elementos atuais da lista para a nova lista
        for (String s : this.getListaEmpregados()) {
            temp.add(s);
        }
        
        return new Empregados(temp);
    }
    
}
