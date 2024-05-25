import java.util.Scanner;

final class ContaEspecial extends ContaBancaria {
    Scanner pergunta = new Scanner(System.in);
    final double credito;

    public ContaEspecial(String nome,double saldo,double credito){
        super(nome,saldo);
        this.credito = credito;
    }

    public void solicitarCredito(){
        System.out.println("Gostaria de acrescentar o valor do crédito no seu saldo? [S/N] :");
        String per = pergunta.nextLine();
        if (per.equalsIgnoreCase("S")){
            System.out.println("OK! Adicionando crédito ao seu saldo...");
            this.saldo+=this.credito;
            System.out.println("Aqui está o seu novo saldo: "+this.saldo);
        }
        else if (per.equalsIgnoreCase("N")){
            System.out.println("Entendi, finalizando operação...");
        }
        else{
            System.out.println("Insira um dado válido.");
        }
    }
}
