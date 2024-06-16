package Cliente;

import java.util.*;

public class ClientePessoaFisica extends Cliente {

    private String cpf;
    private int idade;
    private char sexo;

    public ClientePessoaFisica(String nome,  String endereco, String cpf, int idade, char sexo) {
        super(nome, endereco, new Date());
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    @Override //Object()
    public String toString(){
        return
        "\n===== Cliente PF ====="+
        "\nNome: " + this.nome + 
        "\nIdade: " + this.idade +
        "\nSexo: " + this.sexo +
        "\nEndereco: " + this.endereco +
        "\nCPF: " + this.cpf +
        "\n====================";
    }

    @Override //Object()
    public boolean equals(Object obj) {
        ClientePessoaFisica pessoa = (ClientePessoaFisica) obj;
        return cpf.equals(pessoa.cpf);
    }
    
    @Override //Cliente()
    boolean autenticar(String key) {
        return key.equals(this.cpf);
    }

    //Encapsulamento
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public int getIdade() {return idade;}
    public void setIdade(int idade) {this.idade = idade;}
    public char getSexo() {return sexo;}
    public void setSexo(char sexo) {this.sexo = sexo;}

}

/*public boolean verificadorCpf() {
        boolean cpfValido = true;
        
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11)
            cpfValido = false;

        // Verifica se todos os dígitos são iguais
        boolean allDigitsEqual = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }
        if (allDigitsEqual)
            cpfValido = false;

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digit1 = 11 - (sum % 11);
        if (digit1 > 9)
            digit1 = 0;

        // Verifica o primeiro dígito verificador
        if ((cpf.charAt(9) - '0') != digit1)
            cpfValido = false;

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digit2 = 11 - (sum % 11);
        if (digit2 > 9)
            digit2 = 0;

        // Verifica o segundo dígito verificador
        if ((cpf.charAt(10) - '0') != digit2)
            cpfValido = false;

        return cpfValido;
    }

    static Cliente criarCliente(String nome, String cpf, String endereco, int idade, char sexo) {
        Cliente cliente = new ClientePessoaFisica(cpf, idade, sexo, nome, endereco);
        if (cliente.verificadorCpf()){
            //System.out.println("Cliente criado com sucesso!");
            return cliente;
        }
        else {
            //System.out.printf("\n!!!!! Cliente %s não foi criado, ERRO:cpf !!!!!\n\n", nome);
            return null;
        }
    }*/

