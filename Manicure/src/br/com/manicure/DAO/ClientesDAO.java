package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Cliente;
import br.com.manicure.model.Endereco;
import br.com.manicure.model.Pacotes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John
 */
public class ClientesDAO {

    private EnderecoDAO eDAO;
    private PacotesDAO pDAO;

    public ClientesDAO() {
        this.eDAO = new EnderecoDAO();
        this.pDAO = new PacotesDAO();
    }

    private final static String CLIENTES = "SELECT idCliente, nome, cpf, rg, celular, email, endereco_id, "
            + "id_endereco, rua, cep, bairro, numero, cidade, estado, idPacote, nomeP, valor, descricao "
            + "FROM cliente LEFT JOIN endereco ON endereco_id = id_endereco "
            + "LEFT JOIN pacotes ON pacote_id = idPacote";

    private final static String CPF_EXISTS = "SELECT cpf FROM cliente WHERE cpf = ?";
    private final static String CPF_EXISTS_MINUS = "SELECT cpf FROM cliente WHERE cpf = ? AND idCliente != ?";

    private final static String CADASTRAR = "INSERT INTO cliente(nome, cpf, rg, dataNasc, celular, endereco_id, email, sexo, pacote_id, observacao ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public void cadastrarCliente(Cliente cliente) throws SQLException {
        ResultSet rs = null;
        PreparedStatement st = null, stmt = null, stmte = null;
        Connection conn = null;
        int id_pacote = 0;
        int id_endereco = 0;

        try {
            conn = new Conexao().getConexao();
            conn.setAutoCommit(false);

            if (cliente.getEndereco() != null) {
                id_endereco = this.eDAO.cadastrarEndereco(conn, stmt, rs, cliente.getEndereco());
                if (id_endereco == java.sql.Types.NULL) {
                    id_endereco = 0;
                }

            }

            if (cliente.getPacote() != null) {
                id_pacote = this.pDAO.cadastrar(conn, stmte, rs, cliente.getPacote());
                if (id_pacote == java.sql.Types.NULL) {
                    id_pacote = 0;
                }

            }

            st = conn.prepareStatement(CADASTRAR);

            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getCpf());
            st.setString(3, cliente.getRg());
            st.setDate(4, new java.sql.Date(cliente.getDataNasc().getTime()));
            st.setString(5, cliente.getCelular());
            st.setInt(6, id_endereco);
            st.setString(7, cliente.getEmail());
            st.setString(8, cliente.getSexo());
            if (id_pacote == 0) {
                st.setNull(9, Types.NULL);
            } else {
                st.setInt(9, id_pacote);;
            }

            st.setString(10, cliente.getObservacao());

            st.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listarClientes() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Cliente> lista = new ArrayList<>();

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(CLIENTES);
            rs = st.executeQuery();

            while (rs.next()) {
                Cliente clientes = new Cliente();
                Pacotes p = new Pacotes();
                Endereco e = null;

                if (rs.getInt(7) != 0) {
                    e = new Endereco();
                    e.setId(rs.getInt(8));
                    e.setRua(rs.getString(9));
                    e.setCep(rs.getString(10));
                    e.setBairro(rs.getString(11));
                    e.setNumero(rs.getInt(12));
                    e.setCidade(rs.getString(13));
                    e.setEstado(rs.getString(14));
                }

                p.setId(rs.getInt(15));
                p.setNome(rs.getString(16));
                p.setValor(rs.getDouble(17));
                p.setDescricao(rs.getString(18));

                clientes.setPacote(p);
                clientes.setEndereco(e);
                clientes.setId(rs.getInt(1));
                clientes.setNome(rs.getString(2));
                clientes.setCpf(rs.getString(3));
                clientes.setRg(rs.getString(4));
                clientes.setCelular(rs.getString(5));
                clientes.setEmail(rs.getString(6));

                lista.add(clientes);

            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static boolean CPFExists(String cpf, int id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = new Conexao().getConexao();

            if (id == 0) {
                st = conn.prepareStatement(CPF_EXISTS);
            } else {
                st = conn.prepareStatement(CPF_EXISTS_MINUS);
                st.setInt(2, id);
            }

            st.setString(1, cpf);
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
