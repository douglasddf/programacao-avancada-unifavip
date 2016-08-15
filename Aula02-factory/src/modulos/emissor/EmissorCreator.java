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
public class EmissorCreator {
    
    public static final int SMS = 0;
    public static final int EMAIL = 1;
    public static final int JMS = 2;

    public IEmissor create(int tipoDeEmissor) {
        IEmissor response = null;
        
        if(tipoDeEmissor == EmissorCreator.SMS) {
            response = new EmissorSMS();
        } else if(tipoDeEmissor == EmissorCreator.EMAIL) {
            response = new EmissorEmail();
        } else if(tipoDeEmissor == EmissorCreator.JMS) {
            response = new EmissorJMS();
        } else {
            throw new IllegalArgumentException("Tipo de emissor não suportado");
        }
        
        return response;
    }
}
