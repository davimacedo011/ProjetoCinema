package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Compra;
import Model.beans.*;
public class CompraDAO {
    public static void registrarCompra(Compra compra) throws SQLException {
        String sql = "INSERT INTO Compras (titulofilme, Assento, quantidade_ingressos, total_pago) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConectaBD.getConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, compra.getFilme());

            List<String> tiposIngresso = (List<String>) compra.getAssento();
            for (int i = 0; i < tiposIngresso.size(); i++) {
                stmt.setString(2 + i, tiposIngresso.get(i));
            }
            
            stmt.setInt(3, compra.getQuantidadeIngressos());
            stmt.setDouble(4, IngressoBean.calcularValorTotal());
            
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConectaBD.fecharConexao(conn);
            }
        }
    }
    public static List<Compra> obterComprasDoUsuario(String nomeUsuario) throws SQLException {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT * FROM Compras";
        try (Connection conn = ConectaBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Crie o objeto Compra e preencha-o com os dados do ResultSet
                    Compra compra = new Compra(nomeUsuario, 0, null, 0);
                   
                    compra.setFilme(rs.getString("titulofilme"));
                    compra.setTipoIngresso(rs.getString("Assento"));
                    compra.setQuantidadeIngressos(rs.getInt("quantidade_ingressos"));
        
                    compras.add(compra);
                }
            }
        }
        return compras;
    	}
	}
