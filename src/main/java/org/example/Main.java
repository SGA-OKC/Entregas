package org.example;

import org.example.dao.ClienteDAO;
import org.example.dao.MotoristaDAO;
import org.example.dao.PedidoDAO;
import org.example.model.Cliente;
import org.example.model.Motorista;
import org.example.model.Pedido;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        inicio();
    }

    public static void inicio() {
        boolean sair = false;

        System.out.println(" === ENTREGAS DO VITINHO ===");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Cadastrar Motorista");
        System.out.println("3 - Criar Pedido");

        int opcao = SC.nextInt();
        SC.nextLine();

        switch (opcao) {
            case 1: {
                cadastrarCliente();
                break;
            }
            case 2: {
                cadastrarMotorista();
                break;
            }
            case 3: {
                criarPedido();
                break;
            }
        }
            if (!sair) {
                inicio();
            }
        }

        public static void cadastrarCliente() {

            System.out.println("Digite o nome do cliente: ");
            String nome = SC.nextLine();

            System.out.println("Digite o CPF/CNPJ do cliente: ");
            String cpf_cnpj = SC.nextLine();

            System.out.println("Digite o endereço do cliente: ");
            String endereco = SC.nextLine();

            System.out.println("Digite o cidade do cliente: ");
            String cidade = SC.nextLine();

            System.out.println("Digite o estado do cliente: ");
            String estado = SC.nextLine();

            Cliente cliente = new Cliente(nome, cpf_cnpj, endereco, cidade, estado);

            ClienteDAO dao = new ClienteDAO();
            dao.cadastrarCliente(cliente);
        }

        public static void cadastrarMotorista() {

            System.out.println("Digite o nome do Motorista: ");
            String nome = SC.nextLine();

            System.out.println("Digite a CNH do Motorista: ");
            String cnh = SC.nextLine();

            System.out.println("Digite o veículo do Motorista: ");
            String veiculo = SC.nextLine();

            System.out.println("Digite a cidade base do Motorista: ");
            String cidadeBase = SC.nextLine();

            Motorista motorista = new Motorista(nome, cnh, veiculo, cidadeBase);

            MotoristaDAO dao = new MotoristaDAO();
            dao.cadastrarMotorista(motorista);
        }

        public static void criarPedido() {

            System.out.println("Digite o ID do Cliente: ");
            int clienteID = SC.nextInt();

            LocalDate data = LocalDate.now();
            System.out.println("Digite a Data do Pedido: ");
            LocalDate dataPedido = LocalDate.parse(SC.next());

            System.out.println("Digite o volume de cargas: ");
            int volumeM3 = SC.nextInt();

            System.out.println("Digite o peso da carga: ");
            double pesoKG = SC.nextDouble();


            Pedido pedido = new Pedido(clienteID, dataPedido, volumeM3, pesoKG);

            PedidoDAO dao = new PedidoDAO();
            dao.criarPedido(pedido);

        }
    }
