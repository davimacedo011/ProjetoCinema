package Model.DAO;

import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public boolean validarUsuario(String usuario, String senha) {
        String query = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";
        try (Connection conexao = ConectaBD.getConexao();
             PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}