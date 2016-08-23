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
public interface IComunicadorFactory1 {
    
    public Emissor1 createEmissor();
    public Receptor1 createReceptor();
}
