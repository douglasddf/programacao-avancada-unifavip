/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula05.exemplo;

/**
 * While implementing Adapter pattern, there are two approaches – class adapter
 * and object adapter, however both these approaches produce same result. 
 * 
 * 1.Class Adapter – This form uses java inheritance and extends the source
 * interface, in our case Socket class. 
 * 
 * 2. Object Adapter – This form uses Java
 * Composition and adapter contains the source object.
 */


/**
 *
 * @author dddf
 */
public interface IPlugSocketAdapter {
    
    
    public Volt get120Volt();
    
    public Volt get12Volt();
    
    public Volt get3Volt();
    
}
