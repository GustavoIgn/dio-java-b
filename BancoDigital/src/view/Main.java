package view;

import controller.ContaCorrente;
import controller.ContaPoupanca;
import java.util.Scanner;
import model.Cliente;
import model.Conta;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cliente gustavo = new Cliente();
        gustavo.setNome("Gustavo");

        Conta cC = new ContaCorrente(gustavo);
        Conta cPoupanca = new ContaPoupanca(gustavo);

        cC.depositar(90);
        cPoupanca.depositar(300);
        cPoupanca.sacar(250);
        cC.transferir(79.99, cPoupanca);

        cC.imprimirExtrato();
        cPoupanca.imprimirExtrato();

        int opc = 0;
        double valor;

        while (opc != 9) {
            System.out.println("\tMENU\n1 - Depositar\n2 - Sacar\n3 - Trasferir\n4 - Consultar Extrato\n9 - Sair.");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("\tDepositar:\n1 - Conta Corrente\n2 - Conta Poupanca\n3 - Voltar");
                    int opc1 = input.nextInt();
                    switch (opc1) {
                        case 1:
                            System.out.println("Valor: ");
                            valor = input.nextDouble();
                            cC.depositar(valor);
                            break;
                        case 2:
                            System.out.println("Valor: ");
                            valor = input.nextDouble();
                            cPoupanca.depositar(valor);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opcao Inválida");
                    }
                    break;
                case 2:
                    System.out.println("\tSacar:\n1 - Conta Corrente\n2 - Conta Poupanca\n3 - Voltar");
                    int opc2 = input.nextInt();
                    switch (opc2) {
                        case 1:
                            System.out.println("Valor: ");
                            valor = input.nextDouble();
                            cC.sacar(valor);
                            break;
                        case 2:
                            System.out.println("Valor: ");
                            valor = input.nextDouble();
                            cPoupanca.sacar(valor);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opcao Inválida");
                    }
                    break;
                case 3:
                    System.out.println("\tTransferir:\n1 - Conta Corrente -> Poupanca\n2 - Conta Poupanca -> Corrente\n3 - Voltar");
                    int opc3 = input.nextInt();
                    switch (opc3) {
                        case 1:
                            System.out.println("Valor: ");
                            valor = input.nextDouble();
                            cC.transferir(valor, cPoupanca);
                            break;
                        case 2:
                            System.out.println("Valor: ");
                            valor = input.nextDouble();
                            cPoupanca.transferir(valor, cC);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opcao Inválida");
                    }
                    break;
                case 4:
                    cC.imprimirExtrato();
                    cPoupanca.imprimirExtrato();
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Opcao Inválida");
            }
        }
    }
}
