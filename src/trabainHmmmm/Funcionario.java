//Classe Funcionario
//� Estende a classe Pessoa
//� 1 construtor com os par�metros de pessoa, o salario e a funcao
//� M�todo:
//a) @Override
//public String toString()
//retorna uma String com o nome, o cpf, o celular, a fun��o e o sal�rio do funcion�rio.
package trabainHmmmm;

public class Funcionario extends Pessoa {
	
	int salario;
	String funcao;
	
	public Funcionario(String nome, String cpf, String endereco, String celular, int salario, String funcao) {
		super(nome, cpf, endereco, celular);
		this.salario = salario;
		this.funcao = funcao;
	}
	
	@Override
	public String toString()
	{
		return getNome()+""+getCpf()+""+getCelular()+""+funcao+""+salario;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
}