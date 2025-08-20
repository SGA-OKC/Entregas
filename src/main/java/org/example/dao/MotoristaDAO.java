package org.example.dao;

import org.example.Conexao;
import org.example.model.Motorista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Motorista> listarMotorista(){
        String query = "SELECT nome,cnh,veiculo,cidade_base FROM motorista";
        List<Motorista> motoristas = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String nome = rs.getNString("nome");
                String cnh = rs.getNString("cnh");
                String veiculo = rs.getNString("veiculo");
                String cidadeBase = rs.getNString("cidade_base");

                Motorista motorista = new Motorista(nome,cnh,veiculo,cidadeBase);
                motoristas.add(motorista);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return motoristas;
    }


}
