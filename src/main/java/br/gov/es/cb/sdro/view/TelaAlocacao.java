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
import br.gov.es.cb.sdro.model.Viatura;
import br.gov.es.cb.sdro.util.CategoriaDAO;
import br.gov.es.cb.sdro.util.StatusDAO;
import br.gov.es.cb.sdro.util.TipocombustivelDAO;
import br.gov.es.cb.sdro.util.TipoviaturaDAO;
import br.gov.es.cb.sdro.util.ViaturaDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Patrícia
 */
public class TelaAlocacao extends javax.swing.JInternalFrame {
    
    private DefaultTableModel tableViaturas;
    DefaultTableModel tableViaturasAlocadas;
    ViaturaDAO viaturaDAO;
    List<Viatura> lstViaturas;
    StatusDAO statusDAO;
    CategoriaDAO categoriaDAO;
    TipocombustivelDAO tpCombustivelDAO;
    TipoviaturaDAO tpViaturaDAO;
    Status status;
    Categoria categoria;
    Tipocombustivel tpCombustivel;
    Tipoviatura tpViatura;
    ArrayList<Viatura> lstViaturasAlocadas;
    ArrayList<Integer> lstAuxViaturas;
    private static TelaAlocacao telaAlocacao;
    int idEquipamentoSelecionado;
    int idViaturaAlocada;
    HashMap<Integer, ArrayList<Integer>> mapViaturaEquipamento;

    /**
     * Creates new form TelaAlocar
     */
    public static TelaAlocacao getInstancia() {
        if (telaAlocacao == null) {
            telaAlocacao = new TelaAlocacao();
        }
        return telaAlocacao;
    }

    private TelaAlocacao() {
        initComponents();
        mapViaturaEquipamento = new HashMap<Integer, ArrayList<Integer>>();
        status = new Status();
        categoria = new Categoria();
        tpCombustivel = new Tipocombustivel();
        tpViatura = new Tipoviatura();
        statusDAO = new StatusDAO();
        categoriaDAO = new CategoriaDAO();
        tpCombustivelDAO = new TipocombustivelDAO();
        tpViaturaDAO = new TipoviaturaDAO();
        viaturaDAO = new ViaturaDAO();
        tableViaturas = (DefaultTableModel) jTableViaturas.getModel();
        tableViaturasAlocadas = (DefaultTableModel) jTableViaturasAlocadas.getModel();
        lstViaturas = viaturaDAO.buscaViaturasDisponiveis();
        lstViaturasAlocadas = new ArrayList<Viatura>();
        lstAuxViaturas = new ArrayList<Integer>();
        addTabelaViaturas();
        this.setVisible(true);
    }
    
    public void addTabelaViaturas() {
        if (tableViaturas.getRowCount() > 0) {
            
            int qtd = tableViaturas.getRowCount();
            for (int i = 0; i < qtd; i++) {
                tableViaturas.removeRow(0);
            }
        }
        System.out.println(lstViaturas);
        for (Viatura vt : lstViaturas) {
            status = vt.getIdstatus();
            categoria = vt.getIdcategoria();
            tpViatura = vt.getIdtipoviatura();
            tpCombustivel = vt.getIdtipocombustivel();
            Status statusResult = statusDAO.buscaStatusPorID(status.getIdstatus());
            
            Categoria categoriaResult = categoriaDAO.buscaCategoriaPorID(categoria.getIdcategoria());
            Tipocombustivel tpCombustivelResult = tpCombustivelDAO.buscaTipoCombustivelPorID(tpCombustivel.getIdtipocombustivel());
            Tipoviatura tpViaturaResult = tpViaturaDAO.buscaTipoViaturaPorID(tpViatura.getIdtipoviatura());
            
            tableViaturas.addRow(new Object[]{vt.getIdviatura(), vt.getPlaca(), vt.getPrefixo(), vt.getModelo(), categoriaResult.getDescricao(),
                tpViaturaResult.getDescricao(), vt.getCappessoas(), vt.getCapagua(), statusResult.getDescricao(), statusResult.getDescricao()});
        }
        
    }
    
