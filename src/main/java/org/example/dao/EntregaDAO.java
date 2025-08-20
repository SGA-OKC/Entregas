package org.example.dao;

import org.example.Conexao;
import org.example.model.Entrega;
import org.example.model.StatusEntrega;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO {

    public static void criarEntrega(Entrega entrega){

        String query = "INSERT motorista(pedido_id,motorista_id,data_saida,status_entrega) VALUES (?,?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, entrega.getPedidoID());
            stmt.setInt(2, entrega.getMotoristaID());
            stmt.setDate(3, Date.valueOf(entrega.getDataSaida()));
            stmt.setString(4, entrega.getStatusEntrega().name());
            stmt.executeUpdate();

            System.out.println("\nSua entrega foi criada com sucesso!\n");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void atualizarStatusEntrega(int id, StatusEntrega status){
        String query = "UPDATE entrega SET status = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, status.name());
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("Atualizado com sucesso o status da entrega!\n");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Entrega> listarEntregas(){
        String query = "SELECT id,pedido_id,motorista_id,data_saida,status_entrega FROM entrega";
        List<Entrega> entregas = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                int pedidoId = rs.getInt("pedido_id");
                int motoristaId = rs.getInt("motorista_id");
                LocalDate dataSaida = rs.getDate("data_saida").toLocalDate();
                StatusEntrega status = StatusEntrega.valueOf(rs.getString("status_entrega"));

                Entrega entrega = new Entrega(id, pedidoId, motoristaId, dataSaida, status);
                entregas.add(entrega);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return entregas;
    }
}
