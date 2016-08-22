package dados;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.GerenciadorArquivoUnicoFuncionario;
import util.Util;


/**
 * Escreva a descrição da classe Funcionario aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Funcionario extends Pessoa implements Serializable
{

    // dados usados para gravar prefixo em arquivo
    public static final String CODIGO = "codigo_";
    public static final String NOME = "nome_";    
    public static final String SALARIO = "salario_"; 
    public static final String LOGIN = "login_";
    public static final String SENHA = "senha_";

    
    
    private int codigo;
    private double salario;
    private String login;
    private String senha;
    private static int contador = 1;

    // TODO permitir os dados abaixo serem guardados no arquivo
    private double acumuladoLucroVendas;
    private int quantidadeVendas;
    
    

    public Funcionario(String nome, double salario,String login, String senha) {
        try {
            this.codigo = contador++;
            this.nome = nome;
            this.salario = salario;
            this.login = login;
            
            // criptografa senha
            this.senha = Util.convertPasswordToMD5(senha); 
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Funcionario() {
        // default
        this.codigo = contador++;
    }
    
    public void atualizarLucroDeVendas(double lucro) {
        acumuladoLucroVendas += lucro;
    }
    
    public void atualizarQuantideDeVendas(int quantidadeAtualDaVenda) {
        quantidadeVendas += quantidadeAtualDaVenda;
    }

    @Override
    public String toString() {
        return "nome="+nome+",salario="+salario+",login="+login+",senha="+senha;
    }
    
    public static void setContador(int contadorAtual) {
        Funcionario.contador = contadorAtual;
    }
     
    public void imprimirFuncionario() {
        System.out.println(toString());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    
    
            
            
}