    public void atualizaTabelaViaturas() {
        if (tableViaturas.getRowCount() > 0) {
            int qtd = tableViaturas.getRowCount();
            for (int i = 0; i < qtd; i++) {
                tableViaturas.removeRow(0);
            }
        }
        for (Viatura vt : lstViaturas) {
            status = vt.getIdstatus();
            categoria = vt.getIdcategoria();
            tpViatura = vt.getIdtipoviatura();
            tpCombustivel = vt.getIdtipocombustivel();
            Status statusResult = statusDAO.buscaStatusPorID(status.getIdstatus());
            
            Categoria categoriaResult = categoriaDAO.buscaCategoriaPorID(categoria.getIdcategoria());
            Tipocombustivel tpCombustivelResult = tpCombustivelDAO.buscaTipoCombustivelPorID(tpCombustivel.getIdtipocombustivel());
            Tipoviatura tpViaturaResult = tpViaturaDAO.buscaTipoViaturaPorID(tpViatura.getIdtipoviatura());
            if (!lstAuxViaturas.contains(vt.getIdviatura())) {
                tableViaturas.addRow(new Object[]{vt.getIdviatura(), vt.getPlaca(), vt.getPrefixo(), vt.getModelo(), categoriaResult.getDescricao(),
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableViaturas = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableViaturasAlocadas = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableEquipamentosAlocados = new javax.swing.JTable();
        btnAlocarViatura = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnAdicionarEquipamentoViatura = new javax.swing.JButton();
        btnRemoverViaturaAlocada = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setClosable(true);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTableViaturas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableViaturas);
        if (jTableViaturas.getColumnModel().getColumnCount() > 0) {
            jTableViaturas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableViaturas.getColumnModel().getColumn(1).setMaxWidth(100);
            jTableViaturas.getColumnModel().getColumn(2).setMaxWidth(100);
            jTableViaturas.getColumnModel().getColumn(6).setMaxWidth(75);
            jTableViaturas.getColumnModel().getColumn(7).setMaxWidth(75);
            jTableViaturas.getColumnModel().getColumn(8).setMaxWidth(300);
        }

        jTableViaturasAlocadas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTableViaturasAlocadas);
        if (jTableViaturasAlocadas.getColumnModel().getColumnCount() > 0) {
            jTableViaturasAlocadas.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableViaturasAlocadas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableViaturasAlocadas.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jTableEquipamentosAlocados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Marca"
            }
        ));
        jScrollPane5.setViewportView(jTableEquipamentosAlocados);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlocarViatura)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdicionarEquipamentoViatura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoverViaturaAlocada)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlocarViatura)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarEquipamentoViatura)
                    .addComponent(btnRemoverViaturaAlocada))
                .addGap(142, 142, 142))
        );

        jTabbedPane1.addTab("Viatura", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane2.addTab("tab1", jScrollPane2);

        jTabbedPane1.addTab("Miitares", jTabbedPane2);

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

    private void btnAlocarViaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlocarViaturaActionPerformed
        int linha = jTableViaturas.getSelectedRow();
        int codigo = Integer.parseInt(tableViaturas.getValueAt(linha, 0).toString());
        lstAuxViaturas.add(codigo);
        Viatura viatura = new Viatura();
        viatura = viaturaDAO.buscaViaturaPorID(codigo);
        addTabelaViaturasSelecionadas();
        atualizaTabelaViaturas();
    }//GEN-LAST:event_btnAlocarViaturaActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void btnRemoverViaturaAlocadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverViaturaAlocadaActionPerformed
        int linha = jTableViaturasAlocadas.getSelectedRow();
        int codigo = Integer.parseInt(tableViaturasAlocadas.getValueAt(linha, 0).toString());
        for (int i = 0; i < lstAuxViaturas.size(); i++) {
            if (lstAuxViaturas.get(i).equals(codigo)) {
                lstAuxViaturas.remove(i);
                break;
            }
        }
        atualizaTabelaViaturas();
        addTabelaViaturasSelecionadas();
    }//GEN-LAST:event_btnRemoverViaturaAlocadaActionPerformed

    private void btnAdicionarEquipamentoViaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEquipamentoViaturaActionPerformed
        int linha = jTableViaturasAlocadas.getSelectedRow();
        idViaturaAlocada = Integer.parseInt(tableViaturasAlocadas.getValueAt(linha, 0).toString());
        try {
            TelaEquipamentosAlocacao equipamentoAlocacao = new TelaEquipamentosAlocacao();
            
        } catch (Exception ex) {
            Logger.getLogger(TelaAlocacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }//GEN-LAST:event_btnAdicionarEquipamentoViaturaActionPerformed
    
    public void addTabelaViaturasSelecionadas() {
        if (tableViaturasAlocadas.getRowCount() > 0) {
            int qtd = tableViaturasAlocadas.getRowCount();
            for (int i = 0; i < qtd; i++) {
                tableViaturasAlocadas.removeRow(0);
            }
        }
        for (Viatura viatura : lstViaturas) {
            status = viatura.getIdstatus();
            categoria = viatura.getIdcategoria();
            tpViatura = viatura.getIdtipoviatura();
            tpCombustivel = viatura.getIdtipocombustivel();
            Status statusResult = statusDAO.buscaStatusPorID(status.getIdstatus());
            
            Categoria categoriaResult = categoriaDAO.buscaCategoriaPorID(categoria.getIdcategoria());
            Tipocombustivel tpCombustivelResult = tpCombustivelDAO.buscaTipoCombustivelPorID(tpCombustivel.getIdtipocombustivel());
            Tipoviatura tpViaturaResult = tpViaturaDAO.buscaTipoViaturaPorID(tpViatura.getIdtipoviatura());
            if (lstAuxViaturas.contains(viatura.getIdviatura())) {
                tableViaturasAlocadas.addRow(new Object[]{viatura.getIdviatura(), viatura.getPlaca(), categoriaResult.getDescricao(),
                    tpViaturaResult.getDescricao()});
            }
        }
    }

    public void setIdEquipamento(int id) {
        idEquipamentoSelecionado = id;
         AdicionaMapViaturaEquipamento(idViaturaAlocada);
        
    }
    
    public void AdicionaMapViaturaEquipamento(int idViaturaAlocada) {
        if (mapViaturaEquipamento.containsKey(idViaturaAlocada)) {
            mapViaturaEquipamento.get(idViaturaAlocada).add(idEquipamentoSelecionado);
        } else {
            mapViaturaEquipamento.put(idViaturaAlocada, new ArrayList<Integer>());
            mapViaturaEquipamento.get(idViaturaAlocada).add(idEquipamentoSelecionado);
        }   
        System.out.println("map "+mapViaturaEquipamento);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarEquipamentoViatura;
    private javax.swing.JButton btnAlocarViatura;
    private javax.swing.JButton btnRemoverViaturaAlocada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableEquipamentosAlocados;
    private javax.swing.JTable jTableViaturas;
    private javax.swing.JTable jTableViaturasAlocadas;
    // End of variables declaration//GEN-END:variables
}
