package Cliente;

import java.util.*;

public class ClientePessoaJuridica extends Cliente {

    private String cnpj;
    private int numFuncionarios;
    private String setor;

    public ClientePessoaJuridica(String nome,  String endereco, String cnpj, int numFuncionarios, String setor){
        super(nome, endereco, new Date());
        this.cnpj=cnpj;
        this.numFuncionarios = numFuncionarios;
        this.setor = setor;
    }

    @Override //Object()
    public String toString(){
        return 
        "\n===== Cliente PJ ====="+
        "\nNome: " + this.nome+
        "\nSetor: " + this.setor+
        "\nNumero de funcionários: " + this.numFuncionarios+
        "\nEndereco: " + this.endereco+
        "\nCNPJ: " + this.cnpj+
        "\n====================";
    }

    @Override //Object()
    public boolean equals(Object obj) {
        return cnpj.equals(((ClientePessoaJuridica) obj).cnpj) ; //converte Object obj to ClientePessoaJuridica obj
    }

    @Override //Cliente()
    public boolean autenticar(String key){
        return key == cnpj;
    }

    //Encapsulation
    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}
    public int getNumFuncionarios() {return numFuncionarios;}
    public void setNumFuncionarios(int numFuncionarios) {this.numFuncionarios = numFuncionarios;}
    public String getSetor() {return setor;}
    public void setSetor(String setor) {this.setor = setor;}

}