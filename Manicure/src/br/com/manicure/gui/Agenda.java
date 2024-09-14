package br.com.manicure.gui;

import br.com.manicure.DAO.AgendaDAO;
import br.com.manicure.DAO.ClientesDAO;
import br.com.manicure.DAO.HorarioDAO;
import br.com.manicure.DAO.PacotesDAO;
import br.com.manicure.DAO.UsuarioDAO;
import br.com.manicure.dao.factory.DAOFactory;
import br.com.manicure.esmalte.EditarEsmalte;
import br.com.manicure.esmalte.NovoEsmalte;
import br.com.manicure.model.Horario;
import br.com.manicure.gui.procedimentos.NovoProcedimento;
import br.com.manicure.tabelas.AgendaTable;
import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import br.com.manicure.gui.agendamento.EditarAgendamento;
import br.com.manicure.gui.agendamento.NovoAgendamento;
import br.com.manicure.gui.cliente.EditarCliente;
import br.com.manicure.gui.cliente.NovoCliente;
import br.com.manicure.gui.pacote.EditarPacote;
import br.com.manicure.gui.pacote.NovoPacote;
import br.com.manicure.gui.procedimentos.EditarProcedimento;
import br.com.manicure.gui.usuarios.EditarUsuario;
import br.com.manicure.gui.usuarios.NovoUsuario;
import br.com.manicure.model.Agendamentos;
import br.com.manicure.model.Cliente;
import br.com.manicure.model.Esmalte;
import br.com.manicure.model.Formatacao;
import br.com.manicure.model.Pacotes;
import br.com.manicure.model.Procedimento;
import br.com.manicure.model.Usuarios;
import br.com.manicure.tabelas.AgendamentoTable;
import br.com.manicure.tabelas.ClienteTable;
import br.com.manicure.tabelas.EsmalteTable;
import br.com.manicure.tabelas.PacotesTable;
import br.com.manicure.tabelas.ProcedimentoTable;
import br.com.manicure.tabelas.UsuarioTable;
import java.awt.Font;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author John
 */
public class Agenda extends javax.swing.JFrame {

    private int clickTela;
    AgendaTable tableModelAgenda = new AgendaTable();
    public AgendamentoTable tableModelAgendamento = new AgendamentoTable();
    public ProcedimentoTable tableModelProcedimentos = new ProcedimentoTable();
    public ClienteTable tableModelClientes = new ClienteTable();
    public PacotesTable tableModelPacotes = new PacotesTable();
    public UsuarioTable tableModelUsuario = new UsuarioTable();
    public EsmalteTable tableModelEsmalte = new EsmalteTable();
    private List<Horario> horarios = null;

