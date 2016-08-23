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
public class VisaComunicadorFactory1 implements IComunicadorFactory1 {

    @Override
    public Emissor1 createEmissor() {
        return new Emissor1();
    }

    @Override
    public Receptor1 createReceptor() {
        return new Receptor1();
    }
    
}
