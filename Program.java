public class Program {
    public static void main(String args[]){
        System.setProperty("file.encoding", "UTF-8");

        // 1. Instanciar um cliente, para o qual serão instanciadas as 5 compras abaixo
        Cliente cliente = new Cliente("Jeferson", new Data(1, 12, 1995));

        // 2. Instanciar uma compra à vista (usar o primeiro construtor), com mês da
        // compra igual ao do aniversário do cliente, finalizar a compra e exibir
        // dados da compra.
        System.out.println("\t* Fazendo a primeira compra *");

        Compra compra1 = new Compra(cliente, new Data(8, 12, 2016), 5000);
        System.out.println(compra1.finalizaCompra());
        compra1.exibirDados();

        System.out.println("\n\n\n");

        // 3. Instanciar para o mesmo cliente uma segunda compra (usar o segundo
        // construtor), de valor mais alto que a primeira, para pagamento com
        // entrada e duas parcelas, finalizar a compra e exibir dados dela.
        System.out.println("\t* Fazendo a segunda compra *");

        Compra compra2 = new Compra(cliente, new Data(), 8000);
        System.out.println(compra2.finalizaCompra());
        compra2.exibirDados();

        System.out.println("\n\n\n");

        // 4. Instancia uma nova compra à vista, num mês diferente do de seu
        // aniversário e com valor maior que os das compras anteriores. Finalizar e
        // exibir dados da compra.
        System.out.println("\t* Fazendo a terceira compra *");

        Compra compra3 = new Compra(cliente, new Data(), 10000);
        System.out.println(compra3.finalizaCompra());
        compra3.exibirDados();

        System.out.println("\n\n\n");

        // 5. Instanciar uma compra à vista, fora do mês de aniversário, com valor
        // menor que o da compra anterior. Finalizar e exibir dados da compra.
        System.out.println("\t* Fazendo a quarta compra *");

        Compra compra4 = new Compra(cliente, new Data(), 9000);
        System.out.println(compra4.finalizaCompra());
        compra4.exibirDados();

        System.out.println("\n\n\n");

        // 6. Instanciar uma compra em 3 parcelas. Finalizar e exibir dados dela.
        System.out.println("\t* Fazendo a útlima compra *");

        Compra compra5 = new Compra(cliente, new Data(), 3300);
        System.out.println(compra5.finalizaCompra());
        compra5.exibirDados();
    }
}
