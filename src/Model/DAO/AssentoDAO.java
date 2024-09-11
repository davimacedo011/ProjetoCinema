package Model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssentoDAO {
    private ConectaBD conecta;

    public AssentoDAO() {
        this.conecta = new ConectaBD();
    }

    public List<String> carregarAssentos(String sala, String horario) {
        List<String> assentos = new ArrayList<>();
        try {
            Connection conexao = ConectaBD.getConexao();
            PreparedStatement statement = conexao.prepareStatement("SELECT assento, disponivel FROM Assentos WHERE sala_filme = ? AND horario_filme = ?");
            statement.setString(1, sala);
            statement.setString(2, horario);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                assentos.add(resultSet.getString("assento"));
            }

            resultSet.close();
            statement.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return assentos;
    }

    public void atualizarDisponibilidadeAssento(String sala, String horario, String assento, boolean disponivel) {
        try {
            Connection connection = ConectaBD.getConexao();
            PreparedStatement statement = connection.prepareStatement("UPDATE Assentos SET disponivel = ? WHERE sala_filme = ? AND horario_filme = ? AND assento = ?");
            statement.setBoolean(1, disponivel);
            statement.setString(2, sala);
            statement.setString(3, horario);
            statement.setString(4, assento);
            statement.executeUpdate();
            statement.close();
            connection.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean verificarDisponibilidadeAssento(String sala, String horario, String assento) {
        boolean disponivel = false;
        try {
            Connection connection = ConectaBD.getConexao();
            PreparedStatement statement = connection.prepareStatement("SELECT disponivel FROM Assentos WHERE sala_filme = ? AND horario_filme = ? AND assento = ?");
            statement.setString(1, sala);
            statement.setString(2, horario);
            statement.setString(3, assento);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                disponivel = resultSet.getBoolean("disponivel");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return disponivel;
    }
}