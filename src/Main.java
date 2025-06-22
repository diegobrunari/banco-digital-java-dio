public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Diego Brunari");

        Conta cc = new ContaCorrente(cliente1);
        cc.depositar(500);

        Conta poupanca = new ContaPoupanca(cliente1);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
