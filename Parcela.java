public class Parcela {
    private Cliente cliente;
    private Data dataVencimento;
    private double valorOriginal;
    private double valorFinal;
    private char situacao;

    public Parcela(Cliente cliente, Data vencimento, double valor){
        this.cliente = cliente;
        this.dataVencimento = vencimento;
        this.valorOriginal = valor;
        this.situacao = 'N';
    }

    public Cliente getCliente() {
    	return this.cliente;
    }

    public void setCliente(Cliente cliente) {
    	this.cliente = cliente;
    }

    public Data getDataVencimento() {
    	return this.dataVencimento;
    }

    public void setDataVencimento(Data dataVencimento) {
    	this.dataVencimento = dataVencimento;
    }

    public double getValorOriginal() {
    	return this.valorOriginal;
    }

    public void setValorOriginal(double valorOriginal) {
    	this.valorOriginal = valorOriginal;
    }

    public double getValorFinal() {
    	return this.valorFinal;
    }

    public void setValorFinal(double valorFinal) {
    	this.valorFinal = valorFinal;
    }

    public char getSituacao() {
    	return this.situacao;
    }

    public void setSituacao(char situacao) {
    	this.situacao = situacao;
    }

    public boolean registraAtraso(){
        Data hoje = new Data();

        if(this.situacao == 'N' && this.dataVencimento.eMaiorQue(hoje)){
            this.situacao = 'A';
            return true;
        }

        return false;
    }

    public double paga(Data dataPagamento){
        double percJuros;

        if(!dataPagamento.eMaiorQue(this.dataVencimento)){
            percJuros = 0;
        }

        int diasDiff = dataPagamento.diasDeOutraData(this.dataVencimento);

        if(diasDiff <= 5){
            percJuros = 0.01;
        }else if (diasDiff <= 15){
            percJuros = 0.015;
        }else{
            percJuros = 0.025;
        }

        double valorJuros = this.valorOriginal * percJuros;
        this.situacao = 'Q';
        this.valorFinal = this.valorOriginal + valorJuros;

        double saldoDevedorCliente = this.cliente.getSaldoDevedor() - this.valorOriginal;
        //Tem que subtrair o valor original, porque o atributo "saldoDevedor" foi calculado com os valores originais das parcelas
        this.cliente.setSaldoDevedor(saldoDevedorCliente);

        return valorJuros;
    }

    public String traduzSituacao(){
        if(this.situacao == 'N')
            return "Nao venceu ainda";

        if(this.situacao == 'A')
            return "Em atraso";

        return "Quitada";
    }

    public void exibeDados(int numParcela){
        //Todo: Acho que isso deveria ser na classe compra
        System.out.print("Parcela numero: " + numParcela);
        System.out.print(" - Nome do cliente: " + cliente.getNome());
        System.out.print(" - Vencimento: " + dataVencimento.obtemDataPadraoComZeros());
        System.out.print(" - Valor original: " + valorOriginal);
        System.out.print(" - Situacao: " + traduzSituacao() + "\n");

    }
}
