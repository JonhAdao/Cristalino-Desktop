package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Cliente;
import br.com.manicure.model.Endereco;
import br.com.manicure.model.Pacotes;
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
public class ClientesDAO {

    private EnderecoDAO eDAO;
    private Conexao conexao;
    private Connection conn;

    public ClientesDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
        this.eDAO = new EnderecoDAO();
    }

    public void cadastrarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente(nome, cpf, rg, email, celular, pacote_id, endereco_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        int id_endereco = this.eDAO.cadastrarEndereco(conn, stmt, rs, cliente.getEndereco());
        int id_pacote = 0;
        try {
            PreparedStatement st = this.conn.prepareStatement(sql);

            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getCpf());
            st.setString(3, cliente.getRg());
            st.setString(4, cliente.getEmail());
            st.setString(5, cliente.getCelular());
            st.setInt(6, id_endereco);
            // st.setInt(7, cliente.getPacote());
            st.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listarClientes() {
        String sql = "SELECT idCliente, nome, cpf, rg, celular, email, endereco_id, "
                + " id_endereco, rua, cep, bairro, numero, cidade, estado, idPacote, nomeP, valor, descricao FROM cliente LEFT JOIN endereco ON endereco_id = id_endereco"
                + " LEFT JOIN pacotes ON pacote_id = idPacote";

        try {
            PreparedStatement st = this.conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Cliente> lista = new ArrayList<>();
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

}
