/**
 * @author Lais Frigério da Silva
 */
package br.com.manicure.gui.agendamento;

import br.com.manicure.gui.Agenda;
import br.com.manicure.model.Agendamentos;
import br.com.manicure.model.Cliente;
import br.com.manicure.model.Esmalte;
import br.com.manicure.model.Formatacao;
import br.com.manicure.model.Horario;
import br.com.manicure.model.Procedimento;
import br.com.manicure.model.Validacao;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class NovoAgendamento extends javax.swing.JFrame {

    private final Agenda tela;
    private final Agendamentos agenda;
    private final Cliente cliente = null;
    private final Procedimento procedimento = null;
    private final Esmalte esmalte = null;

    public NovoAgendamento(Agenda tela, Agendamentos a) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/calendar.png")).getImage());
        UIManager.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
        UIManager.put("ToolTip.background", Color.decode("#F7F7F7"));
        UIManager.put("ToolTip.border", new LineBorder(Color.decode("#006634"), 1));
        UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
        UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
        UIManager.put("Button.background", Color.WHITE);

        this.tela = tela;
        this.agenda = a;
        this.setTitle("Novo agendamento");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        format.setMaximumFractionDigits(0);
        Formatacao.setDisableTextField(tData);
        Formatacao.setDisableTextField(tHora);
        Formatacao.setDisableTextField(tCliente);
        Formatacao.setDisableTextField(tProcedimento);
        tHora.setText(Formatacao.dateTime2OnlyStringTime(a.getDataAgendamento()));
        tData.setText(Formatacao.dateTime2OnlyStringDate(a.getDataAgendamento()));
        tHora.setEditable(false);
        tData.setEditable(false);

    }

    public NovoAgendamento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
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
        tData = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tHora = new javax.swing.JFormattedTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Usuário");
        setMinimumSize(new java.awt.Dimension(600, 230));
        setResizable(false);

        bg.setBackground(new java.awt.Color(247, 247, 247));

        input.setBackground(new java.awt.Color(247, 247, 247));

        tCliente.setEnabled(false);
        tCliente.setSelectionColor(new java.awt.Color(0, 102, 67));
        tCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tClienteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Cliente");
        jLabel4.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel4.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(211, 0, 0));
        jLabel8.setText("*");
        jLabel8.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel8.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel8.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel14.setText("Observação");
        jLabel14.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel14.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel14.setPreferredSize(new java.awt.Dimension(40, 20));

        bCancelarAgendamento.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarAgendamento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarAgendamento.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/error.png"))); // NOI18N
        bCancelarAgendamento.setText("Cancelar");
        bCancelarAgendamento.setBorder(null);
        bCancelarAgendamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bCancelarAgendamento.setDoubleBuffered(true);
        bCancelarAgendamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bCancelarAgendamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bCancelarAgendamentoFocusLost(evt);
            }
        });
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
        bCancelarAgendamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCancelarAgendamentoKeyPressed(evt);
            }
        });

        bSalvarAgendamento.setBackground(new java.awt.Color(0, 102, 52));
        bSalvarAgendamento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bSalvarAgendamento.setForeground(new java.awt.Color(255, 255, 255));
        bSalvarAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/checked.png"))); // NOI18N
        bSalvarAgendamento.setText("Salvar");
        bSalvarAgendamento.setBorder(null);
        bSalvarAgendamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bSalvarAgendamento.setDoubleBuffered(true);
        bSalvarAgendamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bSalvarAgendamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bSalvarAgendamentoFocusLost(evt);
            }
        });
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

        tObservacao.setColumns(20);
        tObservacao.setRows(5);
        jScrollObservacoes.setViewportView(tObservacao);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Data");
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel3.setMinimumSize(new java.awt.Dimension(40, 20));

        tData.setBackground(new java.awt.Color(240, 240, 240));
        try {
            tData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tData.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(211, 0, 0));
        jLabel13.setText("*");
        jLabel13.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel13.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel13.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Hora");
        jLabel6.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel6.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel6.setPreferredSize(new java.awt.Dimension(40, 20));

        tHora.setBackground(new java.awt.Color(240, 240, 240));
        tHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        tHora.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(211, 0, 0));
        jLabel7.setText("*");
        jLabel7.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel7.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel7.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel20.setText("Endereço ");
        jLabel20.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel20.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel20.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel22.setText("Frete");

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
        bBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarClienteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Procedimento");
        jLabel5.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel5.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel5.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(211, 0, 0));
        jLabel15.setText("*");
        jLabel15.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel15.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel15.setPreferredSize(new java.awt.Dimension(5, 20));

        tProcedimento.setEnabled(false);
        tProcedimento.setSelectionColor(new java.awt.Color(0, 102, 67));

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
        bBuscarProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarProcedimentoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel21.setText("Cor do Esmalte");
        jLabel21.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel21.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel21.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(211, 0, 0));
        jLabel23.setText("*");
        jLabel23.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel23.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel23.setPreferredSize(new java.awt.Dimension(5, 20));

        tCorEsmalte.setEnabled(false);
        tCorEsmalte.setSelectionColor(new java.awt.Color(0, 102, 67));

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
        bBuscarCorEsmalte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarCorEsmalteActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(211, 0, 0));
        jLabel24.setText("*");
        jLabel24.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel24.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel24.setPreferredSize(new java.awt.Dimension(5, 20));

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                .addGap(36, 36, Short.MAX_VALUE)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tData, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(bSalvarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bCancelarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputLayout.createSequentialGroup()
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23))
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputLayout.createSequentialGroup()
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(tCorEsmalte, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bBuscarProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bBuscarCorEsmalte, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(109, 109, 109)))
                .addGap(47, 47, 47))
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inputLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bBuscarProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bBuscarCorEsmalte, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tCorEsmalte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(tFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bCancelarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bSalvarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(238, 238, 238))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSalvarAgendamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoMouseExited
        bSalvarAgendamento.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarAgendamentoMouseExited

    private void bSalvarAgendamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoMouseEntered
        bSalvarAgendamento.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarAgendamentoMouseEntered

    private void bSalvarAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoMouseClicked
        if (this.cliente == null) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar um Cliente", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (this.procedimento == null) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar um Procedimento", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!Validacao.dateIsValid(tData.getText())) {
            JOptionPane.showMessageDialog(null, "Informe uma data válida", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!Validacao.isEmpty(tEndereco.getText())) {
            JOptionPane.showMessageDialog(null, "O campo Endereço deve ser preenchido", "Atenção", JOptionPane.WARNING_MESSAGE);
        }

        /* switch (ac.cadastrar(this.agenda)) {
            case 0:
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar o cadastro. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.ERROR_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Agendamento efetuado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                if (this.tela.getTDate().getDate() != null) {
                    List<Horario> lista = ac.agendamentos(Formatacao.date2StringScreen(this.tela.getTDate().getDate()));
                    if (lista != null) {
                        this.tela.tableModelAgenda.addLista(lista);
                        for (int i = 0; i < 20; i++) {
                            this.tela.getTableAgenda().setRowHeight(i, 30);
                        }
                        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                        this.tela.getTableAgenda().getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                        this.tela.getTableAgenda().getColumnModel().getColumn(0).setMinWidth(100);
                        this.tela.getTableAgenda().getColumnModel().getColumn(0).setMaxWidth(100);
                    }
                }
                this.dispose();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Não foi possível replicar o agendamento, por motivo de horário cheio.", "Atenção", JOptionPane.ERROR_MESSAGE);
                break;
        }*/
    }//GEN-LAST:event_bSalvarAgendamentoMouseClicked

    private void bSalvarAgendamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoFocusLost
        bSalvarAgendamento.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarAgendamentoFocusLost

    private void bSalvarAgendamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoFocusGained
        bSalvarAgendamento.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarAgendamentoFocusGained

    private void bCancelarAgendamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoKeyPressed
        // this.agenda.setConsulta(null);
        this.dispose();
    }//GEN-LAST:event_bCancelarAgendamentoKeyPressed

    private void bCancelarAgendamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoMouseExited
        bCancelarAgendamento.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarAgendamentoMouseExited

    private void bCancelarAgendamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoMouseEntered
        bCancelarAgendamento.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarAgendamentoMouseEntered

    private void bCancelarAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoMouseClicked
        //  this.agenda.setConsulta(null);
        this.dispose();
    }//GEN-LAST:event_bCancelarAgendamentoMouseClicked

    private void bCancelarAgendamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoFocusLost
        bCancelarAgendamento.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarAgendamentoFocusLost

    private void bCancelarAgendamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoFocusGained
        bCancelarAgendamento.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarAgendamentoFocusGained

    private void bBuscarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarClienteMouseClicked
        bBuscarCliente.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bBuscarClienteMouseClicked

    private void bBuscarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarClienteMouseEntered
        bBuscarCliente.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bBuscarClienteMouseEntered

    private void bBuscarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarClienteMouseExited
        bBuscarCliente.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bBuscarClienteMouseExited

    private void bBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarClienteActionPerformed

    private void bBuscarProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarProcedimentoMouseClicked

    private void bBuscarProcedimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarProcedimentoMouseEntered

    private void bBuscarProcedimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarProcedimentoMouseExited

    private void bBuscarProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarProcedimentoActionPerformed

    private void bBuscarCorEsmalteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarCorEsmalteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarCorEsmalteMouseClicked

    private void bBuscarCorEsmalteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarCorEsmalteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarCorEsmalteMouseEntered

    private void bBuscarCorEsmalteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarCorEsmalteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarCorEsmalteMouseExited

    private void bBuscarCorEsmalteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarCorEsmalteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarCorEsmalteActionPerformed

    private void tClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tClienteActionPerformed

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
            java.util.logging.Logger.getLogger(NovoAgendamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoAgendamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoAgendamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoAgendamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscarCliente;
    private javax.swing.JButton bBuscarCorEsmalte;
    private javax.swing.JButton bBuscarProcedimento;
    private javax.swing.JButton bCancelarAgendamento;
    private javax.swing.JButton bSalvarAgendamento;
    private javax.swing.JPanel bg;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JFormattedTextField tData;
    private javax.swing.JTextField tEndereco;
    private javax.swing.JTextField tFrete;
    private javax.swing.JFormattedTextField tHora;
    private javax.swing.JTextArea tObservacao;
    private javax.swing.JTextField tProcedimento;
    // End of variables declaration//GEN-END:variables
}
