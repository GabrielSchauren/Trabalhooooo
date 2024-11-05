package fag.objetos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<Registro> registros;

    public Estacionamento() {
        vagas = new ArrayList<>();
        registros = new ArrayList<>();
    }

    public void adicionarVaga(int numero, String tamanho) {
        vagas.add(new Vaga(numero, tamanho));
    }

    public Vaga encontrarVagaDisponivel(String tamanho) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equals(tamanho)) {
                return vaga;
            }
        }
        return null;
    }

    public void registrarEntrada(Veiculo veiculo) {
        Vaga vaga = encontrarVagaDisponivel(veiculo.getTamanho());
        if (vaga != null) {
            vaga.ocupar();
            veiculo.setHoraEntrada(LocalDateTime.now());
            System.out.println("Veículo " + veiculo.getPlaca() + " estacionado na vaga " + vaga.getNumero());
        } else {
            System.out.println("Não há vagas disponíveis para o tamanho " + veiculo.getTamanho());
        }
    }

    public void registrarSaida(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel() && veiculo.getHoraEntrada() != null) {
                vaga.liberar();
                veiculo.setHoraSaida(LocalDateTime.now());
                long horas = veiculo.calcularTempoPermanencia();
                double valor = calcularValor(horas);
                registros.add(new Registro(veiculo, veiculo.getHoraEntrada(), veiculo .getHoraSaida(), valor));
                System.out.println("Veículo " + veiculo.getPlaca() + " saiu da vaga " + vaga.getNumero() + ". Valor a pagar: R$ " + valor);
                return;
            }
        }
        System.out.println("Veículo " + veiculo.getPlaca() + " não encontrado.");
    }

    private double calcularValor(long horas) {
        double taxaPorHora = 5.0; // Exemplo de taxa por hora
        return horas * taxaPorHora;
    }

    public List<Registro> getRegistros() {
        return registros;
    }
}
