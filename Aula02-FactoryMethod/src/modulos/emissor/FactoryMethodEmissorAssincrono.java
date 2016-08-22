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
public class FactoryMethodEmissorAssincrono extends FactoryMethodEmissor {
    
    /**
     * 
     * @param tipoDeEmissor
     * @return
     * @throws Exception 
     */
    public IEmissor create(int tipoDeEmissor) throws Exception {
        
        IEmissor result = null;
        
        if(tipoDeEmissor == FactoryMethodEmissor.SMS) {
            result = new EmissorSMSAssincrono();            
        } else if(tipoDeEmissor == FactoryMethodEmissor.EMAIL) {
            result = new EmissorEmailAssincrono();            
        } else if(tipoDeEmissor == FactoryMethodEmissor.JMS) {
            result = new EmissorJSMAssincrono();
        }                        
        
        return result;
    }
    
}
