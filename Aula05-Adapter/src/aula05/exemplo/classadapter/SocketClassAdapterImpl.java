/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula05.exemplo.classadapter;

import aula05.exemplo.IPlugSocketAdapter;
import aula05.exemplo.PlugSocket;
import aula05.exemplo.Volt;

/**
 *
 * @author dddf
 */
public class SocketClassAdapterImpl extends PlugSocket implements IPlugSocketAdapter {

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v = getVolt();
        return convertVolt(v,10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = getVolt();
        return convertVolt(v,40);
    }
    
    
    private Volt convertVolt(Volt v, int i) { 
        return new Volt(v.getVolts()/i);
    }
    
}
