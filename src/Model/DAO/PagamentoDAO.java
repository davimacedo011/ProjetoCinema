package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Compra;

public class PagamentoDAO {
    public void inserirPagamentoCartao(String numeroCartao, String nomeTitular, String cpf, String dataValidade, String cvc) throws SQLException {
        String sql = "INSERT INTO Pagamentos (numero_cartao, nome_titular, cpf, data_validade, cvc) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConectaBD.getConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, numeroCartao);
            stmt.setString(2, nomeTitular);
            stmt.setString(3, cpf);
            stmt.setString(4, dataValidade);
            stmt.setString(5, cvc);
            
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

}
