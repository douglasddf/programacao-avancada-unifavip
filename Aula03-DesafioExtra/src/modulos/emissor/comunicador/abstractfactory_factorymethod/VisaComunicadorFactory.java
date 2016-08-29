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
public class VisaComunicadorFactory implements IComunicadorFactory {

    private EmissorCreator emissorCreator = new EmissorCreator();
    private ReceptorCreator receptorCreator = new ReceptorCreator();
    
    @Override
    public IEmissor createEmissor() {
        return emissorCreator.create(EmissorCreator.VISA);
    }

    @Override
    public IReceptor createReceptor() {
        return receptorCreator.create(ReceptorCreator.VISA);
    }
    
}
