package org.example.dao;

import org.example.Conexao;
import org.example.model.Motorista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MotoristaDAO {

    public void cadastrarMotorista(Motorista motorista){
        String query = "INSERT INTO motorista (nome, cnh, veiculo, cidadeBase) VALUES (?,?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, motorista.getNome());
            stmt.setString(2, motorista.getCnh());
            stmt.setString(3, motorista.getVeiculo());
            stmt.setString(4, motorista.getCidade_base());
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
