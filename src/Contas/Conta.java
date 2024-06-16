package Contas;

import Operacao.*;
import Cliente.*;
import ITaxas.*;
import java.util.*;

public abstract class Conta implements ITaxas{ //implements para Interfaces

    protected int numero;
    protected Cliente dono;
    protected double saldo;
    protected double limiteMax, limiteMin;
    protected List<Double> taxas = new ArrayList<>();
    protected Operacao[] operacoes;
    protected int proximaOperacao;
    protected static int totalContas = 0;

    public Conta(int numero, Cliente dono, double saldo, double limiteMin, double limiteMax) {
        this.limiteMin = limiteMin;
        this.limiteMax = limiteMax;
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
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
        if (valor >= limiteMin && valor <= limiteMax) {
            saldo -= valor;
            operacoes[proximaOperacao] = new OperacaoSaque(valor);
            taxas.add(operacoes[proximaOperacao].calculaTaxas());
            proximaOperacao++;
            redimensionarOperacoes();
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
        saldo += valor;
        operacoes[proximaOperacao] = new OperacaoDeposito(valor);
        proximaOperacao++;
        redimensionarOperacoes();
    }

    public boolean transferir(Conta destino, double valor) {
        boolean valorSacado = sacar(valor);
        if (valorSacado) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public void imprimirExtratoConta() {
        System.out.println("\n======= Extrato Conta " + numero + "======");
        for(Operacao atual : operacoes) {
            if (atual != null) {
                System.out.println(atual);
            }
        }
        System.out.println("====================");
    }

    public void imprimirExtratoTaxas(){
        double f=0, total=0;
        taxas.sort(Comparator.reverseOrder());
        System.out.println("\n======= Extrato de Taxas Conta " + numero + "======");
        for(double atual : taxas) {
            total+=atual;
            if (atual<10){
                if (f<0){
                    f=1;
                    System.out.println("\nOperacoes");
                }
                System.out.println("Saque: " + atual);
            }else if (atual>0.05){
                if (f==0){
                    f=-1;
                    System.out.print("Manutencao da Conta: ");
                }
                System.out.println(atual);
            }          
        }
        System.out.printf("\nTotal:"+ total +"\n====================");
    }

    @Override //Object()
    public String toString() {
        return
        "\n===== Conta " + numero + " ====="+
        "\nDono: " + dono.getNome()+
        "\nSaldo: " + saldo+
        "\nLimite Max: " + limiteMax+
        "\nLimite Min: " + limiteMin+
        "\n====================";
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
    abstract void setLimite();

}
