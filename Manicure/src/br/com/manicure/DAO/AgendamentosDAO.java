package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Agendamentos;
import br.com.manicure.model.Cliente;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author const
 */
public class AgendamentosDAO {

    private final String AGENDAMENTOS = "SELECT a.idAgendamento,"
            + "c.idCliente, c.nome,a.data_agendamento, "
            + "a.observacao FROM agendamento a "
            + "JOIN cliente c ON c.idCliente = a.cliente_id ";

    public List<Agendamentos> listarAgendamentos() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Agendamentos> lista = new ArrayList<>();

        try {
            conn = new Conexao().getConexao();
            st = conn.prepareStatement(AGENDAMENTOS);
            rs = st.executeQuery();

            while (rs.next()) {
                Agendamentos agendamento = new Agendamentos();
                Cliente cliente = new Cliente();

                agendamento.setId(rs.getInt(1));
                cliente.setId(rs.getInt(2));
                cliente.setNome(rs.getString(3));

                agendamento.setCliente(cliente);
                agendamento.setDataAgendamento(rs.getTimestamp(4));
                agendamento.setObservacao(rs.getString(5));

                lista.add(agendamento);
            }

            return lista;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

}
