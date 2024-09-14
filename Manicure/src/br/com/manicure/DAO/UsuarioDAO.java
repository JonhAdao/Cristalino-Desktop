package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import java.sql.Connection;
import br.com.manicure.model.Usuarios;
import java.util.List;
import br.com.manicure.interfaces.GenericDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author John
 */
public class UsuarioDAO implements GenericDAO<Usuarios> {

    private final static String CADASTRAR = "INSERT INTO usuarios(nomeU, login, senha) VALUES (?, ?, ?)";

    private final static String EDITAR = "UPDATE usuarios SET nomeU = ?, login = ?, senha = ? WHERE idUsuario = ?";

    private final static String EXCLUIR = "DELETE FROM usuarios WHERE idUsuario = ?";

    private final static String LISTAR = "SELECT * FROM usuarios ";

    private final static String FILTRAR = "SELECT * FROM usuarios WHERE nomeU LIKE ?  ";

    private final static String LOGIN_EXISTS = "SELECT * FROM usuario WHERE login = ?";

    private final static String USUARIO = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";

    @Override
    public void cadastrar(Usuarios usuario) {
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(CADASTRAR);
            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getLogin());
            st.setString(3, usuario.getSenha());
            st.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Usuario: " + e.getMessage());
        }
    }

    @Override
    public void editar(Usuarios usuario) {
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(EDITAR);

            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getLogin());
            st.setString(3, usuario.getSenha());
            st.setInt(4, usuario.getId());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void excluir(Usuarios usuario) {
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(EXCLUIR);

            st.setInt(1, usuario.getId());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Usuarios> listar() {
        ResultSet rs = null;
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(LISTAR);
            rs = st.executeQuery();
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

    @Override
    public List<Usuarios> filtrar(String busca) {
        ResultSet rs = null;
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(FILTRAR);
            st.setString(1, "%" + busca + "%");
            rs = st.executeQuery();
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

    public static Usuarios validarUsuario(Usuarios usuario) {
        ResultSet rs = null;
        PreparedStatement st = null;
        Connection conn = null;
        Usuarios usuarioEncontrado = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(USUARIO);

            st.setString(1, usuario.getLogin());
            st.setString(2, usuario.getSenha());
            rs = st.executeQuery();
            while (rs.next()) {
                usuarioEncontrado = new Usuarios();
                usuarioEncontrado.setId(rs.getInt("idUsuario"));
                usuarioEncontrado.setNome(rs.getString("nomeU"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao encontrar Usuario" + ex.getMessage());
        }

        return usuarioEncontrado;
    }

    public static boolean loginExists(String login, int id) {
        ResultSet rs = null;
        PreparedStatement st = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(LOGIN_EXISTS);
            st.setString(1, login);
            rs = st.executeQuery();

            if (rs.next()) {
                return true;
            }

            return false;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

}
