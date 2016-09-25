public class Cliente {
    private String nome;
    private Data dataNascimento;
    private double valorPenultimaCompra;
    private double valorUltimaCompra;
    private double saldoDevedor;

    public Cliente(String nome, Data dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getValorPenultimaCompra() {
        return this.valorPenultimaCompra;
    }

    public void setValorPenultimaCompra(double valorPenultimaCompra) {
        this.valorPenultimaCompra = valorPenultimaCompra;
    }

    public double getValorUltimaCompra() {
        return this.valorUltimaCompra;
    }

    public void setValorUltimaCompra(double valorUltimaCompra) {
        this.valorUltimaCompra = valorUltimaCompra;
    }

    public double getSaldoDevedor() {
        return this.saldoDevedor;
    }

    public void setSaldoDevedor(double saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public void fazCompra(double valorCompra){
        this.valorPenultimaCompra = this.valorUltimaCompra;
        this.valorUltimaCompra = valorCompra;
    }

    public void fazCompra(double valorFinal, double valorParcelas){
        this.fazCompra(valorFinal);

        this.saldoDevedor += valorParcelas;
    }

    public void pagaParcela(double valorPago){
        this.saldoDevedor -= valorPago;
    }

    public void exibeDados(){
        System.out.println("Exibindo dados do cliente: " + this.nome);
        System.out.println("Data de nascimento: " + this.dataNascimento.obtemDataPadrao());
        System.out.println("Valor da penúltima compra: " + this.valorPenultimaCompra);
        System.out.println("Valor da última compra: " + this.valorUltimaCompra);
        System.out.println("Saldo devedor: " + this.saldoDevedor);
    }
}
