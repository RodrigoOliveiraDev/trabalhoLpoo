//Classe Endere�o
//� Atributos:
//String rua; int numero; String bairro; String cidade; String cep;
//� 2 construtores:
//a) Para endere�o completo
//public Endereco(String rua, int numero, String bairro, String cidade, String cep)
//b) Para endere�o sem cep
//public Endereco(String rua, int numero, String bairro, String cidade)
//� M�todos:
//a) gets e sets

package trabainHmmmm;

public class Endereco {
	
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String cep;
	
	public Endereco(String rua, int numero, String bairro, String cidade, String cep) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}
	public Endereco(String rua, int numero, String bairro, String cidade) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
}
