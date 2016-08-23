/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos.emissor.comunicador.abstractfactory;

/**
 *
 * @author dddf
 */
public class Receptor1 implements IReceptor1 {

    @Override
    public String recebe() {
        System.out.println("Recebendo pagamento pelo RECEPTOR ");        
        String mensagem = "Confirmacao do pagamento realizada com SUCESSOR";
        
        return mensagem;
    }
    
    
    
}
