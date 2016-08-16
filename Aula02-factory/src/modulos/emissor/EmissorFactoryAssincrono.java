/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos.emissor;

/**
 *
 * @author douglasfrari
 */
public class EmissorFactoryAssincrono extends EmissorFactory {
    
    /**
     * 
     * @param tipoDeEmissor
     * @return
     * @throws Exception 
     */
    public IEmissor create(int tipoDeEmissor) throws Exception {
        
        IEmissor result = null;
        
        if(tipoDeEmissor == EmissorFactory.SMS) {
            // ...
            throw new UnsupportedOperationException("Nao suportado ainda (EmissorFactory.SMS)"); 
            
        } else if(tipoDeEmissor == EmissorFactory.EMAIL) {
            
            result = new EmissorEmailAssincrono();
            
        } else if(tipoDeEmissor == EmissorFactory.JMS) {
            // ...
            throw new UnsupportedOperationException("Nao suportado ainda (EmissorFactory.JMS)"); 
        }                        
        
        return result;
    }

    

    
}
