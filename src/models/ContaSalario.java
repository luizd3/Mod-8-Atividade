package models;

public class ContaSalario extends Conta implements Tributavel {

    private int numLimiteSaques;

    public ContaSalario(int agencia, Cliente cliente, double saldo, int numLimiteSaques) {
        super(agencia, cliente, saldo, TipoConta.SALARIO);
        this.numLimiteSaques = numLimiteSaques;
    }

    public int getNumLimiteSaques() {return this.numLimiteSaques;}

    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
        System.out.println("Depósito efetuado. Saldo: R$ " + getSaldo());
    }

    @Override
    public void sacar(double valorSaque) {
        if (numLimiteSaques > 0) {
            this.saldo -= valorSaque;
            numLimiteSaques--;
            System.out.println("Saque efetuado. Saldo atual: R$ " + getSaldo() +
                    ". Você tem " + numLimiteSaques + " saque(s) restante(s).");
        } else {
            System.out.println("Saque não autorizado. Limite de saques atingido. Saldo: R$ " + getSaldo());
        }
    }

    @Override
    public double getImposto() {
        return getSaldo() * 0.1;
    }
}
