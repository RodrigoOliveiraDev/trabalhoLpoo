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
    static List<Funcionario> funcionarios = new ArrayList<>();
    static List<Cliente> cliente = new ArrayList<>();
    static List<Fornecedor> fornecedores = new ArrayList<>();
    static List<Produto> produtos = new ArrayList<>();
    static List<Compra> compras = new ArrayList<>();
    static double salario;
    static  String funcao, nome, cpf, celular;
    static int opcao = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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
        try {
            sc.nextLine();
            System.out.println("Digite o nome do funcionário: ");
            nome = sc.nextLine();
            System.out.println("Digite o CPF do funcionário: ");
            cpf = sc.nextLine();
            System.out.println("Digite o contato do funcionário: ");
            celular = sc.nextLine();
            System.out.println("Digite o salário do funcionário: ");
            salario = sc.nextDouble();
            System.out.println("Digite sua funcao: ");
            funcao = sc.nextLine();
            System.out.println("Cadastrar endereço completo (1) ou sem o CEP(2): ");
            int opcaoEndereco = sc.nextInt();
            Endereco endereco = cadastrarEndereco(opcaoEndereco);
            Funcionario funcionario =  new Funcionario(nome, cpf, endereco, celular,salario,funcao);
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getEndereco().getBairro());
        }catch (InputMismatchException erro){
            System.out.println("Campo digitado errado.");
            opcao = 0;
            return;
        }
    }

	public static void cadastrarClientes() {
	}

    public static Endereco cadastrarEndereco(int opcaoEndereco) {
        String rua, bairro, cidade, cep;
        int numero;
        Endereco endereco;
        try {
            sc.nextLine();
            System.out.println("Digite a cidade: ");
            cidade = sc.nextLine();
            System.out.println("Digite o bairro: ");
            bairro = sc.nextLine();
            System.out.println("Digite a rua: ");
            rua = sc.nextLine();
            System.out.println("Digite o numero: ");
            numero = sc.nextInt();
            if (opcaoEndereco == 2) {
                System.out.println("Digite o CEP");
                cep = sc.nextLine();
                endereco = new Endereco(rua, numero, bairro, cidade, cep);
                //contrutor do cep
            } else
                endereco = new Endereco(rua, numero, bairro, cidade);
        } catch (InputMismatchException erro) {
            System.out.println("Campo digitado errado.");
            return null;
        }
        return endereco;
    }

}
