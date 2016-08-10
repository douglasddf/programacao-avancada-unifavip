package dados;


/**
 * Escreva a descrição da classe Venda aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.ArrayList;
import java.util.Date;

public class Venda
{
   private int codigo;
   private ArrayList<Produto> produtos = new ArrayList();
   private Funcionario funcionario;
   private Cliente cliente;
   private Date data;
   private int quantidadeProdutos;
}
