//Classe Cliente
//� Estende a classe Pessoa
//� 1 construtor com os par�metros de pessoa
//� M�todo:
//a) @Override
//public String toString()
//retorna uma String com o nome, o cpf e o celular do cliente
package trabainHmmmm;

class Cliente extends Pessoa {

	public Cliente(String nome, String cpf,Endereco endereco, String celular) {
		super(nome, cpf, endereco, celular);
	}
	
	@Override
	public String toString()
	{
		return getNome()+""+getCpf()+""+getEndereco()+""+getCelular();
	}
}
