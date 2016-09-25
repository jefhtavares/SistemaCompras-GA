public class Parcela {
    private Cliente cliente; //completamente desnecessário
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

        if(this.situacao.equals('N') && this.dataVencimento.eMaiorQue(hoje)){
            this.situacao = 'A';
            return true;
        }

        return false;
    }

    public void paga(Data dataPagamento){
        //Todo:
    }

    public String traduzSituacao(){
        if(this.situacao.equals('N'))
            return "Não venceu ainda";

        if(this.situacao.equals('A'))
            return "Em atraso";

        return "Quitada";
    }

    public void exibeDados(){
        //Todo: Acho que isso deveria ser na classe compra
    }
}
