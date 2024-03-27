package br.com.manicure.tabelas;

import br.com.manicure.model.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author John
 */
public class UsuarioTable extends AbstractTableModel {

    private List<Usuarios> usuarios;
    private final String[] colunas = {"Código", "Nome", "Login"};

    public UsuarioTable() {
        this.usuarios = new ArrayList();

    }

    public void addLista(List<Usuarios> lista) {
        this.usuarios = lista;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public Usuarios getUsuario(int row) {
        return this.usuarios.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuarios atualUsuario = this.usuarios.get(rowIndex);
        String val = null;
        switch (columnIndex) {
            case 0:
                val = Integer.toString(atualUsuario.getId());
                break;
            case 1:
                val = atualUsuario.getNome();
                break;
            case 2:
                val = atualUsuario.getLogin();
                break;
            default:
                System.out.println("Inválide column (Tipo Usuarios Table)");
                break;
        }
        return val;
    }

}
