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
class ReceptorCreator extends AbstractEmissorReceptor {

    
    public IReceptor create(int tipoDoReceptor) {
        
        IReceptor receptor = null;
        
        if(tipoDoReceptor == AbstractEmissorReceptor.VISA) {
            receptor = new ReceptorVisa();
        } else if (tipoDoReceptor == AbstractEmissorReceptor.MASTERCARD) {
            receptor = new ReceptorMastercard();
        } else {
            throw new IllegalArgumentException("Tipo de receptor não suportado.");
        }
        
        return receptor;
    }
    
    
}
