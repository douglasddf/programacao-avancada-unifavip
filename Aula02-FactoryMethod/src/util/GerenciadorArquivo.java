/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;

/**
 *
 * @author douglasfrari
 */
public abstract class GerenciadorArquivo {
    
    protected static final String FOLDER_NAME = "arquivos";
    protected static final String NOME_ARQUIVO_SERIALIZADO = FOLDER_NAME+File.separator+"funcionario_";
    protected static final String ARQUIVO_BANCO_DADOS_XML = "funcionarios.xml";

    
    
    protected static void checkFolder() {
        File theDir = new File(FOLDER_NAME);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + FOLDER_NAME);
            boolean result = false;

            try{
                theDir.mkdir();
                result = true;
            } 
            catch(SecurityException se){
                //handle it
                System.out.println(se.getMessage());  
            }        
            if(result) {    
                System.out.println("DIR created");  
            }
        }
    }
    
}
