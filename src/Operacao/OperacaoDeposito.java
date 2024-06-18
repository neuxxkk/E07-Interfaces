package Operacao;

public class OperacaoDeposito extends Operacao{

    public OperacaoDeposito(double valor){
        super('d', valor);
    }

    @Override //ITaxas
    public double calculaTaxas() {
        return 0;
    }

}

