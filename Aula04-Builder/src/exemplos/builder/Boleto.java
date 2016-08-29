/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos.builder;

import java.util.Calendar;

/**
 *
 * @author douglasfrari
 */
public interface Boleto {
    
    String getSacado();
    String getCedente();
    double getValor();
    Calendar getVencimento();
    int getNossoNumero(); 
    String toString();
}
