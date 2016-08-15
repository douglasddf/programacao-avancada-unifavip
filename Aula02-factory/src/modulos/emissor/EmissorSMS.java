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
class EmissorSMS implements IEmissor {

    @Override
    public void envia(String mensagem) {
        System.out.println("Enviando por SMS a mensagem: ");
        System.out.println(mensagem);
    }
    
    
}
