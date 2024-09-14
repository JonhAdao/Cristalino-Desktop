package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.interfaces.CrudPesquisa;
import br.com.manicure.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import br.com.manicure.interfaces.GenericDAO;
import br.com.manicure.model.Agendamentos;
import br.com.manicure.model.Contato;
import br.com.manicure.model.Endereco;
import br.com.manicure.model.Pacotes;
import br.com.manicure.model.Validacao;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author John
 */
public class ClientesDAO implements GenericDAO<Cliente>, CrudPesquisa<Cliente> {

    private EnderecoDAO eDAO;
    private ContatoDAO cDAO;
    private PacotesDAO pDAO;

    public ClientesDAO() {
        this.eDAO = new EnderecoDAO();
        this.pDAO = new PacotesDAO();
        this.cDAO = new ContatoDAO();
    }

    private final static String CADASTRAR = "INSERT INTO cliente(nome, cpf, rg, dataNasc, endereco_id, contato_id, sexo, pacote_id, observacao, atendimento ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final static String ACRESCENTAR_ATENDIMENTO = "UPDATE cliente SET atendimento = atendimento + 1 "
            + "WHERE idCliente = ?";

    private final static String EXCLUIR_ATENDIMENTO = "UPDATE cliente "
            + "SET atendimento = atendimento - 1 "
            + "WHERE idCliente = ?";

    private final static String EDITAR = "UPDATE cliente SET nome = ?, cpf = ?, "
            + " rg = ?, endereco_id = ?, contato_id = ?, pacote_id = ?, "
            + " dataNasc = ?, sexo = ?, observacao = ? "
            + " WHERE idCliente = ? ";
    private final static String EXCLUIR = "DELETE FROM cliente WHERE idCliente = ?";

    private final static String LISTAR = "SELECT idCliente, nome, cpf, rg, dataNasc, sexo, observacao, atendimento, endereco_id, "
            + "id_endereco, rua, cep, bairro, numero, cidade, estado, contato_id, id_contato, celular, email, pacote_id, idPacote, nomeP, valor, descricao "
            + "FROM cliente LEFT JOIN endereco ON endereco_id = id_endereco "
            + "LEFT JOIN contato ON contato_id = id_contato LEFT JOIN pacotes ON pacote_id = idPacote";

    private final static String FILTRAR = "SELECT idCliente, nome, cpf, rg, "
            + "dataNasc, sexo, observacao, endereco_id, id_endereco,"
            + "rua, cep, bairro, numero, cidade, estado, contato_id, id_contato, celular, email, pacote_id, idPacote, nomeP, valor, descricao "
            + "FROM cliente LEFT JOIN "
            + "endereco ON endereco_id = id_endereco LEFT JOIN contato ON contato_id = id_contato LEFT JOIN pacotes ON pacote_id = idPacote "
            + "WHERE idCliente LIKE ? OR "
            + "nome LIKE ? ORDER BY nome";

    private final static String LISTAR_POR_ID = "SELECT idCliente, nome, cpf, rg, dataNasc, sexo, observacao, endereco_id, "
            + "id_endereco, rua, cep, bairro, numero, cidade, estado, contato_id, celular, email, pacote_id, idPacote, nomeP, valor, descricao "
            + "FROM cliente LEFT JOIN endereco ON endereco_id = id_endereco "
            + "LEFT JOIN contato ON contato_id = id_contato LEFT JOIN pacotes ON pacote_id = idPacote WHERE idCliente = ?";

    private final static String CPF_EXISTS = "SELECT cpf FROM cliente WHERE cpf = ?";

    private final static String CPF_EXISTS_MINUS = "SELECT cpf FROM cliente WHERE cpf = ? AND idCliente != ?";

