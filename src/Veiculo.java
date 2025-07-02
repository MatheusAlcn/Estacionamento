import java.time.LocalDateTime;

// Representa um veículo que entrou no estacionamento
public class Veiculo {
    private final String tipo;
    private final String nomeCondutor;
    private final int vaga;
    private final LocalDateTime dataHoraEntrada;

    public Veiculo(String tipo, String nomeCondutor, int vaga, LocalDateTime dataHoraEntrada) {
        this.tipo = tipo;
        this.nomeCondutor = nomeCondutor;
        this.vaga = vaga;
        this.dataHoraEntrada = dataHoraEntrada;
    }

    // Getters — úteis para exibir dados ou integrar com banco de dados
    public String getTipo() {
        return tipo;
    }

    public String getNomeCondutor() {
        return nomeCondutor;
    }

    public int getVaga() {
        return vaga;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    // Facilita imprimir informações no console (útil na depuração)
    @Override
    public String toString() {
        return "Veiculo {" +
                "tipo='" + tipo + '\'' +
                ", nomeCondutor='" + nomeCondutor + '\'' +
                ", vaga=" + vaga +
                ", dataHoraEntrada=" + dataHoraEntrada +
                '}';
    }
}

