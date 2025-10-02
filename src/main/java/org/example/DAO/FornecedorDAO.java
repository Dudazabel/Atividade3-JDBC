package org.example.DAO;

import org.example.Model.Fornecedor;
import org.example.Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public void cadastroFornecedor(Fornecedor fornecedor)throws SQLException {
        String query = "INSERT INTO Fornecedor(nome, cnpj) VALUES (?,?);";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.executeUpdate();
        }
    }

    public List<Fornecedor> listarFornecedor() throws SQLException{
        String query = "SELECT id, nome, cnpj FROM Fornecedor;";

        List<Fornecedor> fornecedores = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");

                var fornecedor = new Fornecedor(id, nome, cnpj);
                fornecedores.add(fornecedor);
            }
        }

        return fornecedores;
    }
}
