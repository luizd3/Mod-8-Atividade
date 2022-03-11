package models;

public class ContaPoupanca extends Conta{

    private int diaAniversario;
    private double taxaDeJuros;

    public ContaPoupanca(int agencia, Cliente cliente, double saldo, int diaAniversario, double taxaDeJuros) {
        super(agencia, cliente, saldo, TipoConta.POUPANCA);
        this.diaAniversario = diaAniversario;
        this.taxaDeJuros = taxaDeJuros;
    }

    public double getSaldo(int dia) {
        if (dia >= this.diaAniversario) {
            return this.saldo + (this.saldo * this.taxaDeJuros);
        } else
            return this.saldo;
    }

    public int getDiaAniversario() {
        return this.diaAniversario;
    }

    public double getTaxaDeJuros() {
        return this.taxaDeJuros;
    }

    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
        System.out.println("Depósito efetuado. Saldo: R$ " + getSaldo());
    }

    public void sacar(double valorSaque) {
        if (this.saldo >= valorSaque) {
            this.saldo -= valorSaque;
            System.out.println("Saque efetuado. Saldo: R$ " + getSaldo() + ".");
        } else {
            System.out.println("Saque não autorizado. Saldo insuficiente. Saldo: R$ " + getSaldo() + ".");
        }
    }
}
