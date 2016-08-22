/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos.emissor.comunicador;

/**
 *
 * @author dddf
 */
public class VisaComunicadorFactory implements IComunicadorFactory {

    @Override
    public Emissor createEmissor() {
        return new Emissor();
    }

    @Override
    public Receptor createReceptor() {
        return new Receptor();
    }
    
}
