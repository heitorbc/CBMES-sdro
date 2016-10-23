/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.es.cb.sdro.view;

import br.gov.es.cb.sdro.model.Categoria;
import br.gov.es.cb.sdro.model.Equipamento;
import br.gov.es.cb.sdro.model.Status;
import br.gov.es.cb.sdro.model.Tipocombustivel;
import br.gov.es.cb.sdro.model.Tipoviatura;
import br.gov.es.cb.sdro.model.Tipoviatura_;
import br.gov.es.cb.sdro.model.Unidade;
import br.gov.es.cb.sdro.model.Viatura;
import br.gov.es.cb.sdro.util.CategoriaDAO;
import br.gov.es.cb.sdro.util.EquipamentoDAO;
import br.gov.es.cb.sdro.util.Sessao;
import br.gov.es.cb.sdro.util.StatusDAO;
import br.gov.es.cb.sdro.util.TipocombustivelDAO;
import br.gov.es.cb.sdro.util.TipoviaturaDAO;
import br.gov.es.cb.sdro.util.ViaturaDAO;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Patrícia
 */
public class TelaAlocacao extends javax.swing.JInternalFrame {

    DefaultTableModel tableViaturasDisponiveis;
    DefaultTableModel tableViaturasSelecionadasAlocacao;
    DefaultTableModel tableViaturasAlocadas;
    DefaultTableModel tableEquipamentosSelecionadosAlocacao;
    DefaultTableModel tableEquipamentosAlocados;
    DefaultTableModel tableMilitares;
    
    ViaturaDAO viaturaDAO;
    List<Viatura> lstViaturasDisponiveis;
    List<Viatura> lstViaturasAlocadas;
    StatusDAO statusDAO;
    CategoriaDAO categoriaDAO;
    TipocombustivelDAO tpCombustivelDAO;
    TipoviaturaDAO tpViaturaDAO;
    Status status;
    Categoria categoria;
    Tipocombustivel tpCombustivel;
    Tipoviatura tpViatura;
    ArrayList<Viatura> lstViaturasSelecionadasAlocacao;
    ArrayList<Integer> lstAuxViaturas;
    ArrayList<Integer> lstEquipamentosSelecionados;
    private static TelaAlocacao telaAlocacao = null;
    int idEquipamentoSelecionado;
    int idViaturaSelecionadaAlocacao;
    int idViaturaAlocada;
    Sessao sessao;
    HashMap<Integer, ArrayList<Integer>> mapViaturaEquipamento;
    HashMap<Integer, ArrayList<Equipamento>> mapViaturaEquipamentoAlocados;
    EquipamentoDAO equipamentoDAO;

    /**
     * Creates new form TelaAlocar
     *
     * @return
     */
    public static TelaAlocacao getInstancia() {
        if (telaAlocacao == null) {
            telaAlocacao = new TelaAlocacao();
        }
        return telaAlocacao;
    }

    private TelaAlocacao() {
        initComponents();
        sessao = Sessao.getInstancia();
        
        tableViaturasDisponiveis = (DefaultTableModel) jTableViaturasDisponiveis.getModel();
        tableViaturasSelecionadasAlocacao = (DefaultTableModel) jTableViaturasSelecionadasAlocacao.getModel();
        tableEquipamentosSelecionadosAlocacao = (DefaultTableModel) jTableEquipamentosSelecionadosAlocacao.getModel();
        tableViaturasAlocadas = (DefaultTableModel) JTableViaturasAlocadas.getModel();
        tableEquipamentosAlocados = (DefaultTableModel) JTableEquipamentosAlocados.getModel();
        tableMilitares = (DefaultTableModel) jTableMilitares.getModel();
        
        statusDAO = new StatusDAO();
        categoriaDAO = new CategoriaDAO();
        tpCombustivelDAO = new TipocombustivelDAO();
        tpViaturaDAO = new TipoviaturaDAO();
        viaturaDAO = new ViaturaDAO();
        equipamentoDAO = new EquipamentoDAO();
         
        lstEquipamentosSelecionados = new ArrayList<Integer>();
        lstViaturasSelecionadasAlocacao = new ArrayList<Viatura>();
        lstAuxViaturas = new ArrayList<Integer>();
        lstViaturasDisponiveis = viaturaDAO.buscaViaturasDisponiveisUnidade(sessao.getUnidade());
        
        mapViaturaEquipamento = new HashMap<Integer, ArrayList<Integer>>();
        mapViaturaEquipamentoAlocados = new HashMap<Integer, ArrayList<Equipamento>>();
       
        status = new Status();
        categoria = new Categoria();
        tpCombustivel = new Tipocombustivel();
        tpViatura = new Tipoviatura();
        
        populaTabelaViaturasDisponiveis();
        // this.setVisible(true);
    }

