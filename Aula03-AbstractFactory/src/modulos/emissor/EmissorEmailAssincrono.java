/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos.emissor;

/**
 *
 * @author douglasfrari
 */
class EmissorEmailAssincrono extends EmissorEmail {

    @Override
    protected void enviaImpl(String mensagem) {
        System.out.println("- EmissorEmailAssincrono -");
        
        System.out.println("Enviando por email a mensagem: ");
        System.out.println(mensagem);
    }
    
}
