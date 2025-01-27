package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Agendamentos;
import br.com.manicure.model.Cliente;
import br.com.manicure.model.Endereco;
import br.com.manicure.model.Esmalte;
import br.com.manicure.model.Formatacao;
import br.com.manicure.model.Horario;
import br.com.manicure.model.Procedimento;
import br.com.manicure.model.Validacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author John
 */
public class AgendaDAO {

    private final String AGENDAMENTOS = "SELECT a.idAgendamento,"
            + "c.idCliente, c.nome, p.idProcedimento, p.nomePr, p.valor,"
            + "co.idCorEsmalte, co.CoresDisponiveis, c.endereco_id, e.id_endereco, e.rua, e.numero,"
            + "a.frete, a.obs FROM agendamento a "
            + "LEFT JOIN cliente c ON c.idCliente = a.cliente_id "
            + "LEFT JOIN procedimento p ON p.idProcedimento = a.procedimento_id "
            + "LEFT JOIN coresmalte co ON co.idCorEsmalte = a.cor_esmalte_id "
            + "LEFT JOIN endereco e ON c.endereco_id = e.id_endereco "
            + "WHERE a.data_agendamento = ?";

    public List<Horario> agendamentos(String data) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Horario> horarios = null;
        try {
            conn = new Conexao().getConexao();
            if (Validacao.isDate(data)) {
                String buscaVar;
                horarios = HorarioDAO.horarios();
                for (Horario h : horarios) {
                    buscaVar = data + " " + Formatacao.time2String(h.getHora());
                    Date dataAgenda = Formatacao.string2DateTime(buscaVar);
                    st = conn.prepareStatement(AGENDAMENTOS);
                    st.setString(1, Formatacao.dateTime2String(dataAgenda));
                    rs = st.executeQuery();
                    int i = 1;
                    while (rs.next()) {
                        Agendamentos a = h.getAgendamento(i++);
                        this.getAgendamento(rs, a, dataAgenda);
                    }
                }
            }
            return horarios;
        } catch (SQLException e) {
            return null;
        }
    }

    private void getAgendamento(ResultSet rs, Agendamentos a, Date dataAgenda) throws SQLException {
        Procedimento procedimento = new Procedimento();
        procedimento.setIdProcedimento(rs.getInt(4));
        procedimento.setNome(rs.getString(5));
        procedimento.setValor(rs.getDouble(6));

        Esmalte corEsmalte = new Esmalte();
        corEsmalte.setIdEsmalte(rs.getInt(7));
        corEsmalte.setCor(rs.getString(8));

        Endereco e = null;

        if (rs.getInt(9) != 0) {
            e = new Endereco();
            e.setIdEndereco(rs.getInt(10));
            e.setRua(rs.getString(11));
            e.setNumero(rs.getInt(12));
        }

        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt(2));
        cliente.setNome(rs.getString(3));
        cliente.setEndereco(e);

        a.setCliente(cliente);
        a.setProcedimento(procedimento);
        if (corEsmalte.getIdEsmalte() == 0) {
            a.setCorEsmalte(null);
        } else {
            a.setCorEsmalte(corEsmalte);
        }

        a.setDataAgendamento(new java.sql.Timestamp(dataAgenda.getTime()));
        if (rs.getDouble(13) != 0.0) {
            a.setFrete(rs.getDouble(13));
            a.setValoraPagar(rs.getDouble(6) + a.getFrete());
        } else {
            a.setValoraPagar(rs.getDouble(6));
        }

        a.setId(rs.getInt(1));
        a.setObservacao(rs.getString(14));
    }

}
