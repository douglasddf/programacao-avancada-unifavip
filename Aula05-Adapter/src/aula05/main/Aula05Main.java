/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula05.main;

import aula05.exemplo.IPlugSocketAdapter;
import aula05.exemplo.Volt;
import aula05.exemplo.classadapter.SocketClassAdapterImpl;
import aula05.exemplo.objectadapter.SocketObjectAdapterImpl;

/**
 *
 * @author douglasfrari
 */
public class Aula05Main {

    /**
     * Objetivo: Permitir que um objeto seja substituído por outro que, apesar de 
     * realizar a mesma tarefa, possui uma interface diferente. 
     * (fonte: k19-k51-design-patterns-em-java.pdf, Adapter)
     * 
     * 
     * Adapter design pattern is one of the structural design pattern and it’s 
     * used so that two unrelated interfaces can work together. The object that 
     * joins these unrelated interface is called an Adapter.
     * (fonte: Java_Design_Pattern_eBook.pdf)
     */
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        testClassAdapter();
        testObjectAdapter();
        
    }
    
    
    
    private static void testObjectAdapter() {
        IPlugSocketAdapter sockAdapter = new SocketObjectAdapterImpl(); 
        Volt v3 = getVolt(sockAdapter,3);
        Volt v12 = getVolt(sockAdapter,12);
        Volt v120 = getVolt(sockAdapter,120);
        
        
        System.out.println("v3 volts using Object Adapter="+v3.getVolts());
        System.out.println("v12 volts using Object Adapter="+v12.getVolts());
        System.out.println("v120 volts using Object Adapter="+v120.getVolts());
    }
    
    private static void testClassAdapter() {
        IPlugSocketAdapter sockAdapter = new SocketClassAdapterImpl();
        Volt v3 = getVolt(sockAdapter, 3);
        Volt v12 = getVolt(sockAdapter, 12);
        Volt v120 = getVolt(sockAdapter, 120);
        
        System.out.println("v3 volts using Class Adapter = "+v3.getVolts());
        System.out.println("v12 volts using Class Adapter = "+v12.getVolts()); 
        System.out.println("v120 volts using Class Adapter = "+v120.getVolts());
    }
    
    
    private static Volt getVolt(IPlugSocketAdapter sockAdapter, int i) {
        switch (i) {
            case 3:
                return sockAdapter.get3Volt();
            case 12:
                return sockAdapter.get12Volt();
            case 120:
                return sockAdapter.get120Volt();
            default:
                return sockAdapter.get120Volt();
        }
    }
}
