package org.example.dao;

import org.example.Conexao;
import org.example.model.Pedido;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

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
}
