/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos.emissor;

/**
 *
 * @author dddf
 */
public class EmissorJMS implements IEmissor {

    @Override
    public void envia(String mensagem) {
        System.out.println("Enviando por JMS a mensagem: ");
        System.out.println(mensagem);        
    }
    
}
