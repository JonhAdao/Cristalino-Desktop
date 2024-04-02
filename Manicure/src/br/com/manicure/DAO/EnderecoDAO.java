package br.com.manicure.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.manicure.model.Endereco;

/**
 *
 * @author John
 */
public class EnderecoDAO {

    private final String CADASTRAR_ENDERECO = "INSERT INTO endereco (CEP, rua, bairro, "
            + "cidade, estado, numero) values (?, ?, ?, ?, ?, ?)";

    public int cadastrarEndereco(Connection conn, PreparedStatement stmt, ResultSet rs, Endereco endereco) throws SQLException {
        stmt = conn.prepareStatement(CADASTRAR_ENDERECO, PreparedStatement.RETURN_GENERATED_KEYS);
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
        return 0;
    }

}
