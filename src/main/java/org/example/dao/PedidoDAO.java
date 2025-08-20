package org.example.dao;

import org.example.Conexao;
import org.example.model.Pedido;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public void criarPedido(Pedido pedido){
        String query = "INSERT INTO (clienteID, dataPedido, volumeM3, pesoKG) VALUES (?,?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, pedido.getClienteID());
            stmt.setDate(2, Date.valueOf(LocalDate.now()));
            stmt.setInt(3, pedido.getVolumeM3());
            stmt.setDouble(4, pedido.getPesoKG());
            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Pedido> listarPedido() {
        String query = "SELECT id,cliente_id,data_pedido,volume_m3, peso_kg, status FROM pedido";
        List<Pedido> pedidos = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                int clienteId = rs.getInt("cliente_id");
                LocalDate dataPedido = rs.getDate("data_pedido").toLocalDate();
                int volumeM3 = rs.getInt("volume_m3");
                double pesoKg = rs.getDouble("peso_kg");
                boolean status = rs.getBoolean("status");

                Pedido pedido = new Pedido(clienteId,dataPedido,volumeM3,pesoKg);
                pedidos.add(pedido);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return pedidos;
    }


}
