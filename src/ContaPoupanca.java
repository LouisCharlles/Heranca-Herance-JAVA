final class ContaPoupanca extends ContaBancaria{
    double taxa_rendimento;

    public ContaPoupanca(String nome,double saldo, double taxa_rendimento){
        super(nome,saldo);
        this.taxa_rendimento = taxa_rendimento;
    }
    public void calcular_novo_saldo(){
        System.out.println("Calculando novo saldo com base na taxa de rendimento...");
        System.out.println("Seu rendimento será de: "+saldo * taxa_rendimento);
    }
}
