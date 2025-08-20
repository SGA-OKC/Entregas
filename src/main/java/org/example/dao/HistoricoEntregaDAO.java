package org.example.dao;

import org.example.Conexao;
import org.example.model.HistoricoEntrega;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoricoEntregaDAO {

    public void registrarEntrega(HistoricoEntrega historicoEntrega){
        String query = "INSERT INTO historicoEntrega(entrega_id,data_evento,descricao) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, historicoEntrega.getEntregaID());
            stmt.setDate(2, Date.valueOf(historicoEntrega.getDataEvento()));
            stmt.setString(3, historicoEntrega.getDescricao());
            stmt.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
