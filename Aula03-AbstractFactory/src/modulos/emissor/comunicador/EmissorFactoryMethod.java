/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos.emissor.comunicador;

import aula03.main.Aula03Main;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dddf
 */
public abstract class EmissorFactoryMethod {
    
    public static IComunicadorFactory getComunicadorFactory(Cartao cartao) {
        String bandeira = cartao.getBandeira();
        Class clazz = null;
        try {
            clazz = Class.forName("modulos.emissor.comunicador."+bandeira + "ComunicadorFactory");
            return (IComunicadorFactory) clazz.newInstance(); 
            
        } catch (Exception ex) {
            Logger.getLogger(Aula03Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }
    
}
