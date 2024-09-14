package br.com.manicure.tabelas;

import br.com.manicure.model.Procedimento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author John
 */
public class ProcedimentoTable extends AbstractTableModel {

    private List<Procedimento> procedimentos;
    private final String[] colunas = {"Código", "Nome", "Valor", "Duração"};

    public ProcedimentoTable() {
        this.procedimentos = new ArrayList();

    }

    public void addLista(List<Procedimento> lista) {
        this.procedimentos = lista;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return procedimentos.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public Procedimento getProcedimento(int row) {
        return this.procedimentos.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Procedimento atualProcedimento = this.procedimentos.get(rowIndex);
        String val = null;
        switch (columnIndex) {
            case 0:
                val = Integer.toString(atualProcedimento.getIdProcedimento());
                break;
            case 1:
                val = atualProcedimento.getNome();
                break;
            case 2:
                val = Double.toString(atualProcedimento.getValor());
                break;
            case 3:
                val = atualProcedimento.getDuracao();
                break;
            default:
                System.out.println("Inválide column (Tipo Profissional Table)");
                break;
        }
        return val;
    }

}
