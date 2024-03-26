package br.com.manicure.tabelas;

import br.com.manicure.model.Agendamentos;
import br.com.manicure.model.Formatacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author const
 */
public class AgendamentoTable extends AbstractTableModel {

    private List<Agendamentos> agendamento;
    private final String[] colunas = {"Código", "Cliente", "Data do atendimento", "Horário do atendimento", "Observações"};

    public AgendamentoTable() {
        agendamento = new ArrayList();
    }

    @Override
    public int getRowCount() {
        return agendamento.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Agendamentos atualAgendamento = this.agendamento.get(row);
        String val = null;
        switch (column) {
            case 0:
                val = Integer.toString(atualAgendamento.getId());
                break;
            case 1:
                val = atualAgendamento.getCliente().getNome();
                break;
            case 2:
                val = Formatacao.date2StringScreen(atualAgendamento.getDataAgendamento());
                break;
            case 3:
                val = Formatacao.time2String(atualAgendamento.getDataAgendamento());
                break;
            case 4:
                val = atualAgendamento.getObservacao();
                break;
            default:
                System.out.println("Inválide column (Cliente Table)");
                break;
        }
        return val;
    }

    public Agendamentos getCliente(int row) {
        return this.agendamento.get(row);
    }

    public void addCliente(Agendamentos a) {
        this.agendamento.add(a);
        fireTableDataChanged();
    }

    public void addLista(List<Agendamentos> lista) {
        this.agendamento = lista;
        fireTableDataChanged();
    }

    public void limpar() {
        this.agendamento.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return this.agendamento.isEmpty();
    }
}
