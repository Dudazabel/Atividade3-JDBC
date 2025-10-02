package org.example.DAO;

import org.example.Model.NotaEntrada;
import org.example.Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotaEntradaDAO {

    public void registrarNotaEntrada(NotaEntrada notaEntrada) throws SQLException {

        String query = "INSERT INTO NotaEntrada(idFornecedor, dataEntrada) VALUES (?,?);";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, notaEntrada.getIdFornecedor());
            stmt.setObject(2, notaEntrada.getDataEntrada());
            stmt.executeUpdate();
        }
    }


}
