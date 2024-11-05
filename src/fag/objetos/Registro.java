package fag.objetos;

import java.time.LocalDateTime;

public class Registro {
    private Veiculo veiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private double valorPago;

    public Registro(Veiculo veiculo, LocalDateTime horaEntrada, LocalDateTime horaSaida, double valorPago) {
        this.veiculo = veiculo;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.valorPago = valorPago;
    }

    @Override
    public String toString() {
        return "Veículo: " + veiculo.getPlaca() + 
               ", Entrada: " + horaEntrada + 
               ", Saída: " + horaSaida + 
               ", Valor Pago: R$ " + valorPago;
    }
}
