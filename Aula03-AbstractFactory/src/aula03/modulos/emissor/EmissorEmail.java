/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos.emissor;

import modulos.emissor.IEmissor;

/**
 *
 * @author dddf
 */
abstract class EmissorEmail implements IEmissor {

    @Override
    public void envia(String mensagem) {
        
        enviaImpl(mensagem);
    }
    
    abstract protected void enviaImpl(String mensagem);
    
}
