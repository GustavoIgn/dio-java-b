
import java.util.Scanner;
import java.util.InputMismatchException;

public class ContaTerminal {

    public static void main(String[] args) {
        int num = 0;
        String agencia = "", nomeCliente = "";
        double saldo = 0.0;
        boolean valido = false;

        Scanner input = new Scanner(System.in);

        //Coleta número da agência
        while (!valido) {
            try {
                System.out.println("Por favor digite o número da agência!");
                num = input.nextInt();
                input.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada Inválida.");
                input.next();
            }
        }
        
        valido = false;

        // Coleta do nome da agência
        while (!valido) {
            System.out.println("Por favor digite o nome da agência!");
            agencia = input.nextLine();
            if (!agencia.trim().isEmpty()) {
                valido = true;
            } else {
                System.out.println("Entrada Inválida. O nome da agência não pode estar vazio.");
            }
        }

        valido = false;
        // Coleta do nome do cliente
        while (!valido) {
            System.out.println("Por favor digite o nome do cliente!");
            nomeCliente = input.nextLine();
            if (!nomeCliente.trim().isEmpty()) {
                valido = true;
            } else {
                System.out.println("Entrada Inválida. O nome do cliente não pode estar vazio.");
            }
        }

        valido = false;
        // Coleta do saldo
        while (!valido) {
            try {
                System.out.println("Por favor digite o saldo!");
                saldo = input.nextDouble();
                input.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada Inválida. Por favor, insira um valor numérico.");
                input.next();
            }
        }

        input.close();

        // Exibir os dados coletados
        System.out.printf("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + num + " e seu saldo " + saldo + " já está disponível para saque.");
    }

}
