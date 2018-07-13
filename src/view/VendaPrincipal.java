package view;

import controller.VendaController;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VendaPrincipal extends javax.swing.JFrame {

    VendaController controllerVenda = new VendaController(VendaPrincipal.this);
    
    public VendaPrincipal() {
        initComponents();
        this.controllerVenda.listarCliente();
        this.controllerVenda.listarFuncionario();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JComboBox getCbCliente() {
        return cbCliente;
    }

    public void setCbCliente(JComboBox cbCliente) {
        this.cbCliente = cbCliente;
    }

    public JComboBox getCbFormaPagamento() {
        return cbFormaPagamento;
    }

    public void setCbFormaPagamento(JComboBox cbFormaPagamento) {
        this.cbFormaPagamento = cbFormaPagamento;
    }

    public JComboBox getCbFuncionario() {
        return cbFuncionario;
    }

    public void setCbFuncionario(JComboBox cbFuncionario) {
        this.cbFuncionario = cbFuncionario;
    }

    public JComboBox getCbProduto() {
        return cbProduto;
    }

    public void setCbProduto(JComboBox cbProduto) {
        this.cbProduto = cbProduto;
    }

    public JButton getJbtAdicionarProduto() {
        return jbtAdicionarProduto;
    }

    public void setJbtAdicionarProduto(JButton jbtAdicionarProduto) {
        this.jbtAdicionarProduto = jbtAdicionarProduto;
    }

    public JButton getJbtAlterarProduto() {
        return jbtAlterarProduto;
    }

    public void setJbtAlterarProduto(JButton jbtAlterarProduto) {
        this.jbtAlterarProduto = jbtAlterarProduto;
    }

    public JButton getJbtCancelar() {
        return jbtCancelar;
    }

    public void setJbtCancelar(JButton jbtCancelar) {
        this.jbtCancelar = jbtCancelar;
    }

    public JButton getJbtConfirmar() {
        return jbtConfirmar;
    }

    public void setJbtConfirmar(JButton jbtConfirmar) {
        this.jbtConfirmar = jbtConfirmar;
    }

    public JButton getJbtExcluirProduto() {
        return jbtExcluirProduto;
    }

    public void setJbtExcluirProduto(JButton jbtExcluirProduto) {
        this.jbtExcluirProduto = jbtExcluirProduto;
    }

    public JButton getJbtIncluirPagamento() {
        return jbtIncluirPagamento;
    }

    public void setJbtIncluirPagamento(JButton jbtIncluirPagamento) {
        this.jbtIncluirPagamento = jbtIncluirPagamento;
    }

    public JButton getJbtIniciarVenda() {
        return jbtIniciarVenda;
    }

    public void setJbtIniciarVenda(JButton jbtIniciarVenda) {
        this.jbtIniciarVenda = jbtIniciarVenda;
    }

    public JButton getJbtSair() {
        return jbtSair;
    }

    public void setJbtSair(JButton jbtSair) {
        this.jbtSair = jbtSair;
    }

    public JTextField getJtfDescontoProduto() {
        return jtfDescontoProduto;
    }

    public void setJtfDescontoProduto(JTextField jtfDescontoProduto) {
        this.jtfDescontoProduto = jtfDescontoProduto;
    }

    public JTextField getJtfPagamentoDesconto() {
        return jtfPagamentoDesconto;
    }

    public void setJtfPagamentoDesconto(JTextField jtfPagamentoDesconto) {
        this.jtfPagamentoDesconto = jtfPagamentoDesconto;
    }

    public JTextField getJtfPagamentoValor() {
        return jtfPagamentoValor;
    }

    public void setJtfPagamentoValor(JTextField jtfPagamentoValor) {
        this.jtfPagamentoValor = jtfPagamentoValor;
    }

    public JTextField getJtfQuantidadeProduto() {
        return jtfQuantidadeProduto;
    }

    public void setJtfQuantidadeProduto(JTextField jtfQuantidadeProduto) {
        this.jtfQuantidadeProduto = jtfQuantidadeProduto;
    }

    public JTable getTabelaFormaPagamento() {
        return tabelaFormaPagamento;
    }

    public void setTabelaFormaPagamento(JTable tabelaFormaPagamento) {
        this.tabelaFormaPagamento = tabelaFormaPagamento;
    }

    public JTable getTabelaProdutos() {
        return tabelaProdutos;
    }

    public void setTabelaProdutos(JTable tabelaProdutos) {
        this.tabelaProdutos = tabelaProdutos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtIniciarVenda = new javax.swing.JButton();
        cbCliente = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cbFuncionario = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfQuantidadeProduto = new javax.swing.JTextField();
        jbtAdicionarProduto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        cbProduto = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jtfDescontoProduto = new javax.swing.JTextField();
        jbtAlterarProduto = new javax.swing.JButton();
        jbtExcluirProduto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbFormaPagamento = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jtfPagamentoValor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfPagamentoDesconto = new javax.swing.JTextField();
        jbtIncluirPagamento = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaFormaPagamento = new javax.swing.JTable();
        jbtCancelar = new javax.swing.JButton();
        jbtConfirmar = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Controle de Venda");
        setAlwaysOnTop(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Dados Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Cliente:");

        jbtIniciarVenda.setText("INICIAR VENDA");

        cbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Selecione o Cliente)" }));

        jLabel8.setText("Funcionário:");

        cbFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Selecione o Funcionário)" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtIniciarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbFuncionario, 0, 449, Short.MAX_VALUE))
                        .addGap(217, 217, 217))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtIniciarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Descrição:");

        jLabel3.setText("Quantidade:");

        jbtAdicionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar.png"))); // NOI18N
        jbtAdicionarProduto.setText("Adicionar Produto");

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Quantidade", "Valor Unitário", "Desconto", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutos.setColumnSelectionAllowed(true);
        tabelaProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaProdutos);
        tabelaProdutos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaProdutos.getColumnModel().getColumn(0).setResizable(false);
        tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(400);
        tabelaProdutos.getColumnModel().getColumn(1).setResizable(false);
        tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(15);
        tabelaProdutos.getColumnModel().getColumn(2).setResizable(false);
        tabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabelaProdutos.getColumnModel().getColumn(3).setPreferredWidth(20);
        tabelaProdutos.getColumnModel().getColumn(4).setPreferredWidth(80);

        cbProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Selecione o produto)" }));

        jLabel7.setText("Desconto:");

        jbtAlterarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        jbtAlterarProduto.setText("Alterar Produto");
        jbtAlterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarProdutoActionPerformed(evt);
            }
        });

        jbtExcluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excluir.png"))); // NOI18N
        jbtExcluirProduto.setText("Excluir Produto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jbtAlterarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jbtExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jtfQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jtfDescontoProduto)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtfDescontoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtAdicionarProduto)
                    .addComponent(jbtAlterarProduto)
                    .addComponent(jbtExcluirProduto))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Formas de Pagamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel4.setText("Forma Pagamento:");

        cbFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 - DINHEIRO", "2 - CHEQUE", "3 - VISA DÉBITO", "4 - VISA CRÉDITO", "5 - MASTER DÉBITO", "6 - MASTER CRÉDITO", "7 - BOLETO", "8 - OUTROS" }));

        jLabel5.setText("Valor:");

        jLabel6.setText("Desconto:");

        jtfPagamentoDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPagamentoDescontoActionPerformed(evt);
            }
        });

        jbtIncluirPagamento.setText("INCLUIR FORMA DE PAGAMENTO");

        tabelaFormaPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelaFormaPagamento);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtIncluirPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfPagamentoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfPagamentoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtfPagamentoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPagamentoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtIncluirPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/venda.gif"))); // NOI18N
        jbtConfirmar.setText("Confirmar");
        jbtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmarActionPerformed(evt);
            }
        });

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        jbtSair.setText("SAIR");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "VALOR TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jbtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jbtSair, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        dispose();
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jbtCancelarActionPerformed

    private void jbtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmarActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jbtConfirmarActionPerformed

    private void jtfPagamentoDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPagamentoDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPagamentoDescontoActionPerformed

    private void jbtAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAlterarProdutoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbCliente;
    private javax.swing.JComboBox cbFormaPagamento;
    private javax.swing.JComboBox cbFuncionario;
    private javax.swing.JComboBox cbProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtAdicionarProduto;
    private javax.swing.JButton jbtAlterarProduto;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtConfirmar;
    private javax.swing.JButton jbtExcluirProduto;
    private javax.swing.JButton jbtIncluirPagamento;
    private javax.swing.JButton jbtIniciarVenda;
    private javax.swing.JButton jbtSair;
    private javax.swing.JTextField jtfDescontoProduto;
    private javax.swing.JTextField jtfPagamentoDesconto;
    private javax.swing.JTextField jtfPagamentoValor;
    private javax.swing.JTextField jtfQuantidadeProduto;
    private javax.swing.JTable tabelaFormaPagamento;
    private javax.swing.JTable tabelaProdutos;
    // End of variables declaration//GEN-END:variables
}
