package Operacao;

public class OperacaoSaque extends Operacao{

    public OperacaoSaque(double valor){
        super('s', valor);
    }

    @Override //ITaxas
    public double calculaTaxas() {
        return 0.05;
    }

}
