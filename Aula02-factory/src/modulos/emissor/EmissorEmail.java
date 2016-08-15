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
public class EmissorEmail implements IEmissor {

    @Override
    public void envia(String mensagem) {
        System.out.println("Enviando por email a mensagem: ");
        System.out.println(mensagem);
    }
    
}
