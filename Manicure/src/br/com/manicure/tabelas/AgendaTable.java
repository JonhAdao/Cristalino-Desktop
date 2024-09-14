/**
 * @author Jonh
 */
package br.com.manicure.tabelas;

import br.com.manicure.model.Agendamentos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.manicure.model.Formatacao;
import br.com.manicure.model.Horario;

public class AgendaTable extends AbstractTableModel {

    private List<Horario> horas;
    private List<Agendamentos> agenda;
    private final String[] colunas = {"Horário", "Cliente", "Procedimento", "Cor do Esmalte", "Endereço", "Valor"};

    public AgendaTable() {
        this.horas = new ArrayList();
    }

    @Override
    public int getRowCount() {
        return this.horas.size();
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        Horario atualHorario = this.horas.get(rowIndex);
        Object val = null;
        switch (columnIndex) {
            case 0:
                val = Formatacao.time2StringNoSec(atualHorario.getHora());
                break;
            case 1:
                val = this.getVal(atualHorario, 1);
                break;
            case 2:
                val = this.getVal2(atualHorario, 1);
                break;
            case 3:
                val = this.getVal3(atualHorario, 1);
                break;
            case 4:
                val = this.getVal4(atualHorario, 1);
                break;
            case 5:
                val = this.getVal5(atualHorario, 1);
                break;
            default:
                System.out.println("Inválide column (Tipo Profissional Table)");
                break;
        }
        return val;
    }

    public Horario getHorario(int row) {
        return this.horas.get(row);
    }

    public Horario getAgendamento(int row, int column) {
        return this.horas.get(row);

    }

    public Agendamentos getAgendamento(int row) {
        return this.agenda.get(row);

    }

    public void addLista(List<Horario> horarios) {
        this.horas = horarios;
    }

    public void limpar() {
        this.horas.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return this.horas.isEmpty();
    }

    private String getVal(Horario a, int column) {
        if (a.getAgendamento(column).getCliente() != null) {
            return a.getAgendamento(column).getCliente().getNome();
        } else {
            return "";
        }

    }

    private String getVal2(Horario a, int column) {
        if (a.getAgendamento(column).getProcedimento() != null) {
            return a.getAgendamento(column).getProcedimento().getNome();
        } else {
            return "";
        }
    }

    private String getVal3(Horario a, int column) {
        if (a.getAgendamento(column).getCorEsmalte() != null) {
            return a.getAgendamento(column).getCorEsmalte().getCor();
        } else {
            return "";
        }
    }

    private String getVal4(Horario a, int column) {
        if (a.getAgendamento(column).getCliente() != null) {
            return "Rua " + a.getAgendamento(column).getCliente().getEndereco().getRua().concat("   Número: " + String.valueOf(a.getAgendamento(column).getCliente().getEndereco().getNumero()));
        } else {
            return "";
        }
    }

    private String getVal5(Horario a, int column) {
        if (a.getAgendamento(column).getFrete() != null) {
            return "R$ " + a.getAgendamento(column).getValoraPagar().toString() + " (Taxa de deslocamento inclusa)";
        } else if (a.getAgendamento(column).getValoraPagar() != null && a.getAgendamento(column).getFrete() == null) {
            return "R$ " + a.getAgendamento(column).getValoraPagar().toString();
        } else {
            return "";
        }
    }

}
