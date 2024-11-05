package fag;

import java.util.Scanner;

import fag.objetos.Estacionamento;
import fag.objetos.Veiculo;

public class Principal {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        estacionamento.adicionarVaga(1, "pequeno");
        estacionamento.adicionarVaga(2, "médio");
        estacionamento.adicionarVaga(3, "grande");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Registrar Entrada");
            System.out.println("2. Registrar Saída");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                System.out.print("Placa do veículo: ");
                String placa = scanner.nextLine();
                System.out.print("Modelo do veículo: ");
                String modelo = scanner.nextLine();
                System.out.print("Tamanho do veículo (pequeno/médio/grande): ");
                String tamanho = scanner.nextLine();
                Veiculo veiculo = new Veiculo(placa, modelo, tamanho);
                estacionamento.registrarEntrada(veiculo);
            } else if (opcao == 2) {
                System.out.print("Placa do veículo: ");
                String placa = scanner.nextLine();
               
            } else if (opcao == 3) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}

