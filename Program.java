public class Program {
    public static void main(String args[]){
        // 1. Instanciar um cliente, para o qual serão instanciadas as 5 compras abaixo
        Cliente cliente = new Cliente("Jeferson", new Data(01, 12, 1995));

        // 2. Instanciar uma compra à vista (usar o primeiro construtor), com mês da
        // compra igual ao do aniversário do cliente, finalizar a compra e exibir
        // dados da compra.
        Compra compra1 = new Compra(cliente, new Data(08, 12, 2016), 5000);
        compra1.finalizar();
        compra1.exibirDados();

        // 3. Instanciar para o mesmo cliente uma segunda compra (usar o segundo
        // construtor), de valor mais alto que a primeira, para pagamento com
        // entrada e duas parcelas, finalizar a compra e exibir dados dela.
        Compra compra2 = new Compra(cliente, new Data(), 8000)
        compra2.finalizar();
        compra2.exibirDados();

        // 4. Instancia uma nova compra à vista, num mês diferente do de seu
        // aniversário e com valor maior que os das compras anteriores. Finalizar e
        // exibir dados da compra.
        Compra compra3 = new Compra(cliente, new Data(), 10000);
        compra3.finalizar();
        compra3.exibirDados();

        // 5. Instanciar uma compra à vista, fora do mês de aniversário, com valor
        // menor que o da compra anterior. Finalizar e exibir dados da compra.
        Compra compra4 = new Compra(cliente, new Data(), 9000);
        compra4.finalizar();
        compra4.exibirDados();

        // 6. Instanciar uma compra em 3 parcelas. Finalizar e exibir dados dela.
        Compra compra5 = new Compra(cliente, new Data(), 3300);
        compra5.finalizar();
        compra5.exibirDados();
    }
}
