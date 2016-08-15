/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import dados.Funcionario;

/**
 *
 * @author douglasdanieldelfrari
 */
public final class Arquivos {

    private static final String FOLDER_NAME = "arquivos";
    private static final String NOME_ARQUIVO_SERIALIZADO = FOLDER_NAME+File.separator+"funcionario_";
    private static final String ARQUIVO_BANCO_DADOS_XML = "funcionarios.xml";

    private Arquivos() {

    }

    public static void gravarFuncionarioEmArquivo(final Funcionario funcionario) {

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

    /**
     * Salva os dados em arquivo. Porém, coloca no arquivo somente os novos que
     * estao na memoria.
     *
     * @param funcionarios lista com dados da memoria
     * @param listaFuncionariosArquivo lista de dados que foram lidos no arquivo
     */
    public static void salvarFuncionarios(final ArrayList<Funcionario> funcionarios,
            final ArrayList<Funcionario> listaFuncionariosArquivo) {

        if (funcionarios.size() == 0) {
            System.err.println("NAO TEM DADOS PARA SALVAR");
            return;
        }

        FileInputStream fileInput = null;
        FileOutputStream fileOut = null;

        try {

            Properties properties = new Properties();
            
            File file = new File(ARQUIVO_BANCO_DADOS_XML);
            if (file.isFile()) {
                System.out.println("lendo arquivo: " + file.getAbsolutePath());

                fileInput = new FileInputStream(file);
                properties.loadFromXML(fileInput);

                // somente adicionar os novos
                for (Funcionario funcionario : funcionarios) {
                    if (!listaFuncionariosArquivo.contains(funcionario)) {
                        properties.setProperty(Funcionario.CODIGO + funcionario.getCodigo(), "" + funcionario.getCodigo());
                        properties.setProperty(Funcionario.NOME + funcionario.getCodigo(), funcionario.getNome());
                        properties.setProperty(Funcionario.SALARIO + funcionario.getCodigo(), String.valueOf(funcionario.getSalario()));
                        properties.setProperty(Funcionario.LOGIN + funcionario.getCodigo(), funcionario.getLogin());
                        properties.setProperty(Funcionario.SENHA + funcionario.getCodigo(), funcionario.getSenha());
                    }
                }

                atualizaContadorCodigos(funcionarios);

            } else {
                System.out.println("cria arquivo: " + file.getAbsolutePath());
                for (Funcionario funcionario : funcionarios) {
                    properties.setProperty(Funcionario.CODIGO + funcionario.getCodigo(), "" + funcionario.getCodigo());
                    properties.setProperty(Funcionario.NOME + funcionario.getCodigo(), funcionario.getNome());
                    properties.setProperty(Funcionario.SALARIO + funcionario.getCodigo(), String.valueOf(funcionario.getSalario()));
                    properties.setProperty(Funcionario.LOGIN + funcionario.getCodigo(), funcionario.getLogin());
                    properties.setProperty(Funcionario.SENHA + funcionario.getCodigo(), funcionario.getSenha());
                }
            }

            // salva no XML
            fileOut = new FileOutputStream(file);

            Date myDate = new Date();
            String simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(myDate);
            System.out.println("Dados Salvos: " + simpleDateFormat);

            properties.storeToXML(fileOut, "ultima atualizacao: " + simpleDateFormat);

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo ainda nao existe: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fileInput != null) {
                    fileInput.close();
                }

                if (fileInput != null) {
                    fileOut.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Recupera os dados armazenados em arquivo XML e retorna um
     * {@link ArrayList}.
     *
     * @return uma lista de objetos armazenados em arquivo.
     */
    public static ArrayList<Funcionario> recuperarFuncionarios() {

        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        FileInputStream fileInput = null;

        try {
            File file = new File(ARQUIVO_BANCO_DADOS_XML);
            fileInput = new FileInputStream(file);

            System.out.println("lendo arquivo existente: " + file.getAbsolutePath());

            Properties properties = new Properties();
            properties.loadFromXML(fileInput);

            int size = properties.size();

            // percorre a lista 
            for (int i = 1; i <= size; i++) {

                // se contem uma chave inicial, obtem os dados restantes desta mesma chave 
                if (properties.containsKey(Funcionario.CODIGO + i)) {
                    // cria objeto
                    Funcionario funcionarioAtual = new Funcionario();
                    // seta objeto com os dados do arquivo
                    funcionarioAtual.setCodigo(Integer.parseInt(properties.getProperty(Funcionario.CODIGO + i)));
                    funcionarioAtual.setNome(properties.getProperty(Funcionario.NOME + i));
                    funcionarioAtual.setSalario(Double.parseDouble(properties.getProperty(Funcionario.SALARIO + i)));
                    funcionarioAtual.setLogin(properties.getProperty(Funcionario.LOGIN + i));
                    funcionarioAtual.setSenha(properties.getProperty(Funcionario.SENHA + i));

                    // seta o ArrayList com objeto novo
                    funcionarios.add(funcionarioAtual);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("ARQUIVO NAO EXISTE AINDA: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fileInput != null) {
                    fileInput.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        atualizaContadorCodigos(funcionarios);

        return funcionarios;
    }

    private static void atualizaContadorCodigos(ArrayList<Funcionario> funcionarios) {
        // atualizar contador de codigo de funcionario
        int contadorAtual = funcionarios.size() + 1;
        Funcionario.setContador(contadorAtual);
    }

    public static String convertPasswordToMD5(String password)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));

        return String.format("%32x", hash);
    }

    // para testar funcionalidades
    public static void main(String[] args) {
        try {
            // Gravando exemplos de teste

			Funcionario funcionario1 = new Funcionario("Nome 1", 2000.0,"login1", convertPasswordToMD5("senha1"));
			Funcionario funcionario2 = new Funcionario("Nome 2", 3000.0,"login2", convertPasswordToMD5("senha2"));
//			
			gravarFuncionarioEmArquivo(funcionario1);
			gravarFuncionarioEmArquivo(funcionario2);
            // recuperando da pasta arquivos
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void prepararDados(final File file) {

        if (file.isDirectory()) {
            System.out.println("pasta existente...");

        } else {
            System.out.println("criando pasta ...");
            file.mkdir();
        }
    }

    public static ArrayList<Funcionario> processarArquivos() {

        File file = new File("arquivos");
        prepararDados(file);
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        String[] files = file.list();
        if (files.length != 0) {

            for (int i = 0; i < files.length; i++) {

                int index = files[i].indexOf("_");
                String codigo = files[i].substring(index + 1);

                Funcionario funcionario = recuperarFuncionarioDeArquivo(Integer.parseInt(codigo));
                if (funcionario != null) {
                    funcionarios.add(funcionario);
                }
            }

            System.out.println("CARREGANDO DADOS...");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }

        return funcionarios;
    }

    
    private static void checkFolder() {
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

