/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula05.exemplo.objectadapter;

import aula05.exemplo.IPlugSocketAdapter;
import aula05.exemplo.PlugSocket;
import aula05.exemplo.Volt;

/**
 *
 * @author dddf
 */
public class SocketObjectAdapterImpl implements IPlugSocketAdapter {

    // usando composicao para padrao adapter
    private PlugSocket plug = new PlugSocket();
    
    @Override
    public Volt get120Volt() {
        return plug.getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v = plug.getVolt();
        return convertVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = plug.getVolt();
        return convertVolt(v, 40);
    }
    
    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }
    
}
