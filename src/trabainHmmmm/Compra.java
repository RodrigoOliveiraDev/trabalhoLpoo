//Classe Compra
//� Atributos privados:
//Funcionario funcionario; Cliente cliente; List Produto produto
//� 1 construtor com os par�metros: Funcionario e Cliente
//� M�todo:
//a) void adicionaProduto(Produto prod)
//b) public void listarCompra()
//O m�todo listar compra dever� informar o Funcion�rio que fez a venda e o cliente que
//fez a compra
//Em seguida, dever� listar todos os produtos comprados pelo cliente ordenado do menor
//para o maior valor do produto
//Ao final mostrar o valor total da compra.
//O valor do Produto impresso deve possuir 2 casas decimais.
package trabainHmmmm;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

class Compra {
	private Funcionario funcionario;
	private Cliente cliente;
	private List <Produto> produtos;
	
	public Compra(Funcionario funcionario, Cliente cliente) {
		super();
		this.funcionario = funcionario;
		this.cliente = cliente;
	}
	
	void adicionaProduto (Produto prod)
	{
		this.produtos.add(prod);
	}
	
	//FAZER O LISTARRRR
	//
	public void listarCompra() {
		Float valorTotal = 0F;
		System.out.println("Funcionário de venda: " + funcionario.getNome());
		System.out.println("Cliente: " + cliente.getNome());
		Collections.sort(produtos, (Produto r1, Produto r2) -> {//método para organizar a lista de produtos por valor
			return r1.getValor().compareTo(r2.getValor());
		});
		for (Produto produto : produtos) {
			System.out.println("Produto: "+produto.getNomeProduto()+" - Valor:"+produto.getValor());
			valorTotal = valorTotal + produto.getValor();
		}
		System.out.println("Valor da compra: "+valorTotal);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
