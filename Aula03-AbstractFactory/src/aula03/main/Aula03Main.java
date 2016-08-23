/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.main;


import modulos.emissor.comunicador.abstractfactory_factorymethod.IComunicadorFactory;
import modulos.emissor.comunicador.abstractfactory_factorymethod.IReceptor;
import modulos.emissor.comunicador.abstractfactory_factorymethod.IEmissor;
import modulos.emissor.comunicador.abstractfactory_factorymethod.VisaComunicadorFactory;

import modulos.emissor.comunicador.abstractfactory.Emissor1;

import dados.Funcionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modulos.emissor.comunicador.abstractfactory.Cartao1;
import modulos.emissor.comunicador.abstractfactory.EmissorFactoryMethod1;
import modulos.emissor.comunicador.abstractfactory.IComunicadorFactory1;
import modulos.emissor.comunicador.abstractfactory.Receptor1;
import telas.TelaCadastrarFuncionario;
import telas.TelaLogin;
import util.GerenciadorArquivoUnicoFuncionario;

/**
 *
 * @author dddf
 */
public class Aula03Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // VERIFICAR SE TEM USUARIO
        ArrayList<Funcionario> funcionarios = GerenciadorArquivoUnicoFuncionario.recuperarFuncionarios();
        if (funcionarios.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado!\n\n"
                    + "-faça um cadastro do usuário; \n-efetue o login no sistema");
            
            new TelaCadastrarFuncionario(true).setVisible(true);
            
        } else {
            
            new TelaLogin().setVisible(true);
        }
        
        
        // ###################################################################
        // aplicando o uso do padrao Factory Method + Abstract Method
        // ###################################################################
        System.out.println("########## padrao Factory Method + Abstract Method ##########");
        IComunicadorFactory comunicadorFactory = new VisaComunicadorFactory();
        String transacao = "Valor=560;Senha=123";

        IEmissor emissor = comunicadorFactory.createEmissor(); 
        emissor.envia(transacao);

        IReceptor receptor = comunicadorFactory.createReceptor();
        String mensagem = receptor.recebe();
        System.out.println(mensagem);
        System.out.println("##############################################################\n\n");
        
        // ###################################################################
        // aplicando uso do padrão Abstract Method
        // ###################################################################        
        System.out.println("########## padrao Abstract Method ##########");
        Cartao1 cartao1 = new Cartao1(Cartao1.TipoCartao.VISA);
        
        // chamando metodo geral para retornar instancia concreta
        IComunicadorFactory1 concreteFactory1 = EmissorFactoryMethod1.getComunicadorFactory(cartao1);
        
        String transacaoCompra1 = "Comprando item XXX";
        Emissor1 emissor1 = concreteFactory1.createEmissor();
        emissor1.envia(transacaoCompra1);
        
        Receptor1 receptor1 = concreteFactory1.createReceptor();
        String resposta1 = receptor.recebe();
        
        System.out.println(resposta1);
        System.out.println("##############################################");        
        
        
/*
    // DESAFIO COMPLEMENTAR
        
    1) fazer uma rotina para cadastrar dados em arquivo (se nao existir) para
      produtos, clientes e funcionarios;
    2) fazer uma tela para realizar Venda;
    3) implementar uma rotina para realizar uma simulacao de efetuar 
      pagamentos (VISA e MASTERCARD);
    4) persistir Venda se sucesso;
    5) ao abrir o programa, carregar as vendas se tiver.    
*/
        

    } // fim main

} // fim da classe
