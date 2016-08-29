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
public class Cartao1 {
    
    
    private String bandeira;

    public Cartao1(TipoCartao tipoCartao) {
        
        this.bandeira = tipoCartao.getValue();
        
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
    
    
    public enum TipoCartao {
        VISA("Visa"),
        MASTER("Mastercard");
        
        private String value;

        TipoCartao(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.getValue();
        }
    }
    
}
