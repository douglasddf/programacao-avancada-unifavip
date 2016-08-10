package repositorios;


import dados.Funcionario;
import dados.Cliente;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author douglasfrari
 */
public class RepositorioPessoa {
    
    private static RepositorioPessoa instancia;
    
    private ArrayList<Cliente>clientes;
    private ArrayList<Funcionario>funcionarios;

    
    // SINGLETON com construtor private
    private RepositorioPessoa() {
        
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
    }

    public static RepositorioPessoa getInstancia() {
        
        if (instancia == null) {
            instancia = new RepositorioPessoa();
        }
        
        return instancia;
    }
    
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }
    
    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    
            
    
    
}
