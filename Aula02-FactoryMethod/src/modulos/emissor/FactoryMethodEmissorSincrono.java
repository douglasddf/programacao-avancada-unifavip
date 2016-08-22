/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos.emissor;

/**
 *
 * @author dddf
 */
public class FactoryMethodEmissorSincrono extends FactoryMethodEmissor {

    @Override
    public IEmissor create(int tipoDeEmissor) throws Exception {
        IEmissor result = null;
        
        if(tipoDeEmissor == FactoryMethodEmissor.SMS) {            
            result = new EmissorEmailSincrono();
            
        } else if(tipoDeEmissor == FactoryMethodEmissor.EMAIL) {            
            result = new EmissorEmailSincrono();
            
        } else if(tipoDeEmissor == FactoryMethodEmissor.JMS) {            
            result = new EmissorJSMSincrono();
        }                        
        
        return result;
    }

    
    
    
    
}