    public void populaTabelaViaturasDisponiveis() {
        if (tableViaturasDisponiveis.getRowCount() > 0) {

            int qtd = tableViaturasDisponiveis.getRowCount();
            for (int i = 0; i < qtd; i++) {
                tableViaturasDisponiveis.removeRow(0);
            }
        }
        System.out.println(lstViaturasDisponiveis);
        for (Viatura vt : lstViaturasDisponiveis) {
            status = vt.getIdstatus();
            categoria = vt.getIdcategoria();
            tpViatura = vt.getIdtipoviatura();
            tpCombustivel = vt.getIdtipocombustivel();
            Status statusResult = statusDAO.buscaStatusPorID(status.getIdstatus());

            Categoria categoriaResult = categoriaDAO.buscaCategoriaPorID(categoria.getIdcategoria());
            Tipocombustivel tpCombustivelResult = tpCombustivelDAO.buscaTipoCombustivelPorID(tpCombustivel.getIdtipocombustivel());
            Tipoviatura tpViaturaResult = tpViaturaDAO.buscaTipoViaturaPorID(tpViatura.getIdtipoviatura());

            tableViaturasDisponiveis.addRow(new Object[]{vt.getIdviatura(), vt.getPlaca(), vt.getPrefixo(), vt.getModelo(), categoriaResult.getDescricao(),
                tpViaturaResult.getDescricao(), vt.getCappessoas(), vt.getCapagua(), statusResult.getDescricao(), statusResult.getDescricao()});
        }

    }

    public void populaTabelaViaturasAlocadas() {
        if (tableViaturasAlocadas.getRowCount() > 0) {

            int qtd = tableViaturasAlocadas.getRowCount();
            for (int i = 0; i < qtd; i++) {
                tableViaturasAlocadas.removeRow(0);
            }
        }
        //System.out.println(tableViaturasAlocadas);
        for (Viatura vt : lstViaturasAlocadas) {
            status = vt.getIdstatus();
            categoria = vt.getIdcategoria();
            tpViatura = vt.getIdtipoviatura();
            tpCombustivel = vt.getIdtipocombustivel();
            Status statusResult = statusDAO.buscaStatusPorID(status.getIdstatus());

            Categoria categoriaResult = categoriaDAO.buscaCategoriaPorID(categoria.getIdcategoria());
            Tipocombustivel tpCombustivelResult = tpCombustivelDAO.buscaTipoCombustivelPorID(tpCombustivel.getIdtipocombustivel());
            Tipoviatura tpViaturaResult = tpViaturaDAO.buscaTipoViaturaPorID(tpViatura.getIdtipoviatura());

            tableViaturasAlocadas.addRow(new Object[]{vt.getIdviatura(), vt.getPlaca(), vt.getPrefixo(), vt.getModelo(), categoriaResult.getDescricao(),
                tpViaturaResult.getDescricao(), vt.getCappessoas(), vt.getCapagua(), statusResult.getDescricao(), statusResult.getDescricao()});
        }

    }

