package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Pacotes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John
 */
public class PacotesDAO {

    private Conexao conexao;
    private Connection conn;

    public PacotesDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public List<Pacotes> listarPacotes() {
        String sql = "SELECT * FROM pacotes ";

        try {
            PreparedStatement st = this.conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Pacotes> lista = new ArrayList<>();
            while (rs.next()) {
                Pacotes pacotes = new Pacotes();

                pacotes.setId(rs.getInt("idPacote"));
                pacotes.setNome(rs.getString("nomeP"));
                pacotes.setValor(rs.getDouble("valor"));
                pacotes.setDescricao(rs.getString("descricao"));

                lista.add(pacotes);

            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

}
