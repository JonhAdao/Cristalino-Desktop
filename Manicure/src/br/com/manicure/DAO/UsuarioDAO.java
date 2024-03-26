package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Pacotes;
import br.com.manicure.model.Usuarios;
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
public class UsuarioDAO {

    private Conexao conexao;
    private Connection conn;

    public UsuarioDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public List<Usuarios> listarUsuarios() {
        String sql = "SELECT idUsuario, nomeU, login FROM usuarios ";

        try {
            PreparedStatement st = this.conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Usuarios> lista = new ArrayList<>();
            while (rs.next()) {
                Usuarios usuario = new Usuarios();

                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nomeU"));
                usuario.setLogin(rs.getString("login"));

                lista.add(usuario);

            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

}
