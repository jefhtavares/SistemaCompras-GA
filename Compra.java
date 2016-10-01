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
        System.out.println("1 - " + traduzModalidade(1));
        System.out.println("2 - " + traduzModalidade(2));
        System.out.println("3 - " + traduzModalidade(3));

        int modalidade = Teclado.leInt("Escolha a modalidade da compra: ");

        if(modalidade < 1 || modalidade > 3)
            this.modalidade = 1;
        else
            this.modalidade = modalidade;
    }

    public boolean ultimasCrescente(double valorUltimaCompra){
        return (valorUltimaCompra > this.valorUltimaCompra) && (this.valorUltimaCompra > this.valorPenultimaCompra);
    }

    public void finalizaCompra(){
        //Todo:
    }

    public Data calculaVencimentoParcela(Data vencimento){
        Data ret = new Data(28, vencimento.getMes(), vencimento.getAno());
        ret.incrementaMes();
        return ret;
    }

    public static String traduzModalidade(int modalidade){
        if(modalidade == 1){
            return "A vista";
        }

        if(modalidade == 2){
            return "Parcelada, com 50% de entrada e duas parcelas iguais";
        }

        return "100% parcelada em 3 vezes iguais";
    }

    public String traduzModalidade(){
        traduzModalidade(this.modalidade);
    }

    public void exibirDados(){
        System.out.println(" === Exibindo dados da compra ===");

        System.out.println("Data: " + dataCompra.obtemDataPadrao());
        System.out.println("Preço: " + preco);
        System.out.println("Preço final: " + precoFinal);
        System.out.println("Modalidade: " + traduzModalidade());

        if(this.cliente != null){
            System.out.println("\t-- Dados do cliente da compra --");
            this.cliente.exibeDados();
        }

        /* Vou fazer por parcela porque não sei se a compra com modalidade 2 tem que ter 2
        ou 3 parcelas... Sem contar que fica mais consistente. */

        if(p1 != null){
            System.out.println("\t -- Exibindo parcelas --");
            this.p1.exibeDados(1);
        }

        if(p2 != null){
            this.p2.exibeDados(2);
        }

        if(p3 != null){
            this.p3.exibeDados(3);
        }
    }
}
