package Contas;

import Cliente.*;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numero, Cliente dono, double saldo, double limiteMax, double limiteMin){
        super(numero, dono, saldo, limiteMax, limiteMin);
    }

    @Override //Conta()
    void setLimite(double limiteMin, double limiteMax) {
        if (limiteMin < 100) limiteMin = 100;
        if (limiteMax > 1000) limiteMax = 1000;
        this.limiteMin = limiteMin;
        this.limiteMax = limiteMax;
    }

    @Override //ITaxas()
    public double calculaTaxas(){
        return 0;
    }

}