    public void atualizaTabelaViaturasDisponiveis() {
        if (tableViaturasDisponiveis.getRowCount() > 0) {
            int qtd = tableViaturasDisponiveis.getRowCount();
            for (int i = 0; i < qtd; i++) {
                tableViaturasDisponiveis.removeRow(0);
            }
        }
        for (Viatura vt : lstViaturasDisponiveis) {
            status = vt.getIdstatus();
            categoria = vt.getIdcategoria();
            tpViatura = vt.getIdtipoviatura();
            tpCombustivel = vt.getIdtipocombustivel();
            Status statusResult = statusDAO.buscaStatusPorID(status.getIdstatus());

            Categoria categoriaResult = categoriaDAO.buscaCategoriaPorID(categoria.getIdcategoria());
            Tipocombustivel tpCombustivelResult = tpCombustivelDAO.buscaTipoCombustivelPorID(tpCombustivel.getIdtipocombustivel());
            Tipoviatura tpViaturaResult = tpViaturaDAO.buscaTipoViaturaPorID(tpViatura.getIdtipoviatura());
            if (!lstAuxViaturas.contains(vt.getIdviatura())) {
                tableViaturasDisponiveis.addRow(new Object[]{vt.getIdviatura(), vt.getPlaca(), vt.getPrefixo(), vt.getModelo(), categoriaResult.getDescricao(),
                    tpViaturaResult.getDescricao(), vt.getCappessoas(), vt.getCapagua(), statusResult.getDescricao(), statusResult.getDescricao()});
            }
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

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableViaturasDisponiveis = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableViaturasSelecionadasAlocacao = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableEquipamentosSelecionadosAlocacao = new javax.swing.JTable();
        btnAlocarViatura = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnAdicionarEquipamentoViatura = new javax.swing.JButton();
        btnRemoverViaturaAlocada = new javax.swing.JButton();
        btnRemoverEquipamento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalvarAlocacao = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        JTableViaturasAlocadas = new javax.swing.JTable();
        liberarViatura = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        JTableEquipamentosAlocados = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMilitares = new javax.swing.JTable();
        jComboStatusMilitar = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTableViaturasDisponiveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Placa", "Prefixo", "Modelo", "Categoria", "Tipo", "Cap. Pessoas", "Cap. Água", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableViaturasDisponiveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableViaturasDisponiveisMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableViaturasDisponiveis);
        if (jTableViaturasDisponiveis.getColumnModel().getColumnCount() > 0) {
            jTableViaturasDisponiveis.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableViaturasDisponiveis.getColumnModel().getColumn(1).setMaxWidth(100);
            jTableViaturasDisponiveis.getColumnModel().getColumn(2).setMaxWidth(100);
            jTableViaturasDisponiveis.getColumnModel().getColumn(6).setMaxWidth(75);
            jTableViaturasDisponiveis.getColumnModel().getColumn(7).setMaxWidth(75);
            jTableViaturasDisponiveis.getColumnModel().getColumn(8).setMaxWidth(300);
        }

        jTableViaturasSelecionadasAlocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Placa", "Categoria", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableViaturasSelecionadasAlocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableViaturasSelecionadasAlocacaoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableViaturasSelecionadasAlocacao);
        if (jTableViaturasSelecionadasAlocacao.getColumnModel().getColumnCount() > 0) {
            jTableViaturasSelecionadasAlocacao.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableViaturasSelecionadasAlocacao.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableViaturasSelecionadasAlocacao.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jTableEquipamentosSelecionadosAlocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Marca"
            }
        ));
        jScrollPane5.setViewportView(jTableEquipamentosSelecionadosAlocacao);