    public Agenda() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        sidebarScroll.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelAgenda.getViewport().setBackground(Color.WHITE);
        scrollPanelAgenda.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelAgendamentos.getViewport().setBackground(Color.WHITE);
        scrollPanelAgendamentos.setBorder(BorderFactory.createEmptyBorder());
        sidebarScroll.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelClientes.getViewport().setBackground(Color.WHITE);
        scrollPanelClientes.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelUsuarios.getViewport().setBackground(Color.WHITE);
        scrollPanelUsuarios.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelPacotes.getViewport().setBackground(Color.WHITE);
        scrollPanelPacotes.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelEsmalte.getViewport().setBackground(Color.WHITE);
        scrollPanelEsmalte.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelProcedimentos.getViewport().setBackground(Color.WHITE);
        scrollPanelProcedimentos.setBorder(BorderFactory.createEmptyBorder());
        tablePacotes.setShowVerticalLines(false);
        tablePacotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableClientes.setShowVerticalLines(false);
        tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableUsuario.setShowVerticalLines(false);
        tableUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableEsmalte.setShowVerticalLines(false);
        tableEsmalte.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableEsmalte.setAutoResizeMode(1);
        tableProcedimentos.setShowVerticalLines(false);
        tableProcedimentos.setRowMargin(NORMAL);
        tableProcedimentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableAgenda.setShowVerticalLines(false);
        tableAgenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableAgendamentos.setShowVerticalLines(false);
        tableAgendamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        Date date = new Date();
        tDate.setDate(date);
        updateAgendaConteudo();
        setHorarios();
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/icone_agendaTELA.png")).getImage());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        contentAgenda = new javax.swing.JPanel();
        headerAgenda = new javax.swing.JPanel();
        iconContentHomeAgenda = new javax.swing.JLabel();
        pathContentHomeAgenda = new javax.swing.JLabel();
        navButtonsAgenda = new javax.swing.JPanel();
        tDate = new com.toedter.calendar.JDateChooser();
        lVoltar = new javax.swing.JLabel();
        lAvancar = new javax.swing.JLabel();
        mainAgenda = new javax.swing.JPanel();
        scrollPanelAgenda = new javax.swing.JScrollPane();
        tableAgenda = new javax.swing.JTable();
        bAgendamentos = new javax.swing.JButton();
        contentCliente = new javax.swing.JPanel();
        headerClientes = new javax.swing.JPanel();
        iconContentHomeCliente = new javax.swing.JLabel();
        pathContentHomeCliente = new javax.swing.JLabel();
        pathCliente = new javax.swing.JLabel();
        navButtonsClientes = new javax.swing.JPanel();
        bNovoCliente = new javax.swing.JButton();
        bEditarCliente = new javax.swing.JButton();
        lPesquisarCliente = new javax.swing.JLabel();
        tBuscarCliente = new javax.swing.JTextField();
        bRemoverCliente = new javax.swing.JButton();
        mainClientes = new javax.swing.JPanel();
        scrollPanelClientes = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        contentUsuarios = new javax.swing.JPanel();
        headerUsuarios = new javax.swing.JPanel();
        pathUsuarios = new javax.swing.JLabel();
        pathContentHomeUsuarios = new javax.swing.JLabel();
        iconContentHomeUsuarios = new javax.swing.JLabel();
        navButtonsUsuarios = new javax.swing.JPanel();
        bNovoUsuario = new javax.swing.JButton();
        bEditarUsuario = new javax.swing.JButton();
        lPesquisarUsuario = new javax.swing.JLabel();
        tBuscarUsuario = new javax.swing.JTextField();
        bRemoverUsuario = new javax.swing.JButton();
        mainUsuarios = new javax.swing.JPanel();
        scrollPanelUsuarios = new javax.swing.JScrollPane();
        tableUsuario = new javax.swing.JTable();
        contentPacotes = new javax.swing.JPanel();
        headerPacotes = new javax.swing.JPanel();
        iconContentHomePacotes = new javax.swing.JLabel();
        pathContentHomePacotes = new javax.swing.JLabel();
        pathPacotes = new javax.swing.JLabel();
        navButtonsPacotes = new javax.swing.JPanel();
        bNovoPacotes = new javax.swing.JButton();
        bEditarPacotes = new javax.swing.JButton();
        lPesquisarPacotes = new javax.swing.JLabel();
        tBuscarPacotes = new javax.swing.JTextField();
        bRemoverPacotes = new javax.swing.JButton();
        mainPacotes = new javax.swing.JPanel();
        scrollPanelPacotes = new javax.swing.JScrollPane();
        tablePacotes = new javax.swing.JTable();
        contentEsmalte = new javax.swing.JPanel();
        headerEsmalte = new javax.swing.JPanel();
        iconContentHomeEsmalte = new javax.swing.JLabel();
        pathContentHomeEsmalte = new javax.swing.JLabel();
        pathEsmalte = new javax.swing.JLabel();
        navButtonsEsmalte = new javax.swing.JPanel();
        bNovoEsmalte = new javax.swing.JButton();
        bEditarEsmalte = new javax.swing.JButton();
        lPesquisarEsmalte = new javax.swing.JLabel();
        tBuscarEsmalte = new javax.swing.JTextField();
        bRemoverEsmalte = new javax.swing.JButton();
        mainEsmalte = new javax.swing.JPanel();
        scrollPanelEsmalte = new javax.swing.JScrollPane();
        tableEsmalte = new javax.swing.JTable();
        contentProcedimentos = new javax.swing.JPanel();
        headerProcedimentos = new javax.swing.JPanel();
        iconContentHomeProcedimentos = new javax.swing.JLabel();
        pathContentHomeProcedimentos = new javax.swing.JLabel();
        pathProcedimentos = new javax.swing.JLabel();
        navButtonsProcedimentos = new javax.swing.JPanel();
        bNovoProcedimento = new javax.swing.JButton();
        bEditarProcedimento = new javax.swing.JButton();
        lPesquisarProcedimento = new javax.swing.JLabel();
        tBuscarProcedimento = new javax.swing.JTextField();
        bRemoverProcedimento = new javax.swing.JButton();
        mainProcedimentos = new javax.swing.JPanel();
        scrollPanelProcedimentos = new javax.swing.JScrollPane();
        tableProcedimentos = new javax.swing.JTable();
        contentAgendamentos = new javax.swing.JPanel();
        headerAgendamentos = new javax.swing.JPanel();
        iconContentHomeAgendamentos = new javax.swing.JLabel();
        pathContentHomeAgendamentos = new javax.swing.JLabel();
        pathAgendamentos = new javax.swing.JLabel();
        navButtonsAgendamentos = new javax.swing.JPanel();
        bNovoAgendamentos = new javax.swing.JButton();
        bEditarAgendamentos = new javax.swing.JButton();
        lPesquisarAgendamentos = new javax.swing.JLabel();
        tBuscarAgendamentos = new javax.swing.JTextField();
        bRemoverAgendamentos = new javax.swing.JButton();
        mainAgendamentos = new javax.swing.JPanel();
        scrollPanelAgendamentos = new javax.swing.JScrollPane();
        tableAgendamentos = new javax.swing.JTable();
        sidebarScroll = new javax.swing.JScrollPane();
        sidenav = new javax.swing.JPanel();
        logo = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        pAgenda = new javax.swing.JPanel();
        iconAgendamentos = new javax.swing.JLabel();
        lAgenda = new javax.swing.JLabel();
        pProcedimentos = new javax.swing.JPanel();
        iconProcedimentos = new javax.swing.JLabel();
        lProcedimento = new javax.swing.JLabel();
        pClientes = new javax.swing.JPanel();
        iconClliente = new javax.swing.JLabel();
        lClliente = new javax.swing.JLabel();
        pUsuarios = new javax.swing.JPanel();
        iconUsuario = new javax.swing.JLabel();
        lUsuarios = new javax.swing.JLabel();
        pPacotes = new javax.swing.JPanel();
        iconPacotes = new javax.swing.JLabel();
        lPacotes = new javax.swing.JLabel();
        pEsmalte = new javax.swing.JPanel();
        lEsmalte = new javax.swing.JLabel();
        iconEsmalte = new javax.swing.JLabel();
        pSair = new javax.swing.JPanel();
        iconSair = new javax.swing.JLabel();
        lSair = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agenda");

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(820, 640));
        bg.setPreferredSize(new java.awt.Dimension(820, 600));

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setMaximumSize(new java.awt.Dimension(600, 600));
        content.setMinimumSize(new java.awt.Dimension(600, 600));
        content.setName(""); // NOI18N
        content.setLayout(new java.awt.CardLayout());

        contentAgenda.setBackground(new java.awt.Color(255, 255, 255));
        contentAgenda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contentAgenda.setMaximumSize(new java.awt.Dimension(580, 600));
        contentAgenda.setPreferredSize(new java.awt.Dimension(580, 600));

        headerAgenda.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomeAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/home.png"))); // NOI18N

        pathContentHomeAgenda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomeAgenda.setForeground(new java.awt.Color(0, 0, 0));
        pathContentHomeAgenda.setText("Agenda");

        javax.swing.GroupLayout headerAgendaLayout = new javax.swing.GroupLayout(headerAgenda);
        headerAgenda.setLayout(headerAgendaLayout);
        headerAgendaLayout.setHorizontalGroup(
            headerAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerAgendaLayout.createSequentialGroup()
                .addComponent(iconContentHomeAgenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomeAgenda)
                .addContainerGap(490, Short.MAX_VALUE))
        );
        headerAgendaLayout.setVerticalGroup(
            headerAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerAgendaLayout.createSequentialGroup()
                .addComponent(iconContentHomeAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(53, 53, 53))
            .addGroup(headerAgendaLayout.createSequentialGroup()
                .addComponent(pathContentHomeAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        navButtonsAgenda.setBackground(new java.awt.Color(255, 255, 255));

        tDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tDatePropertyChange(evt);
            }
        });

        lVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/setaEsquerdap.png"))); // NOI18N
        lVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lVoltarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lVoltarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lVoltarMouseExited(evt);
            }
        });

        lAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/setaDireitap.png"))); // NOI18N
        lAvancar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lAvancarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lAvancarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lAvancarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout navButtonsAgendaLayout = new javax.swing.GroupLayout(navButtonsAgenda);
        navButtonsAgenda.setLayout(navButtonsAgendaLayout);
        navButtonsAgendaLayout.setHorizontalGroup(
            navButtonsAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsAgendaLayout.createSequentialGroup()
                .addComponent(lVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tDate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navButtonsAgendaLayout.setVerticalGroup(
            navButtonsAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsAgendaLayout.createSequentialGroup()
                .addGroup(navButtonsAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navButtonsAgendaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(navButtonsAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lAvancar)
                            .addComponent(tDate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(navButtonsAgendaLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lVoltar)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        mainAgenda.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelAgenda.setBackground(new java.awt.Color(255, 255, 255));
        scrollPanelAgenda.setBorder(null);

        tableAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableAgenda.setRowHeight(30);
        scrollPanelAgenda.setViewportView(tableAgenda);

        javax.swing.GroupLayout mainAgendaLayout = new javax.swing.GroupLayout(mainAgenda);
        mainAgenda.setLayout(mainAgendaLayout);
        mainAgendaLayout.setHorizontalGroup(
            mainAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainAgendaLayout.createSequentialGroup()
                .addComponent(scrollPanelAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainAgendaLayout.setVerticalGroup(
            mainAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainAgendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanelAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );

        bAgendamentos.setBackground(new java.awt.Color(232, 121, 22));
        bAgendamentos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
        bAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/iconeAgenda.png"))); // NOI18N
        bAgendamentos.setText(" Agendamentos");
        bAgendamentos.setBorder(null);
        bAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bAgendamentos.setDoubleBuffered(true);
        bAgendamentos.setFocusPainted(false);
        bAgendamentos.setFocusable(false);
        bAgendamentos.setRequestFocusEnabled(false);
        bAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAgendamentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bAgendamentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bAgendamentosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout contentAgendaLayout = new javax.swing.GroupLayout(contentAgenda);
        contentAgenda.setLayout(contentAgendaLayout);
        contentAgendaLayout.setHorizontalGroup(
            contentAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentAgendaLayout.createSequentialGroup()
                .addGroup(contentAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerAgenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentAgendaLayout.createSequentialGroup()
                        .addComponent(navButtonsAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        contentAgendaLayout.setVerticalGroup(
            contentAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentAgendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navButtonsAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentAgendaLayout.createSequentialGroup()
                        .addComponent(bAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addComponent(mainAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        content.add(contentAgenda, "card2");

        contentCliente.setBackground(new java.awt.Color(255, 255, 255));
        contentCliente.setPreferredSize(new java.awt.Dimension(580, 600));

        headerClientes.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomeCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/home.png"))); // NOI18N
        iconContentHomeCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconContentHomeClienteMouseClicked(evt);
            }
        });

        pathContentHomeCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomeCliente.setForeground(new java.awt.Color(255, 102, 0));
        pathContentHomeCliente.setText("Home >");
        pathContentHomeCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pathContentHomeClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pathContentHomeClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pathContentHomeClienteMouseExited(evt);
            }
        });

        pathCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathCliente.setText("Cliente");

        javax.swing.GroupLayout headerClientesLayout = new javax.swing.GroupLayout(headerClientes);
        headerClientes.setLayout(headerClientesLayout);
        headerClientesLayout.setHorizontalGroup(
            headerClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerClientesLayout.createSequentialGroup()
                .addComponent(iconContentHomeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathCliente)
                .addContainerGap(432, Short.MAX_VALUE))
        );
        headerClientesLayout.setVerticalGroup(
            headerClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconContentHomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathContentHomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(pathCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        navButtonsClientes.setBackground(new java.awt.Color(255, 255, 255));

        bNovoCliente.setBackground(new java.awt.Color(232, 121, 22));
        bNovoCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoCliente.setForeground(new java.awt.Color(255, 255, 255));
        bNovoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/novo.png"))); // NOI18N
        bNovoCliente.setText("Novo");
        bNovoCliente.setBorder(null);
        bNovoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoCliente.setDoubleBuffered(true);
        bNovoCliente.setFocusPainted(false);
        bNovoCliente.setFocusable(false);
        bNovoCliente.setRequestFocusEnabled(false);
        bNovoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoClienteMouseExited(evt);
            }
        });

        bEditarCliente.setBackground(new java.awt.Color(232, 121, 22));
        bEditarCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarCliente.setForeground(new java.awt.Color(255, 255, 255));
        bEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/editar.png"))); // NOI18N
        bEditarCliente.setText("Editar");
        bEditarCliente.setBorder(null);
        bEditarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarCliente.setDoubleBuffered(true);
        bEditarCliente.setFocusPainted(false);
        bEditarCliente.setFocusable(false);
        bEditarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarClienteMouseExited(evt);
            }
        });

        lPesquisarCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarCliente.setText("Pesquisar: ");

        tBuscarCliente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tBuscarClienteCaretUpdate(evt);
            }
        });

        bRemoverCliente.setBackground(new java.awt.Color(232, 121, 22));
        bRemoverCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bRemoverCliente.setForeground(new java.awt.Color(255, 255, 255));
        bRemoverCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/excluir.png"))); // NOI18N
        bRemoverCliente.setText("Excluir");
        bRemoverCliente.setBorder(null);
        bRemoverCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bRemoverCliente.setDoubleBuffered(true);
        bRemoverCliente.setFocusPainted(false);
        bRemoverCliente.setFocusable(false);
        bRemoverCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bRemoverClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bRemoverClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bRemoverClienteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout navButtonsClientesLayout = new javax.swing.GroupLayout(navButtonsClientes);
        navButtonsClientes.setLayout(navButtonsClientesLayout);
        navButtonsClientesLayout.setHorizontalGroup(
            navButtonsClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsClientesLayout.createSequentialGroup()
                .addComponent(bNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemoverCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPesquisarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tBuscarCliente)
                .addContainerGap())
        );
        navButtonsClientesLayout.setVerticalGroup(
            navButtonsClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsClientesLayout.createSequentialGroup()
                .addGroup(navButtonsClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navButtonsClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bEditarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bNovoCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(bRemoverCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(navButtonsClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lPesquisarCliente)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        mainClientes.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelClientes.setBackground(new java.awt.Color(255, 255, 255));
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
        scrollPanelClientes.setViewportView(tableClientes);

        javax.swing.GroupLayout mainClientesLayout = new javax.swing.GroupLayout(mainClientes);
        mainClientes.setLayout(mainClientesLayout);
        mainClientesLayout.setHorizontalGroup(
            mainClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelClientes)
        );
        mainClientesLayout.setVerticalGroup(
            mainClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainClientesLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(scrollPanelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout contentClienteLayout = new javax.swing.GroupLayout(contentCliente);
        contentCliente.setLayout(contentClienteLayout);
        contentClienteLayout.setHorizontalGroup(
            contentClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentClienteLayout.createSequentialGroup()
                .addGroup(contentClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentClienteLayout.setVerticalGroup(
            contentClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navButtonsClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );

        content.add(contentCliente, "card2");

        contentUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        contentUsuarios.setPreferredSize(new java.awt.Dimension(580, 600));

        headerUsuarios.setBackground(new java.awt.Color(255, 255, 255));

        pathUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathUsuarios.setText("Usuários");

        pathContentHomeUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomeUsuarios.setForeground(new java.awt.Color(255, 102, 0));
        pathContentHomeUsuarios.setText("Home >");
        pathContentHomeUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pathContentHomeUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pathContentHomeUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pathContentHomeUsuariosMouseExited(evt);
            }
        });

        iconContentHomeUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/home.png"))); // NOI18N
        iconContentHomeUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconContentHomeUsuariosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerUsuariosLayout = new javax.swing.GroupLayout(headerUsuarios);
        headerUsuarios.setLayout(headerUsuariosLayout);
        headerUsuariosLayout.setHorizontalGroup(
            headerUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerUsuariosLayout.createSequentialGroup()
                .addComponent(iconContentHomeUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomeUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathUsuarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerUsuariosLayout.setVerticalGroup(
            headerUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerUsuariosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pathUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pathContentHomeUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(iconContentHomeUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navButtonsUsuarios.setBackground(new java.awt.Color(255, 255, 255));

        bNovoUsuario.setBackground(new java.awt.Color(232, 121, 22));
        bNovoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        bNovoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/novo.png"))); // NOI18N
        bNovoUsuario.setText("Novo");
        bNovoUsuario.setBorder(null);
        bNovoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoUsuario.setDoubleBuffered(true);
        bNovoUsuario.setFocusPainted(false);
        bNovoUsuario.setFocusable(false);
        bNovoUsuario.setRequestFocusEnabled(false);
        bNovoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoUsuarioMouseExited(evt);
            }
        });

        bEditarUsuario.setBackground(new java.awt.Color(232, 121, 22));
        bEditarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        bEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/editar.png"))); // NOI18N
        bEditarUsuario.setText("Editar");
        bEditarUsuario.setBorder(null);
        bEditarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarUsuario.setDoubleBuffered(true);
        bEditarUsuario.setFocusPainted(false);
        bEditarUsuario.setFocusable(false);
        bEditarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarUsuarioMouseExited(evt);
            }
        });

        lPesquisarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarUsuario.setText("Pesquisar: ");

        tBuscarUsuario.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tBuscarUsuarioCaretUpdate(evt);
            }
        });

        bRemoverUsuario.setBackground(new java.awt.Color(232, 121, 22));
        bRemoverUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bRemoverUsuario.setForeground(new java.awt.Color(255, 255, 255));
        bRemoverUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/excluir.png"))); // NOI18N
        bRemoverUsuario.setText("Excluir");
        bRemoverUsuario.setBorder(null);
        bRemoverUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bRemoverUsuario.setDoubleBuffered(true);
        bRemoverUsuario.setFocusPainted(false);
        bRemoverUsuario.setFocusable(false);
        bRemoverUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bRemoverUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bRemoverUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bRemoverUsuarioMouseExited(evt);
            }
        });

        javax.swing.GroupLayout navButtonsUsuariosLayout = new javax.swing.GroupLayout(navButtonsUsuarios);
        navButtonsUsuarios.setLayout(navButtonsUsuariosLayout);
        navButtonsUsuariosLayout.setHorizontalGroup(
            navButtonsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsUsuariosLayout.createSequentialGroup()
                .addComponent(bNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemoverUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPesquisarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tBuscarUsuario)
                .addContainerGap())
        );
        navButtonsUsuariosLayout.setVerticalGroup(
            navButtonsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsUsuariosLayout.createSequentialGroup()
                .addGroup(navButtonsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navButtonsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bEditarUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bNovoUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(bRemoverUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(navButtonsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lPesquisarUsuario)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        mainUsuarios.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        scrollPanelUsuarios.setBorder(null);

        tableUsuario.setAutoCreateRowSorter(true);
        tableUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPanelUsuarios.setViewportView(tableUsuario);

        javax.swing.GroupLayout mainUsuariosLayout = new javax.swing.GroupLayout(mainUsuarios);
        mainUsuarios.setLayout(mainUsuariosLayout);
        mainUsuariosLayout.setHorizontalGroup(
            mainUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );
        mainUsuariosLayout.setVerticalGroup(
            mainUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPanelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );

        javax.swing.GroupLayout contentUsuariosLayout = new javax.swing.GroupLayout(contentUsuarios);
        contentUsuarios.setLayout(contentUsuariosLayout);
        contentUsuariosLayout.setHorizontalGroup(
            contentUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentUsuariosLayout.createSequentialGroup()
                .addGroup(contentUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentUsuariosLayout.setVerticalGroup(
            contentUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navButtonsUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        content.add(contentUsuarios, "card2");

        contentPacotes.setBackground(new java.awt.Color(255, 255, 255));
        contentPacotes.setPreferredSize(new java.awt.Dimension(580, 600));

        headerPacotes.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomePacotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/home.png"))); // NOI18N
        iconContentHomePacotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconContentHomePacotesMouseClicked(evt);
            }
        });

        pathContentHomePacotes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomePacotes.setForeground(new java.awt.Color(255, 102, 0));
        pathContentHomePacotes.setText("Home >");
        pathContentHomePacotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pathContentHomePacotesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pathContentHomePacotesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pathContentHomePacotesMouseExited(evt);
            }
        });

        pathPacotes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathPacotes.setText("Pacotes");

        javax.swing.GroupLayout headerPacotesLayout = new javax.swing.GroupLayout(headerPacotes);
        headerPacotes.setLayout(headerPacotesLayout);
        headerPacotesLayout.setHorizontalGroup(
            headerPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPacotesLayout.createSequentialGroup()
                .addComponent(iconContentHomePacotes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomePacotes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathPacotes)
                .addGap(0, 426, Short.MAX_VALUE))
        );
        headerPacotesLayout.setVerticalGroup(
            headerPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconContentHomePacotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathContentHomePacotes, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(pathPacotes, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        navButtonsPacotes.setBackground(new java.awt.Color(255, 255, 255));

        bNovoPacotes.setBackground(new java.awt.Color(232, 121, 22));
        bNovoPacotes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoPacotes.setForeground(new java.awt.Color(255, 255, 255));
        bNovoPacotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/novo.png"))); // NOI18N
        bNovoPacotes.setText("Novo");
        bNovoPacotes.setBorder(null);
        bNovoPacotes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoPacotes.setDoubleBuffered(true);
        bNovoPacotes.setFocusPainted(false);
        bNovoPacotes.setFocusable(false);
        bNovoPacotes.setRequestFocusEnabled(false);
        bNovoPacotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoPacotesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoPacotesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoPacotesMouseExited(evt);
            }
        });

        bEditarPacotes.setBackground(new java.awt.Color(232, 121, 22));
        bEditarPacotes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarPacotes.setForeground(new java.awt.Color(255, 255, 255));
        bEditarPacotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/editar.png"))); // NOI18N
        bEditarPacotes.setText("Editar");
        bEditarPacotes.setBorder(null);
        bEditarPacotes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarPacotes.setDoubleBuffered(true);
        bEditarPacotes.setFocusPainted(false);
        bEditarPacotes.setFocusable(false);
        bEditarPacotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarPacotesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarPacotesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarPacotesMouseExited(evt);
            }
        });

        lPesquisarPacotes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarPacotes.setText("Pesquisar: ");

        tBuscarPacotes.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tBuscarPacotesCaretUpdate(evt);
            }
        });

        bRemoverPacotes.setBackground(new java.awt.Color(232, 121, 22));
        bRemoverPacotes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bRemoverPacotes.setForeground(new java.awt.Color(255, 255, 255));
        bRemoverPacotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/excluir.png"))); // NOI18N
        bRemoverPacotes.setText("Excluir");
        bRemoverPacotes.setBorder(null);
        bRemoverPacotes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bRemoverPacotes.setDoubleBuffered(true);
        bRemoverPacotes.setFocusPainted(false);
        bRemoverPacotes.setFocusable(false);
        bRemoverPacotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bRemoverPacotesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bRemoverPacotesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bRemoverPacotesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout navButtonsPacotesLayout = new javax.swing.GroupLayout(navButtonsPacotes);
        navButtonsPacotes.setLayout(navButtonsPacotesLayout);
        navButtonsPacotesLayout.setHorizontalGroup(
            navButtonsPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsPacotesLayout.createSequentialGroup()
                .addComponent(bNovoPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemoverPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPesquisarPacotes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tBuscarPacotes)
                .addContainerGap())
        );
        navButtonsPacotesLayout.setVerticalGroup(
            navButtonsPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsPacotesLayout.createSequentialGroup()
                .addGroup(navButtonsPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navButtonsPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bEditarPacotes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bNovoPacotes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(bRemoverPacotes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(navButtonsPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tBuscarPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lPesquisarPacotes)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        mainPacotes.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelPacotes.setBackground(new java.awt.Color(255, 255, 255));
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
        scrollPanelPacotes.setViewportView(tablePacotes);

        javax.swing.GroupLayout mainPacotesLayout = new javax.swing.GroupLayout(mainPacotes);
        mainPacotes.setLayout(mainPacotesLayout);
        mainPacotesLayout.setHorizontalGroup(
            mainPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelPacotes, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );
        mainPacotesLayout.setVerticalGroup(
            mainPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPacotesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(scrollPanelPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentPacotesLayout = new javax.swing.GroupLayout(contentPacotes);
        contentPacotes.setLayout(contentPacotesLayout);
        contentPacotesLayout.setHorizontalGroup(
            contentPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPacotesLayout.createSequentialGroup()
                .addGroup(contentPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPacotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerPacotes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsPacotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPacotesLayout.setVerticalGroup(
            contentPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPacotesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navButtonsPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );

        content.add(contentPacotes, "card2");

        contentEsmalte.setBackground(new java.awt.Color(255, 255, 255));
        contentEsmalte.setPreferredSize(new java.awt.Dimension(580, 600));

        headerEsmalte.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomeEsmalte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/home.png"))); // NOI18N
        iconContentHomeEsmalte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconContentHomeEsmalteMouseClicked(evt);
            }
        });

        pathContentHomeEsmalte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomeEsmalte.setForeground(new java.awt.Color(255, 102, 0));
        pathContentHomeEsmalte.setText("Home >");
        pathContentHomeEsmalte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pathContentHomeEsmalteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pathContentHomeEsmalteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pathContentHomeEsmalteMouseExited(evt);
            }
        });

        pathEsmalte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathEsmalte.setText("Esmalte");

        javax.swing.GroupLayout headerEsmalteLayout = new javax.swing.GroupLayout(headerEsmalte);
        headerEsmalte.setLayout(headerEsmalteLayout);
        headerEsmalteLayout.setHorizontalGroup(
            headerEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerEsmalteLayout.createSequentialGroup()
                .addComponent(iconContentHomeEsmalte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomeEsmalte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathEsmalte)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerEsmalteLayout.setVerticalGroup(
            headerEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconContentHomeEsmalte, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(pathContentHomeEsmalte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathEsmalte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navButtonsEsmalte.setBackground(new java.awt.Color(255, 255, 255));

        bNovoEsmalte.setBackground(new java.awt.Color(232, 121, 22));
        bNovoEsmalte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoEsmalte.setForeground(new java.awt.Color(255, 255, 255));
        bNovoEsmalte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/novo.png"))); // NOI18N
        bNovoEsmalte.setText("Novo");
        bNovoEsmalte.setBorder(null);
        bNovoEsmalte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoEsmalte.setDoubleBuffered(true);
        bNovoEsmalte.setFocusPainted(false);
        bNovoEsmalte.setFocusable(false);
        bNovoEsmalte.setRequestFocusEnabled(false);
        bNovoEsmalte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoEsmalteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoEsmalteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoEsmalteMouseExited(evt);
            }
        });

        bEditarEsmalte.setBackground(new java.awt.Color(232, 121, 22));
        bEditarEsmalte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarEsmalte.setForeground(new java.awt.Color(255, 255, 255));
        bEditarEsmalte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/editar.png"))); // NOI18N
        bEditarEsmalte.setText("Editar");
        bEditarEsmalte.setBorder(null);
        bEditarEsmalte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarEsmalte.setDoubleBuffered(true);
        bEditarEsmalte.setFocusPainted(false);
        bEditarEsmalte.setFocusable(false);
        bEditarEsmalte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarEsmalteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarEsmalteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarEsmalteMouseExited(evt);
            }
        });

        lPesquisarEsmalte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarEsmalte.setText("Pesquisar: ");

        tBuscarEsmalte.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tBuscarEsmalteCaretUpdate(evt);
            }
        });

        bRemoverEsmalte.setBackground(new java.awt.Color(232, 121, 22));
        bRemoverEsmalte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bRemoverEsmalte.setForeground(new java.awt.Color(255, 255, 255));
        bRemoverEsmalte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/excluir.png"))); // NOI18N
        bRemoverEsmalte.setText("Excluir");
        bRemoverEsmalte.setBorder(null);
        bRemoverEsmalte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bRemoverEsmalte.setDoubleBuffered(true);
        bRemoverEsmalte.setFocusPainted(false);
        bRemoverEsmalte.setFocusable(false);
        bRemoverEsmalte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bRemoverEsmalteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bRemoverEsmalteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bRemoverEsmalteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout navButtonsEsmalteLayout = new javax.swing.GroupLayout(navButtonsEsmalte);
        navButtonsEsmalte.setLayout(navButtonsEsmalteLayout);
        navButtonsEsmalteLayout.setHorizontalGroup(
            navButtonsEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsEsmalteLayout.createSequentialGroup()
                .addComponent(bNovoEsmalte, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarEsmalte, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemoverEsmalte, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPesquisarEsmalte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tBuscarEsmalte)
                .addContainerGap())
        );
        navButtonsEsmalteLayout.setVerticalGroup(
            navButtonsEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsEsmalteLayout.createSequentialGroup()
                .addGroup(navButtonsEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navButtonsEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bEditarEsmalte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bNovoEsmalte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(bRemoverEsmalte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(navButtonsEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tBuscarEsmalte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lPesquisarEsmalte)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        mainEsmalte.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelEsmalte.setBackground(new java.awt.Color(255, 255, 255));
        scrollPanelEsmalte.setBorder(null);
        scrollPanelEsmalte.setMinimumSize(null);

        tableEsmalte.setAutoCreateRowSorter(true);
        tableEsmalte.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPanelEsmalte.setViewportView(tableEsmalte);

        javax.swing.GroupLayout mainEsmalteLayout = new javax.swing.GroupLayout(mainEsmalte);
        mainEsmalte.setLayout(mainEsmalteLayout);
        mainEsmalteLayout.setHorizontalGroup(
            mainEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelEsmalte, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );
        mainEsmalteLayout.setVerticalGroup(
            mainEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelEsmalte, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentEsmalteLayout = new javax.swing.GroupLayout(contentEsmalte);
        contentEsmalte.setLayout(contentEsmalteLayout);
        contentEsmalteLayout.setHorizontalGroup(
            contentEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentEsmalteLayout.createSequentialGroup()
                .addGroup(contentEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainEsmalte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerEsmalte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsEsmalte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentEsmalteLayout.setVerticalGroup(
            contentEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentEsmalteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerEsmalte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(navButtonsEsmalte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainEsmalte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        content.add(contentEsmalte, "card2");

        contentProcedimentos.setBackground(new java.awt.Color(255, 255, 255));
        contentProcedimentos.setPreferredSize(new java.awt.Dimension(580, 600));

        headerProcedimentos.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomeProcedimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/home.png"))); // NOI18N
        iconContentHomeProcedimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconContentHomeProcedimentosMouseClicked(evt);
            }
        });

        pathContentHomeProcedimentos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomeProcedimentos.setForeground(new java.awt.Color(255, 102, 0));
        pathContentHomeProcedimentos.setText("Home >");
        pathContentHomeProcedimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pathContentHomeProcedimentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pathContentHomeProcedimentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pathContentHomeProcedimentosMouseExited(evt);
            }
        });

        pathProcedimentos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathProcedimentos.setText("Procedimentos");

        javax.swing.GroupLayout headerProcedimentosLayout = new javax.swing.GroupLayout(headerProcedimentos);
        headerProcedimentos.setLayout(headerProcedimentosLayout);
        headerProcedimentosLayout.setHorizontalGroup(
            headerProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerProcedimentosLayout.createSequentialGroup()
                .addComponent(iconContentHomeProcedimentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomeProcedimentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathProcedimentos)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerProcedimentosLayout.setVerticalGroup(
            headerProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconContentHomeProcedimentos, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(pathContentHomeProcedimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathProcedimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navButtonsProcedimentos.setBackground(new java.awt.Color(255, 255, 255));

        bNovoProcedimento.setBackground(new java.awt.Color(232, 121, 22));
        bNovoProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoProcedimento.setForeground(new java.awt.Color(255, 255, 255));
        bNovoProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/novo.png"))); // NOI18N
        bNovoProcedimento.setText("Novo");
        bNovoProcedimento.setBorder(null);
        bNovoProcedimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoProcedimento.setDoubleBuffered(true);
        bNovoProcedimento.setFocusPainted(false);
        bNovoProcedimento.setFocusable(false);
        bNovoProcedimento.setRequestFocusEnabled(false);
        bNovoProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoProcedimentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoProcedimentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoProcedimentoMouseExited(evt);
            }
        });

        bEditarProcedimento.setBackground(new java.awt.Color(232, 121, 22));
        bEditarProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarProcedimento.setForeground(new java.awt.Color(255, 255, 255));
        bEditarProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/editar.png"))); // NOI18N
        bEditarProcedimento.setText("Editar");
        bEditarProcedimento.setBorder(null);
        bEditarProcedimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarProcedimento.setDoubleBuffered(true);
        bEditarProcedimento.setFocusPainted(false);
        bEditarProcedimento.setFocusable(false);
        bEditarProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarProcedimentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarProcedimentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarProcedimentoMouseExited(evt);
            }
        });

        lPesquisarProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarProcedimento.setText("Pesquisar: ");

        tBuscarProcedimento.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tBuscarProcedimentoCaretUpdate(evt);
            }
        });

        bRemoverProcedimento.setBackground(new java.awt.Color(232, 121, 22));
        bRemoverProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bRemoverProcedimento.setForeground(new java.awt.Color(255, 255, 255));
        bRemoverProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/excluir.png"))); // NOI18N
        bRemoverProcedimento.setText("Excluir");
        bRemoverProcedimento.setBorder(null);
        bRemoverProcedimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bRemoverProcedimento.setDoubleBuffered(true);
        bRemoverProcedimento.setFocusPainted(false);
        bRemoverProcedimento.setFocusable(false);
        bRemoverProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bRemoverProcedimentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bRemoverProcedimentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bRemoverProcedimentoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout navButtonsProcedimentosLayout = new javax.swing.GroupLayout(navButtonsProcedimentos);
        navButtonsProcedimentos.setLayout(navButtonsProcedimentosLayout);
        navButtonsProcedimentosLayout.setHorizontalGroup(
            navButtonsProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsProcedimentosLayout.createSequentialGroup()
                .addComponent(bNovoProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemoverProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPesquisarProcedimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tBuscarProcedimento))
        );
        navButtonsProcedimentosLayout.setVerticalGroup(
            navButtonsProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsProcedimentosLayout.createSequentialGroup()
                .addGroup(navButtonsProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navButtonsProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bEditarProcedimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bNovoProcedimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(bRemoverProcedimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(navButtonsProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tBuscarProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lPesquisarProcedimento)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        mainProcedimentos.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelProcedimentos.setBackground(new java.awt.Color(255, 255, 255));
        scrollPanelProcedimentos.setBorder(null);
        scrollPanelProcedimentos.setMinimumSize(null);

        tableProcedimentos.setAutoCreateRowSorter(true);
        tableProcedimentos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPanelProcedimentos.setViewportView(tableProcedimentos);

        javax.swing.GroupLayout mainProcedimentosLayout = new javax.swing.GroupLayout(mainProcedimentos);
        mainProcedimentos.setLayout(mainProcedimentosLayout);
        mainProcedimentosLayout.setHorizontalGroup(
            mainProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelProcedimentos, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );
        mainProcedimentosLayout.setVerticalGroup(
            mainProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainProcedimentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanelProcedimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout contentProcedimentosLayout = new javax.swing.GroupLayout(contentProcedimentos);
        contentProcedimentos.setLayout(contentProcedimentosLayout);
        contentProcedimentosLayout.setHorizontalGroup(
            contentProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentProcedimentosLayout.createSequentialGroup()
                .addGroup(contentProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainProcedimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerProcedimentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsProcedimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentProcedimentosLayout.setVerticalGroup(
            contentProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentProcedimentosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerProcedimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navButtonsProcedimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainProcedimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );

        content.add(contentProcedimentos, "card2");

        contentAgendamentos.setBackground(new java.awt.Color(255, 255, 255));
        contentAgendamentos.setPreferredSize(new java.awt.Dimension(580, 600));

        headerAgendamentos.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomeAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/home.png"))); // NOI18N
        iconContentHomeAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconContentHomeAgendamentosMouseClicked(evt);
            }
        });

        pathContentHomeAgendamentos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomeAgendamentos.setForeground(new java.awt.Color(255, 102, 0));
        pathContentHomeAgendamentos.setText("Home >");
        pathContentHomeAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pathContentHomeAgendamentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pathContentHomeAgendamentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pathContentHomeAgendamentosMouseExited(evt);
            }
        });

        pathAgendamentos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathAgendamentos.setText("Agendamentos");

        javax.swing.GroupLayout headerAgendamentosLayout = new javax.swing.GroupLayout(headerAgendamentos);
        headerAgendamentos.setLayout(headerAgendamentosLayout);
        headerAgendamentosLayout.setHorizontalGroup(
            headerAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerAgendamentosLayout.createSequentialGroup()
                .addComponent(iconContentHomeAgendamentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomeAgendamentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathAgendamentos)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerAgendamentosLayout.setVerticalGroup(
            headerAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconContentHomeAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(pathContentHomeAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navButtonsAgendamentos.setBackground(new java.awt.Color(255, 255, 255));

        bNovoAgendamentos.setBackground(new java.awt.Color(232, 121, 22));
        bNovoAgendamentos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
        bNovoAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/novo.png"))); // NOI18N
        bNovoAgendamentos.setText("Novo");
        bNovoAgendamentos.setBorder(null);
        bNovoAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoAgendamentos.setDoubleBuffered(true);
        bNovoAgendamentos.setFocusPainted(false);
        bNovoAgendamentos.setFocusable(false);
        bNovoAgendamentos.setRequestFocusEnabled(false);
        bNovoAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoAgendamentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoAgendamentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoAgendamentosMouseExited(evt);
            }
        });

        bEditarAgendamentos.setBackground(new java.awt.Color(232, 121, 22));
        bEditarAgendamentos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
        bEditarAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/editar.png"))); // NOI18N
        bEditarAgendamentos.setText("Editar");
        bEditarAgendamentos.setBorder(null);
        bEditarAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarAgendamentos.setDoubleBuffered(true);
        bEditarAgendamentos.setFocusPainted(false);
        bEditarAgendamentos.setFocusable(false);
        bEditarAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarAgendamentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarAgendamentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarAgendamentosMouseExited(evt);
            }
        });

        lPesquisarAgendamentos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarAgendamentos.setText("Pesquisar: ");

        tBuscarAgendamentos.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tBuscarAgendamentosCaretUpdate(evt);
            }
        });

        bRemoverAgendamentos.setBackground(new java.awt.Color(232, 121, 22));
        bRemoverAgendamentos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bRemoverAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
        bRemoverAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/excluir.png"))); // NOI18N
        bRemoverAgendamentos.setText("Excluir");
        bRemoverAgendamentos.setBorder(null);
        bRemoverAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bRemoverAgendamentos.setDoubleBuffered(true);
        bRemoverAgendamentos.setFocusPainted(false);
        bRemoverAgendamentos.setFocusable(false);
        bRemoverAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bRemoverAgendamentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bRemoverAgendamentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bRemoverAgendamentosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout navButtonsAgendamentosLayout = new javax.swing.GroupLayout(navButtonsAgendamentos);
        navButtonsAgendamentos.setLayout(navButtonsAgendamentosLayout);
        navButtonsAgendamentosLayout.setHorizontalGroup(
            navButtonsAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsAgendamentosLayout.createSequentialGroup()
                .addComponent(bNovoAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemoverAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPesquisarAgendamentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tBuscarAgendamentos)
                .addContainerGap())
        );
        navButtonsAgendamentosLayout.setVerticalGroup(
            navButtonsAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsAgendamentosLayout.createSequentialGroup()
                .addGroup(navButtonsAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navButtonsAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bEditarAgendamentos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bNovoAgendamentos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(bRemoverAgendamentos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(navButtonsAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tBuscarAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lPesquisarAgendamentos)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        mainAgendamentos.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelAgendamentos.setBackground(new java.awt.Color(255, 255, 255));
        scrollPanelAgendamentos.setBorder(null);
        scrollPanelAgendamentos.setMinimumSize(null);

        tableAgendamentos.setAutoCreateRowSorter(true);
        tableAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPanelAgendamentos.setViewportView(tableAgendamentos);

        javax.swing.GroupLayout mainAgendamentosLayout = new javax.swing.GroupLayout(mainAgendamentos);
        mainAgendamentos.setLayout(mainAgendamentosLayout);
        mainAgendamentosLayout.setHorizontalGroup(
            mainAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );
        mainAgendamentosLayout.setVerticalGroup(
            mainAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentAgendamentosLayout = new javax.swing.GroupLayout(contentAgendamentos);
        contentAgendamentos.setLayout(contentAgendamentosLayout);
        contentAgendamentosLayout.setHorizontalGroup(
            contentAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentAgendamentosLayout.createSequentialGroup()
                .addGroup(contentAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainAgendamentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerAgendamentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentAgendamentosLayout.setVerticalGroup(
            contentAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentAgendamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(navButtonsAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        content.add(contentAgendamentos, "card2");

        sidenav.setBackground(new java.awt.Color(255, 255, 255));
        sidenav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setBackground(new java.awt.Color(255, 255, 255));

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/Logo.png"))); // NOI18N

        javax.swing.GroupLayout logoLayout = new javax.swing.GroupLayout(logo);
        logo.setLayout(logoLayout);
        logoLayout.setHorizontalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLayout.createSequentialGroup()
                .addComponent(labelLogo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        logoLayout.setVerticalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sidenav.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, -1));

        pAgenda.setBackground(new java.awt.Color(255, 255, 255));
        pAgenda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pAgendaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pAgendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pAgendaMouseExited(evt);
            }
        });

        iconAgendamentos.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentos.png"))); // NOI18N

        lAgenda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lAgenda.setText("Agenda");

        javax.swing.GroupLayout pAgendaLayout = new javax.swing.GroupLayout(pAgenda);
        pAgenda.setLayout(pAgendaLayout);
        pAgendaLayout.setHorizontalGroup(
            pAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAgendaLayout.createSequentialGroup()
                .addComponent(iconAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );
        pAgendaLayout.setVerticalGroup(
            pAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        sidenav.add(pAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, 50));

        pProcedimentos.setBackground(new java.awt.Color(255, 255, 255));
        pProcedimentos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pProcedimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pProcedimentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pProcedimentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pProcedimentosMouseExited(evt);
            }
        });

        iconProcedimentos.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconProcedimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/procedimento.png"))); // NOI18N

        lProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lProcedimento.setText("Procedimentos");

        javax.swing.GroupLayout pProcedimentosLayout = new javax.swing.GroupLayout(pProcedimentos);
        pProcedimentos.setLayout(pProcedimentosLayout);
        pProcedimentosLayout.setHorizontalGroup(
            pProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProcedimentosLayout.createSequentialGroup()
                .addComponent(iconProcedimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );
        pProcedimentosLayout.setVerticalGroup(
            pProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconProcedimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        sidenav.add(pProcedimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 200, 50));

        pClientes.setBackground(new java.awt.Color(255, 255, 255));
        pClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pClientesMouseExited(evt);
            }
        });

        iconClliente.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconClliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/clientes.png"))); // NOI18N

        lClliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lClliente.setText("Clientes");

        javax.swing.GroupLayout pClientesLayout = new javax.swing.GroupLayout(pClientes);
        pClientes.setLayout(pClientesLayout);
        pClientesLayout.setHorizontalGroup(
            pClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClientesLayout.createSequentialGroup()
                .addComponent(iconClliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lClliente, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        pClientesLayout.setVerticalGroup(
            pClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconClliente, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lClliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidenav.add(pClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, 50));

        pUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        pUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pUsuariosMouseExited(evt);
            }
        });

        iconUsuario.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/usuarios.png"))); // NOI18N

        lUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lUsuarios.setText("Usuários");

        javax.swing.GroupLayout pUsuariosLayout = new javax.swing.GroupLayout(pUsuarios);
        pUsuarios.setLayout(pUsuariosLayout);
        pUsuariosLayout.setHorizontalGroup(
            pUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUsuariosLayout.createSequentialGroup()
                .addComponent(iconUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        pUsuariosLayout.setVerticalGroup(
            pUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidenav.add(pUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 200, 50));

        pPacotes.setBackground(new java.awt.Color(255, 255, 255));
        pPacotes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pPacotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pPacotesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pPacotesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pPacotesMouseExited(evt);
            }
        });

        iconPacotes.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconPacotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/pacotes.png"))); // NOI18N

        lPacotes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPacotes.setText("Pacotes");

        javax.swing.GroupLayout pPacotesLayout = new javax.swing.GroupLayout(pPacotes);
        pPacotes.setLayout(pPacotesLayout);
        pPacotesLayout.setHorizontalGroup(
            pPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPacotesLayout.createSequentialGroup()
                .addComponent(iconPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 49, Short.MAX_VALUE))
        );
        pPacotesLayout.setVerticalGroup(
            pPacotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconPacotes, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lPacotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidenav.add(pPacotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 200, 50));

        pEsmalte.setBackground(new java.awt.Color(255, 255, 255));
        pEsmalte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pEsmalte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pEsmalteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pEsmalteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pEsmalteMouseExited(evt);
            }
        });

        lEsmalte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lEsmalte.setText("Esmaltes");

        iconEsmalte.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconEsmalte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/esmalteicon.png"))); // NOI18N

        javax.swing.GroupLayout pEsmalteLayout = new javax.swing.GroupLayout(pEsmalte);
        pEsmalte.setLayout(pEsmalteLayout);
        pEsmalteLayout.setHorizontalGroup(
            pEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEsmalteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(iconEsmalte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lEsmalte)
                .addGap(0, 88, Short.MAX_VALUE))
        );
        pEsmalteLayout.setVerticalGroup(
            pEsmalteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lEsmalte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEsmalteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconEsmalte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidenav.add(pEsmalte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 50));

        pSair.setBackground(new java.awt.Color(255, 255, 255));
        pSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pSairMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pSairMouseExited(evt);
            }
        });

        iconSair.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/manicure/icones/sair.png"))); // NOI18N

        lSair.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lSair.setText("Sair");

        javax.swing.GroupLayout pSairLayout = new javax.swing.GroupLayout(pSair);
        pSair.setLayout(pSairLayout);
        pSairLayout.setHorizontalGroup(
            pSairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSairLayout.createSequentialGroup()
                .addComponent(iconSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lSair, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 84, Short.MAX_VALUE))
        );
        pSairLayout.setVerticalGroup(
            pSairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconSair, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSairLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidenav.add(pSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 200, 50));

        sidebarScroll.setViewportView(sidenav);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sidebarScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sidebarScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pAgendaMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        this.setTitle("Agenda");
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        this.clickTela = 1;
        mouseSaindo();
        pAgenda.setBackground(Color.decode("#F0F0F0"));

    }//GEN-LAST:event_pAgendaMouseClicked

    private void pAgendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pAgendaMouseEntered
        if (this.clickTela != 1) {
            pAgenda.setBackground(Color.decode("#F0F0F0"));
        }
    }//GEN-LAST:event_pAgendaMouseEntered

    private void pAgendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pAgendaMouseExited
        if (this.clickTela != 1) {
            pAgenda.setBackground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_pAgendaMouseExited

    private void pClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pClientesMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/clientesicon.png")).getImage());
        this.setTitle("Clientes");
        List<Cliente> clientes = DAOFactory.getClienteDAO().listar();
        if (clientes != null) {
            tableModelClientes.addLista(clientes);
        }
        tableClientes.setModel(tableModelClientes);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableClientes.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableClientes.getColumnModel().getColumn(0).setMinWidth(90);
        tableClientes.getColumnModel().getColumn(0).setMaxWidth(90);
        tableClientes.getColumnModel().getColumn(1).setMinWidth(250);
        tableClientes.getColumnModel().getColumn(1).setMaxWidth(250);
        tableClientes.getColumnModel().getColumn(2).setMinWidth(150);
        tableClientes.getColumnModel().getColumn(2).setMaxWidth(150);
        tableClientes.getColumnModel().getColumn(3).setMinWidth(150);
        tableClientes.getColumnModel().getColumn(3).setMaxWidth(150);
        tableClientes.getColumnModel().getColumn(6).setMinWidth(150);
        tableClientes.getColumnModel().getColumn(6).setMaxWidth(150);
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentCliente);
        this.clickTela = 2;
        mouseSaindo();
        pClientes.setBackground(Color.decode("#F0F0F0"));
    }//GEN-LAST:event_pClientesMouseClicked

    private void pClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pClientesMouseEntered
        if (this.clickTela != 2) {
            pClientes.setBackground(Color.decode("#F0F0F0"));
        }
    }//GEN-LAST:event_pClientesMouseEntered

    private void pClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pClientesMouseExited
        if (this.clickTela != 2) {
            pClientes.setBackground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_pClientesMouseExited

    private void pPacotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPacotesMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/pacotesicon.png")).getImage());
        this.setTitle("Pacotes");

        List<Pacotes> pacotes = DAOFactory.getPacoteDAO().listar();
        if (pacotes != null) {
            tableModelPacotes.addLista(pacotes);
        }
        tablePacotes.setModel(tableModelPacotes);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tablePacotes.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablePacotes.getColumnModel().getColumn(0).setMinWidth(90);
        tablePacotes.getColumnModel().getColumn(0).setMaxWidth(90);
        tablePacotes.getColumnModel().getColumn(1).setMinWidth(150);
        tablePacotes.getColumnModel().getColumn(1).setMaxWidth(150);
        tablePacotes.getColumnModel().getColumn(2).setMinWidth(150);
        tablePacotes.getColumnModel().getColumn(2).setMaxWidth(150);

        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentPacotes);
        this.clickTela = 3;
        mouseSaindo();
        pPacotes.setBackground(Color.decode("#F0F0F0"));
    }//GEN-LAST:event_pPacotesMouseClicked

    private void pPacotesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPacotesMouseEntered
        if (this.clickTela != 3) {
            pPacotes.setBackground(Color.decode("#F0F0F0"));
        }
    }//GEN-LAST:event_pPacotesMouseEntered

    private void pPacotesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPacotesMouseExited
        if (this.clickTela != 3) {
            pPacotes.setBackground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_pPacotesMouseExited

    private void pEsmalteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pEsmalteMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/iconesmalte.png")).getImage());
        this.setTitle("Esmaltes");

        List<Esmalte> esmaltes = DAOFactory.getEsmalteDAO().listar();
        if (esmaltes != null) {
            tableModelEsmalte.addLista(esmaltes);
        }
        tableEsmalte.setModel(tableModelEsmalte);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableEsmalte.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableEsmalte.getColumnModel().getColumn(0).setMinWidth(90);
        tableEsmalte.getColumnModel().getColumn(0).setMaxWidth(90);

        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentEsmalte);
        this.clickTela = 4;
        mouseSaindo();
        pEsmalte.setBackground(Color.decode("#F0F0F0"));
    }//GEN-LAST:event_pEsmalteMouseClicked

    private void pEsmalteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pEsmalteMouseEntered
        if (this.clickTela != 4) {
            pEsmalte.setBackground(Color.decode("#F0F0F0"));
        }
    }//GEN-LAST:event_pEsmalteMouseEntered

    private void pEsmalteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pEsmalteMouseExited
        if (this.clickTela != 4) {
            pEsmalte.setBackground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_pEsmalteMouseExited

    private void pSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pSairMouseClicked
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
        this.clickTela = 5;
        mouseSaindo();
        pSair.setBackground(Color.decode("#F0F0F0"));
    }//GEN-LAST:event_pSairMouseClicked

    private void pSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pSairMouseEntered
        if (this.clickTela != 5) {
            pSair.setBackground(Color.decode("#F0F0F0"));
        }
    }//GEN-LAST:event_pSairMouseEntered

    private void pSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pSairMouseExited
        if (this.clickTela != 5) {
            pSair.setBackground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_pSairMouseExited

    private void pUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pUsuariosMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/usuariosicon.png")).getImage());
        this.setTitle("Usuários");
        List<Usuarios> usuario = DAOFactory.getUsuarioDAO().listar();
        if (usuario != null) {
            tableModelUsuario.addLista(usuario);
        }
        tableUsuario.setModel(tableModelUsuario);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableUsuario.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableUsuario.getColumnModel().getColumn(0).setMinWidth(90);
        tableUsuario.getColumnModel().getColumn(0).setMaxWidth(90);
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentUsuarios);
        this.clickTela = 6;
        mouseSaindo();
        pUsuarios.setBackground(Color.decode("#F0F0F0"));
    }//GEN-LAST:event_pUsuariosMouseClicked

    private void pUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pUsuariosMouseEntered
        if (this.clickTela != 6) {
            pUsuarios.setBackground(Color.decode("#F0F0F0"));
        }
    }//GEN-LAST:event_pUsuariosMouseEntered

    private void pUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pUsuariosMouseExited
        if (this.clickTela != 6) {
            pUsuarios.setBackground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_pUsuariosMouseExited

    private void pProcedimentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pProcedimentosMouseExited
        if (this.clickTela != 8) {
            pProcedimentos.setBackground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_pProcedimentosMouseExited

    private void pProcedimentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pProcedimentosMouseEntered
        if (this.clickTela != 8) {
            pProcedimentos.setBackground(Color.decode("#F0F0F0"));
        }

    }//GEN-LAST:event_pProcedimentosMouseEntered

    private void pProcedimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pProcedimentosMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/procedimentoicon.png")).getImage());
        this.setTitle("Procedimentos");
        scrollPanelProcedimentos.getViewport().setBackground(Color.WHITE);
        List<Procedimento> procedimentos = DAOFactory.getProcedimentoDAO().listar();
        if (procedimentos != null) {
            tableModelProcedimentos.addLista(procedimentos);
        }
        tableProcedimentos.setModel(tableModelProcedimentos);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableProcedimentos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableProcedimentos.getColumnModel().getColumn(0).setMinWidth(100);
        tableProcedimentos.getColumnModel().getColumn(0).setMaxWidth(100);
        tableProcedimentos.getColumnModel().getColumn(2).setMinWidth(150);
        tableProcedimentos.getColumnModel().getColumn(2).setMaxWidth(150);
        tableProcedimentos.getColumnModel().getColumn(3).setMinWidth(150);
        tableProcedimentos.getColumnModel().getColumn(3).setMaxWidth(150);

        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentProcedimentos);
        this.clickTela = 8;
        mouseSaindo();
        pProcedimentos.setBackground(Color.decode("#F0F0F0"));
    }//GEN-LAST:event_pProcedimentosMouseClicked

    private void bNovoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoClienteMouseClicked
        bNovoCliente.setBackground(Color.decode("#E87916"));
        NovoCliente cliente = new NovoCliente(this);
        cliente.setVisible(true);
    }//GEN-LAST:event_bNovoClienteMouseClicked

    private void bNovoClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoClienteMouseEntered
        bNovoCliente.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bNovoClienteMouseEntered

    private void bNovoClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoClienteMouseExited
        bNovoCliente.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bNovoClienteMouseExited

    private void bEditarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarClienteMouseClicked
        bEditarCliente.setBackground(Color.decode("#E87916"));
        int row = tableClientes.getSelectedRow();
        if (row > -1) {
            Cliente c = this.tableModelClientes.getCliente(row);
            EditarCliente ep = new EditarCliente(this, c);
            ep.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um cliente da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEditarClienteMouseClicked

    private void bEditarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarClienteMouseEntered
        bEditarCliente.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bEditarClienteMouseEntered

    private void bEditarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarClienteMouseExited
        bEditarCliente.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bEditarClienteMouseExited

    private void bRemoverClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverClienteMouseClicked
        bRemoverCliente.setBackground(Color.decode("#E87916"));
        int row = this.tableClientes.getSelectedRow();
        if (row > -1) {
            Object[] options = {"Sim", "Não"};
            int resp = JOptionPane.showOptionDialog(null, "Deseja realmente excluir este cliente?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (resp == 0) {
                Cliente c = this.tableModelClientes.getCliente(row);
                DAOFactory.getClienteDAO().excluir(c);
                List<Cliente> clientes = DAOFactory.getClienteDAO().listar();
                if (clientes != null) {
                    tableModelClientes.addLista(clientes);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a exclusão do cliente. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um Cliente da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bRemoverClienteMouseClicked

    private void bRemoverClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverClienteMouseEntered
        bRemoverCliente.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bRemoverClienteMouseEntered

    private void bRemoverClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverClienteMouseExited
        bRemoverCliente.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bRemoverClienteMouseExited

    private void bNovoUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoUsuarioMouseEntered
        bNovoUsuario.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bNovoUsuarioMouseEntered

    private void bNovoUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoUsuarioMouseExited
        bNovoUsuario.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bNovoUsuarioMouseExited

    private void bEditarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarUsuarioMouseClicked
        bEditarUsuario.setBackground(Color.decode("#E87916"));
        int row = tableUsuario.getSelectedRow();
        if (row > -1) {
            Usuarios u = tableModelUsuario.getUsuario(row);
            EditarUsuario editar = new EditarUsuario(this, u);
            editar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um usuário da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEditarUsuarioMouseClicked

    private void bEditarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarUsuarioMouseEntered
        bEditarUsuario.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bEditarUsuarioMouseEntered

    private void bEditarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarUsuarioMouseExited
        bEditarUsuario.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bEditarUsuarioMouseExited

    private void bRemoverUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverUsuarioMouseClicked
        bRemoverUsuario.setBackground(Color.decode("#E87916"));
        int row = this.tableUsuario.getSelectedRow();
        if (row > -1) {
            Object[] options = {"Sim", "Não"};
            int resp = JOptionPane.showOptionDialog(null, "Deseja realmente excluir este usuário ?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (resp == 0) {
                Usuarios u = this.tableModelUsuario.getUsuario(row);
                DAOFactory.getUsuarioDAO().excluir(u);
                List<Usuarios> usuario = DAOFactory.getUsuarioDAO().listar();
                if (usuario != null) {
                    tableModelUsuario.addLista(usuario);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a exclusão do usuário. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um usuário da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bRemoverUsuarioMouseClicked

    private void bRemoverUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverUsuarioMouseEntered
        bRemoverUsuario.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bRemoverUsuarioMouseEntered

    private void bRemoverUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverUsuarioMouseExited
        bRemoverUsuario.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bRemoverUsuarioMouseExited

    private void bNovoPacotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoPacotesMouseClicked
        bNovoPacotes.setBackground(Color.decode("#E87916"));
        NovoPacote pacote = new NovoPacote(this);
        pacote.setVisible(true);
    }//GEN-LAST:event_bNovoPacotesMouseClicked

    private void bNovoPacotesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoPacotesMouseEntered
        bNovoPacotes.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bNovoPacotesMouseEntered

    private void bNovoPacotesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoPacotesMouseExited
        bNovoPacotes.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bNovoPacotesMouseExited

    private void bEditarPacotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarPacotesMouseClicked
        bEditarPacotes.setBackground(Color.decode("#E87916"));
        int row = tablePacotes.getSelectedRow();
        if (row > -1) {
            Pacotes p = tableModelPacotes.getPacote(row);
            EditarPacote editar = new EditarPacote(this, p);
            editar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um pacote da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEditarPacotesMouseClicked

    private void bEditarPacotesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarPacotesMouseEntered
        bEditarPacotes.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bEditarPacotesMouseEntered

    private void bEditarPacotesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarPacotesMouseExited
        bEditarPacotes.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bEditarPacotesMouseExited

    private void bRemoverPacotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverPacotesMouseClicked
        bRemoverPacotes.setBackground(Color.decode("#E87916"));
        int row = this.tablePacotes.getSelectedRow();
        if (row > -1) {
            Object[] options = {"Sim", "Não"};
            int resp = JOptionPane.showOptionDialog(null, "Deseja realmente excluir este pacote?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (resp == 0) {
                Pacotes p = this.tableModelPacotes.getPacote(row);
                DAOFactory.getPacoteDAO().excluir(p);
                List<Pacotes> pacotes = DAOFactory.getPacoteDAO().listar();
                if (pacotes != null) {
                    tableModelPacotes.addLista(pacotes);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a exclusão do pacote. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um Pacote da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bRemoverPacotesMouseClicked

    private void bRemoverPacotesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverPacotesMouseEntered
        bRemoverPacotes.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bRemoverPacotesMouseEntered

    private void bRemoverPacotesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverPacotesMouseExited
        bRemoverPacotes.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bRemoverPacotesMouseExited

    private void bNovoEsmalteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoEsmalteMouseClicked
        bNovoEsmalte.setBackground(Color.decode("#E87916"));
        NovoEsmalte esmalte = new NovoEsmalte(this);
        esmalte.setVisible(true);
    }//GEN-LAST:event_bNovoEsmalteMouseClicked

    private void bNovoEsmalteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoEsmalteMouseEntered
        bNovoEsmalte.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bNovoEsmalteMouseEntered

    private void bNovoEsmalteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoEsmalteMouseExited
        bNovoEsmalte.setBackground(Color.decode("#E87916"));

    }//GEN-LAST:event_bNovoEsmalteMouseExited

    private void bEditarEsmalteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarEsmalteMouseClicked
        bEditarEsmalte.setBackground(Color.decode("#E87916"));
        int row = tableEsmalte.getSelectedRow();
        if (row > -1) {
            Esmalte e = this.tableModelEsmalte.getEsmalte(row);

            EditarEsmalte ee = new EditarEsmalte(this, e);
            ee.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um esmalte da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEditarEsmalteMouseClicked

    private void bEditarEsmalteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarEsmalteMouseEntered
        bEditarEsmalte.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bEditarEsmalteMouseEntered

    private void bEditarEsmalteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarEsmalteMouseExited
        bEditarEsmalte.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bEditarEsmalteMouseExited

    private void bRemoverEsmalteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverEsmalteMouseClicked
        bRemoverEsmalte.setBackground(Color.decode("#E87916"));
        int row = this.tableEsmalte.getSelectedRow();
        if (row > -1) {
            Object[] options = {"Sim", "Não"};
            int resp = JOptionPane.showOptionDialog(null, "Deseja realmente excluir este esmalte?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (resp == 0) {
                Esmalte e = this.tableModelEsmalte.getEsmalte(row);

                DAOFactory.getEsmalteDAO().excluir(e);
                List<Esmalte> esmalte = DAOFactory.getEsmalteDAO().listar();
                if (esmalte != null) {
                    tableModelEsmalte.addLista(esmalte);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao realizar a exclusão do esmalte. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um Esmalte da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bRemoverEsmalteMouseClicked

    private void bRemoverEsmalteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverEsmalteMouseEntered
        bRemoverEsmalte.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bRemoverEsmalteMouseEntered

    private void bRemoverEsmalteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverEsmalteMouseExited
        bRemoverEsmalte.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bRemoverEsmalteMouseExited

    private void bNovoProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoProcedimentoMouseClicked
        bNovoProcedimento.setBackground(Color.decode("#E87916"));
        NovoProcedimento procedimentos = new NovoProcedimento(this);
        procedimentos.setVisible(true);
    }//GEN-LAST:event_bNovoProcedimentoMouseClicked

    private void bNovoProcedimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoProcedimentoMouseEntered
        bNovoProcedimento.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bNovoProcedimentoMouseEntered

    private void bNovoProcedimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoProcedimentoMouseExited
        bNovoProcedimento.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bNovoProcedimentoMouseExited

    private void bEditarProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarProcedimentoMouseClicked
        bEditarProcedimento.setBackground(Color.decode("#E87916"));
        int row = tableProcedimentos.getSelectedRow();
        if (row > -1) {
            Procedimento p = tableModelProcedimentos.getProcedimento(row);
            EditarProcedimento editar = new EditarProcedimento(this, p);
            editar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um procedimento da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEditarProcedimentoMouseClicked

    private void bEditarProcedimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarProcedimentoMouseEntered
        bEditarProcedimento.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bEditarProcedimentoMouseEntered

    private void bEditarProcedimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarProcedimentoMouseExited
        bEditarProcedimento.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bEditarProcedimentoMouseExited

    private void bRemoverProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverProcedimentoMouseClicked
        bRemoverProcedimento.setBackground(Color.decode("#E87916"));
        int row = this.tableProcedimentos.getSelectedRow();
        if (row > -1) {
            Object[] options = {"Sim", "Não"};
            int resp = JOptionPane.showOptionDialog(null, "Deseja realmente excluir este procedimento?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (resp == 0) {
                Procedimento p = this.tableModelProcedimentos.getProcedimento(row);
                DAOFactory.getProcedimentoDAO().excluir(p);
                List<Procedimento> procedimentos = DAOFactory.getProcedimentoDAO().listar();
                if (procedimentos != null) {
                    tableModelProcedimentos.addLista(procedimentos);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a exclusão do procedimento. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um Procedimento da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bRemoverProcedimentoMouseClicked

    private void bRemoverProcedimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverProcedimentoMouseEntered
        bRemoverProcedimento.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bRemoverProcedimentoMouseEntered

    private void bRemoverProcedimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverProcedimentoMouseExited
        bRemoverProcedimento.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bRemoverProcedimentoMouseExited

    private void tDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tDatePropertyChange
        if (tDate.getDate() != null) {
            AgendaDAO aDAO = new AgendaDAO();
            List<Horario> lista = aDAO.agendamentos(Formatacao.date2StringScreen(tDate.getDate()));
            if (lista != null) {
                this.tableModelAgenda.addLista(lista);
                for (int i = 0; i < 20; i++) {
                    this.tableAgenda.setRowHeight(i, 30);
                }
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                this.tableAgenda.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                this.tableAgenda.getColumnModel().getColumn(0).setMinWidth(100);
                this.tableAgenda.getColumnModel().getColumn(0).setMaxWidth(100);
            }
        }
    }//GEN-LAST:event_tDatePropertyChange

    private void bNovoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoUsuarioMouseClicked
        bNovoUsuario.setBackground(Color.decode("#E87916"));
        NovoUsuario usuario = new NovoUsuario(this);
        usuario.setVisible(true);
    }//GEN-LAST:event_bNovoUsuarioMouseClicked

    private void bNovoAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoAgendamentosMouseClicked
        bNovoAgendamentos.setBackground(Color.decode("#E87916"));
        NovoAgendamento agendamento = new NovoAgendamento(this);
        agendamento.setVisible(true);
    }//GEN-LAST:event_bNovoAgendamentosMouseClicked

    private void bNovoAgendamentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoAgendamentosMouseEntered
        bNovoAgendamentos.setBackground(Color.decode("#FCA85d"));
    }//GEN-LAST:event_bNovoAgendamentosMouseEntered

    private void bNovoAgendamentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoAgendamentosMouseExited
        bNovoAgendamentos.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bNovoAgendamentosMouseExited

    private void bAgendamentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAgendamentosMouseExited
        bAgendamentos.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bAgendamentosMouseExited

    private void bAgendamentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAgendamentosMouseEntered
        bAgendamentos.setBackground(Color.decode("#FCA85d"));
    }//GEN-LAST:event_bAgendamentosMouseEntered

    private void bAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAgendamentosMouseClicked
        bAgendamentos.setBackground(Color.decode("#E87916"));
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/icone_agendaTELA.png")).getImage());
        this.setTitle("Agendamentos");

        List<Agendamentos> agendamentos = DAOFactory.getAgendamentoDAO().listar();
        if (agendamentos != null) {
            tableModelAgendamento.addLista(agendamentos);
        }
        tableAgendamentos.setModel(tableModelAgendamento);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableAgendamentos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableAgendamentos.getColumnModel().getColumn(0).setMinWidth(90);
        tableAgendamentos.getColumnModel().getColumn(0).setMaxWidth(90);
        tableAgendamentos.getColumnModel().getColumn(1).setMinWidth(250);
        tableAgendamentos.getColumnModel().getColumn(1).setMaxWidth(250);
        tableAgendamentos.getColumnModel().getColumn(2).setMinWidth(150);
        tableAgendamentos.getColumnModel().getColumn(2).setMaxWidth(150);
        tableAgendamentos.getColumnModel().getColumn(3).setMinWidth(150);
        tableAgendamentos.getColumnModel().getColumn(3).setMaxWidth(150);

        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgendamentos);

    }//GEN-LAST:event_bAgendamentosMouseClicked

    private void bRemoverAgendamentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverAgendamentosMouseExited
        bRemoverAgendamentos.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bRemoverAgendamentosMouseExited

    private void bRemoverAgendamentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverAgendamentosMouseEntered
        bRemoverAgendamentos.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bRemoverAgendamentosMouseEntered

    private void bRemoverAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverAgendamentosMouseClicked
        bRemoverAgendamentos.setBackground(Color.decode("#E87916"));
        int row = this.tableAgendamentos.getSelectedRow();
        if (row > -1) {
            Object[] options = {"Sim", "Não"};
            int resp = JOptionPane.showOptionDialog(null, "Deseja realmente excluir este agendamento?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (resp == 0) {
                Agendamentos a = this.tableModelAgendamento.getAgendamento(row);
                DAOFactory.getAgendamentoDAO().excluir(a);
                List<Agendamentos> agendamento = DAOFactory.getAgendamentoDAO().listar();
                if (agendamento != null) {
                    tableModelAgendamento.addLista(agendamento);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a exclusão do agendamento. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um Agendamento da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bRemoverAgendamentosMouseClicked

    private void bEditarAgendamentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarAgendamentosMouseExited
        bEditarAgendamentos.setBackground(Color.decode("#E87916"));
    }//GEN-LAST:event_bEditarAgendamentosMouseExited

    private void bEditarAgendamentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarAgendamentosMouseEntered
        bEditarAgendamentos.setBackground(Color.decode("#EB9F59"));
    }//GEN-LAST:event_bEditarAgendamentosMouseEntered

    private void bEditarAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarAgendamentosMouseClicked
        bEditarAgendamentos.setBackground(Color.decode("#E87916"));
        int row = tableAgendamentos.getSelectedRow();
        if (row > -1) {
            Agendamentos a = this.tableModelAgendamento.getAgendamento(row);

            EditarAgendamento ea = new EditarAgendamento(this, a);
            ea.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um agendamento da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEditarAgendamentosMouseClicked

    private void pathContentHomeAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeAgendamentosMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        pathContentHomeAgendamentos.setFont(Font.decode("Segoe UI-Plain-16"));
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        mouseSaindo();

        this.setTitle("Agenda");
    }//GEN-LAST:event_pathContentHomeAgendamentosMouseClicked

    private void pathContentHomeAgendamentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeAgendamentosMouseEntered
        pathContentHomeAgendamentos.setFont(Font.decode("Segoe UI-Bold-15"));

    }//GEN-LAST:event_pathContentHomeAgendamentosMouseEntered

    private void pathContentHomeAgendamentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeAgendamentosMouseExited
        pathContentHomeAgendamentos.setFont(Font.decode("Segoe UI-Plain-16"));

    }//GEN-LAST:event_pathContentHomeAgendamentosMouseExited

    private void iconContentHomeAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconContentHomeAgendamentosMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        mouseSaindo();

        this.setTitle("Agenda");
    }//GEN-LAST:event_iconContentHomeAgendamentosMouseClicked

    private void pathContentHomeClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeClienteMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        pathContentHomeCliente.setFont(Font.decode("Segoe UI-Plain-16"));
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        mouseSaindo();

        this.setTitle("Agenda");
    }//GEN-LAST:event_pathContentHomeClienteMouseClicked

    private void pathContentHomeClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeClienteMouseEntered
        pathContentHomeCliente.setFont(Font.decode("Segoe UI-Bold-15"));
    }//GEN-LAST:event_pathContentHomeClienteMouseEntered

    private void pathContentHomeClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeClienteMouseExited
        pathContentHomeCliente.setFont(Font.decode("Segoe UI-Plain-16"));
    }//GEN-LAST:event_pathContentHomeClienteMouseExited

    private void iconContentHomeClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconContentHomeClienteMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        mouseSaindo();

        this.setTitle("Agenda");
    }//GEN-LAST:event_iconContentHomeClienteMouseClicked

    private void pathContentHomeUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeUsuariosMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        mouseSaindo();

        this.setTitle("Agenda");
    }//GEN-LAST:event_pathContentHomeUsuariosMouseClicked

    private void pathContentHomeUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeUsuariosMouseEntered
        pathContentHomeUsuarios.setFont(Font.decode("Segoe UI-Bold-15"));
    }//GEN-LAST:event_pathContentHomeUsuariosMouseEntered

    private void pathContentHomeUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeUsuariosMouseExited
        pathContentHomeUsuarios.setFont(Font.decode("Segoe UI-Plain-16"));
    }//GEN-LAST:event_pathContentHomeUsuariosMouseExited

    private void iconContentHomeUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconContentHomeUsuariosMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        mouseSaindo();

        this.setTitle("Agenda");
    }//GEN-LAST:event_iconContentHomeUsuariosMouseClicked

    private void pathContentHomePacotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomePacotesMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        mouseSaindo();

        this.setTitle("Agenda");
    }//GEN-LAST:event_pathContentHomePacotesMouseClicked

    private void pathContentHomePacotesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomePacotesMouseEntered
        pathContentHomePacotes.setFont(Font.decode("Segoe UI-Bold-15"));
    }//GEN-LAST:event_pathContentHomePacotesMouseEntered

    private void pathContentHomePacotesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomePacotesMouseExited
        pathContentHomePacotes.setFont(Font.decode("Segoe UI-Plain-16"));
    }//GEN-LAST:event_pathContentHomePacotesMouseExited

    private void iconContentHomePacotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconContentHomePacotesMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        mouseSaindo();

        this.setTitle("Agenda");
    }//GEN-LAST:event_iconContentHomePacotesMouseClicked

    private void pathContentHomeEsmalteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeEsmalteMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        mouseSaindo();

        this.setTitle("Agenda");
    }//GEN-LAST:event_pathContentHomeEsmalteMouseClicked

    private void pathContentHomeEsmalteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeEsmalteMouseEntered
        pathContentHomeEsmalte.setFont(Font.decode("Segoe UI-Bold-15"));
    }//GEN-LAST:event_pathContentHomeEsmalteMouseEntered

    private void pathContentHomeEsmalteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeEsmalteMouseExited
        pathContentHomeEsmalte.setFont(Font.decode("Segoe UI-Plain-16"));
    }//GEN-LAST:event_pathContentHomeEsmalteMouseExited

    private void iconContentHomeEsmalteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconContentHomeEsmalteMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        mouseSaindo();

        this.setTitle("Agenda");
    }//GEN-LAST:event_iconContentHomeEsmalteMouseClicked

    private void pathContentHomeProcedimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeProcedimentosMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        mouseSaindo();

        this.setTitle("Agenda");
    }//GEN-LAST:event_pathContentHomeProcedimentosMouseClicked

    private void pathContentHomeProcedimentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeProcedimentosMouseEntered
        pathContentHomeProcedimentos.setFont(Font.decode("Segoe UI-Bold-15"));
    }//GEN-LAST:event_pathContentHomeProcedimentosMouseEntered

    private void pathContentHomeProcedimentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathContentHomeProcedimentosMouseExited
        pathContentHomeProcedimentos.setFont(Font.decode("Segoe UI-Plain-16"));
    }//GEN-LAST:event_pathContentHomeProcedimentosMouseExited

    private void iconContentHomeProcedimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconContentHomeProcedimentosMouseClicked
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/manicure/icones/agendamentosicon.png")).getImage());
        content.removeAll();
        content.repaint();
        content.revalidate();
        content.add(contentAgenda);
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        mouseSaindo();

        this.setTitle("Agenda");
    }//GEN-LAST:event_iconContentHomeProcedimentosMouseClicked

    private void lVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lVoltarMouseEntered
        lVoltar.setIcon(new ImageIcon(getClass().getResource("/br/com/manicure/icones/setaEsquerdapcor.png")));
    }//GEN-LAST:event_lVoltarMouseEntered

    private void lVoltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lVoltarMouseExited
        lVoltar.setIcon(new ImageIcon(getClass().getResource("/br/com/manicure/icones/setaEsquerdap.png")));
    }//GEN-LAST:event_lVoltarMouseExited

    private void lAvancarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAvancarMouseEntered
        lAvancar.setIcon(new ImageIcon(getClass().getResource("/br/com/manicure/icones/setaDireitapCor.png")));
    }//GEN-LAST:event_lAvancarMouseEntered

    private void lAvancarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAvancarMouseExited
        lAvancar.setIcon(new ImageIcon(getClass().getResource("/br/com/manicure/icones/setaDireitap.png")));
    }//GEN-LAST:event_lAvancarMouseExited

    private void lVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lVoltarMouseClicked
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(tDate.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        tDate.setDate(calendar.getTime());
    }//GEN-LAST:event_lVoltarMouseClicked

    private void lAvancarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAvancarMouseClicked
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(tDate.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        tDate.setDate(calendar.getTime());
    }//GEN-LAST:event_lAvancarMouseClicked

    private void tBuscarProcedimentoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tBuscarProcedimentoCaretUpdate
        searchProcedimento();
    }//GEN-LAST:event_tBuscarProcedimentoCaretUpdate

    private void tBuscarPacotesCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tBuscarPacotesCaretUpdate
        searchPacote();
    }//GEN-LAST:event_tBuscarPacotesCaretUpdate

    private void tBuscarEsmalteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tBuscarEsmalteCaretUpdate
        searchEsmalte();
    }//GEN-LAST:event_tBuscarEsmalteCaretUpdate

    private void tBuscarUsuarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tBuscarUsuarioCaretUpdate
        searchUsuario();
    }//GEN-LAST:event_tBuscarUsuarioCaretUpdate

    private void tBuscarClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tBuscarClienteCaretUpdate
        searchCliente();
    }//GEN-LAST:event_tBuscarClienteCaretUpdate

    private void tBuscarAgendamentosCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tBuscarAgendamentosCaretUpdate
        searchAgendamento();
    }//GEN-LAST:event_tBuscarAgendamentosCaretUpdate

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
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgendamentos;
    private javax.swing.JButton bEditarAgendamentos;
    private javax.swing.JButton bEditarCliente;
    private javax.swing.JButton bEditarEsmalte;
    private javax.swing.JButton bEditarPacotes;
    private javax.swing.JButton bEditarProcedimento;
    private javax.swing.JButton bEditarUsuario;
    private javax.swing.JButton bNovoAgendamentos;
    private javax.swing.JButton bNovoCliente;
    private javax.swing.JButton bNovoEsmalte;
    private javax.swing.JButton bNovoPacotes;
    private javax.swing.JButton bNovoProcedimento;
    private javax.swing.JButton bNovoUsuario;
    private javax.swing.JButton bRemoverAgendamentos;
    private javax.swing.JButton bRemoverCliente;
    private javax.swing.JButton bRemoverEsmalte;
    private javax.swing.JButton bRemoverPacotes;
    private javax.swing.JButton bRemoverProcedimento;
    private javax.swing.JButton bRemoverUsuario;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel content;
    private javax.swing.JPanel contentAgenda;
    private javax.swing.JPanel contentAgendamentos;
    private javax.swing.JPanel contentCliente;
    private javax.swing.JPanel contentEsmalte;
    private javax.swing.JPanel contentPacotes;
    private javax.swing.JPanel contentProcedimentos;
    private javax.swing.JPanel contentUsuarios;
    private javax.swing.JPanel headerAgenda;
    private javax.swing.JPanel headerAgendamentos;
    private javax.swing.JPanel headerClientes;
    private javax.swing.JPanel headerEsmalte;
    private javax.swing.JPanel headerPacotes;
    private javax.swing.JPanel headerProcedimentos;
    private javax.swing.JPanel headerUsuarios;
    private javax.swing.JLabel iconAgendamentos;
    private javax.swing.JLabel iconClliente;
    private javax.swing.JLabel iconContentHomeAgenda;
    private javax.swing.JLabel iconContentHomeAgendamentos;
    private javax.swing.JLabel iconContentHomeCliente;
    private javax.swing.JLabel iconContentHomeEsmalte;
    private javax.swing.JLabel iconContentHomePacotes;
    private javax.swing.JLabel iconContentHomeProcedimentos;
    private javax.swing.JLabel iconContentHomeUsuarios;
    private javax.swing.JLabel iconEsmalte;
    private javax.swing.JLabel iconPacotes;
    private javax.swing.JLabel iconProcedimentos;
    private javax.swing.JLabel iconSair;
    private javax.swing.JLabel iconUsuario;
    private javax.swing.JLabel lAgenda;
    private javax.swing.JLabel lAvancar;
    private javax.swing.JLabel lClliente;
    private javax.swing.JLabel lEsmalte;
    private javax.swing.JLabel lPacotes;
    private javax.swing.JLabel lPesquisarAgendamentos;
    private javax.swing.JLabel lPesquisarCliente;
    private javax.swing.JLabel lPesquisarEsmalte;
    private javax.swing.JLabel lPesquisarPacotes;
    private javax.swing.JLabel lPesquisarProcedimento;
    private javax.swing.JLabel lPesquisarUsuario;
    private javax.swing.JLabel lProcedimento;
    private javax.swing.JLabel lSair;
    private javax.swing.JLabel lUsuarios;
    private javax.swing.JLabel lVoltar;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel logo;
    private javax.swing.JPanel mainAgenda;
    private javax.swing.JPanel mainAgendamentos;
    private javax.swing.JPanel mainClientes;
    private javax.swing.JPanel mainEsmalte;
    private javax.swing.JPanel mainPacotes;
    private javax.swing.JPanel mainProcedimentos;
    private javax.swing.JPanel mainUsuarios;
    private javax.swing.JPanel navButtonsAgenda;
    private javax.swing.JPanel navButtonsAgendamentos;
    private javax.swing.JPanel navButtonsClientes;
    private javax.swing.JPanel navButtonsEsmalte;
    private javax.swing.JPanel navButtonsPacotes;
    private javax.swing.JPanel navButtonsProcedimentos;
    private javax.swing.JPanel navButtonsUsuarios;
    private javax.swing.JPanel pAgenda;
    private javax.swing.JPanel pClientes;
    private javax.swing.JPanel pEsmalte;
    private javax.swing.JPanel pPacotes;
    private javax.swing.JPanel pProcedimentos;
    private javax.swing.JPanel pSair;
    private javax.swing.JPanel pUsuarios;
    private javax.swing.JLabel pathAgendamentos;
    private javax.swing.JLabel pathCliente;
    private javax.swing.JLabel pathContentHomeAgenda;
    private javax.swing.JLabel pathContentHomeAgendamentos;
    private javax.swing.JLabel pathContentHomeCliente;
    private javax.swing.JLabel pathContentHomeEsmalte;
    private javax.swing.JLabel pathContentHomePacotes;
    private javax.swing.JLabel pathContentHomeProcedimentos;
    private javax.swing.JLabel pathContentHomeUsuarios;
    private javax.swing.JLabel pathEsmalte;
    private javax.swing.JLabel pathPacotes;
    private javax.swing.JLabel pathProcedimentos;
    private javax.swing.JLabel pathUsuarios;
    private javax.swing.JScrollPane scrollPanelAgenda;
    private javax.swing.JScrollPane scrollPanelAgendamentos;
    private javax.swing.JScrollPane scrollPanelClientes;
    private javax.swing.JScrollPane scrollPanelEsmalte;
    private javax.swing.JScrollPane scrollPanelPacotes;
    private javax.swing.JScrollPane scrollPanelProcedimentos;
    private javax.swing.JScrollPane scrollPanelUsuarios;
    private javax.swing.JScrollPane sidebarScroll;
    private javax.swing.JPanel sidenav;
    private javax.swing.JTextField tBuscarAgendamentos;
    private javax.swing.JTextField tBuscarCliente;
    private javax.swing.JTextField tBuscarEsmalte;
    private javax.swing.JTextField tBuscarPacotes;
    private javax.swing.JTextField tBuscarProcedimento;
    private javax.swing.JTextField tBuscarUsuario;
    private com.toedter.calendar.JDateChooser tDate;
    private javax.swing.JTable tableAgenda;
    private javax.swing.JTable tableAgendamentos;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTable tableEsmalte;
    private javax.swing.JTable tablePacotes;
    private javax.swing.JTable tableProcedimentos;
    private javax.swing.JTable tableUsuario;
    // End of variables declaration//GEN-END:variables

    public void mouseSaindo() {
        pAgenda.setBackground(Color.decode("#FFFFFF"));
        lAgenda.setForeground(Color.decode("#3C3F41"));

        pClientes.setBackground(Color.decode("#FFFFFF"));
        lClliente.setForeground(Color.decode("#3C3F41"));

        pUsuarios.setBackground(Color.decode("#FFFFFF"));
        lUsuarios.setForeground(Color.decode("#3C3F41"));

        pPacotes.setBackground(Color.decode("#FFFFFF"));
        lPacotes.setForeground(Color.decode("#3C3F41"));

        pEsmalte.setBackground(Color.decode("#FFFFFF"));
        lEsmalte.setForeground(Color.decode("#3C3F41"));

        pProcedimentos.setBackground(Color.decode("#FFFFFF"));
        lProcedimento.setForeground(Color.decode("#3C3F41"));

        pSair.setBackground(Color.decode("#FFFFFF"));
        lSair.setForeground(Color.decode("#3C3F41"));
    }

    private void searchProcedimento() {
        String busca = this.tBuscarProcedimento.getText();
        List<Procedimento> lista;
        lista = DAOFactory.getProcedimentoDAO().filtrar(busca);
        if (lista != null) {
            this.tableModelProcedimentos.addLista(lista);
        }
        this.tBuscarProcedimento.requestFocusInWindow();

    }

    private void searchPacote() {
        String busca = this.tBuscarPacotes.getText();
        List<Pacotes> lista;
        lista = DAOFactory.getPacoteDAO().filtrar(busca);
        if (lista != null) {
            this.tableModelPacotes.addLista(lista);
        }
        this.tBuscarPacotes.requestFocusInWindow();

    }

    private void searchEsmalte() {
        String busca = this.tBuscarEsmalte.getText();
        List<Esmalte> lista;
        lista = DAOFactory.getEsmalteDAO().filtrar(busca);
        if (lista != null) {
            this.tableModelEsmalte.addLista(lista);
        }
        this.tBuscarEsmalte.requestFocusInWindow();

    }

    private void searchUsuario() {
        String busca = this.tBuscarUsuario.getText();
        List<Usuarios> lista;
        lista = DAOFactory.getUsuarioDAO().filtrar(busca);
        if (lista != null) {
            this.tableModelUsuario.addLista(lista);
        }
        this.tBuscarUsuario.requestFocusInWindow();

    }

    private void searchCliente() {
        String busca = this.tBuscarCliente.getText();
        List<Cliente> lista;
        lista = DAOFactory.getClienteDAO().filtrar(busca);
        if (lista != null) {
            this.tableModelClientes.addLista(lista);
        }
        this.tBuscarCliente.requestFocusInWindow();

    }

    private void searchAgendamento() {
        String busca = this.tBuscarAgendamentos.getText();

        List<Agendamentos> lista;
        lista = DAOFactory.getAgendamentoDAO().filtrar(busca);
        if (lista != null) {
            this.tableModelAgendamento.addLista(lista);
        }
        this.tBuscarAgendamentos.requestFocusInWindow();

    }

    public final void updateAgendaConteudo() {
        scrollPanelAgenda.getViewport().setBackground(Color.WHITE);
        bAgendamentos.setModel(new FixedButtonModel());
        bAgendamentos.setBorder(BorderFactory.createEtchedBorder(0));
        AgendaDAO aDAO = new AgendaDAO();
        List<Horario> agendamentos = aDAO.agendamentos(Formatacao.date2StringScreen(tDate.getDate()));
        if (agendamentos != null) {
            tableModelAgenda.addLista(agendamentos);
        }
        tableAgenda.setModel(tableModelAgenda);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableAgenda.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableAgenda.getColumnModel().getColumn(0).setMinWidth(100);
        tableAgenda.getColumnModel().getColumn(0).setMaxWidth(100);
    }

    public JTable getTableAgenda() {
        return this.tableAgenda;
    }

    public com.toedter.calendar.JDateChooser getTDate() {
        return this.tDate;
    }

    public final void setHorarios() {
        this.horarios = HorarioDAO.horarios();
    }

    public Time getHorarios() {
        return this.horarios.get(1).getHora();
    }
}
