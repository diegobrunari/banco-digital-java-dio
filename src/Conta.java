public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numeroDaConta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numeroDaConta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(saldo < valor) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
        if(valor > 0) {
            saldo += valor;
        } else {
            System.out.println("O valor tem que ser positivo.");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(saldo < valor) {
            System.out.println("Não foi possível realizar a transferencia.");
        } else {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Conta: %d%n", this.numeroDaConta);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}
