package Contas;

import Cliente.*;

public class ContaUniversitaria extends Conta{

    public ContaUniversitaria(int numero, Cliente dono, double saldo, double limiteMin, double limiteMax){
        super(numero, dono, saldo, limiteMin, limiteMax);
        setLimite();
    }

    @Override //Conta()
    void setLimite() {
        if (limiteMin < 0) limiteMin = 0;
        if (limiteMax > 500) limiteMax = 500;
    }

    @Override //ITaxas()
    public double calculaTaxas(){
        return 0;
    }

}