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
public class Emissor1 implements IEmissor1 {

    @Override
    public void envia(String mensagem) {
        System.out.println("Enviando pagamento pelo EMISSOR ");
        System.out.println(mensagem);
    }
    
}
