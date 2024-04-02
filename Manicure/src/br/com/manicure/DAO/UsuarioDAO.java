package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Usuarios;
import java.io.IOException;
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

    public void cadastrarUsuario(Usuarios usuario) {
        String CADASTRAR = "INSERT INTO usuarios(nomeU, login, senha) VALUES (?, ?, ?)";

        try {
            PreparedStatement st = this.conn.prepareStatement(CADASTRAR);
            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getLogin());
            st.setString(3, usuario.getSenha());
            st.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Usuario: " + e.getMessage());
        }
    }

    public void editarUsuario(Usuarios usuario) {
        String EDITAR = "UPDATE usuarios SET nomeU = ?, login = ?, senha = ? WHERE idUsuario = ?";

        try {
            PreparedStatement st = this.conn.prepareStatement(EDITAR);

            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getLogin());
            st.setString(3, usuario.getSenha());
            st.setInt(4, usuario.getId());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void removerUsuario(Usuarios u) {
        String DELETAR = "DELETE FROM usuarios WHERE idUsuario = ?";

        try {
            PreparedStatement st = this.conn.prepareStatement(DELETAR);

            st.setInt(1, u.getId());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public List<Usuarios> listarUsuarios() {
        String LISTAR = "SELECT * FROM usuarios ";

        try {
            PreparedStatement st = this.conn.prepareStatement(LISTAR);
            ResultSet rs = st.executeQuery();
            List<Usuarios> lista = new ArrayList<>();
            while (rs.next()) {
                Usuarios usuario = new Usuarios();

                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nomeU"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));

                lista.add(usuario);

            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Usuarios> filtrarUsuarios(String busca) {
        String BUSCAR = "SELECT * FROM usuarios WHERE nomeU LIKE ?  ";

        try {
            PreparedStatement st = this.conn.prepareStatement(BUSCAR);
            st.setString(1, "%" + busca + "%");
            ResultSet rs = st.executeQuery();
            List<Usuarios> lista = new ArrayList<>();
            while (rs.next()) {
                Usuarios usuarios = new Usuarios();

                usuarios.setId(rs.getInt("idUsuario"));
                usuarios.setNome(rs.getString("nomeU"));
                usuarios.setLogin(rs.getString("login"));

                lista.add(usuarios);

            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    /* public static boolean loginExists(String login, int id) {
        String LOGIN_EXISTS = "SELECT * FROM usuario WHERE login = ?";

        try {
            PreparedStatement st = UsuarioDAO.conn.prepareStatement(LOGIN_EXISTS);
            st.setString(1, login);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true;
            }

            return false;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }*/
}
