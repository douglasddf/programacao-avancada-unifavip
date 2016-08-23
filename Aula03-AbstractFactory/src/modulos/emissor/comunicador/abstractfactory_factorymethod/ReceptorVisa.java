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
class ReceptorVisa implements IReceptor {

    @Override
    public String recebe() {
        
        System.out.println("<<-- Recebendo mensagem da VISA <<--");
        String mensagem = "Mensagem da VISA";
        
        return mensagem;
    }
    
}
