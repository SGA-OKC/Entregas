package org.example;

import org.example.dao.*;
import org.example.model.*;

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
        System.out.println("4 - Atribuir Pedido a Motorista(Gerar Entrega)");
        System.out.println("5 - Registrar Evento de Entrega(Histórico)");
        System.out.println("6 - Atualizar Status da Entrega");

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
            case 4: {
                atribuirPedido();
                break;
            }
            case 5: {
                registrarEntrega();
                break;
            }
            case 6: {
                atualizarStatus();
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

            System.out.println("Digite a Data do Pedido: ");
            String dataStr = SC.nextLine();
            LocalDate dataPedido = LocalDate.parse(dataStr);

            System.out.println("Digite o volume de cargas: ");
            int volumeM3 = SC.nextInt();

            System.out.println("Digite o peso da carga: ");
            double pesoKG = SC.nextDouble();

            Pedido pedido = new Pedido(clienteID, dataPedido, volumeM3, pesoKG);

            PedidoDAO dao = new PedidoDAO();
            dao.criarPedido(pedido);
        }

        public static void atribuirPedido() {
            MotoristaDAO motoristaDAO = new MotoristaDAO();
            PedidoDAO pedidoDAO = new PedidoDAO();

            System.out.println("Pedidos: ");
            for(Pedido pedido : pedidoDAO.listarPedido()) {
                System.out.println(pedido);
            }

            System.out.println("Digite o ID do Pedido: ");
            int id = SC.nextInt();

            for(Motorista mo : motoristaDAO.listarMotorista()) {
                System.out.println(mo);
            }

            System.out.println("Digite o ID do motorista: ");
            int motoristaId = SC.nextInt();

            Entrega entrega = new Entrega(id, motoristaId, LocalDate.now(), StatusEntrega.EM_ROTA);
            EntregaDAO.criarEntrega(entrega);
        }
        public static void registrarEntrega() {
            EntregaDAO entregaDAO = new EntregaDAO();
            HistoricoEntregaDAO historicoEntregaDAO = new HistoricoEntregaDAO();

            System.out.println("Registrar Entrega");
            System.out.println("Entregas: ");
            for(Entrega entrega : entregaDAO.listarEntregas()) {
                System.out.println(entrega);
            }

            System.out.println("Digite o ID da Entrega: ");
            int entregaID = SC.nextInt();

            System.out.println("Informe a descrição da Entrega: ");
            String descricao = SC.nextLine();

            HistoricoEntrega historicoEntrega = new HistoricoEntrega(entregaID,LocalDate.now(),descricao);
            historicoEntregaDAO.registrarEntrega(historicoEntrega);
        }

        public static void atualizarStatus(){
// n terminei
        }
    }
