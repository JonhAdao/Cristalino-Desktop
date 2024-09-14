package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Agendamentos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import br.com.manicure.interfaces.GenericDAO;
import br.com.manicure.model.Cliente;
import br.com.manicure.model.Contato;
import br.com.manicure.model.Endereco;
import br.com.manicure.model.Esmalte;
import br.com.manicure.model.Formatacao;
import br.com.manicure.model.Pacotes;
import br.com.manicure.model.Procedimento;
import br.com.manicure.model.Validacao;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Esta classe gerencia os dados de agendamentos
 *
 * @author John
 */
public class AgendamentosDAO implements GenericDAO<Agendamentos> {

    private ClientesDAO cDAO;
    private ProcedimentoDAO pDAO;
    private EsmalteDAO eDAO;

    public AgendamentosDAO() {
        this.cDAO = new ClientesDAO();
        this.pDAO = new ProcedimentoDAO();
        this.eDAO = new EsmalteDAO();

    }

    private final static String CADASTRAR = "INSERT INTO agendamento(cliente_id, procedimento_id, cor_esmalte_id, Data_Agendamento, frete, obs) "
            + "VALUES (?, ?, ?, ?, ?, ? )";

    private final static String EDITAR = "UPDATE agendamento SET cliente_id = ?, "
            + "procedimento_id = ?, cor_esmalte_id = ?, "
            + "Data_Agendamento = ?, frete = ?, obs = ? "
            + "WHERE idAgendamento = ? ";

    private final static String EXCLUIR = "DELETE FROM agendamento WHERE idAgendamento = ?";

    private final String LISTAR = "SELECT idAgendamento,"
            + "data_agendamento, frete, obs, idCliente, idCorEsmalte, CoresDisponiveis, idProcedimento, "
            + "nomePr, valor, duracao FROM agendamento "
            + "LEFT JOIN cliente ON idCliente = cliente_id "
            + "LEFT JOIN coresmalte ON idCorEsmalte = cor_esmalte_id "
            + "LEFT JOIN procedimento ON idProcedimento = procedimento_id ";

    private final String FILTRAR = "SELECT a.idAgendamento, c.idCliente, c.nome, "
            + "a.data_agendamento, a.obs FROM agendamento a "
            + "LEFT JOIN cliente c ON c.idCliente = a.cliente_id "
            + "WHERE a.idAgendamento LIKE ? "
            + "OR c.nome LIKE ? OR a.data_agendamento LIKE ? ";

    private final static String CLIENTES_ID = "SELECT idCliente, nome, cpf, rg, dataNasc, sexo, observacao, "
            + "id_endereco, rua, cep, bairro, numero, cidade, estado, contato_id, id_contato, celular, email, pacote_id, idPacote, nomeP, valor, descricao "
            + "FROM cliente LEFT JOIN endereco ON endereco_id = id_endereco "
            + "LEFT JOIN contato ON contato_id = id_contato LEFT JOIN pacotes ON pacote_id = idPacote WHERE idCliente = ?";

    private final static String PROCEDIMENTOS = "SELECT p.idProcedimento, p.nomePr, p.valor, p.duracao "
            + "FROM procedimento p JOIN agendamento a ON p.idProcedimento = a.procedimento_id ";

    @Override
    public void cadastrar(Agendamentos agenda) {
        ResultSet rs = null;
        PreparedStatement st = null;
        Connection conn = null;
        LocalDate data = agenda.getDataAgendamento().toLocalDateTime().toLocalDate();
        LocalTime horas = LocalTime.parse(agenda.getHorario());

        LocalDateTime localDateTime = LocalDateTime.of(data, horas);
        Timestamp dataeHora = Timestamp.valueOf(localDateTime);

        try {
            conn = new Conexao().getConexao();
            conn.setAutoCommit(false);

            st = conn.prepareStatement(CADASTRAR);

            st.setInt(1, agenda.getCliente().getId());
            st.setInt(2, agenda.getProcedimento().getIdProcedimento());
            st.setInt(3, agenda.getCorEsmalte().getIdEsmalte());
            st.setTimestamp(4, dataeHora);
            if (agenda.getFrete() != null) {
                st.setDouble(5, agenda.getFrete());
            } else {
                st.setNull(5, Types.NULL);
            }
            st.setString(6, agenda.getObservacao());
            cDAO.editarAtendimento(agenda.getCliente(), agenda.getId());

            st.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Agendamento: " + e.getMessage());
        }
    }

