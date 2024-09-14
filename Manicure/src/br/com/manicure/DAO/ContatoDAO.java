package br.com.manicure.DAO;

import br.com.manicure.model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.manicure.interfaces.CrudPesquisa;
import java.sql.SQLException;

/**
 *
 * @author John
 */
public class ContatoDAO implements CrudPesquisa<Contato> {

    private final String CADASTRAR = "INSERT INTO contato (celular, email) values (?, ?)";

    private final static String EDITAR = "UPDATE contato SET celular = ? WHERE id_Contato = ?";

    private final static String EXCLUIR = "DELETE FROM contato WHERE id_Contato = ?";

    @Override
    public int cadastrar(Connection conn, PreparedStatement stmt, ResultSet rs, Contato contato) {
        try {
            stmt = conn.prepareStatement(CADASTRAR, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, contato.getCelular());
            stmt.setString(2, contato.getEmail());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar contato" + e.getMessage());
        }
        return 0;
    }

    @Override
    public int editar(Connection conn, PreparedStatement stmt, Contato contato) {
        try {
            stmt = conn.prepareStatement(EDITAR);
            stmt.setString(1, contato.getCelular());
            stmt.setString(2, contato.getEmail());
            stmt.setInt(3, contato.getIdContato());
            stmt.executeUpdate();
            return contato.getIdContato();

        } catch (SQLException e) {
            System.out.println("Erro ao editar contato" + e.getMessage());
        }
        return 0;
    }

    @Override
    public void excluir(Connection conn, PreparedStatement stmt, int contato_id) {
        try {
            stmt = conn.prepareStatement(EXCLUIR);
            stmt.setInt(1, contato_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir contato" + e.getMessage());
        }
    }

}
