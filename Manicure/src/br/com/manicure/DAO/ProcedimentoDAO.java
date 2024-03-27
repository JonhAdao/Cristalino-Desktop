package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Procedimento;
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
public class ProcedimentoDAO {

    private Conexao conexao;
    private Connection conn;

    public ProcedimentoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void cadastrarProcedimento(Procedimento procedimento) {
        String CADASTRAR = "INSERT INTO procedimento(nomePr, valor, duracao) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement st = this.conn.prepareStatement(CADASTRAR);
            st.setString(1, procedimento.getNome());
            st.setDouble(2, procedimento.getValor());
            st.setString(3, procedimento.getDuracao());
            st.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Procedimento: " + e.getMessage());
        }
    }

    public List<Procedimento> listarProcedimentos() {
        String LISTAR = "SELECT * FROM procedimento ";

        try {
            PreparedStatement st = this.conn.prepareStatement(LISTAR);
            ResultSet rs = st.executeQuery();
            List<Procedimento> lista = new ArrayList<>();
            while (rs.next()) {
                Procedimento procedimento = new Procedimento();

                procedimento.setId(rs.getInt("idProcedimento"));
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

    public void editarProcedimento(Procedimento procedimento) {
        String EDITAR = "UPDATE procedimento SET nomePr = ?, valor = ?, duracao = ? WHERE idProcedimento = ?";

        try {
            PreparedStatement st = this.conn.prepareStatement(EDITAR);

            st.setString(1, procedimento.getNome());
            st.setDouble(2, procedimento.getValor());
            st.setString(3, procedimento.getDuracao());
            st.setInt(4, procedimento.getId());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void removerProcedimento(Procedimento p) {
        String DELETAR = "DELETE FROM procedimento WHERE idProcedimento = ?";

        try {
            PreparedStatement st = this.conn.prepareStatement(DELETAR);

            st.setInt(1, p.getId());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public List<Procedimento> filtrarProcedimentos(String busca) {
        String BUSCAR = "SELECT * FROM procedimento WHERE nomePr LIKE ?  ";

        try {
            PreparedStatement st = this.conn.prepareStatement(BUSCAR);
            st.setString(1, "%" + busca + "%");
            ResultSet rs = st.executeQuery();
            List<Procedimento> lista = new ArrayList<>();
            while (rs.next()) {
                Procedimento procedimento = new Procedimento();

                procedimento.setId(rs.getInt("idProcedimento"));
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
}
