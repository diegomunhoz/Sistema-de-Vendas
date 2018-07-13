package controller;

import dao.FornecedorDAO;
import dao.ProdutoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import model.Fornecedor;
import view.ProdutoPrincipal;

/**
 * Classe de controle das ações de CLIENTE
 *
 * @author Diego Munhoz
 */
public class ProdutoController {

    private ProdutoPrincipal viewProduto;
    private Produto produto = new Produto();
    private Fornecedor fornecedor = new Fornecedor();
    private List<Produto> listaProdutos;
    private List<Fornecedor> listaFornecedores;
    private boolean alterarTrue;

    public ProdutoController(ProdutoPrincipal viewProduto) {
        this.viewProduto = viewProduto;
    }

    public void salvarProduto() {
        if (alterarTrue == false) {
            if (validarSalvar()) {
                Produto produto = new Produto();
                produto.setDescricao(this.viewProduto.getJtfDescricao().getText().toUpperCase());
                for (Fornecedor fornecedor : listaFornecedores) {
                    if (fornecedor.getIdFornecedor() == this.viewProduto.getCbFornecedor().getSelectedIndex()) {
                        produto.setFornecedorIdFornecedor(fornecedor);
                        System.out.println(fornecedor.getRazaoSocial());
                        break;
                    }
                }
                produto.setValorCusto(Double.parseDouble(this.viewProduto.getJtfValorCusto().getText()));
                produto.setValorVenda(Double.parseDouble(this.viewProduto.getJtfValorVenda().getText()));
                produto.setQtdeMinEstoque(Integer.parseInt(this.viewProduto.getJtfEstoqueMinimo().getText()));
                try {
                    new ProdutoDAO().salvar(produto);
                    JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir produto!");
                    Logger.getLogger(ProdutoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                listarProdutos();
                bloqueioInicial();
                alterarTrue = false;
            }
        } else {
            if (validarSalvar()) {
                int ind = this.viewProduto.getCbFornecedor().getSelectedIndex();
                ind--;
                produto.setDescricao(this.viewProduto.getJtfDescricao().getText());
                for (Fornecedor fornecedor : listaFornecedores) {
                    if (fornecedor.getIdFornecedor() == ind) {
                        produto.setFornecedorIdFornecedor(fornecedor);
                        break;
                    }
                }
                produto.setValorCusto(Double.parseDouble(this.viewProduto.getJtfValorCusto().getText()));
                produto.setValorVenda(Double.parseDouble(this.viewProduto.getJtfValorVenda().getText()));
                produto.setQtdeMinEstoque(Integer.parseInt(this.viewProduto.getJtfEstoqueMinimo().getText()));
                try {
                    new ProdutoDAO().salvar(produto);
                    JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar produto!");
                    Logger.getLogger(ProdutoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                listarProdutos();
                bloqueioInicial();
                alterarTrue = false;
            }
        }
    }

    public void alterarProduto() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewProduto.getTabelaProduto().getModel();
        if (this.viewProduto.getTabelaProduto().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um produto!");
        } else {
            produto = listaProdutos.get(this.viewProduto.getTabelaProduto().getSelectedRow());
            this.viewProduto.getJtfDescricao().setText(produto.getDescricao());
            this.viewProduto.getCbFornecedor().setSelectedItem(produto.getFornecedorIdFornecedor().getRazaoSocial());
            this.viewProduto.getJtfValorCusto().setText(produto.getValorCusto() + "");
            this.viewProduto.getJtfValorVenda().setText(produto.getValorVenda() + "");
            this.viewProduto.getJtfEstoqueMinimo().setText(produto.getQtdeMinEstoque() + "");
            alterarTrue = true;
            acaoBotaoAlterar();
        }
    }

    public void excluirProduto() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewProduto.getTabelaProduto().getModel();
        if (this.viewProduto.getTabelaProduto().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um produto!");
        } else {
            produto = listaProdutos.get(this.viewProduto.getTabelaProduto().getSelectedRow());
            fornecedor.setIdFornecedor(produto.getFornecedorIdFornecedor().getIdFornecedor());
            int x = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if ((x == JOptionPane.YES_OPTION)) {
                try {
                    new FornecedorDAO().excluir(fornecedor);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir fornecedor!");
                    Logger.getLogger(ProdutoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new ProdutoDAO().excluir(produto);
                    JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir produto!");
                    Logger.getLogger(ProdutoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void pesquisarProdutoDescricao() {
        ProdutoDAO dao = new ProdutoDAO();
        try {
            listaProdutos = dao.buscarPorDescricao(this.viewProduto.getJtfPesquisarDescricao().getText());
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pesquisarProdutoCodigo() {
        ProdutoDAO dao = new ProdutoDAO();
        try {
            produto = dao.buscarPorCodigo(Integer.parseInt(this.viewProduto.getJtfPesquisarDescricao().getText()));
            DefaultTableModel modelo = (DefaultTableModel) this.viewProduto.getTabelaProduto().getModel();
            modelo.setRowCount(0);
            modelo.addRow(new String[]{"" + produto.getIdProduto(), produto.getDescricao(), "R$ " + produto.getValorCusto(), "R$ " + produto.getValorVenda()});
        } catch (Exception ex) {
            Logger.getLogger(ProdutoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listarProdutos() {
        try {
            listaProdutos = new ProdutoDAO().buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarFornecedor() {
        try {
            listaFornecedores = new FornecedorDAO().buscarTodos();
            for (Fornecedor fornecedor : listaFornecedores) {
                this.viewProduto.getCbFornecedor().addItem(fornecedor.getRazaoSocial());
            }
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewProduto.getTabelaProduto().getModel();
        modelo.setRowCount(0);
        for (Produto produto : listaProdutos) {
            modelo.addRow(new String[]{"" + produto.getIdProduto(), produto.getDescricao(), "R$ " + produto.getValorCusto(), "R$ " + produto.getValorVenda()});
        }
    }

    public boolean validarSalvar() {
        if (this.viewProduto.getJtfDescricao().equals(null) || this.viewProduto.getJtfDescricao().equals("") || this.viewProduto.getJtfDescricao().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe a descrição, campo obrigatório!");
            return false;
        }
        if (this.viewProduto.getCbFornecedor().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Informe o fornecedor, campo obrigatório!");
            return false;
        }
        if (this.viewProduto.getJtfValorCusto().equals(null) || this.viewProduto.getJtfValorCusto().equals("") || this.viewProduto.getJtfValorCusto().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o valor de custo, campo obrigatório!");
            return false;
        }
        if (this.viewProduto.getJtfValorVenda().equals(null) || this.viewProduto.getJtfValorVenda().equals("") || this.viewProduto.getJtfValorVenda().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o valor de venda, campo obrigatório!");
            return false;
        }
        if (this.viewProduto.getJtfEstoqueMinimo().equals(null) || this.viewProduto.getJtfEstoqueMinimo().equals("") || this.viewProduto.getJtfEstoqueMinimo().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o estoque mínimo, campo obrigatório!");
            return false;
        }
        return true;
    }

    public void bloqueioInicial() {
        this.viewProduto.getJbtNovo().setEnabled(true);
        this.viewProduto.getJbtAlterar().setEnabled(true);
        this.viewProduto.getJbtExcluir().setEnabled(true);
        this.viewProduto.getJbtSair().setEnabled(true);
        this.viewProduto.getJbtConfirmar().setEnabled(false);
        this.viewProduto.getJbtCancelar().setEnabled(false);
        this.viewProduto.getJtfPesquisarDescricao().setEditable(true);
        this.viewProduto.getJtfPesquisarCodigo().setEditable(true);
        this.viewProduto.getJtfPesquisarDescricao().grabFocus();
        bloquearCampos();
    }

    public void acaoBotaoCancelar() {
        this.viewProduto.getJbtConfirmar().setEnabled(false);
        this.viewProduto.getJbtCancelar().setEnabled(false);
        this.viewProduto.getJbtNovo().setEnabled(true);
        this.viewProduto.getJbtAlterar().setEnabled(true);
        this.viewProduto.getJbtExcluir().setEnabled(true);
        this.viewProduto.getJbtSair().setEnabled(true);
        this.viewProduto.getJtfPesquisarDescricao().setEditable(true);
        this.viewProduto.getJtfPesquisarCodigo().setEditable(true);
        bloquearCampos();
        limparCampos();
    }

    public void acaoBotaoAlterar() {
        this.viewProduto.getJbtNovo().setEnabled(false);
        this.viewProduto.getJbtAlterar().setEnabled(false);
        this.viewProduto.getJbtExcluir().setEnabled(false);
        this.viewProduto.getJbtSair().setEnabled(false);
        this.viewProduto.getJbtConfirmar().setEnabled(true);
        this.viewProduto.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewProduto.getJtfDescricao().setEditable(false);
    }

    public void acaoBotaoNovo() {
        this.viewProduto.getJbtNovo().setEnabled(false);
        this.viewProduto.getJbtAlterar().setEnabled(false);
        this.viewProduto.getJbtExcluir().setEnabled(false);
        this.viewProduto.getJbtSair().setEnabled(false);
        this.viewProduto.getJbtConfirmar().setEnabled(true);
        this.viewProduto.getJbtCancelar().setEnabled(true);
        this.viewProduto.getJtfPesquisarDescricao().setEditable(false);
        this.viewProduto.getJtfPesquisarCodigo().setEditable(false);
        liberarCampos();
        alterarTrue = false;
    }

    public void bloquearCampos() {
        this.viewProduto.getJtfDescricao().setEditable(false);
        this.viewProduto.getCbFornecedor().setEnabled(false);
        this.viewProduto.getJtfValorCusto().setEditable(false);
        this.viewProduto.getJtfValorVenda().setEditable(false);
        this.viewProduto.getJtfEstoqueMinimo().setEditable(false);
        this.viewProduto.getJtfEstoqueAtual().setEditable(false);
    }

    public void liberarCampos() {
        this.viewProduto.getJtfDescricao().grabFocus();
        this.viewProduto.getJtfDescricao().setEditable(true);
        this.viewProduto.getCbFornecedor().setEnabled(true);
        this.viewProduto.getJtfValorCusto().setEditable(true);
        this.viewProduto.getJtfValorVenda().setEditable(true);
        this.viewProduto.getJtfEstoqueMinimo().setEditable(true);
        this.viewProduto.getJtfEstoqueAtual().setEditable(true);
    }

    public void limparCampos() {
        this.viewProduto.getJtfDescricao().setText(null);
        this.viewProduto.getCbFornecedor().setSelectedIndex(0);
        this.viewProduto.getJtfValorCusto().setText(null);
        this.viewProduto.getJtfValorVenda().setText(null);
        this.viewProduto.getJtfEstoqueMinimo().setText(null);
        this.viewProduto.getJtfEstoqueAtual().setText(null);
    }
}