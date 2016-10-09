/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.es.cb.sdro.view;

import br.gov.es.cb.sdro.model.Categoria;
import br.gov.es.cb.sdro.model.Status;
import br.gov.es.cb.sdro.model.Tipocombustivel;
import br.gov.es.cb.sdro.model.Tipoviatura;
import br.gov.es.cb.sdro.model.Unidade;
import br.gov.es.cb.sdro.model.Viatura;
import br.gov.es.cb.sdro.util.CategoriaDAO;
import br.gov.es.cb.sdro.util.ChecaSimilaridadeString;
import br.gov.es.cb.sdro.util.StatusDAO;
import br.gov.es.cb.sdro.util.TipocombustivelDAO;
import br.gov.es.cb.sdro.util.TipoviaturaDAO;
import br.gov.es.cb.sdro.util.ViaturaDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thales Carreta
 */
public class TelaViatura extends javax.swing.JInternalFrame {
    int codigo;
    List<Viatura> lstViatura;
    ViaturaDAO viaturaDAO;
    private DefaultTableModel tableViatura;
    
    List<Tipoviatura> lstTipoViatura;
    List<Status> lstStatus;
    List<Categoria> lstCategoria;
    List<Tipocombustivel> lstTipoCombustivel;
    
    TipoviaturaDAO tipoViaturaDAO;
    StatusDAO statusDAO;
    CategoriaDAO categoriaDAO;
    TipocombustivelDAO tipoCombustivelDAO;
    
    HashMap<String,Integer> mapTipoViatura;
    HashMap<String,Integer> mapStatus;
    HashMap<String,Integer> mapCategoria;
    HashMap<String,Integer> mapTipoCombustivel;
    
    Tipoviatura tipoViatura;
    Status status;
    Categoria categoria;
    Tipocombustivel tipoCombustivel;
    ChecaSimilaridadeString similaridadeString;
    
    /**
     * Creates new form NovoJInternalFrame
     */
    
    public TelaViatura() throws Exception {
        initComponents();            
        tableViatura = (DefaultTableModel) jTableViatura.getModel();
        viaturaDAO = new ViaturaDAO();
        similaridadeString = new ChecaSimilaridadeString();

        tipoViatura = new Tipoviatura();
        lstTipoViatura = new ArrayList<Tipoviatura>();
        tipoViaturaDAO = new TipoviaturaDAO();
        lstTipoViatura = tipoViaturaDAO.buscaTipoviaturas();
        mapTipoViatura = getMapTipoViatura(lstTipoViatura);
        System.out.println(lstTipoViatura);
        comboTipoViatura.removeAllItems();
        for (Tipoviatura tipoViatura : lstTipoViatura) {
            comboTipoViatura.addItem(tipoViatura.getDescricao());
        }    
        
        status = new Status();
        lstStatus = new ArrayList<>();
        statusDAO = new StatusDAO();
        lstStatus = statusDAO.buscaStatuss();
        this.mapStatus = getMapStatus(lstStatus);
        comboStatus.removeAllItems();
        for (Status status : lstStatus) {
            comboStatus.addItem(status.getDescricao());
        }
        
        categoria = new Categoria();
        lstCategoria = new ArrayList<>();
        categoriaDAO = new CategoriaDAO();
        lstCategoria = categoriaDAO.buscaCategorias();
        this.mapCategoria = getMapCategoria(lstCategoria);
        comboCategoria.removeAllItems();
        for (Categoria categoria : lstCategoria) {
            comboCategoria.addItem(categoria.getDescricao());
        }
        
        tipoCombustivel = new Tipocombustivel();
        lstTipoCombustivel = new ArrayList<>();
        tipoCombustivelDAO = new TipocombustivelDAO();
        lstTipoCombustivel = tipoCombustivelDAO.buscaTipoCombustiveis();
        this.mapTipoCombustivel = getMapTipoCombustivel(lstTipoCombustivel);
        comboTipoCombustivel.removeAllItems();
        for (Tipocombustivel tipoCombustivel : lstTipoCombustivel) {
            comboTipoCombustivel.addItem(tipoCombustivel.getDescricao());
        }        
        addTabela();  //Usar quando clicar na aba
        this.setVisible(true);
    }
    
