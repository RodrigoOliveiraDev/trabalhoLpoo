//Interface Verific�vel
//� M�todo:
//a) boolean validar(String codigo);
//Este m�todo dever� validar o CPF para Pessoa e o CNPJ para Fornecedor, sempre que
//esses valores forem cadastradso ou alterados no nestas classes. Se o valor retronado for
//false, ent�o dever� chamar o m�todo que solicita um novo valor a ser validado. b) void
//solicitarNovo():
//Este m�todo dever� solicitar um novo CPF para Pessoa ou um novo CNPJ para fornecedor, sempre que o valor validado retorna false. Quando o novo valor for fornecido,
//dever� chamar o m�todo validar, para que seja verificado.


package trabainHmmmm;

public interface Verificavel {
	boolean validar(String codigo);
	void solicitarNovo();
}
