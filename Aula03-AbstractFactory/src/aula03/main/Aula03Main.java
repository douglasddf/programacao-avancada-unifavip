/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.main;


import modulos.emissor.comunicador.IEmissor;
import modulos.emissor.comunicador.*;

/**
 *
 * @author dddf
 */
public class Aula03Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // aplicando o uso do padrao Abstract Factory
        
        
        Cartao cartao = new Cartao(Cartao.TipoCartao.VISA);
        
        // chamando metodo geral para retornar instancia concreta
        IComunicadorFactory concreteFactory = EmissorFactoryMethod.getComunicadorFactory(cartao);
        
        String transacaoCompra1 = "Comprando item XXX";
        Emissor emissor = concreteFactory.createEmissor();
        emissor.envia(transacaoCompra1);
        
        
        Receptor receptor = concreteFactory.createReceptor();
        String resposta = receptor.recebe();
        
        System.out.println(resposta);
        
    }
    
    
    
    
    
}
