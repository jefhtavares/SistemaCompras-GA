public class Program {
    public static void main(String args[]){
        // 1. Instanciar um cliente, para o qual serão instanciadas as 5 compras abaixo
        Cliente cliente = new Cliente("Jeferson", new Data(01, 12, 1995));

        // 2. Instanciar uma compra à vista (usar o primeiro construtor), com mês da
        // compra igual ao do aniversário do cliente, finalizar a compra e exibir
        // dados da compra.


        // 3. Instanciar para o mesmo cliente uma segunda compra (usar o segundo
        // construtor), de valor mais alto que a primeira, para pagamento com
        // entrada e duas parcelas, finalizar a compra e exibir dados dela.


        // 4. Instancia uma nova compra à vista, num mês diferente do de seu
        // aniversário e com valor maior que os das compras anteriores. Finalizar e
        // exibir dados da compra.

        // 5. Instanciar uma compra à vista, fora do mês de aniversário, com valor
        // menor que o da compra anterior. Finalizar e exibir dados da compra.


        // 6. Instanciar uma compra em 3 parcelas. Finalizar e exibir dados dela.
        Parcela p = new Parcela(cliente, new Data(01, 12, 2016), 80.0);
        p.exibeDados(1);

        Data d = new Data(1, 10, 1995);
        d.incrementaMes();

        System.out.println(d.obtemDataPadrao());
    }
}
