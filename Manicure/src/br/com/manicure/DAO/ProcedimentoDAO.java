package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Procedimento;
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
public class ProcedimentoDAO implements GenericDAO<Procedimento>, CrudPesquisa<Procedimento> {

    private final static String CADASTRAR = "INSERT INTO procedimento(nomePr, valor, duracao, descricao) VALUES (?, ?, ?, ?)";

    private final static String EDITAR = "UPDATE procedimento SET nomePr = ?, valor = ?, duracao = ?, descricao = ? WHERE idProcedimento = ?";

    private final static String EXCLUIR = "DELETE FROM procedimento WHERE idProcedimento = ?";

    private final static String LISTAR = "SELECT * FROM procedimento";

    private final static String FILTRAR = "SELECT * FROM procedimento WHERE nomePr LIKE ?  ";

    @Override
    public void cadastrar(Procedimento procedimento) {
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(CADASTRAR);
            st.setString(1, procedimento.getNome());
            st.setDouble(2, procedimento.getValor());
            st.setString(3, procedimento.getDuracao());
            st.setString(4, procedimento.getDescricao());

            st.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Procedimento: " + e.getMessage());
        }
    }

    @Override
    public void editar(Procedimento procedimento) {
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(EDITAR);

            st.setString(1, procedimento.getNome());
            st.setDouble(2, procedimento.getValor());
            st.setString(3, procedimento.getDuracao());
            st.setString(4, procedimento.getDescricao());
            st.setInt(5, procedimento.getIdProcedimento());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void excluir(Procedimento procedimento) {
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(EXCLUIR);

            st.setInt(1, procedimento.getIdProcedimento());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Procedimento> listar() {
        ResultSet rs = null;
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(LISTAR);
            rs = st.executeQuery();
            List<Procedimento> lista = new ArrayList<>();
            while (rs.next()) {
                Procedimento procedimento = new Procedimento();

                procedimento.setIdProcedimento(rs.getInt("idProcedimento"));
                procedimento.setNome(rs.getString("nomePr"));
                procedimento.setValor(rs.getDouble("valor"));
                procedimento.setDuracao(rs.getString("duracao"));
                procedimento.setDescricao(rs.getString("descricao"));

                lista.add(procedimento);

            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Procedimento> filtrar(String busca) {
        ResultSet rs = null;
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(FILTRAR);
            st.setString(1, "%" + busca + "%");
            rs = st.executeQuery();
            List<Procedimento> lista = new ArrayList<>();
            while (rs.next()) {
                Procedimento procedimento = new Procedimento();

                procedimento.setIdProcedimento(rs.getInt("idProcedimento"));
                procedimento.setNome(rs.getString("nomePr"));
                procedimento.setValor(rs.getDouble("valor"));
                procedimento.setDuracao(rs.getString("duracao"));

                lista.add(procedimento);

            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public int cadastrar(Connection conn, PreparedStatement stmt, ResultSet rs, Procedimento t) {
        return 0;
    }

    @Override
    public int editar(Connection conn, PreparedStatement stmt, Procedimento procedimento) {
        try {
            stmt = conn.prepareStatement(EDITAR);
            stmt.setString(1, procedimento.getNome());
            stmt.setDouble(2, procedimento.getValor());
            stmt.setString(3, procedimento.getDuracao());
            stmt.setString(4, procedimento.getDescricao());
            stmt.setInt(5, procedimento.getIdProcedimento());
            stmt.executeUpdate();

            return procedimento.getIdProcedimento();

        } catch (SQLException ex) {
            return ex.getErrorCode();
        }

    }

    @Override
    public void excluir(Connection conn, PreparedStatement stmt, int procedimento_id) {
        try {
            stmt = conn.prepareStatement(EXCLUIR);
            stmt.setInt(1, procedimento_id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro :" + ex.getMessage());;
        }

    }

}
