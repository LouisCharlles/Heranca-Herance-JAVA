import java.util.Scanner;

// Uma classe Abstrata significa que ela não pode ser instanciada.
// Uma classe Final não pode se extender para outra classe, tornando-se inextensível.

abstract class ContaBancaria {

    protected String nome;
    protected double saldo;
    Scanner pergunta = new Scanner(System.in);

    public ContaBancaria(String nome,double saldo){
        this.nome = nome;
        this.saldo = saldo;
    }

    protected void sacar(){
        System.out.println("Quanto você gostaria de sacar?");
        double saque = Double.parseDouble(pergunta.nextLine());

        if (saque > saldo){
            System.out.println("Operação não pode continuar devido a saldo insuficiente para saque!");
        }
        else {
            System.out.println(this.nome + ", está sacando dinheiro...");
            this.saldo -= saque;
            System.out.println("Saque realizado com sucesso, " + this.nome + ". Seu novo saldo é de: " + this.saldo);
        }
    }
    protected void depositar(){
        System.out.println("Quanto você gostaria de depositar?:");
        double deposito = Double.parseDouble(pergunta.nextLine());

        System.out.println(this.nome+ ", está depositando dinheiro...");
        this.saldo+=deposito;
        System.out.println("Deposito realizado com sucesso, "+this.nome+". Seu novo saldo é de: "+this.saldo);

    }

}
