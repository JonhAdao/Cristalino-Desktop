package br.com.manicure.DAO;

import br.com.manicure.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.manicure.interfaces.CrudPesquisa;
import java.sql.SQLException;


/**
 *
 * @author John
 */
public class EnderecoDAO implements CrudPesquisa<Endereco> {

    private final String CADASTRAR = "INSERT INTO endereco (CEP, rua, bairro, "
            + "cidade, estado, numero) values (?, ?, ?, ?, ?, ?)";

    private final static String EDITAR = "UPDATE endereco SET cep = ?, rua = ?, bairro = ?,"
            + "cidade = ?, estado = ?, numero = ? WHERE id_endereco = ?";

    private final static String EXCLUIR = "DELETE FROM endereco WHERE id_endereco = ?";

    @Override
    public int cadastrar(Connection conn, PreparedStatement stmt, ResultSet rs, Endereco endereco) {
        try {
            stmt = conn.prepareStatement(CADASTRAR, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setInt(6, endereco.getNumero());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar endereco" + ex.getMessage());
        }

        return 0;
    }

    @Override
    public int editar(Connection conn, PreparedStatement stmt, Endereco endereco) {
        try {
            stmt = conn.prepareStatement(EDITAR);
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setInt(6, endereco.getNumero());
            stmt.setInt(7, endereco.getIdEndereco());
            stmt.executeUpdate();
            return endereco.getIdEndereco();

        } catch (SQLException ex) {
            System.out.println("Erro ao editar endereco" + ex.getMessage());

            return 0;
        }
    }

    @Override
    public void excluir(Connection conn, PreparedStatement stmt, int endereco_id) {
        try {
            stmt = conn.prepareStatement(EXCLUIR);
            stmt.setInt(1, endereco_id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir endereco" + ex.getMessage());
        }

    }

}
