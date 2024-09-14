package br.com.manicure.gui.pacote;

import br.com.manicure.dao.factory.DAOFactory;
import br.com.manicure.gui.cliente.EditarCliente;
import br.com.manicure.model.Pacotes;
import br.com.manicure.tabelas.PacotesTable;
import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author John
 */
public class PacoteEditar extends javax.swing.JFrame {

    private final PacotesTable tableModelPacote = new PacotesTable();
    private EditarCliente cliente = null;

    /**
     * Creates new form PacoteEditar
     *
     * @param cliente
     */
    public PacoteEditar(EditarCliente cliente) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/pacotesicon.png")).getImage());
        scrollPanelPacotes.getViewport().setBackground(Color.WHITE);
        scrollPanelPacotes.setBorder(BorderFactory.createEmptyBorder());
        tablePacotes.setShowVerticalLines(false);
        UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
        UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
        UIManager.put("Button.background", Color.WHITE);
        List<Pacotes> lista = DAOFactory.getPacoteDAO().listar();
        if (lista != null) {
            tableModelPacote.addLista(lista);
        }
        tablePacotes.setModel(tableModelPacote);
        this.cliente = cliente;
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
        this.setTitle("Buscar Pacotes");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        input = new javax.swing.JPanel();
        lPesquisar = new javax.swing.JLabel();
        tBuscarPacotes = new javax.swing.JTextField();
        bOkPacote = new javax.swing.JButton();
        bCancelarPacote = new javax.swing.JButton();
        mainCliente = new javax.swing.JPanel();
        scrollPanelPacotes = new javax.swing.JScrollPane();
        tablePacotes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        input.setBackground(new java.awt.Color(247, 247, 247));

        lPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lPesquisar.setText("Pesquisar");
        lPesquisar.setMaximumSize(new java.awt.Dimension(40, 20));
        lPesquisar.setMinimumSize(new java.awt.Dimension(40, 20));
        lPesquisar.setPreferredSize(new java.awt.Dimension(40, 20));

        tBuscarPacotes.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tBuscarPacotesCaretUpdate(evt);
            }
        });

        bOkPacote.setBackground(new java.awt.Color(0, 102, 52));
        bOkPacote.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bOkPacote.setForeground(new java.awt.Color(255, 255, 255));
        bOkPacote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/Ok.png"))); // NOI18N
        bOkPacote.setText("Ok");
        bOkPacote.setBorder(null);
        bOkPacote.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bOkPacote.setDoubleBuffered(true);
        bOkPacote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bOkPacoteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bOkPacoteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bOkPacoteMouseExited(evt);
            }
        });

        bCancelarPacote.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarPacote.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarPacote.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarPacote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/cancelar.png"))); // NOI18N
        bCancelarPacote.setText("Cancelar");
        bCancelarPacote.setBorder(null);
        bCancelarPacote.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bCancelarPacote.setDoubleBuffered(true);
        bCancelarPacote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarPacoteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarPacoteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarPacoteMouseExited(evt);
            }
        });

        mainCliente.setLayout(new java.awt.CardLayout());

        scrollPanelPacotes.setBorder(null);

        tablePacotes.setAutoCreateRowSorter(true);
        tablePacotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePacotes.setDoubleBuffered(true);
        scrollPanelPacotes.setViewportView(tablePacotes);

        mainCliente.add(scrollPanelPacotes, "card2");

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addComponent(lPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tBuscarPacotes))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bOkPacote, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelarPacote, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tBuscarPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mainCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOkPacote, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarPacote, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bOkPacoteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkPacoteMouseEntered
        bOkPacote.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bOkPacoteMouseEntered

    private void bOkPacoteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkPacoteMouseExited
        bOkPacote.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bOkPacoteMouseExited

    private void bCancelarPacoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarPacoteMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarPacoteMouseClicked

    private void bCancelarPacoteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarPacoteMouseEntered
        bCancelarPacote.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarPacoteMouseEntered

    private void bCancelarPacoteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarPacoteMouseExited
        bCancelarPacote.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarPacoteMouseExited

    private void bOkPacoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkPacoteMouseClicked
        int row = this.tablePacotes.getSelectedRow();
        if (row > -1) {
            Pacotes p = this.tableModelPacote.getPacote(row);
            this.cliente.setPacote(p);

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um pacote da tabela", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bOkPacoteMouseClicked

    private void tBuscarPacotesCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tBuscarPacotesCaretUpdate
        filtrar();
    }//GEN-LAST:event_tBuscarPacotesCaretUpdate

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PacoteEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PacoteEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PacoteEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PacoteEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PacoteEditar().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelarPacote;
    private javax.swing.JButton bOkPacote;
    private javax.swing.JPanel input;
    private javax.swing.JLabel lPesquisar;
    private javax.swing.JPanel mainCliente;
    private javax.swing.JScrollPane scrollPanelPacotes;
    private javax.swing.JTextField tBuscarPacotes;
    private javax.swing.JTable tablePacotes;
    // End of variables declaration//GEN-END:variables
    private void filtrar() {
        String busca = this.tBuscarPacotes.getText();
        List<Pacotes> lista;
        lista = DAOFactory.getPacoteDAO().filtrar(busca);
        if (lista != null) {
            this.tableModelPacote.addLista(lista);
        }
        this.tBuscarPacotes.requestFocusInWindow();

    }

}
