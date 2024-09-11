package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroDAO {
    public boolean cadastrarUsuario(String nome, String usuario, String senha) {
        String query = "INSERT INTO usuario (nome, usuario, senha) VALUES (?, ?, ?)";
        try (Connection conexao = ConectaBD.getConexao();
             PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, usuario);
            preparedStatement.setString(3, senha);
            int linhasAfetadas = preparedStatement.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}