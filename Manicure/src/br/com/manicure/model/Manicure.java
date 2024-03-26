package br.com.manicure.model;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Manicure {

    public static void main(String[] args) {

        Scanner entrada16 = new Scanner(System.in);

        Gestor gestor = new Gestor();
        Cliente cliente = new Cliente();
        List<Cliente> clientes = new ArrayList();
        int opcao;

        System.out.println("==== Sistema Karolyne Naills ====");

        do {
            System.out.println("\n1 - Cadastrar Cliente | 2 - Exibir relatório ordenado por atendimento | 3 - Sair");
            System.out.print("Digite a opção: ");
            opcao = entrada16.nextInt();

            switch (opcao) {
                case 1 -> {
                    cliente.fazCadastro();

                    Cliente clienteadd = new Cliente(cliente.getNome(), cliente.getCpf(), cliente.getRg(), cliente.getCelular(), cliente.getEmail(), cliente.getRua(), cliente.getBairro(), cliente.getCep(), cliente.getNumero(), cliente.getLogin(), cliente.getSenha(), cliente.getQuantAtendimento());

                    clientes.add(clienteadd);
                    gestor.ordenaPorAtendimento((ArrayList) clientes);

                }
                case 2 -> {
                    System.out.println("\nRelatório de clientes: ");
                    if (clientes.isEmpty()) {
                        System.out.println("\nNenhuma cliente registrada. ");
                        System.out.println("Registre alguma cliente para exibir o relatório.");
                    }
                    for (Cliente clientev : clientes) {
                        clientev.mostrarDados();
                    }
                }
                case 3 ->
                    System.out.println("\nFim do Programa !");
            }
        } while (opcao == 1 || opcao == 2);

    }
}
