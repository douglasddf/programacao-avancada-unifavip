/*
 * Factory Method: 
 *
 * Objetivo: Encapsular a escolha da classe concreta a ser utilizada na criação 
 * de objetos de um determinado tipo.
 */
package aula02.main;

import modulos.emissor.EmissorCreator;
import modulos.emissor.IEmissor;
import telas.TelaInicial;

/**
 *
 * @author dddf
 */
public class Aula02Main {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        // new TelaInicial().setVisible(true);
        
        
        EmissorCreator emissorCreator = new EmissorCreator();
        
        IEmissor emissor1 = emissorCreator.create(EmissorCreator.SMS);
        emissor1.envia("Teste de mensagem 1");
        
        IEmissor emissor2 = emissorCreator.create(EmissorCreator.EMAIL);
        emissor2.envia("Teste de mensagem 2");
                
        IEmissor emissor3 = emissorCreator.create(EmissorCreator.JMS);
        emissor3.envia("Teste de mensagem 3");
    }
    
}
