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
class ReceptorMastercard implements IReceptor {

    @Override
    public String recebe() {
        System.out.println("<<-- Recebendo mensagem da MASTERCARD <<--");
        String mensagem = "Mensagem da MASTERCARD";
        
        return mensagem;
    }
    
}
