package Contas;

import Cliente.*;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numero, Cliente dono, double saldo, double limiteMax, double limiteMin){
        super(numero, dono, saldo, limiteMax, limiteMin);
        setLimite();
    }

    @Override //Conta()
    void setLimite() {
        if (limiteMin < 100) limiteMin = 100;
        if (limiteMax > 1000) limiteMax = 1000;
    }

    @Override //ITaxas()
    public double calculaTaxas(){
        return 0;
    }

}