//Classe Main
//� Possui o m�todo main
//� Inserir pelo menos 6 Enderecos, 2 Funcionarios, 2 Clientes, 2 Fornecedores, 10 Produtos
//� Usar exce��o para tratar entradas inv�lidas para os valores referente a produtos e sal�rio
//do Funcionario.
//� Innserir pelo menos 2 compras com no m�nimo 5 produtos.
//� Listar os Cliente, os Fornecedore e as Compras conforme citado acima.

//� 1- Listar Clientes
//o nome, o cpf e o cleular.
//� 2- Listar Funcion�rios
//o nome, o cpf, o cleular, a fun��o e o sal�rio.
//� 3-Listar compras:
//o nome do Cliente que fez a compra, do funcion�rio que vendeu, listar os produtos comprados
//em ordem por valor e o total da compra.
package trabainHmmmm;

//importa��es

import org.jcp.xml.dsig.internal.SignerOutputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException; //input tipo errado


public class Main {
    List<Endereco> enderecos = new ArrayList<>();
    List<Funcionario> funcionarios = new ArrayList<>();
    List<Cliente> cliente = new ArrayList<>();
    List<Fornecedor> fornecedores = new ArrayList<>();
    List<Produto> produtos = new ArrayList<>();
    List<Compra> compras = new ArrayList<>();
    double salario;
    String funcao, nome, cpf, celular;

    public static void main(String[] args) {

        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        while (opcao != 6) {
            System.out.println("MENU PRINCIPAL");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Funcionario");
            System.out.println("2 - Cadastrar Cliente");
            System.out.println("3 - Cadastrar Fornecedor");
            System.out.println("4 - Cadastrar Produto");
            System.out.println("5 - Cadastrar Compra");
            System.out.println("6 - Encerrar");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarFuncionarios();
            }
        }
    }
  
    public static void cadastrarFuncionarios() {
		cadastrarPessoas();
    }

	public static void cadastrarClientes() {
		cadastrarPessoas();
	}

	public static Pessoa cadastrarPessoas() {
		return null;
	}
}
