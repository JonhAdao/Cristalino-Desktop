package br.com.manicure.tabelas;

import br.com.manicure.model.Pacotes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author John
 */
public class PacotesTable extends AbstractTableModel {

    private List<Pacotes> pacotes;
    private final String[] colunas = {"Código", "Nome", "Valor", "Descrição"};

    public PacotesTable() {
        this.pacotes = new ArrayList();

    }

    public void addLista(List<Pacotes> lista) {
        this.pacotes = lista;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return pacotes.size();
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
        Pacotes atualPacote = this.pacotes.get(rowIndex);
        String val = null;
        switch (columnIndex) {
            case 0:
                val = Integer.toString(atualPacote.getId());
                break;
            case 1:
                val = atualPacote.getNome();
                break;
            case 2:
                val = Double.toString(atualPacote.getValor());
                break;
            case 3:
                val = atualPacote.getDescricao();
                break;
            default:
                System.out.println("Inválide column (Tipo Pacotes Table)");
                break;
        }
        return val;
    }

}
