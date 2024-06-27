package Operacao;

import java.util.*;
import ITaxas.*;

public abstract class Operacao implements ITaxas{

    private Date data;
    protected char tipo;
    protected double valor;
    private static int totalOperacoes = 0;

    Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();
        Operacao.totalOperacoes++;
    }

    @Override //Object()
    public String toString() {
        return String.format("%s\t%s\t%s", this.data,  this.tipo,  this.valor);
    }

    //Encapsulation
    public Date getData() {return data;}
    public char getTipo() {return tipo;}
    public double getValor() {return valor;}
    public static int getTotalOperacoes() {return Operacao.totalOperacoes; }
    public void setTipo(char tipo) {if(tipo == 'd' || tipo == 's')this.tipo = tipo;}
    public void setValor(double valor) {this.valor = valor;}

}