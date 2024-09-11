package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;



import Model.Compra;
import View.TelaPrincipal;

public class HistoricoComprasDAO {
    private static final String SELECT_HISTORICO_COMPRAS = "SELECT titulo_comprado, sala_comprada, horario_comprado, total_pago FROM HistoricoCompras";

    public List<Compra> consultarHistoricoCompras() throws SQLException {
        List<Compra> historicoCompras = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConectaBD.getConexao();
            stmt = conn.prepareStatement(SELECT_HISTORICO_COMPRAS);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String filme = rs.getString("titulo_comprado");
                String sala = rs.getString("sala_comprada");
                String horario = rs.getString("horario_comprado");
                double valor = rs.getDouble("total_pago");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return historicoCompras;
    }
    public List<String> obterHistoricoCompras(Connection connection) throws SQLException {
        List<String> historico = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM HistoricoCompras")) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int fkPagamento = resultSet.getInt("fk_pagamento");
                    String tituloComprado = resultSet.getString("titulo_comprado");
                    String salaComprada = resultSet.getString("sala_comprada");
                    Time horarioComprado = resultSet.getTime("horario_comprado");
                    int quantidadeIngressos = resultSet.getInt("quantidade_ingressos");
                    double totalPago = resultSet.getDouble("total_pago");

                    String registro = "ID: " + id + ", Pagamento: " + fkPagamento +
                            ", Filme: " + tituloComprado + ", Sala: " + salaComprada +
                            ", Horário: " + horarioComprado + ", Qtd Ingressos: " + quantidadeIngressos +
                            ", Total Pago: " + totalPago;
                    historico.add(registro);
                }
            }
        }
        return historico;
    }
    public void excluirCompraPorId(int idCompra) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConectaBD.getConexao();
            String sql = "DELETE FROM HistoricoCompras WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCompra); 
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                JOptionPane.showMessageDialog(null, "Nenhuma compra encontrada com o ID informado.");
            } else {
                JOptionPane.showMessageDialog(null, "Compra excluída com sucesso.");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
