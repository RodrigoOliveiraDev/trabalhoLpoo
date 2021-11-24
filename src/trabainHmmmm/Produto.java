//Classe Produto
//� Atributos privados:
//String nomeProduto; Float valor; Fornecedor empresa
//� 1 construtor com os par�metros de Fornecedor, nomeProduto, valor e empresa
//� M�todo:
//a) int compareTo(Object obj)
//compara os produtos pelo valor
//b) public String toString()
//retorna uma String com o nomeProduto e o valor
package trabainHmmmm;

public class Produto {
	private String nomeProduto;
	private Float valor;
	private Fornecedor empresa;
	
	public Produto(String razaoSocial, String nomeFantasia, String cnpj, Endereco endereco, String celular,String nomeProduto, Float valor, Fornecedor empresa) {
		super();
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.empresa = empresa;
	}
	
	int compareTo(Object obj)
	{
		return 1;
	}
	
	 public String toString()
	 {
		 return nomeProduto+""+valor;
	 }

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Fornecedor getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Fornecedor empresa) {
		this.empresa = empresa;
	}
}
