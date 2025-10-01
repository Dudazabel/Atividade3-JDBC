package org.example.DAO;

import org.example.Model.Fornecedor;
import org.example.Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
