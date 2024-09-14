package br.com.manicure.esmalte;

import br.com.manicure.dao.factory.DAOFactory;
import br.com.manicure.gui.Agenda;
import br.com.manicure.model.Esmalte;
import br.com.manicure.model.Validacao;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author John
 */
public class NovoEsmalte extends javax.swing.JFrame {

    private final Agenda tela;

    /**
     * Creates new form NovoEsmalte
     *
     * @param tela
     */
    public NovoEsmalte(Agenda tela) {
        initComponents();
        this.tela = tela;
        this.setTitle("Novo Esmalte");
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/iconesmalte.png")).getImage());
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
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelNome = new javax.swing.JTextField();
        bSalvarEsmalte = new javax.swing.JButton();
        bCancelarEsmalte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        input.setBackground(new java.awt.Color(247, 247, 247));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(211, 0, 0));
        jLabel5.setText("*");
        jLabel5.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel5.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel5.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Nome");
        jLabel1.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel1.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel1.setPreferredSize(new java.awt.Dimension(40, 20));

        bSalvarEsmalte.setBackground(new java.awt.Color(0, 102, 52));
        bSalvarEsmalte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bSalvarEsmalte.setForeground(new java.awt.Color(255, 255, 255));
        bSalvarEsmalte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/Ok.png"))); // NOI18N
        bSalvarEsmalte.setText("Salvar");
        bSalvarEsmalte.setBorder(null);
        bSalvarEsmalte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bSalvarEsmalte.setDoubleBuffered(true);
        bSalvarEsmalte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSalvarEsmalteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bSalvarEsmalteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bSalvarEsmalteMouseExited(evt);
            }
        });

        bCancelarEsmalte.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarEsmalte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarEsmalte.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarEsmalte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/cancelar.png"))); // NOI18N
        bCancelarEsmalte.setText("Cancelar");
        bCancelarEsmalte.setBorder(null);
        bCancelarEsmalte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bCancelarEsmalte.setDoubleBuffered(true);
        bCancelarEsmalte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarEsmalteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarEsmalteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarEsmalteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(bSalvarEsmalte, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelarEsmalte, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvarEsmalte, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarEsmalte, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSalvarEsmalteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarEsmalteMouseEntered
        bSalvarEsmalte.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarEsmalteMouseEntered

    private void bSalvarEsmalteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarEsmalteMouseExited
        bSalvarEsmalte.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarEsmalteMouseExited

    private void bCancelarEsmalteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarEsmalteMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarEsmalteMouseClicked

    private void bCancelarEsmalteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarEsmalteMouseEntered
        bCancelarEsmalte.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarEsmalteMouseEntered

    private void bCancelarEsmalteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarEsmalteMouseExited
        bCancelarEsmalte.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarEsmalteMouseExited

    private void bSalvarEsmalteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarEsmalteMouseClicked
        registrar();
    }//GEN-LAST:event_bSalvarEsmalteMouseClicked

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
            java.util.logging.Logger.getLogger(NovoEsmalte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoEsmalte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoEsmalte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoEsmalte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoEsmalte().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelarEsmalte;
    private javax.swing.JButton bSalvarEsmalte;
    private javax.swing.JPanel input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField labelNome;
    // End of variables declaration//GEN-END:variables
    private void registrar() {
        String nome = labelNome.getText();
        if (Validacao.isEmpty(nome)) {
            JOptionPane.showMessageDialog(null, "O campo nome é obrigatório", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            Esmalte e = new Esmalte();
            e.setCor(nome);

            DAOFactory.getEsmalteDAO().cadastrar(e);
            JOptionPane.showMessageDialog(null, "O cadastro foi efetuado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            List<Esmalte> lista = DAOFactory.getEsmalteDAO().listar();
            if (lista != null) {
                this.tela.tableModelEsmalte.addLista(lista);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar o cadastro. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

}
