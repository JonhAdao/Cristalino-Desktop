package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Esmalte;
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
public class EsmalteDAO implements GenericDAO<Esmalte>, CrudPesquisa<Esmalte> {

    private final static String CADASTRAR = "INSERT INTO coresmalte(idCorEsmalte, CoresDisponiveis) VALUES (?, ?)";

    private final static String EDITAR = "UPDATE coresmalte SET CoresDisponiveis = ? WHERE idCorEsmalte = ? ";

    private final static String EXCLUIR = "DELETE FROM coresmalte WHERE idCorEsmalte = ?";

    private final static String LISTAR = "SELECT idCorEsmalte, CoresDisponiveis FROM coresmalte";

    private final static String FILTRAR = "SELECT idCorEsmalte, CoresDisponiveis FROM coresmalte WHERE CoresDisponiveis LIKE ?";

    @Override
    public void cadastrar(Esmalte esmalte) {
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(CADASTRAR);

            st.setInt(1, esmalte.getIdEsmalte());
            st.setString(2, esmalte.getCor());
            st.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Esmalte: " + e.getMessage());
        }
    }

    @Override
    public void editar(Esmalte esmalte) {
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(EDITAR);

            st.setString(1, esmalte.getCor());
            st.setInt(2, esmalte.getIdEsmalte());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void excluir(Esmalte esmalte) {
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(EXCLUIR);

            st.setInt(1, esmalte.getIdEsmalte());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Esmalte> listar() {
        ResultSet rs = null;
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(LISTAR);
            rs = st.executeQuery();
            List<Esmalte> lista = new ArrayList<>();
            while (rs.next()) {
                Esmalte esmalte = new Esmalte();

                esmalte.setIdEsmalte(rs.getInt(1));
                esmalte.setCor(rs.getString(2));

                lista.add(esmalte);

            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Esmalte> filtrar(String busca) {
        ResultSet rs = null;
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(FILTRAR);
            st.setString(1, "%" + busca + "%");
            rs = st.executeQuery();
            List<Esmalte> lista = new ArrayList<>();
            while (rs.next()) {
                Esmalte esmalte = new Esmalte();

                esmalte.setIdEsmalte(rs.getInt(1));
                esmalte.setCor(rs.getString(2));

                lista.add(esmalte);

            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public int cadastrar(Connection conn, PreparedStatement stmt, ResultSet rs, Esmalte e) {
        return 0;
    }

    @Override
    public int editar(Connection conn, PreparedStatement stmt, Esmalte cor) {
        try {

            stmt = conn.prepareStatement(EDITAR);
            stmt.setString(1, cor.getCor());
            stmt.setInt(2, cor.getIdEsmalte());

            stmt.executeUpdate();
            return cor.getIdEsmalte();
        } catch (SQLException e) {
            System.out.println("Falha ao editar" + e.getMessage());
        }
        return 0;
    }

    @Override
    public void excluir(Connection conn, PreparedStatement stmt, int esmalte_id) {
        try {

            stmt = conn.prepareStatement(EXCLUIR);
            stmt.setInt(1, esmalte_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Falha ao excluir" + e.getMessage());
        }
    }

}
