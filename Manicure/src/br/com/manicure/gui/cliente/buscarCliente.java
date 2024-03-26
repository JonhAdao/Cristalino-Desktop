/**
 * @author Lais Frigério da Silva
 */
package br.com.manicure.gui.cliente;

import br.com.manicure.model.Cliente;
import br.com.manicure.model.Formatacao;
import br.com.manicure.model.Validacao;
import br.com.manicure.tabelas.ClienteTable;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class buscarCliente extends javax.swing.JFrame {

    private final ClienteTable tableModelCliente = new ClienteTable();

    public buscarCliente() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/doctor.png")).getImage());
        tBuscarCliente.setBorder(BorderFactory.createEtchedBorder(0));
        scrollPanelClientes.getViewport().setBackground(Color.WHITE);
        scrollPanelClientes.setBorder(BorderFactory.createEmptyBorder());
        tableClientes.setShowVerticalLines(false);
        tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableClientes.getColumnModel().getColumn(0).setPreferredWidth(10);
        tableClientes.getColumnModel().getColumn(1).setPreferredWidth(270);
        tableClientes.getColumnModel().getColumn(2).setPreferredWidth(10);
        tableClientes.getColumnModel().getColumn(3).setPreferredWidth(10);
        UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
        UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
        UIManager.put("Button.background", Color.WHITE);
        List<Cliente> lista = null;
        if (lista != null) {
            ;
        }
        //  tableClientes.setModel(tableModelPaciente);
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
        this.setTitle("Buscar Paciente");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        input = new javax.swing.JPanel();
        lPesquisar = new javax.swing.JLabel();
        tPesquisar = new javax.swing.JTextField();
        bOkCliente = new javax.swing.JButton();
        bCancelarCliente = new javax.swing.JButton();
        tBuscarCliente = new javax.swing.JButton();
        mainCliente = new javax.swing.JPanel();
        scrollPanelClientes = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Paciente");
        setMinimumSize(new java.awt.Dimension(600, 230));
        setResizable(false);

        bg.setBackground(new java.awt.Color(247, 247, 247));

        input.setBackground(new java.awt.Color(247, 247, 247));

        lPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lPesquisar.setText("Pesquisar");
        lPesquisar.setMaximumSize(new java.awt.Dimension(40, 20));
        lPesquisar.setMinimumSize(new java.awt.Dimension(40, 20));
        lPesquisar.setPreferredSize(new java.awt.Dimension(40, 20));

        bOkCliente.setBackground(new java.awt.Color(0, 102, 52));
        bOkCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bOkCliente.setForeground(new java.awt.Color(255, 255, 255));
        bOkCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/Ok.png"))); // NOI18N
        bOkCliente.setText("Ok");
        bOkCliente.setBorder(null);
        bOkCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bOkCliente.setDoubleBuffered(true);
        bOkCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bOkClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bOkClienteFocusLost(evt);
            }
        });
        bOkCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bOkClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bOkClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bOkClienteMouseExited(evt);
            }
        });

        bCancelarCliente.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarCliente.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/cancelar.png"))); // NOI18N
        bCancelarCliente.setText("Cancelar");
        bCancelarCliente.setBorder(null);
        bCancelarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bCancelarCliente.setDoubleBuffered(true);
        bCancelarCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bCancelarClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bCancelarClienteFocusLost(evt);
            }
        });
        bCancelarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarClienteMouseExited(evt);
            }
        });
        bCancelarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCancelarClienteKeyPressed(evt);
            }
        });

        tBuscarCliente.setBackground(new java.awt.Color(0, 102, 52));
        tBuscarCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tBuscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        tBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/pesquisar.png"))); // NOI18N
        tBuscarCliente.setText("Pesquisar");
        tBuscarCliente.setBorder(null);
        tBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tBuscarCliente.setDoubleBuffered(true);
        tBuscarCliente.setFocusPainted(false);
        tBuscarCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tBuscarClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tBuscarClienteFocusLost(evt);
            }
        });
        tBuscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tBuscarClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tBuscarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tBuscarClienteMouseExited(evt);
            }
        });
        tBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tBuscarClienteKeyPressed(evt);
            }
        });

        mainCliente.setLayout(new java.awt.CardLayout());

        scrollPanelClientes.setBorder(null);

        tableClientes.setAutoCreateRowSorter(true);
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tableClientes.setDoubleBuffered(true);
        scrollPanelClientes.setViewportView(tableClientes);

        mainCliente.add(scrollPanelClientes, "card2");

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addComponent(lPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bOkCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tBuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mainCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOkCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bOkClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkClienteMouseClicked
        /*   int row = this.tableClientes.getSelectedRow();
        if(row > -1){
            Cliente p = this.tableModelCliente.getPaciente(row);
            this.telaAtecedente.setPaciente(p);
            this.telaAtecedente.setNomePaciente(p.getNome());
            this.telaAtecedente.setCodigoPaciente(p.getId());                  
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um paciente da tabela", "Atenção", JOptionPane.WARNING_MESSAGE);
        }*/
    }//GEN-LAST:event_bOkClienteMouseClicked

    private void bOkClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkClienteMouseEntered
        bOkCliente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bOkClienteMouseEntered

    private void bOkClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkClienteMouseExited
        bOkCliente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bOkClienteMouseExited

    private void bCancelarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarClienteMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarClienteMouseClicked

    private void bCancelarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarClienteMouseEntered
        bCancelarCliente.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarClienteMouseEntered

    private void bCancelarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarClienteMouseExited
        bCancelarCliente.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarClienteMouseExited

    private void bCancelarClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarClienteFocusGained
        bCancelarCliente.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarClienteFocusGained

    private void bCancelarClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarClienteFocusLost
        bCancelarCliente.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarClienteFocusLost

    private void bOkClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bOkClienteFocusGained
        bOkCliente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bOkClienteFocusGained

    private void bOkClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bOkClienteFocusLost
        bOkCliente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bOkClienteFocusLost

    private void bCancelarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarClienteKeyPressed
        this.dispose();
    }//GEN-LAST:event_bCancelarClienteKeyPressed

    private void tBuscarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBuscarClienteMouseEntered
        tBuscarCliente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_tBuscarClienteMouseEntered

    private void tBuscarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBuscarClienteMouseExited
        tBuscarCliente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_tBuscarClienteMouseExited

    private void tBuscarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBuscarClienteMouseClicked
        this.search();
    }//GEN-LAST:event_tBuscarClienteMouseClicked

    private void tBuscarClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tBuscarClienteFocusGained
        tBuscarCliente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_tBuscarClienteFocusGained

    private void tBuscarClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tBuscarClienteFocusLost
        tBuscarCliente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_tBuscarClienteFocusLost

    private void tBuscarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tBuscarClienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.search();
        }
    }//GEN-LAST:event_tBuscarClienteKeyPressed

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
            java.util.logging.Logger.getLogger(buscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelarCliente;
    private javax.swing.JButton bOkCliente;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel input;
    private javax.swing.JLabel lPesquisar;
    private javax.swing.JPanel mainCliente;
    private javax.swing.JScrollPane scrollPanelClientes;
    private javax.swing.JButton tBuscarCliente;
    private javax.swing.JTextField tPesquisar;
    private javax.swing.JTable tableClientes;
    // End of variables declaration//GEN-END:variables

    private void search() {
        /*  String busca = this.tPesquisar.getText();
        List<Cliente> lista;
        if(!Validacao.isEmpty(busca)) {
            if(Validacao.isDate(busca))
                busca = Formatacao.removeDateMask(busca);
            lista = pc.pacientes(busca);
            if(lista != null)
                this.tableModelPaciente.addLista(lista);
            else
                this.tableModelPaciente.limpar();
        } else {
            lista = pc.pacientes();
            if(lista != null)
                this.tableModelPaciente.addLista(lista);
            else
                this.tableModelPaciente.limpar();
        }
        this.tPesquisar.requestFocusInWindow();
    }
}*/
    }
}
