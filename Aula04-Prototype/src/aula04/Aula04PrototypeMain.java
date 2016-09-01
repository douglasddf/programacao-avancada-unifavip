/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04;

import aula04.prototype.Empregados;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author douglasfrari
 */
public class Aula04PrototypeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            
            Empregados empregados = new Empregados();
            empregados.loadData();
            
            
            Empregados novaListaEmpregados = (Empregados) empregados.clone();
            Empregados novaListaEmpregados2 = (Empregados) empregados.clone();
            
            List<String> lista = novaListaEmpregados.getListaEmpregados();
            lista.add("PEREIRA");
            
            List<String> lista2 = novaListaEmpregados2.getListaEmpregados();
            lista2.add("SILVA");
            
            
            System.out.println("Lista empregados: "+empregados.getListaEmpregados());
            System.out.println("Nova lista      : "+novaListaEmpregados.getListaEmpregados());
            System.out.println("Nova lista 2    : "+novaListaEmpregados2.getListaEmpregados());
            
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Aula04PrototypeMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
