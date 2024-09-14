package br.com.manicure.tabelas;

import br.com.manicure.model.Esmalte;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author John
 */
public class EsmalteTable extends AbstractTableModel {

    private List<Esmalte> esmalte;
    private final String[] colunas = {"Código", "Nome" };

    public EsmalteTable() {
        this.esmalte = new ArrayList();

    }

    public void addLista(List<Esmalte> lista) {
        this.esmalte = lista;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return esmalte.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public int getId(int row) {
        return this.esmalte.get(row).getIdEsmalte();
    }

    public void limpar() {
        this.esmalte.clear();
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Esmalte atualEsmalte = this.esmalte.get(rowIndex);
        String val = null;
        switch (columnIndex) {
            case 0:
                val = Integer.toString(atualEsmalte.getIdEsmalte());
                break;
            case 1:
                val = atualEsmalte.getCor();
                break;
            default:
                System.out.println("Inválide column (Tipo Esmalte Table)");
                break;
        }
        return val;
    }

    public Esmalte getEsmalte(int row) {
        return this.esmalte.get(row);
    }
}
