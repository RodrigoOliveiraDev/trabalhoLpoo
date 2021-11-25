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


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException; //input tipo errado


public class Main {
    static List<Funcionario> funcionarios = new ArrayList<>();
    static List<Cliente> clientes = new ArrayList<>();
    static List<Fornecedor> fornecedores = new ArrayList<>();
    static List<Produto> produtos = new ArrayList<>();
    static List<Compra> compras = new ArrayList<>();
    static double salario;
    static String funcao, nome, cpf, celular;
    static int opcao = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (opcao != 6) {
            System.out.println("MENU PRINCIPAL");
            System.out.println("Escolha uma opção válida:");
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
                    opcao = 0;
                    break;
                case 2:
                    cadastrarClientes();
                    opcao = 0;
                    break;
                case 3:
                    cadastrarFornecedores();
                    opcao = 0;
                    break;
                case 4:
                    if (fornecedores.isEmpty()) {
                        System.out.println("Favor cadastrar um fornecedor antes de cadastrar produto.");
                        opcao = 0;
                        break;
                    }
                    cadastrarProdutos();
                    opcao = 0;
                    break;
                case 5:
                    if (funcionarios.isEmpty() || clientes.isEmpty() || produtos.isEmpty()) {
                        System.out.println("Você precisa cadastrar clientes, funcionarios e produtos para prosseguir.");
                        opcao = 0;
                        break;
                    }
                    cadastrarCompras();
                    opcao = 0;
                    break;
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
            Funcionario funcionario = new Funcionario(nome, cpf, endereco, celular, salario, funcao);
            funcionarios.add(funcionario);
        } catch (InputMismatchException erro) {
            System.out.println("Campo digitado errado.");
            opcao = 0;
            return;
        }
    }

    public static void cadastrarClientes() {
        try {
            sc.nextLine();
            System.out.println("Digite o nome do Cliente: ");
            nome = sc.nextLine();
            System.out.println("Digite o CPF do Cliente: ");
            cpf = sc.nextLine();
            System.out.println("Digite o contato do Cliente: ");
            celular = sc.nextLine();
            System.out.println("Cadastrar endereço completo (1) ou sem o CEP(2): ");
            int opcaoEndereco = sc.nextInt();
            Endereco endereco = cadastrarEndereco(opcaoEndereco);
            Cliente cliente = new Cliente(nome, cpf, endereco, celular);
            clientes.add(cliente);
        } catch (InputMismatchException erro) {
            System.out.println("Campo digitado errado.");
            opcao = 0;
            return;
        }
    }

    public static void cadastrarProdutos() {
        try {
            sc.nextLine();
            String nomeProduto;
            float valor;
            int opForn, i;
            sc.nextLine();
            System.out.println("Digite o nome do produto: ");
            nomeProduto = sc.nextLine();
            System.out.println("Digite seu valor: ");
            valor = sc.nextFloat();
            do {
                listaForn();
                System.out.println("escolha 1 fornecedor: ");
                opForn = sc.nextInt();
            } while (fornecedores.get(opForn) != null);
            Produto produto = new Produto(nomeProduto, valor, fornecedores.get(opForn));
            produtos.add(produto);
        } catch (InputMismatchException erro) {
            System.out.println("Campo digitado errado.");
            opcao = 0;
            return;
        }
    }

    public static void cadastrarFornecedores() {
        try {
            String razaoSocial, nomeFantasia, cnpj, celular;
            sc.nextLine();
            System.out.println("Digite a razaoSocial: ");
            razaoSocial = sc.nextLine();
            System.out.println("Digite o Nome fantasia: ");
            nomeFantasia = sc.nextLine();
            System.out.println("Digite o CNPJ: ");
            cnpj = sc.nextLine();
            System.out.println("Digite o contato: ");
            celular = sc.nextLine();
            System.out.println("Cadastrar endereço completo (1) ou sem o CEP(2): ");
            int opcaoEndereco = sc.nextInt();
            Endereco endereco = cadastrarEndereco(opcaoEndereco);
            Fornecedor fornecedor = new Fornecedor(razaoSocial, nomeFantasia, cnpj, endereco, celular);
            fornecedores.add(fornecedor);
        } catch (InputMismatchException erro) {
            System.out.println("Campo digitado errado.");
            opcao = 0;
            return;
        }
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
                System.out.println("Digite o CEP: ");
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
    public static void cadastrarCompras() {
        int opFunc,opCliente,opProd;
        try {
            sc.nextLine();
            do {
                listaClientes();
                System.out.println("escolha 1 Cliente: ");
                opCliente = sc.nextInt();
            } while (clientes.get(opCliente) == null);
            do {
                listaFuncionarios();
                System.out.println("escolha 1 Funcionario: ");
                opFunc = sc.nextInt();
            } while (funcionarios.get(opFunc) == null);
            Compra compra = new Compra(funcionarios.get(opFunc),clientes.get(opCliente));
            do {
                listaProdutos();
                System.out.println("escolha 1 produto: ");
                System.out.println("Digite 0 para parar de cadastrar produtos: ");
                opProd = sc.nextInt();
                if(produtos.get(opProd) != null){
                    compra.adicionaProduto(produtos.get(opProd));
                }else
                    System.out.println("Digite um produto válido!");
            } while (opProd !=0);
        } catch (InputMismatchException erro) {
            System.out.println("Campo digitado errado.");
            return;
        }
    }

    public static void listaForn() {
        int i;
        for (i = 0; i < fornecedores.size(); i++) {
            System.out.println("s");
            System.out.println(i + "  - " + fornecedores.get(i).getRazaoSocial());
        }
    }

    public static void listaClientes() {
        int i;
        for (i = 0; 1 > clientes.size(); i++) {
            System.out.println(i + "  - " + clientes.get(i).toString());
        }
    }

    public static void listaFuncionarios() {
        int i;
        for (i = 0; 1 > funcionarios.size(); i++) {
            System.out.println(i + "  - " + funcionarios.get(i).toString());
        }
    }

    public static void listaProdutos() {
        int i;
        for (i = 0; 1 > produtos.size(); i++) {
            System.out.println(i + "  - " + produtos.get(i).toString());
        }
    }
}
