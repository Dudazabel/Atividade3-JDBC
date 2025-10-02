package org.example.DAO;

import org.example.Model.Material;
import org.example.Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    public void cadastroMaterial(Material material)throws SQLException {
        String query = "INSERT INTO Material(nome, unidade, estoque) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1,material.getNome());
            stmt.setString(2,material.getUnidade());
            stmt.setDouble(3,material.getEstoque());
            stmt.executeUpdate();
        }
    }

    public List<Material> listarMateriais() throws SQLException{
        String query = "SELECT id, nome, unidade, estoque FROM Material;";

        List<Material> materiais = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String unidade = rs.getString("unidade");
                double estoque = rs.getDouble("estoque");

                var material = new Material(id, nome, unidade, estoque);
                materiais.add(material);
            }
        }

        return materiais;
    }
}