    @Override
    public void editar(Agendamentos agenda) {
        int id_cliente = 0;
        int id_procedimento = 0;
        int id_corEsmalte = 0;
        Connection conn = null;
        PreparedStatement stmt = null, stmte = null, st = null;
        LocalDate data = agenda.getDataAgendamento().toLocalDateTime().toLocalDate();
        LocalTime horas = LocalTime.parse(agenda.getHorario());

        LocalDateTime localDateTime = LocalDateTime.of(data, horas);
        Timestamp dataeHora = Timestamp.valueOf(localDateTime);
        ResultSet rs = null;

        try {
            conn = new Conexao().getConexao();
            conn.setAutoCommit(false);

            id_cliente = this.cDAO.editar(conn, stmte, agenda.getCliente());

            id_procedimento = this.pDAO.editar(conn, st, agenda.getProcedimento());

            id_corEsmalte = this.eDAO.editar(conn, stmt, agenda.getCorEsmalte());

            stmt = conn.prepareStatement(EDITAR);
            stmt.setInt(1, id_cliente);
            stmt.setInt(2, id_procedimento);
            stmt.setInt(3, id_corEsmalte);
            stmt.setTimestamp(4, dataeHora);
            if (agenda.getFrete() != null) {
                stmt.setDouble(5, agenda.getFrete());
            } else {
                stmt.setNull(5, Types.NULL);
            }

            stmt.setString(6, agenda.getObservacao());
            stmt.setInt(7, agenda.getId());

            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            System.out.println("Erro ao editar Agendamento" + e.getMessage());
        }
    }

    @Override
    public void excluir(Agendamentos agenda) {
        Connection conn = null;
        PreparedStatement stmt;
        try {
            cDAO.editarAtendimento(agenda.getCliente(), agenda.getCliente().getId());
            conn = new Conexao().getConexao();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(EXCLUIR);
            stmt.setInt(1, agenda.getId());

            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Agendamentos> listar() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Agendamentos> lista = new ArrayList<>();

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(LISTAR);
            rs = st.executeQuery();

            while (rs.next()) {
                Agendamentos agendamento = new Agendamentos();
                Procedimento po = new Procedimento();
                Esmalte es = new Esmalte();

                es.setIdEsmalte(rs.getInt(6));
                es.setCor(rs.getString(7));

                po.setIdProcedimento(rs.getInt(8));
                po.setNome(rs.getString(9));
                po.setValor(rs.getDouble(10));
                po.setDuracao(rs.getString(11));

                agendamento.setId(rs.getInt(1));
                agendamento.setProcedimento(po);
                agendamento.setCorEsmalte(es);
                agendamento.setCliente(this.getClientesId(rs.getInt(5)));
                agendamento.setDataAgendamento(rs.getTimestamp(2));
                agendamento.setHorario(rs.getString(2).substring(11));
                agendamento.setFrete(rs.getDouble(3));
                agendamento.setObservacao(rs.getString(4));

                lista.add(agendamento);
            }

            return lista;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Agendamentos> filtrar(String filtro) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(FILTRAR);
            if (Validacao.isNumeric(filtro) && Validacao.isLessOrEqualThan(filtro, 10)) {
                st.setString(1, "%" + Integer.valueOf(filtro) + "%");
            } else {
                st.setInt(1, 0);
            }
            st.setString(2, "%" + filtro + "%");

            if (Validacao.isDate(filtro)) {
                st.setString(3, "%" + new java.sql.Date(Formatacao.string2Date(filtro).getTime()) + "%");
            } else {
                st.setNull(3, java.sql.Types.NULL);
            }

            rs = st.executeQuery();
            List<Agendamentos> lista = new ArrayList<>();
            while (rs.next()) {

                Agendamentos agenda = new Agendamentos();
                Cliente c = new Cliente();

                c.setId(rs.getInt(2));
                c.setNome(rs.getString(3));

                agenda.setId(rs.getInt(1));
                agenda.setCliente(c);
                agenda.setDataAgendamento(rs.getTimestamp(4));
                agenda.setObservacao(rs.getString(5));

                lista.add(agenda);

            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    public Cliente getClientesId(int id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Cliente clientes = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(CLIENTES_ID);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                clientes = new Cliente();
                Pacotes p = new Pacotes();
                Endereco e = new Endereco();
                Contato c = new Contato();

                e.setIdEndereco(rs.getInt(8));
                e.setRua(rs.getString(9));
                e.setCep(rs.getString(10));
                e.setBairro(rs.getString(11));
                e.setNumero(rs.getInt(12));
                e.setCidade(rs.getString(13));
                e.setEstado(rs.getString(14));

                if (rs.getInt(15) != 0) {
                    c.setIdContato(rs.getInt(16));
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
                clientes.setContato(c);
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

    public Procedimento getProcedimentos() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Procedimento procedimento = null;

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(PROCEDIMENTOS);
            rs = st.executeQuery();
            while (rs.next()) {
                procedimento = new Procedimento();

                procedimento.setIdProcedimento(rs.getInt(1));
                procedimento.setNome(rs.getString(2));
                procedimento.setValor(rs.getDouble(3));
                procedimento.setDuracao(rs.getString(4));

            }
            return procedimento;
        } catch (SQLException e) {
            return null;
        }
    }

}
