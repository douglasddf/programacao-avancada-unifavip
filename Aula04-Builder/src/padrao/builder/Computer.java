/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padrao.builder;

/**
 *
 * @author alunofavip
 */
public class Computer {
    //required parameters
    private String HDD;
    private String RAM;

    //optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    // PRECISA SER PRIVATE
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
    }
    
    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }
    
    
    
    // classe estatica para aplicar um padrao BUILDER
    public static class ComputerBuilder {
    
        //required parameters
        private String HDD;
        private String RAM;

        //optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;            
        }

        public Computer builder() {
            return new Computer(this);
        }
        
        public ComputerBuilder setGraphicsCardEnabled(boolean cardEnabled) {
            this.isGraphicsCardEnabled = cardEnabled;
            return this;
        }
        
        public ComputerBuilder setBluetoothEnabled(boolean bluetoothEnabled) {
            this.isBluetoothEnabled = bluetoothEnabled;
            return this;            
        }
    
    } // fim classe estatica ComputerBuilder
    
} // fim classe Computer
    
    

