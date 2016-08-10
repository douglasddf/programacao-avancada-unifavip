package dados;


/**
 * Escreva a descrição da classe Funcionario aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Funcionario extends Pessoa
{

    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "nome="+nome+",salario="+salario;
    }
            
     
    public void imprimirFuncionario() {
        System.out.println(toString());
    }
    
            
            
}
