package org.example.dao;

import org.example.Conexao;
import org.example.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void cadastrarCliente(Cliente cliente){

        String query = "INSERT INTO cliente (nome,cpf_cnpj, endereco, cidade, estado) VALUES (?,?,?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf_cnpj());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getCidade());
            stmt.setString(5, cliente.getEstado());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Cliente> listarClientes(){
        String query = "SELECT id,nome,cpf_cnpj, endereco, cidade, estado FROM cliente";

        List<Cliente> clientes = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getNString("nome");
                String cpf_cnpj = rs.getNString("cpf_cnpj");
                String endereco = rs.getNString("endereco");
                String cidade = rs.getNString("cidade");
                String estado = rs.getNString("estado");

                Cliente cliente = new Cliente(id, nome, cpf_cnpj, endereco, cidade, estado);
                clientes.add(cliente);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clientes;
    }

}
