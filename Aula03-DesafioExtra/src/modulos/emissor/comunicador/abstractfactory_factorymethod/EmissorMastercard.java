/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos.emissor.comunicador.abstractfactory_factorymethod;

/**
 *
 * @author douglasfrari
 */
class EmissorMastercard implements IEmissor {

    @Override
    public void envia(String mensagem) {
        System.out.println("-->> Enviando mensagem para a MASTERCARD -->>");
        System.out.println(mensagem);
        
    }
    
}
