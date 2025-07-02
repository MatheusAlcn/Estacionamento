import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EstacionamentoApp {

    static final double PRECO_HORA = 5.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Veiculo> veiculos = new HashMap<>();

        while (true) {
            System.out.println("\n1 - Entrada de veículo");
            System.out.println("2 - Saída de veículo");
            System.out.println("3 - Listar veículos estacionados");
            System.out.println("4 - Sair do sistema");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            if (opcao == 1) {
                // Entrada
                System.out.print("Tipo do veículo (Carro, Moto...): ");
                String tipo = scanner.nextLine();

                System.out.print("Nome do condutor: ");
                String nomeCondutor = scanner.nextLine();

                boolean vagaOcupada;
                int vaga;

                do {
                    System.out.print("Número da vaga: ");
                    vaga = scanner.nextInt();
                    scanner.nextLine();

                    vagaOcupada = false;
                    for (Veiculo v : veiculos.values()) {
                        if (v.getVaga() == vaga) {
                            vagaOcupada = true;
                            System.out.println("❌ Vaga já está ocupada! Por favor, escolha outra vaga.");
                            break;
                        }
                    }
                } while (vagaOcupada);

                String id = String.valueOf(new Random().nextInt(1000, 9999));
                LocalDateTime agora = LocalDateTime.now();

                Veiculo veiculo = new Veiculo(tipo, nomeCondutor, vaga, agora);
                veiculos.put(id, veiculo);

                System.out.println("✅ Veículo registrado!");
                System.out.println("🎫 Seu ticket: " + id);
                System.out.println("📅 Entrada: " + agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

            } else if (opcao == 2) {
                // Saída
                System.out.print("Digite o ID do ticket: ");
                String id = scanner.nextLine();

                if (veiculos.containsKey(id)) {
                    Veiculo v = veiculos.get(id);
                    LocalDateTime saida = LocalDateTime.now();

                    long minutos = java.time.Duration.between(v.getDataHoraEntrada(), saida).toMinutes();
                    long horas = (long) Math.ceil(minutos / 60.0);
                    double valor = horas * PRECO_HORA;

                    System.out.println("\n📋 Informações do ticket:");
                    System.out.println("🆔 ID: " + id);
                    System.out.println("👤 Condutor: " + v.getNomeCondutor());
                    System.out.println("🚗 Tipo: " + v.getTipo());
                    System.out.println("🅿️ Vaga: " + v.getVaga());
                    System.out.println("🕒 Entrada: " + v.getDataHoraEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    System.out.println("🕒 Saída:   " + saida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    System.out.println("⏱️ Tempo: " + horas + " hora(s)");
                    System.out.printf("💰 Valor a pagar: R$ %.2f\n", valor);

                    veiculos.remove(id); // remove veículo
                } else {
                    System.out.println("❌ Ticket não encontrado!");
                }

            } else if (opcao == 3) {
                // Listar veículos
                if (veiculos.isEmpty()) {
                    System.out.println("📭 Nenhum veículo no estacionamento.");
                } else {
                    System.out.println("🚘 Veículos atualmente estacionados:");
                    for (Map.Entry<String, Veiculo> entry : veiculos.entrySet()) {
                        System.out.println("🎫 Ticket: " + entry.getKey() + " → " + entry.getValue());
                    }
                }

            } else if (opcao == 4) {
                System.out.println("Encerrando o sistema...");
                break;
            } else {
                System.out.println("❗ Opção inválida!");
            }
        }

        scanner.close();
    }
}
