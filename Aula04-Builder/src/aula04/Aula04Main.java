/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04;

import exemplos.builder.Boleto;
import exemplos.builder.bancos.BBBoletoBuilder;
import exemplos.builder.BoletoBuilder;
import exemplos.builder.GeradorDeBoleto;
import padrao.builder.Computer;

/**
 *
 * @author douglasfrari
 */
public class Aula04Main {

    /*
    BUILDER
    Objetivo: Separar o processo de construção de um objeto de sua representação
    e permitir a sua criação passo-a-passo. Diferentes tipos de objetos podem ser 
    criados com implementações distintas de cada passo.
    */
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Versao antiga (nao recomendada, mas funcional)
        BoletoBuilder boletoBuilder = new BBBoletoBuilder();
        GeradorDeBoleto geradorDeBoleto = new GeradorDeBoleto(boletoBuilder);
        Boleto boleto = geradorDeBoleto.geraBoleto();
        System.out.println(boleto);
        
        // Exemplo de Builer em nossa classe
        Computer computador1 = new Computer.ComputerBuilder("320 GB", "8 GB")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true)
                .builder();
        
        // Exemplo utilizando uma biblioteca do Java (JDK)
        StringBuilder textosConcatenados = new StringBuilder().append("OI").append("\nOI 2");
    }
    
}
