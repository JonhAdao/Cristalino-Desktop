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

    public void cadastrarPacote(Pacotes pacotes) {
        String CADASTRAR = "INSERT INTO pacotes(nomeP, valor, descricao) VALUES (?, ?, ?)";

        try {
            PreparedStatement st = this.conn.prepareStatement(CADASTRAR);
            st.setString(1, pacotes.getNome());
            st.setDouble(2, pacotes.getValor());
            st.setString(3, pacotes.getDescricao());
            st.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Procedimento: " + e.getMessage());
        }
    }

    public void editarPacote(Pacotes pacotes) {
        String EDITAR = "UPDATE pacotes SET nomeP = ?, valor = ?, descricao = ? WHERE idPacote = ?";

        try {
            PreparedStatement st = this.conn.prepareStatement(EDITAR);

            st.setString(1, pacotes.getNome());
            st.setDouble(2, pacotes.getValor());
            st.setString(3, pacotes.getDescricao());
            st.setInt(4, pacotes.getId());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void removerPacote(Pacotes p) {
        String DELETAR = "DELETE FROM pacotes WHERE idPacote = ?";

        try {
            PreparedStatement st = this.conn.prepareStatement(DELETAR);

            st.setInt(1, p.getId());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

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

    public List<Pacotes> filtrarPacotes(String busca) {
        String BUSCAR = "SELECT * FROM pacotes WHERE nomeP LIKE ?  ";

        try {
            PreparedStatement st = this.conn.prepareStatement(BUSCAR);
            st.setString(1, "%" + busca + "%");
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
