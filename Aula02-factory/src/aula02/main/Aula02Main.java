/*
 * Factory Method: 
 *
 * Objetivo: Encapsular a escolha da classe concreta a ser utilizada na criação 
 * de objetos de um determinado tipo.
 */
package aula02.main;

import modulos.emissor.EmissorEmail;
import modulos.emissor.EmissorJMS;
import modulos.emissor.EmissorSMS;
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
        
        new TelaInicial().setVisible(true);
        
        
/*        
        IEmissor emissor1 = new EmissorEmail();
        emissor1.envia("Teste de mensagem 1");
        
        IEmissor emissor2 = new EmissorSMS();
        emissor2.envia("Teste de mensagem 2");
                
        IEmissor emissor3 = new EmissorJMS();
        emissor3.envia("Teste de mensagem 3");
*/

    }
    
}
