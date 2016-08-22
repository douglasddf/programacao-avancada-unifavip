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
public abstract class FactoryMethodEmissor {

    public static final int SMS = 0;
    public static final int EMAIL = 1;
    public static final int JMS = 2;
    
    public abstract IEmissor create(int tipoDeEmissor) throws Exception;
    
    
}