        btnAlocarViatura.setText("Adicionar");
        btnAlocarViatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlocarViaturaActionPerformed(evt);
            }
        });

        btnAdicionarEquipamentoViatura.setText("Adicionar Equipamento");
        btnAdicionarEquipamentoViatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEquipamentoViaturaActionPerformed(evt);
            }
        });

        btnRemoverViaturaAlocada.setText("Remover");
        btnRemoverViaturaAlocada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverViaturaAlocadaActionPerformed(evt);
            }
        });

        btnRemoverEquipamento.setText("Remover");
        btnRemoverEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverEquipamentoActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("VIATURAS DISPONÍVEIS");
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 14));

        jLabel2.setText("VIATURAS ALOCADAS");

        jLabel3.setText("EQUIPAMENTOS ALOCADOS");

        btnSalvarAlocacao.setText("Salvar");
        btnSalvarAlocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlocacaoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAlocarViatura)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalvarAlocacao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAdicionarEquipamentoViatura)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnRemoverViaturaAlocada))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(btnRemoverEquipamento))))
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlocarViatura)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdicionarEquipamentoViatura)
                            .addComponent(btnRemoverViaturaAlocada)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnRemoverEquipamento)))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarAlocacao)
                    .addComponent(btnCancelar))
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Alocar Viatura", jPanel1);

        JTableViaturasAlocadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Placa", "Prefixo", "Modelo", "Categoria", "Tipo", "Cap. Pessoas", "Cap. Água", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableViaturasAlocadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableViaturasAlocadasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(JTableViaturasAlocadas);
        if (JTableViaturasAlocadas.getColumnModel().getColumnCount() > 0) {
            JTableViaturasAlocadas.getColumnModel().getColumn(0).setMaxWidth(50);
            JTableViaturasAlocadas.getColumnModel().getColumn(1).setMaxWidth(100);
            JTableViaturasAlocadas.getColumnModel().getColumn(2).setMaxWidth(100);
            JTableViaturasAlocadas.getColumnModel().getColumn(6).setMaxWidth(75);
            JTableViaturasAlocadas.getColumnModel().getColumn(7).setMaxWidth(75);
            JTableViaturasAlocadas.getColumnModel().getColumn(8).setMaxWidth(300);
        }

        liberarViatura.setText("Liberar Viatura");
        liberarViatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liberarViaturaActionPerformed(evt);
            }
        });

        JTableEquipamentosAlocados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Marca"
            }
        ));
        jScrollPane7.setViewportView(JTableEquipamentosAlocados);

        jLabel4.setText("EQUIPAMENTOS ALOCADOS VIATURA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(liberarViatura)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(liberarViatura)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Liberar Viaturas", jPanel3);

        jTableMilitares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Posto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableMilitares);
        if (jTableMilitares.getColumnModel().getColumnCount() > 0) {
            jTableMilitares.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        jComboStatusMilitar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Status");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboStatusMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboStatusMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alocar/Liberar Militares", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        Unidade unidade = new Unidade();
        unidade.setIdunidade(2);
        lstViaturasAlocadas = viaturaDAO.buscaViaturasAlocadas(unidade);
        populaTabelaViaturasAlocadas();
    }//GEN-LAST:event_jTabbedPane1MouseClicked


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarAlocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlocacaoActionPerformed
        boolean sucesso = true;
        ArrayList<Integer> lstEquipamentosAlocados = new ArrayList<>();
        for (Integer idviatura : lstAuxViaturas) {
            Viatura viatura = new Viatura();
            viatura.setIdviatura(idviatura);
            if (!viaturaDAO.updateIsAlocado(viatura)) {
                sucesso = false;
            }
            lstEquipamentosAlocados = mapViaturaEquipamento.get(idviatura);
            for (Integer idEquipamentos : lstEquipamentosAlocados) {
                Equipamento equipamento = new Equipamento();
                equipamento.setIdequipamento(idEquipamentos);
                equipamento.setIdviatura(viatura);
                if (!equipamentoDAO.updateIsAlocado(equipamento)) {
                    sucesso = false;
                }
            }
        }
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados");
        }
    }//GEN-LAST:event_btnSalvarAlocacaoActionPerformed

    private void btnRemoverEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverEquipamentoActionPerformed
        int linha = jTableEquipamentosSelecionadosAlocacao.getSelectedRow();
        if (linha >= 0) {
            int idEquipamento = Integer.parseInt(tableEquipamentosSelecionadosAlocacao.getValueAt(linha, 0).toString());
            removeEquipamentoMap(idEquipamento);
            removeEquipamentoSelecionadoLista(idEquipamento);
        } else {
            JOptionPane.showMessageDialog(null, "Um Equipamento deve ser selecionado");
        }
    }//GEN-LAST:event_btnRemoverEquipamentoActionPerformed

    private void btnRemoverViaturaAlocadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverViaturaAlocadaActionPerformed
        int linha = jTableViaturasSelecionadasAlocacao.getSelectedRow();
        if (linha >= 0) {
            int codigo = Integer.parseInt(tableViaturasSelecionadasAlocacao.getValueAt(linha, 0).toString());
            ArrayList<Integer> lstAuxEquipamentos = new ArrayList<>();
            for (int i = 0; i < lstAuxViaturas.size(); i++) {
                if (lstAuxViaturas.get(i).equals(codigo)) {
                    lstAuxEquipamentos = mapViaturaEquipamento.get(codigo);
                    mapViaturaEquipamento.remove(codigo);
                    lstAuxViaturas.remove(i);
                    break;
                }
            }
            for (int i = 0; i < lstAuxEquipamentos.size(); i++) {
                int id = lstAuxEquipamentos.get(i);
                removeEquipamentoSelecionadoLista(id);
            }
            atualizaTabelaViaturasDisponiveis();
            populaTabelaViaturasSelecionadasAlocacao();
            limpaTabelaEquipamentosSelecionadosAlocacao();
        } else {
            JOptionPane.showMessageDialog(null, "Uma viatura deve ser selecionada");
        }
    }//GEN-LAST:event_btnRemoverViaturaAlocadaActionPerformed

    private void btnAdicionarEquipamentoViaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEquipamentoViaturaActionPerformed
        int linha = jTableViaturasSelecionadasAlocacao.getSelectedRow();
        if (linha >= 0) {
            idViaturaSelecionadaAlocacao = Integer.parseInt(tableViaturasSelecionadasAlocacao.getValueAt(linha, 0).toString());
            try {
                TelaEquipamentosAlocacao equipamentoAlocacao = new TelaEquipamentosAlocacao(lstEquipamentosSelecionados);

            } catch (Exception ex) {
                Logger.getLogger(TelaAlocacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Uma viatura deve ser selecionada");
        }
    }//GEN-LAST:event_btnAdicionarEquipamentoViaturaActionPerformed

    private void btnAlocarViaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlocarViaturaActionPerformed
        int linha = jTableViaturasDisponiveis.getSelectedRow();
        System.out.println("linha " + linha);
        if (linha >= 0) {
            int codigo = Integer.parseInt(tableViaturasDisponiveis.getValueAt(linha, 0).toString());
            lstAuxViaturas.add(codigo);
            Viatura viatura = new Viatura();
            viatura = viaturaDAO.buscaViaturaPorID(codigo);
            populaTabelaViaturasSelecionadasAlocacao();
            atualizaTabelaViaturasDisponiveis();
        } else {
            JOptionPane.showMessageDialog(null, "Uma viatura deve ser selecionada!");
        }
    }//GEN-LAST:event_btnAlocarViaturaActionPerformed

    private void jTableViaturasSelecionadasAlocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableViaturasSelecionadasAlocacaoMouseClicked
        int linha = jTableViaturasSelecionadasAlocacao.getSelectedRow();
        idViaturaSelecionadaAlocacao = Integer.parseInt(tableViaturasSelecionadasAlocacao.getValueAt(linha, 0).toString());
        populaTabelaEquipamentosSelecionadosAlocacao(idViaturaSelecionadaAlocacao);
    }//GEN-LAST:event_jTableViaturasSelecionadasAlocacaoMouseClicked

    private void jTableViaturasDisponiveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableViaturasDisponiveisMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableViaturasDisponiveisMouseClicked

    private void JTableViaturasAlocadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableViaturasAlocadasMouseClicked
        int linha = JTableViaturasAlocadas.getSelectedRow();
        int idViaturaAlocada = Integer.parseInt(tableViaturasAlocadas.getValueAt(linha, 0).toString());
        populaTabelaEquipamentosAlocados(idViaturaAlocada);

    }//GEN-LAST:event_JTableViaturasAlocadasMouseClicked

    public void AdicionaMapViaturaEquipamentoAlocados(int idViaturaAlocada) {
        Viatura viatura = new Viatura();
        viatura.setIdviatura(idViaturaAlocada);
        List<Equipamento> equipamentosAlocadosViatura;
        equipamentosAlocadosViatura = equipamentoDAO.buscaEquipamentosAlocadosViatura(viatura);
        for (Equipamento equipamento : equipamentosAlocadosViatura) {

            if (mapViaturaEquipamentoAlocados.containsKey(idViaturaAlocada)) {
                mapViaturaEquipamentoAlocados.get(idViaturaAlocada).add(equipamento);
            } else {
                mapViaturaEquipamentoAlocados.put(idViaturaAlocada, new ArrayList<Equipamento>());
                mapViaturaEquipamentoAlocados.get(idViaturaAlocada).add(equipamento);
            }
        }
        System.out.println("map " + mapViaturaEquipamentoAlocados);
    }


    private void liberarViaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liberarViaturaActionPerformed
        int linha = JTableViaturasAlocadas.getSelectedRow();
        int idViaturaAlocada = Integer.parseInt(tableViaturasAlocadas.getValueAt(linha, 0).toString());
        Viatura viatura = new Viatura();
        viatura.setIdviatura(idViaturaAlocada);
        boolean sucesso = true;
        if(!viaturaDAO.liberaViatura(viatura)){
            sucesso = false;
        }
        if(sucesso){
            List<Equipamento> equipamentosAlocadosViatura;
            equipamentosAlocadosViatura = equipamentoDAO.buscaEquipamentosAlocadosViatura(viatura);
            for (Equipamento equipamento : equipamentosAlocadosViatura) {
                if(!equipamentoDAO.liberaEquipamento(equipamento)){
                    sucesso = false;
                    JOptionPane.showMessageDialog(null, "Erro ao liberar Equipamento!");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro ao liberar Viatura!");
        }
        if(sucesso){
            JOptionPane.showMessageDialog(null, "Viatura e Equipamentos Liberados com Sucesso!");
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro ao liberar Viatura e Equipamentos");
        }
        
        AdicionaMapViaturaEquipamentoAlocados(idViaturaAlocada);

    }//GEN-LAST:event_liberarViaturaActionPerformed
    public void populaTabelaEquipamentosAlocados(int idViatura) {
        limpaTabelaEquipamentosAlocados();
        Viatura viatura = new Viatura();
        viatura.setIdviatura(idViatura);
        List<Equipamento> equipamentosAlocadosViatura;
        equipamentosAlocadosViatura = equipamentoDAO.buscaEquipamentosAlocadosViatura(viatura);

        for (Equipamento eq : equipamentosAlocadosViatura) {
            tableEquipamentosAlocados.addRow(new Object[]{eq.getIdequipamento(), eq.getNome(), eq.getMarca()});

        }
    }

    public void limpaTabelaEquipamentosAlocados() {
        if (tableEquipamentosAlocados.getRowCount() > 0) {
            int qtd = tableEquipamentosAlocados.getRowCount();
            for (int i = 0; i < qtd; i++) {
                tableEquipamentosAlocados.removeRow(0);
            }
        }
    }

    public void limpaTabelaEquipamentosSelecionadosAlocacao() {
        if (tableEquipamentosSelecionadosAlocacao.getRowCount() > 0) {
            int qtd = tableEquipamentosSelecionadosAlocacao.getRowCount();
            for (int i = 0; i < qtd; i++) {
                tableEquipamentosSelecionadosAlocacao.removeRow(0);
            }
        }
    }

    public void removeEquipamentoSelecionadoLista(int id) {
        for (int i = 0; i < lstEquipamentosSelecionados.size(); i++) {
            if (lstEquipamentosSelecionados.get(i).equals(id)) {
                lstEquipamentosSelecionados.remove(i);
                break;
            }
        }
    }

    public void removeEquipamentoMap(int idEquipamento) {
        for (Map.Entry<Integer, ArrayList<Integer>> entry : mapViaturaEquipamento.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            if (key.equals(idViaturaSelecionadaAlocacao)) {
                for (int i = 0; i < mapViaturaEquipamento.get(key).size(); i++) {
                    if (mapViaturaEquipamento.get(key).get(i).equals(idEquipamento)) {
                        mapViaturaEquipamento.get(key).remove(i);
                    }
                }
            }
        }
        populaTabelaEquipamentosSelecionadosAlocacao(idViaturaSelecionadaAlocacao);
    }

    public void populaTabelaViaturasSelecionadasAlocacao() {
        if (tableViaturasSelecionadasAlocacao.getRowCount() > 0) {
            int qtd = tableViaturasSelecionadasAlocacao.getRowCount();
            for (int i = 0; i < qtd; i++) {
                tableViaturasSelecionadasAlocacao.removeRow(0);
            }
        }
        for (Viatura viatura : lstViaturasDisponiveis) {
            status = viatura.getIdstatus();
            categoria = viatura.getIdcategoria();
            tpViatura = viatura.getIdtipoviatura();
            tpCombustivel = viatura.getIdtipocombustivel();
            Status statusResult = statusDAO.buscaStatusPorID(status.getIdstatus());

            Categoria categoriaResult = categoriaDAO.buscaCategoriaPorID(categoria.getIdcategoria());
            Tipocombustivel tpCombustivelResult = tpCombustivelDAO.buscaTipoCombustivelPorID(tpCombustivel.getIdtipocombustivel());
            Tipoviatura tpViaturaResult = tpViaturaDAO.buscaTipoViaturaPorID(tpViatura.getIdtipoviatura());
            if (lstAuxViaturas.contains(viatura.getIdviatura())) {
                tableViaturasSelecionadasAlocacao.addRow(new Object[]{viatura.getIdviatura(), viatura.getPlaca(), categoriaResult.getDescricao(),
                    tpViaturaResult.getDescricao()});
            }
        }
    }

    public void setIdEquipamento(int id) {
        idEquipamentoSelecionado = id;
        lstEquipamentosSelecionados.add(id);
        AdicionaMapViaturaEquipamento(idViaturaSelecionadaAlocacao);

    }

    public void AdicionaMapViaturaEquipamento(int idViaturaAlocada) {
        if (mapViaturaEquipamento.containsKey(idViaturaAlocada)) {
            mapViaturaEquipamento.get(idViaturaAlocada).add(idEquipamentoSelecionado);
        } else {
            mapViaturaEquipamento.put(idViaturaAlocada, new ArrayList<Integer>());
            mapViaturaEquipamento.get(idViaturaAlocada).add(idEquipamentoSelecionado);
        }
        System.out.println("map " + mapViaturaEquipamento);
        populaTabelaEquipamentosSelecionadosAlocacao(idViaturaAlocada);
    }

    public void populaTabelaEquipamentosSelecionadosAlocacao(int idViaturaAlocada) {
        limpaTabelaEquipamentosSelecionadosAlocacao();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : mapViaturaEquipamento.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            if (key.equals(idViaturaAlocada)) {
                for (Integer idEquipamento : value) {
                    Equipamento eq = equipamentoDAO.buscaEquipamentoPorID(idEquipamento);
//                    Status status = eq.getIdstatus();
//                    Status statusResult = statusDAO.buscaStatusPorID(status.getIdstatus());
                    tableEquipamentosSelecionadosAlocacao.addRow(new Object[]{eq.getIdequipamento(), eq.getNome(), eq.getMarca()});
                }
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableEquipamentosAlocados;
    private javax.swing.JTable JTableViaturasAlocadas;
    private javax.swing.JButton btnAdicionarEquipamentoViatura;
    private javax.swing.JButton btnAlocarViatura;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemoverEquipamento;
    private javax.swing.JButton btnRemoverViaturaAlocada;
    private javax.swing.JButton btnSalvarAlocacao;
    private javax.swing.JComboBox<String> jComboStatusMilitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableEquipamentosSelecionadosAlocacao;
    private javax.swing.JTable jTableMilitares;
    private javax.swing.JTable jTableViaturasDisponiveis;
    private javax.swing.JTable jTableViaturasSelecionadasAlocacao;
    private javax.swing.JButton liberarViatura;
    // End of variables declaration//GEN-END:variables
}
