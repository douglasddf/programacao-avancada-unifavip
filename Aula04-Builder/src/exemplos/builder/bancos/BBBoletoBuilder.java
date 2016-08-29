/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos.builder.bancos;

import exemplos.builder.Boleto;
import exemplos.builder.BoletoBuilder;
import java.util.Calendar;

/**
 *
 * @author douglasfrari
 */
public class BBBoletoBuilder implements BoletoBuilder {

    private String sacado;
    private String cedente;
    private double valor;
    private Calendar vencimento;
    private int nossoNumero;
    
    @Override
    public void buildSacado(String sacado) {
        this.sacado = sacado;
    }

    @Override
    public void buildCedente(String cedente) {
        this.cedente = cedente;
    }

    @Override
    public void buildValor(double valor) {
        this.valor = valor;
    }

    @Override
    public void buildVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public void buildNossoNumero(int nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    @Override
    public void buildCodigoDeBarras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buildLogotipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boleto getBoleto() {
        return new BBBoleto(sacado, cedente, valor, vencimento, nossoNumero);
    }
    
}
