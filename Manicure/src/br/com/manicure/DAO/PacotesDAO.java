package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Pacotes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import br.com.manicure.interfaces.CrudPesquisa;
import br.com.manicure.interfaces.GenericDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author John
 */
public class PacotesDAO implements CrudPesquisa<Pacotes>, GenericDAO<Pacotes> {

    private final String CADASTRAR = "INSERT INTO pacotes(idPacote, nomeP, valor, descricao) VALUES (?, ?, ?, ?)";

    private final static String EDITAR = "UPDATE pacotes SET nomeP = ?, valor = ?, descricao = ? WHERE idPacote = ?";

    private final static String EXCLUIR = "DELETE FROM pacotes WHERE idPacote = ?";

    private final String LISTAR = "SELECT * FROM pacotes";

    private final String FILTRAR = "SELECT * FROM pacotes WHERE nomeP LIKE ? ";

    @Override
    public void cadastrar(Pacotes pacotes) {
        PreparedStatement st = null;
        Connection conn = null;
        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(CADASTRAR);

            st.setInt(1, pacotes.getIdPacote());
            st.setString(2, pacotes.getNome());
            st.setDouble(3, pacotes.getValor());
            st.setString(4, pacotes.getDescricao());
            st.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Pacote: " + e.getMessage());
        }
    }

    @Override
    public void editar(Pacotes pacotes) {
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(EDITAR);

            st.setString(1, pacotes.getNome());
            st.setDouble(2, pacotes.getValor());
            st.setString(3, pacotes.getDescricao());
            st.setInt(4, pacotes.getIdPacote());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void excluir(Pacotes pacotes) {
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(EXCLUIR);

            st.setInt(1, pacotes.getIdPacote());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Pacotes> listar() {
        ResultSet rs = null;
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(LISTAR);
            rs = st.executeQuery();
            List<Pacotes> lista = new ArrayList<>();
            while (rs.next()) {
                Pacotes pacotes = new Pacotes();

                pacotes.setIdPacote(rs.getInt("idPacote"));
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

    @Override
    public List<Pacotes> filtrar(String busca) {
        ResultSet rs = null;
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(FILTRAR);
            st.setString(1, "%" + busca + "%");
            rs = st.executeQuery();
            List<Pacotes> lista = new ArrayList<>();
            while (rs.next()) {
                Pacotes pacotes = new Pacotes();

                pacotes.setIdPacote(rs.getInt("idPacote"));
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

    @Override
    public int cadastrar(Connection conn, PreparedStatement stmt, ResultSet rs, Pacotes pacote) {
        try {
            stmt = conn.prepareStatement(CADASTRAR, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pacote.getNome());

            stmt.setDouble(2, pacote.getValor());
            stmt.setString(3, pacote.getDescricao());
            stmt.setInt(4, pacote.getIdPacote());

            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return 0;
    }

    @Override
    public int editar(Connection conn, PreparedStatement stmt, Pacotes pacote) {
        try {
            stmt = conn.prepareStatement(EDITAR);
            stmt.setString(1, pacote.getNome());
            stmt.setDouble(2, pacote.getValor());
            stmt.setString(3, pacote.getDescricao());
            stmt.setInt(4, pacote.getIdPacote());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return pacote.getIdPacote();
    }

    @Override
    public void excluir(Connection conn, PreparedStatement stmt, int pacote_id) {
        try {
            stmt = conn.prepareStatement(EXCLUIR);
            stmt.setInt(1, pacote_id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
    }

}
