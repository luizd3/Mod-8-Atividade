package models;

public class ContaCorrente extends Conta implements Tributavel{

    private double chequeEspecial;

    public ContaCorrente(int agencia, Cliente cliente, double saldo, double chequeEspecial, TipoConta tipoConta) {
        super(agencia, cliente, saldo, TipoConta.CORRENTE);
        this.chequeEspecial = chequeEspecial;
    }

    public double getSaldo() {
        return this.saldo + this.chequeEspecial;
    }

    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
        System.out.println("Depósito efetuado. Saldo: R$ " + getSaldo());
    }

    public void sacar(double valorSaque) {
        if ((getSaldo() - valorSaque) >= 0) {
            if ((getSaldo() - valorSaque) > chequeEspecial) {
                this.saldo -= valorSaque;
                System.out.println("Saque efetuado. Saldo atual: R$ " + getSaldo() + ". Cheque especial: R$ " + chequeEspecial);
            } else {
                this.saldo -= valorSaque;
                System.out.println("Saque efetuado. Saldo principal zero. Saldo cheque especial: R$ " + getSaldo());
            }
        } else {
            System.out.println("Saque não autorizado. Limite do cheque especial excedido. Saldo atual: R$ " + getSaldo());
        }
    }

    @Override
    public double getImposto() {
        return getSaldo() * 0.1;
    }

    public double getChequeEspecial() {
        return this.chequeEspecial;
    }
}
