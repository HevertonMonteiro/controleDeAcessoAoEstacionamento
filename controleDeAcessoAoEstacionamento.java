import java.util.Scanner;

public class controleDeAcessoAoEstacionamento {
    public static void main(String[] args) {
        
        String[] placasRestritas = {"ABC1234", "ABC5678", "ABC9876"}; 
        double taxaEntrada = 10.00; 
        int maxCarros = 3; // Capacidade máxima do estacionamento
        int carrosNoEstacionamento = 0; // Contador de carros no estacionamento

        Scanner scanner = new Scanner(System.in);
        
        while (true) { // Loop infinito
            System.out.print("Informe a placa do veículo (ou digite 'sair' para encerrar): ");
            String placaVeiculo = scanner.nextLine().trim();
            
            // Condição para sair do loop
            if (placaVeiculo.equalsIgnoreCase("sair")) {
                System.out.println("Saindo do sistema. Obrigado!");
                break; // Sai do loop
            }

            // Verificação se a placa é restrita
            if (placaRestrita(placasRestritas, placaVeiculo)) {
                System.out.println("Entrada negada. Motivo: Placa do veículo restrita.");
                continue; // Volta para o início do loop
            }

            // Solicitar saldo do cliente
            System.out.print("Informe o saldo do cliente: R$ ");
            double saldoCliente = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do scanner

            // Verificação de condições
            if (carrosNoEstacionamento >= maxCarros) {
                System.out.println("Entrada negada. Motivo: Estacionamento lotado.");
            } else if (saldoCliente < taxaEntrada) {
                System.out.println("Entrada negada. Motivo: Saldo insuficiente.");
            } else {
                saldoCliente -= taxaEntrada; // Deduzir a taxa de entrada
                carrosNoEstacionamento++; // Incrementar o contador de carros
                System.out.println("Entrada permitida. Bem-vindo ao estacionamento!");
                System.out.println("Saldo restante: R$ " + saldoCliente);
                System.out.println("Carros no estacionamento: " + carrosNoEstacionamento);
            }
        }

        scanner.close();
    }

    private static boolean placaRestrita(String[] placas, String placa) {
        for (String p : placas) {
            if (p.equalsIgnoreCase(placa)) { // Comparação sem diferenciar maiúsculas e minúsculas
                return true; 
            }
        }
        return false; 
    }
}