/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dados.Funcionario;
import java.util.List;
import repositorios.RepositorioPessoa;

/**
 *
 * @author douglasfrari
 */
public class ProgramaPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
//        RepositorioPessoa repositorio = new RepositorioPessoa();
//        
//        Funcionario func1 = new Funcionario("João da Silva", 1000);
//        Funcionario func2 = new Funcionario("Maria da Xuxa", 4000);
//        
//        repositorio.adicionarFuncionario(func1);
//        repositorio.adicionarFuncionario(func2);
//        
//        List<Funcionario> listaFuncionarios = repositorio.getFuncionarios();
//        for (Funcionario funcionario : listaFuncionarios) {
//            //System.out.println(funcionario);
//            funcionario.imprimirFuncionario();
//        }
//        

        // exibir tela principal
        new telas.TelaInicial().setVisible(true);
        
    }
    
}
