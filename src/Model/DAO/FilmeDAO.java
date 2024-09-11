package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    public List<String[]> getHorariosDoFilme(String tituloDoFilme) {
        List<String[]> horarios = new ArrayList<>();
        String query = "SELECT sala, horario FROM filmes WHERE titulo = ?";

        try (Connection conexao = ConectaBD.getConexao();
             PreparedStatement statement = conexao.prepareStatement(query)) {
            statement.setString(1, tituloDoFilme);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String sala = resultSet.getString("sala");
                String horario = resultSet.getString("horario");
                horarios.add(new String[]{sala, horario});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return horarios;
    }
}