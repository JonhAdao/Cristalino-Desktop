package br.com.manicure.gui.agendamento;

import br.com.manicure.DAO.AgendamentosDAO;
import br.com.manicure.dao.factory.DAOFactory;
import br.com.manicure.esmalte.EsmalteEditar;
import br.com.manicure.gui.Agenda;
import br.com.manicure.gui.cliente.ClienteEditar;
import br.com.manicure.gui.procedimentos.ProcedimentoEditar;
import br.com.manicure.model.Agendamentos;
import br.com.manicure.model.Cliente;
import br.com.manicure.model.Esmalte;
import br.com.manicure.model.Procedimento;
import java.awt.Color;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author John
 */
public class EditarAgendamento extends javax.swing.JFrame {

    private final Agenda agenda;
    private final Agendamentos agendamentos;
    private Cliente cliente = null;
    private Procedimento procedimento = null;
    private Esmalte esmalte = null;

    /**
     * Creates new form EditarAgendamento
     *
     * @param a
     * @param ag
     */
    public EditarAgendamento(Agenda a, Agendamentos ag) {
        initComponents();
        this.agenda = a;
        this.agendamentos = ag;
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        this.setTitle("Editar Agendamento");

        tCliente.setText(ag.getCliente().getNome());
        tProcedimento.setText(ag.getProcedimento().getNome());
        tCorEsmalte.setText(ag.getCorEsmalte().getCor());
        tDate.setDate(ag.getDataAgendamento());
        boxHora.setSelectedItem(ag.getHorario());
        tEndereco.setText(ag.getCliente().getEndereco().getRua());
        if (ag.getFrete() != null) {
            tFrete.setText(String.valueOf(ag.getFrete()));
        } else {
            tFrete.setText(" ");
        }
        if (ag.getObservacao() != null) {
            tObservacao.setText(ag.getObservacao());
        } else {
            tObservacao.setText(" ");
        }
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
        tCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bCancelarAgendamento = new javax.swing.JButton();
        bSalvarAgendamento = new javax.swing.JButton();
        jScrollObservacoes = new javax.swing.JScrollPane();
        tObservacao = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tEndereco = new javax.swing.JTextField();
        bBuscarCliente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tProcedimento = new javax.swing.JTextField();
        bBuscarProcedimento = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tCorEsmalte = new javax.swing.JTextField();
        bBuscarCorEsmalte = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        tFrete = new javax.swing.JTextField();
        tDate = new com.toedter.calendar.JDateChooser();
        boxHora = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        input.setBackground(new java.awt.Color(247, 247, 247));
        input.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tCliente.setEnabled(false);
        tCliente.setSelectionColor(new java.awt.Color(0, 102, 67));
        input.add(tCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 254, 34));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Cliente");
        jLabel4.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel4.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 20));
        input.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(211, 0, 0));
        jLabel8.setText("*");
        jLabel8.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel8.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel8.setPreferredSize(new java.awt.Dimension(5, 20));
        input.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 15, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel14.setText("Observação");
        jLabel14.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel14.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel14.setPreferredSize(new java.awt.Dimension(40, 20));
        input.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 75, -1));

        bCancelarAgendamento.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarAgendamento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarAgendamento.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/cancelar.png"))); // NOI18N
        bCancelarAgendamento.setText("Cancelar");
        bCancelarAgendamento.setBorder(null);
        bCancelarAgendamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bCancelarAgendamento.setDoubleBuffered(true);
        bCancelarAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarAgendamentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarAgendamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarAgendamentoMouseExited(evt);
            }
        });
        input.add(bCancelarAgendamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, 110, 40));

        bSalvarAgendamento.setBackground(new java.awt.Color(0, 102, 52));
        bSalvarAgendamento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bSalvarAgendamento.setForeground(new java.awt.Color(255, 255, 255));
        bSalvarAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/Ok.png"))); // NOI18N
        bSalvarAgendamento.setText("Salvar");
        bSalvarAgendamento.setBorder(null);
        bSalvarAgendamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bSalvarAgendamento.setDoubleBuffered(true);
        bSalvarAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSalvarAgendamentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bSalvarAgendamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bSalvarAgendamentoMouseExited(evt);
            }
        });
        input.add(bSalvarAgendamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 480, 110, 40));

        tObservacao.setColumns(20);
        tObservacao.setRows(5);
        jScrollObservacoes.setViewportView(tObservacao);

        input.add(jScrollObservacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 390, 110));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Data");
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel3.setMinimumSize(new java.awt.Dimension(40, 20));
        input.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(211, 0, 0));
        jLabel13.setText("*");
        jLabel13.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel13.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel13.setPreferredSize(new java.awt.Dimension(5, 20));
        input.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 10, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Hora");
        jLabel6.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel6.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel6.setPreferredSize(new java.awt.Dimension(40, 20));
        input.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 34, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(211, 0, 0));
        jLabel7.setText("*");
        jLabel7.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel7.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel7.setPreferredSize(new java.awt.Dimension(5, 20));
        input.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 16, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel20.setText("Endereço ");
        jLabel20.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel20.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel20.setPreferredSize(new java.awt.Dimension(40, 20));
        input.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 67, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel22.setText("Frete");
        input.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 50, -1));

        tEndereco.setEnabled(false);
        input.add(tEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 374, 35));

        bBuscarCliente.setBackground(new java.awt.Color(232, 121, 22));
        bBuscarCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/pesquisar.png"))); // NOI18N
        bBuscarCliente.setBorder(null);
        bBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBuscarCliente.setDoubleBuffered(true);
        bBuscarCliente.setFocusPainted(false);
        bBuscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuscarClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBuscarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBuscarClienteMouseExited(evt);
            }
        });
        input.add(bBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 50, 34));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Procedimento");
        jLabel5.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel5.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel5.setPreferredSize(new java.awt.Dimension(40, 20));
        input.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 89, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(211, 0, 0));
        jLabel15.setText("*");
        jLabel15.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel15.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel15.setPreferredSize(new java.awt.Dimension(5, 20));
        input.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 15, -1));

        tProcedimento.setEnabled(false);
        tProcedimento.setSelectionColor(new java.awt.Color(0, 102, 67));
        input.add(tProcedimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 254, 34));

        bBuscarProcedimento.setBackground(new java.awt.Color(232, 121, 22));
        bBuscarProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarProcedimento.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/pesquisar.png"))); // NOI18N
        bBuscarProcedimento.setBorder(null);
        bBuscarProcedimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBuscarProcedimento.setDoubleBuffered(true);
        bBuscarProcedimento.setFocusPainted(false);
        bBuscarProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuscarProcedimentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBuscarProcedimentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBuscarProcedimentoMouseExited(evt);
            }
        });
        input.add(bBuscarProcedimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 51, 34));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel21.setText("Cor do Esmalte");
        jLabel21.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel21.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel21.setPreferredSize(new java.awt.Dimension(40, 20));
        input.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 103, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(211, 0, 0));
        jLabel23.setText("*");
        jLabel23.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel23.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel23.setPreferredSize(new java.awt.Dimension(5, 20));
        input.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 15, -1));

        tCorEsmalte.setEnabled(false);
        tCorEsmalte.setSelectionColor(new java.awt.Color(0, 102, 67));
        input.add(tCorEsmalte, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 254, 34));

        bBuscarCorEsmalte.setBackground(new java.awt.Color(232, 121, 22));
        bBuscarCorEsmalte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarCorEsmalte.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarCorEsmalte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/pesquisar.png"))); // NOI18N
        bBuscarCorEsmalte.setBorder(null);
        bBuscarCorEsmalte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBuscarCorEsmalte.setDoubleBuffered(true);
        bBuscarCorEsmalte.setFocusPainted(false);
        bBuscarCorEsmalte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuscarCorEsmalteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBuscarCorEsmalteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBuscarCorEsmalteMouseExited(evt);
            }
        });
        input.add(bBuscarCorEsmalte, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 51, 34));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(211, 0, 0));
        jLabel24.setText("*");
        jLabel24.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel24.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel24.setPreferredSize(new java.awt.Dimension(5, 20));
        input.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 16, -1));
        input.add(tFrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 254, 35));
        input.add(tDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 190, 150, 30));

        boxHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "             ", "09:00:00", "09:30:00", "10:00:00", "10:30:00", "11:00:00", "11:30:00", "12:00:00", "13:00:00", "13:30:00", "14:00:00", "14:30:00", "15:00:00", "15:30:00", "16:00:00", "16:30:00", "17:00:00", "17:30:00", "18:00:00" }));
        input.add(boxHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 134, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarAgendamentoMouseClicked

    private void bCancelarAgendamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoMouseEntered
        bCancelarAgendamento.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarAgendamentoMouseEntered

    private void bCancelarAgendamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoMouseExited
        bCancelarAgendamento.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarAgendamentoMouseExited

    private void bSalvarAgendamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoMouseEntered
        bSalvarAgendamento.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarAgendamentoMouseEntered

    private void bSalvarAgendamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoMouseExited
        bSalvarAgendamento.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarAgendamentoMouseExited

    private void bBuscarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarClienteMouseClicked
        bBuscarCliente.setBackground(Color.decode("#E87916"));
        ClienteEditar ce = new ClienteEditar(this);
        ce.setVisible(true);

    }//GEN-LAST:event_bBuscarClienteMouseClicked

    private void bBuscarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarClienteMouseEntered
        bBuscarCliente.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bBuscarClienteMouseEntered

    private void bBuscarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarClienteMouseExited
        bBuscarCliente.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bBuscarClienteMouseExited

    private void bBuscarProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoMouseClicked
        bBuscarProcedimento.setBackground(Color.decode("#E87916"));
        ProcedimentoEditar pe = new ProcedimentoEditar(this);
        pe.setVisible(true);
    }//GEN-LAST:event_bBuscarProcedimentoMouseClicked

    private void bBuscarProcedimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoMouseEntered
        bBuscarProcedimento.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bBuscarProcedimentoMouseEntered

    private void bBuscarProcedimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoMouseExited
        bBuscarProcedimento.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bBuscarProcedimentoMouseExited

    private void bBuscarCorEsmalteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarCorEsmalteMouseClicked
        bBuscarCorEsmalte.setBackground(Color.decode("#E87916"));
        EsmalteEditar ee = new EsmalteEditar(this);
        ee.setVisible(true);
    }//GEN-LAST:event_bBuscarCorEsmalteMouseClicked

    private void bBuscarCorEsmalteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarCorEsmalteMouseEntered
        bBuscarCorEsmalte.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bBuscarCorEsmalteMouseEntered

    private void bBuscarCorEsmalteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarCorEsmalteMouseExited
        bBuscarCorEsmalte.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bBuscarCorEsmalteMouseExited

    private void bSalvarAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoMouseClicked

        if (tDate.getDate() == null) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar uma data", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (boxHora.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar um horario", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Agendamentos a = new Agendamentos();
        int indice = boxHora.getSelectedIndex();
        String horas = boxHora.getItemAt(indice);

        a.setId(agendamentos.getId());

        if (cliente != null) {
            a.setCliente(cliente);
        } else {
            a.setCliente(agendamentos.getCliente());
        }

        if (procedimento != null) {
            a.setProcedimento(procedimento);
        } else {
            a.setProcedimento(agendamentos.getProcedimento());
        }

        if (esmalte != null) {
            a.setCorEsmalte(esmalte);
        } else {
            a.setCorEsmalte(agendamentos.getCorEsmalte());
        }

        a.setDataAgendamento(new Timestamp(tDate.getDate().getTime()));
        if (!tFrete.getText().isEmpty()) {
            a.setFrete(Double.valueOf(tFrete.getText()));
        }

        a.setHorario(horas);
        a.setObservacao(tObservacao.getText());
        if (a.getFrete() != null) {
            a.setValoraPagar(a.getFrete() + agendamentos.getProcedimento().getValor());
        } else {
            a.setValoraPagar(agendamentos.getProcedimento().getValor());
        }

        DAOFactory.getAgendamentoDAO().editar(a);

        JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        List<Agendamentos> lista = DAOFactory.getAgendamentoDAO().listar();
        if (lista != null) {
            this.agenda.tableModelAgendamento.addLista(lista);

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao editar o agendamento. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_bSalvarAgendamentoMouseClicked

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
            java.util.logging.Logger.getLogger(EditarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarAgendamento().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscarCliente;
    private javax.swing.JButton bBuscarCorEsmalte;
    private javax.swing.JButton bBuscarProcedimento;
    private javax.swing.JButton bCancelarAgendamento;
    private javax.swing.JButton bSalvarAgendamento;
    private javax.swing.JComboBox<String> boxHora;
    private javax.swing.JPanel input;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollObservacoes;
    private javax.swing.JTextField tCliente;
    private javax.swing.JTextField tCorEsmalte;
    private com.toedter.calendar.JDateChooser tDate;
    private javax.swing.JTextField tEndereco;
    private javax.swing.JTextField tFrete;
    private javax.swing.JTextArea tObservacao;
    private javax.swing.JTextField tProcedimento;
    // End of variables declaration//GEN-END:variables

    public void setProcedimento(Procedimento p) {
        this.procedimento = p;
        tProcedimento.setText(procedimento.getNome());

    }

    public void setCorEsmalte(Esmalte e) {
        this.esmalte = e;
        tCorEsmalte.setText(esmalte.getCor());

    }

    public void setCliente(Cliente c) {
        this.cliente = c;
        tCliente.setText(cliente.getNome());
        tEndereco.setText(cliente.getEndereco().getRua() + " Nº " + String.valueOf(cliente.getEndereco().getNumero()));
    }
}
