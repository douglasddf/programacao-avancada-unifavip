/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dados.Funcionario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static util.GerenciadorArquivo.checkFolder;

/**
 *
 * @author douglasfrari
 */
public class GerenciadorArquivoSeparadoFuncionario extends GerenciadorArquivo {
 
    
    public static void salvarFuncionarioEmArquivo(final Funcionario funcionario) {

        ObjectOutputStream obj = null;
        FileOutputStream arqGravar = null;

        try {

            checkFolder();
            
            // Gera o arquivo para armazenar o objeto
            arqGravar = new FileOutputStream(
                    NOME_ARQUIVO_SERIALIZADO + funcionario.getCodigo());

            // inserir objetos
            obj = new ObjectOutputStream(arqGravar);

            // Gravar o objeto no arquivo
            obj.writeObject(funcionario);

            System.out.println("Objeto gravado com sucesso! -> " + funcionario);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {
                if (obj != null) {
                    obj.flush();
                    obj.close();
                }

                if (arqGravar != null) {
                    arqGravar.flush();
                    arqGravar.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static Funcionario recuperarFuncionarioDeArquivo(final int codigo) {

        Funcionario funcionario = null;
        FileInputStream arqRead = null;
        ObjectInputStream objRead = null;

        try {
            // Carrega o arquivo
            arqRead = new FileInputStream(NOME_ARQUIVO_SERIALIZADO + codigo);

            // recuperar os objetos do arquivo
            objRead = new ObjectInputStream(arqRead);
            funcionario = (Funcionario) objRead.readObject();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {
                if (objRead != null) {
                    objRead.close();
                }

                if (arqRead != null) {
                    arqRead.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return funcionario;
    }
    
    
    
    private static void prepararDados(final File file) {

        if (file.isDirectory()) {
            System.out.println("pasta existente...");

        } else {
            System.out.println("criando pasta ...");
            file.mkdir();
        }
    }
    
    public static ArrayList<Funcionario> carregarFuncionariosEmArquivos() {

        File file = new File(FOLDER_NAME);
        prepararDados(file);
        ArrayList<Funcionario> funcionarios = new ArrayList();

        String[] files = file.list();
        if (files.length != 0) {
            System.out.println("CARREGANDO DADOS...");
            for (int i = 0; i < files.length; i++) {

                int index = files[i].indexOf("_");
                String codigo = files[i].substring(index + 1);

                Funcionario funcionario = recuperarFuncionarioDeArquivo(Integer.parseInt(codigo));
                if (funcionario != null) {
                    funcionarios.add(funcionario);
                }
            }
        }

        return funcionarios;
    }

    
    // para testar funcionalidades
    public static void main(String[] args) {
        try {
            // Gravando exemplos de teste
            ArrayList<Funcionario> funcionarios = carregarFuncionariosEmArquivos();

            if (funcionarios.isEmpty()) {
                System.out.println("- cria funcionarios -");
                Funcionario funcionario1 = new Funcionario("Nome 1", 2000.0,"login1", Util.convertPasswordToMD5("senha1"));
                Funcionario funcionario2 = new Funcionario("Nome 2", 3000.0,"login2", Util.convertPasswordToMD5("senha2"));
		
                salvarFuncionarioEmArquivo(funcionario1);
                salvarFuncionarioEmArquivo(funcionario2);
            } else {
                
                System.out.println("- recupera funcionarios -");
                
                for (Funcionario funcionario : funcionarios) {
                    System.out.println(funcionario);
                }
                
            }
            
            
            // recuperando da pasta arquivos
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
}
