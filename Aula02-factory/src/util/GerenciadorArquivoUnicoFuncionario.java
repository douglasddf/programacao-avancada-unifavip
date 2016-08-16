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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import dados.Funcionario;

/**
 *
 * @author douglasdanieldelfrari
 */
public final class GerenciadorArquivoUnicoFuncionario extends GerenciadorArquivo {

    private GerenciadorArquivoUnicoFuncionario() {

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

    // para testar funcionalidades
    public static void main(String[] args) {

        ArrayList<Funcionario> funcionarios = recuperarFuncionarios();

        if (funcionarios.isEmpty()) {
            System.out.println("- criando dados -");

            try {

                Funcionario funcionario1 = new Funcionario("Nome 1", 2000.0, "login1", Util.convertPasswordToMD5("senha1"));
                Funcionario funcionario2 = new Funcionario("Nome 2", 3000.0, "login2", Util.convertPasswordToMD5("senha2"));

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("- recuperando dados -");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }

    }

}
