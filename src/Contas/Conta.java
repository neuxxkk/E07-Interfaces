package Contas;

import java.util.*;
import Cliente.*;
import Operacao.*;
import ITaxas.*;

public abstract class Conta implements ITaxas{

    protected int numero;
    protected Cliente dono;
    protected double saldo;
    protected double limiteMax, limiteMin;
    protected Operacao[] operacoes;
    protected int proximaOperacao;
    protected static int totalContas = 0;

    Conta(int numero, Cliente dono, double saldo, double limiteMin, double limiteMax) {
        this.numero = numero;
        this.dono = dono;
        setLimite(limiteMin, limiteMax);
        setSaldo(saldo);
        this.operacoes = new Operacao[10];
        this.proximaOperacao = 0;
        Conta.totalContas++;
    }

    protected void redimensionarOperacoes() {
        if (operacoes.length == proximaOperacao) {
            operacoes = Arrays.copyOf(operacoes, operacoes.length * 2);
        }
    }

    public boolean sacar(double valor) {
        if (saldo-valor >= limiteMin && valor > 0) {
            operacoes[proximaOperacao] = new OperacaoSaque(valor);
            saldo -= valor + operacoes[proximaOperacao].calculaTaxas();
            proximaOperacao++;
            redimensionarOperacoes();
            return true;
        }
        return false;
    }

    public boolean depositar(double valor) {
        if (saldo+valor <= limiteMax && valor > 0){
            saldo += valor;
            operacoes[proximaOperacao] = new OperacaoDeposito(valor);
            proximaOperacao++;
            redimensionarOperacoes();
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor))
            return destino.depositar(valor);
        return false;
    }

    public void imprimirExtratoConta() {
        System.out.println("\n============= Extrato Conta " + numero + " ==============");
        for(Operacao atual : operacoes) {
            if (atual != null) {
                System.out.println(atual);
            }
        }
        System.out.println("==============================================");
    }

    public void imprimirExtratoTaxas(){
        System.out.println("\n==== Extrato de Taxas ====");
        double total=this.calculaTaxas();
        System.out.println("Manutenção da conta: " + this.calculaTaxas());
        System.out.println("\nOperações");
        for (Operacao o : operacoes)if (o != null){
            total+=o.calculaTaxas();
            if (o.getTipo() == 's')System.out.println("Saque: " + o.calculaTaxas());
        } 
        System.out.println("\nTotal: " + (float)total);
        System.out.println("==========================");
    }

    @Override //Object()
    public String toString() {
        return
        "\n===== Conta " + numero + " ====="+
        "\nDono: " + dono.getNome()+
        "\nSaldo: " + (float)saldo +
        "\nLimite Max: " + limiteMax+
        "\nLimite Min: " + limiteMin+
        "\n======================";
    }

    @Override //Object()
    public boolean equals(Object conta) {
        return this.numero==((Conta) conta).numero; //converte Object conta to Conta conta
    }

    //Encapsulation
    public int getNumero() {return numero;}
    public Cliente getDono() {return dono;}
    public double getSaldo() {return saldo;}
    public double getLimiteMax() {return limiteMax;}
    public double getLimiteMin() {return limiteMin;}
    public static int getTotalContas() {return Conta.totalContas;}
    public void setNumero(int numero) {this.numero = numero;}
    public void setDono(Cliente dono) {this.dono = dono;}
    public void setSaldo(double saldo){
        if (saldo > limiteMax) saldo = limiteMax;
        if (saldo < limiteMin) saldo = limiteMin;
        this.saldo = saldo - this.calculaTaxas();
    }
    abstract void setLimite(double limiteMin, double limiteMax);

}
