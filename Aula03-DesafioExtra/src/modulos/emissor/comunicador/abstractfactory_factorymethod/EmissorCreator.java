/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos.emissor.comunicador.abstractfactory_factorymethod;

/**
 *
 * @author douglasfrari
 */
class EmissorCreator extends AbstractEmissorReceptor {
    
    public IEmissor create(int tipoDoEmissor) {
        
        IEmissor emissor = null;
        
        if(tipoDoEmissor == AbstractEmissorReceptor.VISA) {
            emissor = new EmissorVisa();
            
        } else if(tipoDoEmissor == AbstractEmissorReceptor.MASTERCARD) {
            emissor = new EmissorMastercard();
        } else {         
            throw new IllegalArgumentException("Tipo de emissor não suportado.");        
        }        
        
        return emissor;
        
    }
    
}
