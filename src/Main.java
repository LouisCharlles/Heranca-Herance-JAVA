import java.util.Scanner;





public class Main {
    public static void main(String[] args) {
        Scanner pergunta = new Scanner(System.in);
        System.out.println("Qual o seu nome?:");
        String nome = pergunta.nextLine();
        System.out.println("Qual o seu saldo?:");
        double saldo = Double.parseDouble(pergunta.nextLine());

        System.out.println("Que tipo de conta você quer criar: \n1- Conta Poupança \n2- Conta Especial");
        int tipo_de_conta = Integer.parseInt(pergunta.nextLine());

        ContaBancaria conta;

        if (tipo_de_conta == 1) {
             conta = new ContaPoupanca(nome, saldo, 1.05);
        } else if (tipo_de_conta == 2) {
            System.out.println("Quanto de crédito você possui?");
            double credito = Double.parseDouble(pergunta.nextLine());

            conta = new ContaEspecial(nome, saldo, credito);
        } else{
            System.out.println("Esse valor não é permitido.");
            return;
        }

        while (true) {
            System.out.println("Gostaria de sacar, depositar ou outra operação? \n[S] - SACAR \n[D] - DEPOSITAR \n[C] - " +
                    (conta instanceof ContaPoupanca ? "Calcular rendimento" : "Solicitar crédito"));

            char operacao = pergunta.nextLine().charAt(0);

            switch (operacao) {
                case 'S':
                    System.out.println("Aqui está seu saldo disponível- R$" + conta.saldo + " \n "
                    );
                    conta.sacar();
                    break;
                case 'D':
                    conta.depositar();
                    break;
                case 'C':
                    if (conta instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta).calcular_novo_saldo();
                    } else if (conta instanceof ContaEspecial) {
                        ((ContaEspecial) conta).solicitarCredito();
                    }
                   break;
                default:
                    System.out.println("Operação inválida.");
                    continue;
            }
            System.out.println("Gostaria de realizar outra operação? \n[S] - Sim  \n[N] - Não");
            String per3 = pergunta.nextLine();
            if (per3.equalsIgnoreCase("N")) {
                System.out.println("Finalizando...");
                break;
            } else if (per3.equalsIgnoreCase("S")) {
                System.out.println("OK!");
            }

        }pergunta.close();

    }
    }

