//Classe Pessoa (Abstrata)
//� Implementa a classe Verificavel
//� Atributos privados:
//String nome; String cpf; Endereco endereco; String celular;
//� 1 Construtor
//a) public Pessoa(String nome, String cpf, Endereco endereco, String celular)
//obs: no construtor deve-se validar o CPF antes de atribuir o valor do cpf
//Ent�o � preciso chamar o m�todo para validar(String codigo)
//Se o CPF estiver correto, ele ser� atribu�do,
//Caso contr�rio dever� solicitar um novo valor para o cpf
//� M�todos:
//a) @Override
//public boolean validar(String CPF)
//este m�todo ter� que validar o CPF
//b) @Override
//public void solicitarNovo()
//este m�todo solicita um novo CPF, at� que o valor do CPF informado esteja correto
package trabainHmmmm;

import java.util.Scanner;

public abstract class Pessoa implements Verificavel {
	private String nome;
	private String cpf;
	private Endereco endereco;
	private String celular;
	Scanner sc = new Scanner(System.in);
	
	public Pessoa(String nome, String cpf, Endereco endereco, String celular) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.celular = celular;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public  boolean validar(String CPF)
	{
		if (CPF.equals("00000000000") ||
				CPF.equals("11111111111") ||
				CPF.equals("22222222222") || CPF.equals("33333333333") ||
				CPF.equals("44444444444") || CPF.equals("55555555555") ||
				CPF.equals("66666666666") || CPF.equals("77777777777") ||
				CPF.equals("88888888888") || CPF.equals("99999999999") ||
				(CPF.length() != 11))
			return false;
		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i=0; i<9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for(i=0; i<10; i++) {
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return true;
			else return false;
		} catch (Exception erro) {
			System.out.println(erro);
			return false;
		}
	}
	
	@Override
	public void solicitarNovo()
	{
		do  {
			System.out.println("CPF Inválido, favor digitar novamente: ");
			this.cpf = sc.nextLine();
		}while (!validar(this.cpf));
	}

}
