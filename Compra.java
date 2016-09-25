public class Compra {
    private int modalidade;
    private Cliente cliente;
    private Data dataCompra;
    private double preco;
    private double precoFinal;
    private Parcela p1;
    private Parcela p2;
    private Parcela p3;

    public Compra(Cliente cliente, Data dataCompra, double preco){
        this.cliente = cliente;
        this.dataCompra = dataCompra;
        this.preco = preco;

        this.escolheModalidade();
    }

    public Compra(Cliente cliente, int dia, int mes, int ano, double preco){
        this.cliente = cliente;
        this.dataCompra = dataCompra;
        this.preco = preco;

        this.escolheModalidade();
    }

    public void escolheModalidade(){
        System.out.println("-- Modalidades disponíveis --");
        System.out.println("1 - A vista");
        System.out.println("2 - Parcelada, com 50% de entrada e duas parcelas iguais");
        System.out.println("3 - 100% parcelada em 3 vezes iguais");

        int modalidade = Teclado.leInt("Escolha a modalidade da compra: ");

        if(modalidade < 1 || modalidade > 3)
            this.modalidade = 1;
        else
            this.modalidade = modalidade;
    }
}
