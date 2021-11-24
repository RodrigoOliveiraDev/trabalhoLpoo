//Classe Fornecedor
//� Implementa a classe Verificavel
//� Atributos privados:
//String razaoSocial; String nomeFantasia; String cnpj; Endereco endereco; String celular;
//� 1 Construtor
//a) public Fornecedor(String razaoSocial;String nomeFant; String cnpj Endereco endereco, String celular)
//obs: no construtor deve-se validar o CNPJ antes de atribuir o valor do cnpj
//Ent�o � preciso chamar o m�todo para validar(String codigo)
//Se o CNPJ estiver correto, ele ser� atribu�do,
//Caso contr�rio dever� solicitar um novo valor para o cnpj
//� M�todos:
//a) @Override
//public boolean validar(String CNPJ)
//este m�todo ter� que validar o CNPJ
//b) @Override
//public void solicitarNovo()
//este m�todo solicita um novo CNPJ, at� que o valor do CNPJ informado esteja correto
package trabainHmmmm;

import java.util.Scanner;

public class Fornecedor implements Verificavel {

    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private Endereco endereco;
    private String celular;
	Scanner sc = new Scanner(System.in);

    public Fornecedor(String razaoSocial, String nomeFantasia, String cnpj, Endereco endereco, String celular) {
        super();
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.celular = celular;
    }

    @Override
    public boolean validar(String CNPJ) {
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
                CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
                CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
                CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
                CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
                (CNPJ.length() != 14))
            return (false);

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else dig13 = (char) ((11 - r) + 48);
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else dig14 = (char) ((11 - r) + 48);
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
                return (true);
            else
                return (false);
        } catch (Exception erro) {
            System.out.println(erro);
            return (false);
        }
    }

    @Override
    public void solicitarNovo() {
        do {
            System.out.println("CNPJ Inválido, favor digitar novamente: ");
            this.cnpj = sc.nextLine();
        } while (!validar(this.cnpj));
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
}