    @Override
    public void cadastrar(Cliente cliente) {
        ResultSet rs = null;
        PreparedStatement st = null, stmt = null, stm = null;
        Connection conn = null;
        int id_endereco = 0;
        int id_contato = 0;
        int id_pacote = 0;

        try {
            conn = new Conexao().getConexao();
            conn.setAutoCommit(false);
            id_endereco = this.eDAO.cadastrar(conn, stmt, rs, cliente.getEndereco());
            id_contato = this.cDAO.cadastrar(conn, stm, rs, cliente.getContato());

            if (cliente.getPacote() != null) {
                id_pacote = cliente.getPacote().getIdPacote();

            }
            st = conn.prepareStatement(CADASTRAR);

            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getCpf());
            st.setString(3, cliente.getRg());
            st.setDate(4, new java.sql.Date(cliente.getDataNasc().getTime()));
            st.setInt(5, id_endereco);
            st.setInt(6, id_contato);
            st.setString(7, cliente.getSexo());
            if (id_pacote == 0) {
                st.setNull(8, Types.NULL);
            } else {
                st.setInt(8, id_pacote);
            }

            st.setString(9, cliente.getObservacao());

            st.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Cliente: " + e.getMessage());
        }
    }

    @Override
    public void editar(Cliente cliente) {
        int id_endereco = 0;
        int id_contato = 0;
        int id_pacote = 0;
        boolean removerPacote = false;
        boolean removerContato = false;
        Connection conn = null;
        PreparedStatement stmt = null, stmte = null, stm = null;
        ResultSet rs = null;

        try {
            conn = new Conexao().getConexao();
            conn.setAutoCommit(false);

            Cliente buscarCliente = this.Clientes(cliente.getId());

            if (cliente.getEndereco() != null) {

                // Editar endereço
                if (cliente.getEndereco().getIdEndereco() != 0) {
                    id_endereco = this.eDAO.editar(conn, stmte, cliente.getEndereco());
                } else {
                    // Cadastrar endereço novo
                    id_endereco = this.eDAO.cadastrar(conn, stmte, rs, cliente.getEndereco());

                }
            }

            if (cliente.getContato() != null) {

                if (cliente.getContato().getIdContato() != 0) {
                    id_contato = this.cDAO.editar(conn, stmte, cliente.getContato());
                } else {

                    id_contato = this.cDAO.cadastrar(conn, stmte, rs, cliente.getContato());
                    if (id_contato == 0) {
                        removerContato = true;
                    }
                }
            } else if (buscarCliente.getContato() != null) {
                removerContato = true;
                id_contato = 0;
            }

            if (cliente.getPacote() != null) {

                if (cliente.getPacote().getIdPacote() != 0) {
                    id_pacote = this.pDAO.editar(conn, stmte, cliente.getPacote());
                } else {

                    id_pacote = this.pDAO.cadastrar(conn, stmte, rs, cliente.getPacote());
                    if (id_pacote == 0) {
                        removerPacote = true;
                    }
                }
            } else if (buscarCliente.getPacote() != null) {
                removerPacote = true;
                id_pacote = 0;
            }

            stmt = conn.prepareStatement(EDITAR);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setInt(4, id_endereco);
            stmt.setInt(5, id_contato);
            if (id_pacote == 0) {
                stmt.setNull(6, java.sql.Types.NULL);
            } else {
                stmt.setInt(6, id_pacote);
            }
            stmt.setDate(7, new java.sql.Date(cliente.getDataNasc().getTime()));
            stmt.setString(8, cliente.getSexo());
            stmt.setString(9, cliente.getObservacao());
            stmt.setInt(10, cliente.getId());
            stmt.executeUpdate();

            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void excluir(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null, stmte = null;
        try {
            conn = new Conexao().getConexao();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(EXCLUIR);
            stmt.setInt(1, cliente.getId());
            this.eDAO.excluir(conn, stmte, cliente.getEndereco().getIdEndereco());
            this.cDAO.excluir(conn, stmt, cliente.getContato().getIdContato());
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Cliente> lista = new ArrayList<>();

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(LISTAR);
            rs = st.executeQuery();

            while (rs.next()) {
                Cliente clientes = new Cliente();
                Pacotes p = new Pacotes();
                Endereco e = null;
                Contato c = new Contato();

                if (rs.getInt(9) != 0) {
                    e = new Endereco();
                    e.setIdEndereco(rs.getInt(10));
                    e.setRua(rs.getString(11));
                    e.setCep(rs.getString(12));
                    e.setBairro(rs.getString(13));
                    e.setNumero(rs.getInt(14));
                    e.setCidade(rs.getString(15));
                    e.setEstado(rs.getString(16));
                }

                if (rs.getInt(17) != 0) {
                    c.setIdContato(rs.getInt(18));
                    c.setCelular(rs.getString(19));
                    c.setEmail(rs.getString(20));
                }

                if (rs.getInt(21) != 0) {
                    p.setIdPacote(rs.getInt(22));
                    p.setNome(rs.getString(23));
                    p.setValor(rs.getDouble(24));
                    p.setDescricao(rs.getString(25));
                }

                clientes.setPacote(p);
                clientes.setEndereco(e);
                clientes.setContato(c);
                clientes.setId(rs.getInt(1));
                clientes.setNome(rs.getString(2));
                clientes.setCpf(rs.getString(3));
                clientes.setRg(rs.getString(4));
                clientes.setDataNasc(rs.getDate(5));
                clientes.setSexo(rs.getString(6));
                clientes.setObservacao(rs.getString(7));
                clientes.setAtendimentos(rs.getInt(8));

                lista.add(clientes);

            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Cliente> filtrar(String busca) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(FILTRAR);
            if (Validacao.isNumeric(busca) && Validacao.isLessOrEqualThan(busca, 10)) {
                st.setString(1, "%" + Integer.valueOf(busca) + "%");
            } else {
                st.setInt(1, 0);
            }
            st.setString(2, "%" + busca + "%");

            rs = st.executeQuery();
            List<Cliente> lista = new ArrayList<>();
            while (rs.next()) {

                Cliente clientes = new Cliente();
                Pacotes p = new Pacotes();
                Endereco e = null;
                Contato c = new Contato();

                if (rs.getInt(8) != 0) {
                    e = new Endereco();
                    e.setIdEndereco(rs.getInt(9));
                    e.setRua(rs.getString(10));
                    e.setCep(rs.getString(11));
                    e.setBairro(rs.getString(12));
                    e.setNumero(rs.getInt(13));
                    e.setCidade(rs.getString(14));
                    e.setEstado(rs.getString(15));
                }

                if (rs.getInt(16) != 0) {
                    c.setIdContato(rs.getInt(17));
                    c.setCelular(rs.getString(18));
                    c.setEmail(rs.getString(19));
                }

                if (rs.getInt(20) != 0) {
                    p.setIdPacote(rs.getInt(21));
                    p.setNome(rs.getString(22));
                    p.setValor(rs.getDouble(23));
                    p.setDescricao(rs.getString(24));
                }

                clientes.setPacote(p);
                clientes.setEndereco(e);
                clientes.setContato(c);
                clientes.setId(rs.getInt(1));
                clientes.setNome(rs.getString(2));
                clientes.setCpf(rs.getString(3));
                clientes.setRg(rs.getString(4));
                clientes.setDataNasc(rs.getDate(5));
                clientes.setSexo(rs.getString(6));
                clientes.setObservacao(rs.getString(7));

                lista.add(clientes);

            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public int cadastrar(Connection conn, PreparedStatement stmt, ResultSet rs, Cliente cliente) {
        return 0;
    }

    @Override
    public int editar(Connection conn, PreparedStatement stmt, Cliente cliente) {
        try {
            stmt = conn.prepareStatement(EDITAR);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setInt(4, cliente.getEndereco().getIdEndereco());
            stmt.setInt(5, cliente.getContato().getIdContato());
            if (cliente.getPacote().getIdPacote() != 0) {
                stmt.setInt(6, cliente.getPacote().getIdPacote());
            } else {
                stmt.setNull(6, Types.NULL);
            }

            stmt.setDate(7, new java.sql.Date(cliente.getDataNasc().getTime()));
            stmt.setString(8, cliente.getSexo());
            stmt.setString(9, cliente.getObservacao());

            stmt.setInt(10, cliente.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao editar" + ex.getMessage());
        }
        return cliente.getId();
    }

    @Override
    public void excluir(Connection conn, PreparedStatement stmt, int cliente_id) {
        try {
            stmt = conn.prepareStatement(EXCLUIR);
            stmt.setInt(1, cliente_id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir" + ex.getMessage());
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

    public Cliente Clientes(int id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Cliente clientes = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(LISTAR_POR_ID);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                Pacotes p = new Pacotes();
                clientes = new Cliente();
                Endereco e = null;
                Contato c = new Contato();

                if (rs.getInt(8) != 0) {
                    e = new Endereco();
                    e.setIdEndereco(rs.getInt(9));
                    e.setRua(rs.getString(10));
                    e.setCep(rs.getString(11));
                    e.setBairro(rs.getString(12));
                    e.setNumero(rs.getInt(13));
                    e.setCidade(rs.getString(14));
                    e.setEstado(rs.getString(15));
                }

                if (rs.getInt(16) != 0) {
                    c.setCelular(rs.getString(17));
                    c.setEmail(rs.getString(18));
                }

                if (rs.getInt(19) != 0) {
                    p.setIdPacote(rs.getInt(20));
                    p.setNome(rs.getString(21));
                    p.setValor(rs.getDouble(22));
                    p.setDescricao(rs.getString(23));
                }

                clientes.setPacote(p);
                clientes.setEndereco(e);
                clientes.setId(rs.getInt(1));
                clientes.setNome(rs.getString(2));
                clientes.setCpf(rs.getString(3));
                clientes.setRg(rs.getString(4));
                clientes.setDataNasc(rs.getDate(5));
                clientes.setSexo(rs.getString(6));
                clientes.setObservacao(rs.getString(7));

            }
            return clientes;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void editarAtendimento(Cliente cliente, int id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = new Conexao().getConexao();
            conn.setAutoCommit(false);

            if (cliente.getId() != id) {
                stmt = conn.prepareStatement(ACRESCENTAR_ATENDIMENTO);
                stmt.setInt(1, cliente.getId());
            } else {
                stmt = conn.prepareStatement(EXCLUIR_ATENDIMENTO);
                stmt.setInt(1, cliente.getId());

            }

            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

}
