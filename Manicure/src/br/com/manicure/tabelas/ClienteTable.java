package br.com.manicure.tabelas;

import br.com.manicure.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author John
 */
public class ClienteTable extends AbstractTableModel {

    private List<Cliente> clientes;
    private final String[] colunas = {"Código", "Nome", "CPF", "Telefone", "E-mail", "Endereço", "Pacote", "Atendimentos"};

    public ClienteTable() {
        clientes = new ArrayList();
    }

    @Override
    public int getRowCount() {
        return clientes.size();
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
        Cliente atualCliente = this.clientes.get(row);
        String val = null;
        switch (column) {
            case 0:
                val = Integer.toString(atualCliente.getId());
                break;
            case 1:
                val = atualCliente.getNome();
                break;
            case 2:
                val = atualCliente.getCpf();
                break;
            case 3:
                val = atualCliente.getContato().getCelular();
                break;
            case 4:
                val = atualCliente.getContato().getEmail();
                break;
            case 5:
                val = atualCliente.getEndereco().getRua().concat("  N°" + String.valueOf(atualCliente.getEndereco().getNumero()));
                break;
            case 6:
                val = atualCliente.getPacote().getNome();
                break;
            case 7:
                val = String.valueOf(atualCliente.getAtendimentos());
                break;
            default:
                System.out.println("Inválide column (Cliente Table)");
                break;
        }
        return val;
    }

    public Cliente getCliente(int row) {
        return this.clientes.get(row);
    }

    public void addCliente(Cliente u) {
        this.clientes.add(u);
        fireTableDataChanged();
    }

    public void addLista(List<Cliente> lista) {
        this.clientes = lista;
        fireTableDataChanged();
    }

    public void limpar() {
        this.clientes.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return this.clientes.isEmpty();
    }
}
