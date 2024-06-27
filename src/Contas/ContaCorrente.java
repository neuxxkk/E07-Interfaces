package Contas;

import Cliente.*;

public class ContaCorrente extends Conta{

    public ContaCorrente(int numero, Cliente dono, double saldo, double limiteMin, double limiteMax){
        super(numero, dono, saldo, limiteMin, limiteMax);
    }

    @Override //Conta()
    void setLimite(double limiteMin, double limiteMax) {
        if (limiteMin < -100) limiteMin = -100;
        this.limiteMin = limiteMin;
        this.limiteMax = limiteMax;
    }

    @Override //ITaxas()
    public double calculaTaxas(){
        return dono instanceof ClientePessoaFisica ? 10:20;
    }
    
}