     public HashMap getMapTipoViatura(List<Tipoviatura> lstTipoViatura){
        HashMap<String,Integer> mapTipoViatura = new HashMap<>();
        for (Tipoviatura tipoViatura : lstTipoViatura) {
            mapTipoViatura.put(tipoViatura.getDescricao(), tipoViatura.getIdtipoviatura());
        }
        return mapTipoViatura;
    }
    public int getIdTipoViatura(String tipoViatura){
        for (Map.Entry<String, Integer> entry : mapTipoViatura.entrySet()) {
            String key = entry.getKey();
            int id = entry.getValue();
            if(key.equals(tipoViatura)){
                return id;
            }
        }
        return 0;
    }
    
    public HashMap getMapStatus(List<Status> lstStatus){
        HashMap<String,Integer> mapStatus = new HashMap<>();
        for (Status status : lstStatus) {
            mapStatus.put(status.getDescricao(), status.getIdstatus());
        }
        return mapStatus;
    }
    public int getIdStatus(String status){
        for (Map.Entry<String, Integer> entry : mapStatus.entrySet()) {
            String key = entry.getKey();
            int id = entry.getValue();
            if(key.equals(status)){
                return id;
            }
        }
        return 0;
    }
    
    public HashMap getMapCategoria(List<Categoria> lstCategoria){
        HashMap<String,Integer> mapCategoria = new HashMap<>();
        for (Categoria categoria : lstCategoria) {
            mapCategoria.put(categoria.getDescricao(), categoria.getIdcategoria());
        }
        return mapCategoria;
    }
    public int getIdCategoria(String categoria){
        for (Map.Entry<String, Integer> entry : mapCategoria.entrySet()) {
            String key = entry.getKey();
            int id = entry.getValue();
            if(key.equals(categoria)){
                return id;
            }
        }
        return 0;
    }
    
    public HashMap getMapTipoCombustivel(List<Tipocombustivel> lstTipoCombustivel){
        HashMap<String,Integer> mapTipoCombustivel = new HashMap<>();
        for (Tipocombustivel tipoCombustivel : lstTipoCombustivel) {
            mapTipoCombustivel.put(tipoCombustivel.getDescricao(), tipoCombustivel.getIdtipocombustivel());
        }
        return mapTipoCombustivel;
    }
    public int getIdTipoCombustivel(String tipoCombustivel){
        for (Map.Entry<String, Integer> entry : mapTipoCombustivel.entrySet()) {
            String key = entry.getKey();
            int id = entry.getValue();
            if(key.equals(tipoCombustivel)){
                return id;
            }
        }
        return 0;
    }
    
    
    
   
    public void addTabela() throws Exception {
        //pega o modelo da tabela
        //chama metodo da Class Gerenciador com o nome de ListaCliente passando um nome
       
        lstViatura = viaturaDAO.buscaViaturas();
        
        for (Viatura eq : lstViatura) {//vare a lista de Cliente obtida
            /*
            Tipoviatura viatura = eq.getIdviatura();
            Tipoviatura = ViaturaDAO.buscaStatusPorID(status.getIdstatus());
            */
            Status status = eq.getIdstatus();
            Status statusResult = statusDAO.buscaStatusPorID(status.getIdstatus());
           
           
            tableViatura.addRow(new Object[]{eq.getIdviatura(), 
                                             eq.getPrefixo(), 
                                             eq.getPlaca(), 
                                             eq.getMarca(), 
                                             eq.getModelo(), 
                                             eq.getAno(), 
                                             eq.getCapagua(), 
                                             eq.getCappessoas(), 
                                             
                                             statusResult.getDescricao()});
            
        }
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCapPessoas = new javax.swing.JTextField();
        txtCapAgua = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboTipoViatura = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        comboTipoCombustivel = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        txtPrefixo = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtPrefixoAlterar = new javax.swing.JTextField();
        txtPlacaAlterar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMarcaAlterar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtAnoAlterar = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtModeloAlterar = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtCapPessoasAlterar = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtCapAguaAlterar = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        comboTipoViaturaAlterar = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        comboStatusAlterar = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        comboCategoriaAlterar = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        comboTipoCombustivelAlterar = new javax.swing.JComboBox<>();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableViatura = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel7.setText("Modelo");

        jLabel5.setText("Marca");

        jLabel1.setText("Prefixo");

        jLabel2.setText("Placa");

        jLabel6.setText("Ano");

        jLabel8.setText("Cap. Pessoas");

        jLabel9.setText("Cap. Água");

        jLabel10.setText("Tipo de Viatura");

        comboTipoViatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Status");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Categoria");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Combustível");

        comboTipoCombustivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMarca)
                            .addComponent(txtPrefixo, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAno)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(139, 139, 139))
                            .addComponent(comboTipoCombustivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboTipoViatura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalvar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCapPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCapAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrefixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtCapPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCapAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipoViatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipoCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Cadastrar", jPanel2);

        jLabel14.setText("Prefixo");

        txtPlacaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaAlterarActionPerformed(evt);
            }
        });

        jLabel15.setText("Placa");

        jLabel16.setText("Marca");

        jLabel17.setText("Ano");

        jLabel18.setText("Modelo");

        jLabel19.setText("Cap. Pessoas");

        jLabel20.setText("Cap. Água");

        jLabel21.setText("Tipo de Viatura");

        comboTipoViaturaAlterar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel22.setText("Status");

        comboStatusAlterar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel23.setText("Categoria");

        comboCategoriaAlterar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel24.setText("Combustível");

        comboTipoCombustivelAlterar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAlterar.setText("Salvar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel25.setText("Pesquisar");

        txtPesquisar.setText("???");
        txtPesquisar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtPesquisarCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtPesquisarInputMethodTextChanged(evt);
            }
        });
        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyPressed(evt);
            }
        });

        jTableViatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Marca", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableViatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableViaturaMouseClicked(evt);
            }
        });
        jTableViatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableViaturaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableViatura);

        jLabel26.setText("Placa");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCapPessoasAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCapAguaAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMarcaAlterar)
                                    .addComponent(txtPrefixoAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAnoAlterar)
                                    .addComponent(txtPlacaAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtModeloAlterar))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(comboCategoriaAlterar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(139, 139, 139))
                                    .addComponent(comboTipoCombustivelAlterar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboTipoViaturaAlterar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(comboStatusAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterar)))
                        .addGap(16, 16, 16))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtPrefixoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlacaAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtMarcaAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtModeloAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtCapPessoasAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCapAguaAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipoViaturaAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStatusAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCategoriaAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipoCombustivelAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir))
                .addGap(6, 6, 6))
        );

        jTabbedPane3.addTab("Editar", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String tipoviaturadescricao = comboTipoViatura.getSelectedItem().toString();
        int idTipoViatura = getIdTipoViatura(tipoviaturadescricao);
        tipoViatura.setIdtipoviatura(idTipoViatura);

        String statusdescricao = comboStatus.getSelectedItem().toString();
        int idStatus = getIdStatus(statusdescricao);
        status.setIdstatus(idStatus);

        String categoriadescricao = comboCategoria.getSelectedItem().toString();
        int idCategoria = getIdCategoria(categoriadescricao);
        categoria.setIdcategoria(idCategoria);

        String tipocombustiveldescricao = comboTipoCombustivel.getSelectedItem().toString();
        int idTipoCombustivel = getIdTipoCombustivel(tipocombustiveldescricao);
        tipoCombustivel.setIdtipocombustivel(idTipoCombustivel);

        Unidade unidade = new Unidade();
        unidade.setIdunidade(1);
        Viatura viatura = new Viatura();
        //       viatura.setIdviatura(101);
        viatura.setIdunidade(unidade);
        viatura.setIsalocado(false);
        viatura.setIscbmes(false);
        viatura.setPrefixo(txtPrefixo.getText());
        viatura.setPlaca(txtPlaca.getText());
        viatura.setMarca(txtMarca.getText());
        viatura.setAno(Integer.parseInt(txtAno.getText()));
        viatura.setModelo(txtModelo.getText());
        viatura.setCappessoas(Integer.parseInt(txtCapPessoas.getText()));
        viatura.setCapagua(Integer.parseInt(txtCapAgua.getText()));
        viatura.setIdtipoviatura(tipoViatura);
        viatura.setIdstatus(status);
        viatura.setIdcategoria(categoria);
        viatura.setIdtipocombustivel(tipoCombustivel);
        viaturaDAO.save(viatura);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linha  = jTableViatura.getSelectedRow();
        codigo = Integer.parseInt(jTableViatura.getValueAt(linha, 0).toString());
       
        String tipoviaturadescricao = comboTipoViatura.getSelectedItem().toString();
        int idTipoViatura = getIdTipoViatura(tipoviaturadescricao);
        tipoViatura.setIdtipoviatura(idTipoViatura);

        String statusdescricao = comboStatus.getSelectedItem().toString();
        int idStatus = getIdStatus(statusdescricao);
        status.setIdstatus(idStatus);

        String categoriadescricao = comboCategoria.getSelectedItem().toString();
        int idCategoria = getIdCategoria(categoriadescricao);
        categoria.setIdcategoria(idCategoria);

        String tipocombustiveldescricao = comboTipoCombustivel.getSelectedItem().toString();
        int idTipoCombustivel = getIdTipoCombustivel(tipocombustiveldescricao);
        tipoCombustivel.setIdtipocombustivel(idTipoCombustivel);

        Unidade unidade = new Unidade();
        unidade.setIdunidade(1);
        Viatura viatura = new Viatura();
        //       viatura.setIdviatura(101);
        viatura.setIdunidade(unidade);
        viatura.setIsalocado(false);
        viatura.setIscbmes(false);
        viatura.setPrefixo(txtPrefixo.getText());
        viatura.setPlaca(txtPlaca.getText());
        viatura.setMarca(txtMarca.getText());
        viatura.setAno(Integer.parseInt(txtAno.getText()));
        viatura.setModelo(txtModelo.getText());
        viatura.setCappessoas(Integer.parseInt(txtCapPessoas.getText()));
        viatura.setCapagua(Integer.parseInt(txtCapAgua.getText()));
        viatura.setIdtipoviatura(tipoViatura);
        viatura.setIdstatus(status);
        viatura.setIdcategoria(categoria);
        viatura.setIdtipocombustivel(tipoCombustivel);
        
        
        viaturaDAO.update(viatura);
    }//GEN-LAST:event_btnAlterarActionPerformed

    
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha  = jTableViatura.getSelectedRow();
          codigo = Integer.parseInt(jTableViatura.getValueAt(linha, 0).toString());
          Viatura eq = new Viatura();
          
          eq.setIdviatura(codigo);
          viaturaDAO.remove(eq);
    }//GEN-LAST:event_btnExcluirActionPerformed

    
    private void txtPesquisarCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtPesquisarCaretPositionChanged

    }//GEN-LAST:event_txtPesquisarCaretPositionChanged

    
    private void txtPesquisarInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtPesquisarInputMethodTextChanged

    }//GEN-LAST:event_txtPesquisarInputMethodTextChanged

    
    private void txtPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyPressed
        String input = txtPesquisar.getText();
        System.out.println(input);

        if (jTableViatura.getRowCount() > 0){
            for (int i=0;i<=jTableViatura.getRowCount();i++){
                tableViatura.removeRow(0);
            }

        }
        for (Viatura eq : lstViatura) {
            float result = 0;
            try {
                result = similaridadeString.checkSimilarity(eq.getMarca().toString(),input);                //getNome ???
            } catch (Exception ex) {
                Logger.getLogger(TelaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("result"+result);
            if(result > 0.50){
                Status status = eq.getIdstatus();
                Status statusResult = statusDAO.buscaStatusPorID(status.getIdstatus());
                tableViatura.addRow(new Object[]{eq.getIdviatura(), 
                                                 eq.getAno().toString(), 
                                                 eq.getMarca(),
                                                 statusResult.getDescricao()});
            }

        }
        if(input.equals("")){
            for (Viatura eq : lstViatura) {
                Status status = eq.getIdstatus();
                Status statusResult = statusDAO.buscaStatusPorID(status.getIdstatus());
                tableViatura.addRow(new Object[]{eq.getIdviatura(), 
                                                 eq.getCappessoas().toString(), 
                                                 eq.getMarca(),
                                                 statusResult.getDescricao()});
            }

        }
    }//GEN-LAST:event_txtPesquisarKeyPressed

    
    private void jTableViaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableViaturaMouseClicked
        int linha  = jTableViatura.getSelectedRow();
        codigo = Integer.parseInt(jTableViatura.getValueAt(linha, 0).toString());
        for (Viatura eq : lstViatura) {
            System.out.println(eq.getIdstatus());
            if(eq.getIdviatura().equals(codigo)){
                //txt Alterar.setText(eq.getIdviatura());
                txtPrefixoAlterar.setText(eq.getPrefixo());
                txtPlacaAlterar.setText(eq.getPlaca());
                txtMarcaAlterar.setText(eq.getMarca());
                txtModeloAlterar.setText(eq.getModelo());
                txtAnoAlterar.setText(eq.getAno().toString());             //parseString ???
                txtCapAguaAlterar.setText(eq.getCapagua().toString());    
                txtCapPessoasAlterar.setText(eq.getCappessoas().toString());
                
                //TipoViatura
                comboTipoViaturaAlterar.removeAllItems();
                System.out.println(eq.getIdtipoviatura().getDescricao());
                System.out.println(eq.getIdtipoviatura().getIdtipoviatura());
                comboTipoViaturaAlterar.addItem(eq.getIdtipoviatura().getDescricao());
                for (Tipoviatura tipoViatura : lstTipoViatura) {
                    if(!tipoViatura.getDescricao().equals(eq.getIdtipoviatura().getDescricao())){
                        comboTipoViaturaAlterar.addItem(status.getDescricao());
                    }
                }
                //Status    
                comboStatusAlterar.removeAllItems();
                System.out.println(eq.getIdstatus().getDescricao());
                System.out.println(eq.getIdstatus().getIdstatus());
                comboStatusAlterar.addItem(eq.getIdstatus().getDescricao());
                for (Status status : lstStatus) {
                    if(!status.getDescricao().equals(eq.getIdstatus().getDescricao())){
                        comboStatusAlterar.addItem(status.getDescricao());
                    }
                }
                
                //Categoria
                comboCategoriaAlterar.removeAllItems();
                System.out.println(eq.getIdcategoria().getDescricao());
                System.out.println(eq.getIdcategoria().getIdcategoria());
                comboCategoriaAlterar.addItem(eq.getIdcategoria().getDescricao());
                for (Categoria categoria : lstCategoria) {
                    if(!categoria.getDescricao().equals(eq.getIdcategoria().getDescricao())){
                        comboCategoriaAlterar.addItem(categoria.getDescricao());
                    }
                }
                
                //TipoCombustivel
                comboTipoCombustivelAlterar.removeAllItems();
                System.out.println(eq.getIdtipocombustivel().getDescricao());
                System.out.println(eq.getIdtipocombustivel().getIdtipocombustivel());
                comboTipoCombustivelAlterar.addItem(eq.getIdtipocombustivel().getDescricao());
                for (Tipocombustivel tipoCombustivel : lstTipoCombustivel) {
                    if(!tipoCombustivel.getDescricao().equals(eq.getIdtipocombustivel().getDescricao())){
                        comboTipoCombustivelAlterar.addItem(status.getDescricao());
                    }
                }
                
            }
        }
    }//GEN-LAST:event_jTableViaturaMouseClicked

    private void jTableViaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableViaturaKeyPressed
        int linha  = jTableViatura.getSelectedRow();
        codigo = Integer.parseInt(jTableViatura.getValueAt(linha, 0).toString());
    }//GEN-LAST:event_jTableViaturaKeyPressed

    private void txtPlacaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaAlterarActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboCategoriaAlterar;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JComboBox<String> comboStatusAlterar;
    private javax.swing.JComboBox<String> comboTipoCombustivel;
    private javax.swing.JComboBox<String> comboTipoCombustivelAlterar;
    private javax.swing.JComboBox<String> comboTipoViatura;
    private javax.swing.JComboBox<String> comboTipoViaturaAlterar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTableViatura;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtAnoAlterar;
    private javax.swing.JTextField txtCapAgua;
    private javax.swing.JTextField txtCapAguaAlterar;
    private javax.swing.JTextField txtCapPessoas;
    private javax.swing.JTextField txtCapPessoasAlterar;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMarcaAlterar;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtModeloAlterar;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPlacaAlterar;
    private javax.swing.JTextField txtPrefixo;
    private javax.swing.JTextField txtPrefixoAlterar;
    // End of variables declaration//GEN-END:variables

    
}
