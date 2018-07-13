package controller;

import dao.EnderecoDAO;
import dao.FornecedorDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Fornecedor;
import view.FornecedorPrincipal;

/**
 * Classe de controle das ações de FORNECEDOR
 *
 * @author Diego Munhoz
 */
public class FornecedorController {

    private FornecedorPrincipal viewFornecedor;
    private Fornecedor fornecedor = new Fornecedor();
    private Endereco endereco = new Endereco();
    private List<Fornecedor> listaFornecedores;
    private boolean alterarTrue;

    public FornecedorController(FornecedorPrincipal viewFornecedor) {
        this.viewFornecedor = viewFornecedor;
    }

    public void salvarFornecedor() {
        if (alterarTrue == false) {
            if (validarSalvar()) {
                Endereco endereco = new Endereco();
                endereco.setLogradouro(this.viewFornecedor.getJtfEndereco().getText().toUpperCase());
                endereco.setNumero(this.viewFornecedor.getJtfNumero().getText().toUpperCase());
                endereco.setBairro(this.viewFornecedor.getJtfBairro().getText().toUpperCase());
                endereco.setCidade(this.viewFornecedor.getJtfCidade().getText().toUpperCase());
                endereco.setEstado("" + this.viewFornecedor.getCbEstado().getSelectedItem());
                endereco.setCep(this.viewFornecedor.getJtfCep().getText());
                new EnderecoController().updateEndereco(endereco);
                
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCnpj(this.viewFornecedor.getJtfCnpj().getText());
                fornecedor.setInscricaoEstadual(this.viewFornecedor.getJtfInscricaoEstadual().getText());
                fornecedor.setDataFundacao(this.viewFornecedor.getJtfDataFundacao().getText());
                fornecedor.setRazaoSocial(this.viewFornecedor.getJtfRazaoSocial().getText().toUpperCase());
                fornecedor.setNomeFantasia(this.viewFornecedor.getJtfNomeFantasia().getText().toUpperCase());
                fornecedor.setTelefone(this.viewFornecedor.getJtfTelefone().getText());
                fornecedor.setCelular(this.viewFornecedor.getJtfCelular().getText());
                fornecedor.setContato(this.viewFornecedor.getJtfContato().getText());
                fornecedor.setEmail(this.viewFornecedor.getJtfEmail().getText());
                fornecedor.setEnderecoIdEndereco(endereco);
                try {
                    new FornecedorDAO().salvar(fornecedor);
                    JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor!");
                    Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                listarFornecedors();
                bloqueioInicial();
                alterarTrue = false;
            }
        } else {
            if (validarSalvar()) {
                endereco.setLogradouro(this.viewFornecedor.getJtfEndereco().getText().toUpperCase());
                endereco.setNumero(this.viewFornecedor.getJtfNumero().getText().toUpperCase());
                endereco.setBairro(this.viewFornecedor.getJtfBairro().getText().toUpperCase());
                endereco.setCidade(this.viewFornecedor.getJtfCidade().getText().toUpperCase());
                endereco.setEstado("" + this.viewFornecedor.getCbEstado().getSelectedItem());
                endereco.setCep(this.viewFornecedor.getJtfCep().getText());
                new EnderecoController().updateEndereco(endereco);
                
                fornecedor.setCnpj(this.viewFornecedor.getJtfCnpj().getText());
                fornecedor.setInscricaoEstadual(this.viewFornecedor.getJtfInscricaoEstadual().getText());
                fornecedor.setDataFundacao(this.viewFornecedor.getJtfDataFundacao().getText());
                fornecedor.setRazaoSocial(this.viewFornecedor.getJtfNomeFantasia().getText().toUpperCase());
                fornecedor.setNomeFantasia(this.viewFornecedor.getJtfNomeFantasia().getText().toUpperCase());
                fornecedor.setTelefone(this.viewFornecedor.getJtfTelefone().getText());
                fornecedor.setCelular(this.viewFornecedor.getJtfCelular().getText());
                fornecedor.setContato(this.viewFornecedor.getJtfContato().getText());
                fornecedor.setEmail(this.viewFornecedor.getJtfEmail().getText());
                fornecedor.setEnderecoIdEndereco(endereco);
                try {
                    new FornecedorDAO().salvar(fornecedor);
                    JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar fornecedor!");
                    Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                listarFornecedors();
                bloqueioInicial();
                alterarTrue = false;
            }
        }
    }

    public void alterarFornecedor() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFornecedor.getTabelaFornecedor().getModel();
        if (this.viewFornecedor.getTabelaFornecedor().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um fornecedor!");
        } else {
            fornecedor = listaFornecedores.get(this.viewFornecedor.getTabelaFornecedor().getSelectedRow());
            this.viewFornecedor.getJtfCnpj().setText(fornecedor.getCnpj());
            this.viewFornecedor.getJtfInscricaoEstadual().setText(fornecedor.getInscricaoEstadual());
            this.viewFornecedor.getJtfDataFundacao().setText(fornecedor.getDataFundacao());
            this.viewFornecedor.getJtfRazaoSocial().setText(fornecedor.getRazaoSocial().toUpperCase());
            this.viewFornecedor.getJtfNomeFantasia().setText(fornecedor.getNomeFantasia().toUpperCase());
            this.viewFornecedor.getJtfEndereco().setText(fornecedor.getEnderecoIdEndereco().getLogradouro().toUpperCase());
            this.viewFornecedor.getJtfNumero().setText(fornecedor.getEnderecoIdEndereco().getNumero().toUpperCase());
            this.viewFornecedor.getJtfBairro().setText(fornecedor.getEnderecoIdEndereco().getBairro().toUpperCase());
            this.viewFornecedor.getJtfCidade().setText(fornecedor.getEnderecoIdEndereco().getCidade().toUpperCase());
            this.viewFornecedor.getCbEstado().setSelectedItem(fornecedor.getEnderecoIdEndereco().getEstado().toUpperCase());
            this.viewFornecedor.getJtfCep().setText(fornecedor.getEnderecoIdEndereco().getCep());
            this.viewFornecedor.getJtfTelefone().setText(fornecedor.getTelefone());
            this.viewFornecedor.getJtfCelular().setText(fornecedor.getCelular());
            this.viewFornecedor.getJtfContato().setText(fornecedor.getContato());
            this.viewFornecedor.getJtfEmail().setText(fornecedor.getEmail());
            alterarTrue = true;
            acaoBotaoAlterar();
        }
    }

    public void excluirFornecedor() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFornecedor.getTabelaFornecedor().getModel();
        if (this.viewFornecedor.getTabelaFornecedor().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um fornecedor!");
        } else {
            fornecedor = listaFornecedores.get(this.viewFornecedor.getTabelaFornecedor().getSelectedRow());
            endereco = fornecedor.getEnderecoIdEndereco();
            int x = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if ((x == JOptionPane.YES_OPTION)) {
                try {
                    new EnderecoDAO().excluir(endereco);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir endereço!");
                    Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new FornecedorDAO().excluir(fornecedor);
                    JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir fornecedor!");
                    Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void pesquisarFornecedor() {
        FornecedorDAO dao = new FornecedorDAO();
        try {
            listaFornecedores = dao.buscarPorNome(this.viewFornecedor.getJtfPesquisarRazaoSocial().getText());
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(FornecedorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void listarFornecedors() {
        FornecedorDAO dao = new FornecedorDAO();
        try {
            listaFornecedores = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(FornecedorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFornecedor.getTabelaFornecedor().getModel();
        modelo.setRowCount(0);
        for (Fornecedor fornecedor : listaFornecedores) {
            modelo.addRow(new String[]{fornecedor.getRazaoSocial(), fornecedor.getEnderecoIdEndereco().getCidade(), fornecedor.getTelefone(), fornecedor.getCelular()});
        }
    }

    public boolean validarSalvar() {
        if (this.viewFornecedor.getJtfCnpj().equals("  .   .   /    -  ")) {
            JOptionPane.showMessageDialog(null, "Informe o CNPJ, campo obrigatório!");
            return false;
        }
        if (this.viewFornecedor.getJtfInscricaoEstadual().equals("  .   .   .   ")) {
            JOptionPane.showMessageDialog(null, "Informe a Inscrição Estadual, campo obrigatório!");
            return false;
        }
        if (this.viewFornecedor.getJtfDataFundacao().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Informe o nome, campo obrigatório!");
            return false;
        }
        if (this.viewFornecedor.getJtfRazaoSocial().equals(null) || this.viewFornecedor.getJtfRazaoSocial().equals("") || this.viewFornecedor.getJtfRazaoSocial().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o nome, campo obrigatório!");
            return false;
        }
        if (this.viewFornecedor.getJtfNomeFantasia().equals(null) || this.viewFornecedor.getJtfNomeFantasia().equals("") || this.viewFornecedor.getJtfNomeFantasia().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o nome, campo obrigatório!");
            return false;
        }
        if (this.viewFornecedor.getJtfEndereco().equals(null) || this.viewFornecedor.getJtfEndereco().equals("") || this.viewFornecedor.getJtfEndereco().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o endereço, campo obrigatório!");
            return false;
        }
        if (this.viewFornecedor.getJtfBairro().equals(null) || this.viewFornecedor.getJtfBairro().equals("") || this.viewFornecedor.getJtfBairro().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o bairro, campo obrigatório!");
            return false;
        }
        if (this.viewFornecedor.getJtfCidade().equals(null) || this.viewFornecedor.getJtfCidade().equals("") || this.viewFornecedor.getJtfCidade().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe a cidade, campo obrigatório!");
            return false;
        }
        if (this.viewFornecedor.getCbEstado().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Informe o estado, campo obrigatório!");
            return false;
        }
        if (this.viewFornecedor.getJtfTelefone().equals("(  )    -    ")) {
            JOptionPane.showMessageDialog(null, "Informe o nome, campo obrigatório!");
            return false;
        }
        return true;
    }

    public void bloqueioInicial() {
        this.viewFornecedor.getJbtNovo().setEnabled(true);
        this.viewFornecedor.getJbtAlterar().setEnabled(true);
        this.viewFornecedor.getJbtExcluir().setEnabled(true);
        this.viewFornecedor.getJbtSair().setEnabled(true);        
        this.viewFornecedor.getJbtSalvar().setEnabled(false);
        this.viewFornecedor.getJbtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void acaoBotaoCancelar() {
        this.viewFornecedor.getJbtSalvar().setEnabled(false);
        this.viewFornecedor.getJbtCancelar().setEnabled(false);
        this.viewFornecedor.getJbtNovo().setEnabled(true);
        this.viewFornecedor.getJbtAlterar().setEnabled(true);
        this.viewFornecedor.getJbtExcluir().setEnabled(true);
        this.viewFornecedor.getJbtSair().setEnabled(true);
        this.viewFornecedor.getJtfPesquisarRazaoSocial().setEnabled(true);
        this.viewFornecedor.getJtfPesquisarCNPJ().setEnabled(true);
        limparCampos();
    }

    public void acaoBotaoAlterar() {
        this.viewFornecedor.getJbtNovo().setEnabled(false);
        this.viewFornecedor.getJbtAlterar().setEnabled(false);
        this.viewFornecedor.getJbtExcluir().setEnabled(false);
        this.viewFornecedor.getJbtSair().setEnabled(false);
        this.viewFornecedor.getJbtSalvar().setEnabled(true);
        this.viewFornecedor.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewFornecedor.getJtfCnpj().setEditable(false);
        this.viewFornecedor.getJtfInscricaoEstadual().setEditable(false);
        this.viewFornecedor.getJtfDataFundacao().setEditable(false);
        this.viewFornecedor.getJtfRazaoSocial().setEditable(false);
    }

    public void acaoBotaoNovo() {
        this.viewFornecedor.getJbtNovo().setEnabled(false);
        this.viewFornecedor.getJbtAlterar().setEnabled(false);
        this.viewFornecedor.getJbtExcluir().setEnabled(false);
        this.viewFornecedor.getJbtSair().setEnabled(false);
        this.viewFornecedor.getJbtSalvar().setEnabled(true);
        this.viewFornecedor.getJbtCancelar().setEnabled(true);
        this.viewFornecedor.getJtfPesquisarRazaoSocial().setEnabled(false);
        this.viewFornecedor.getJtfPesquisarCNPJ().setEnabled(false);        
        liberarCampos();
        alterarTrue = false;
    }

    public void bloquearCampos() {
        this.viewFornecedor.getJtfCnpj().setEditable(false);
        this.viewFornecedor.getJtfInscricaoEstadual().setEditable(false);
        this.viewFornecedor.getJtfDataFundacao().setEditable(false);
        this.viewFornecedor.getJtfRazaoSocial().setEditable(false);
        this.viewFornecedor.getJtfNomeFantasia().setEditable(false);
        this.viewFornecedor.getJtfEndereco().setEditable(false);
        this.viewFornecedor.getJtfNumero().setEditable(false);
        this.viewFornecedor.getJtfBairro().setEditable(false);
        this.viewFornecedor.getJtfCidade().setEditable(false);
        this.viewFornecedor.getJtfCep().setEditable(false);
        this.viewFornecedor.getCbEstado().setEnabled(false);
        this.viewFornecedor.getJtfCelular().setEditable(false);
        this.viewFornecedor.getJtfTelefone().setEditable(false);
        this.viewFornecedor.getJtfContato().setEditable(false);
        this.viewFornecedor.getJtfEmail().setEditable(false);
        this.viewFornecedor.getJtfPesquisarRazaoSocial().setEnabled(true);
        this.viewFornecedor.getJtfPesquisarRazaoSocial().grabFocus();
        this.viewFornecedor.getJtfPesquisarCNPJ().setEnabled(true);
    }

    public void liberarCampos() {
        this.viewFornecedor.getJtfCnpj().grabFocus();
        this.viewFornecedor.getJtfCnpj().setEditable(true);
        this.viewFornecedor.getJtfInscricaoEstadual().setEditable(true);
        this.viewFornecedor.getJtfDataFundacao().setEditable(true);
        this.viewFornecedor.getJtfRazaoSocial().setEditable(true);
        this.viewFornecedor.getJtfNomeFantasia().setEditable(true);
        this.viewFornecedor.getJtfEndereco().setEditable(true);
        this.viewFornecedor.getJtfNumero().setEditable(true);
        this.viewFornecedor.getJtfBairro().setEditable(true);
        this.viewFornecedor.getJtfCidade().setEditable(true);
        this.viewFornecedor.getJtfCep().setEditable(true);
        this.viewFornecedor.getCbEstado().setEnabled(true);
        this.viewFornecedor.getJtfCelular().setEditable(true);
        this.viewFornecedor.getJtfTelefone().setEditable(true);
        this.viewFornecedor.getJtfContato().setEditable(true);
        this.viewFornecedor.getJtfEmail().setEditable(true);
    }

    public void limparCampos() {
        this.viewFornecedor.getJtfCnpj().setText(null);
        this.viewFornecedor.getJtfInscricaoEstadual().setText(null);
        this.viewFornecedor.getJtfDataFundacao().setText(null);
        this.viewFornecedor.getJtfRazaoSocial().setText(null);
        this.viewFornecedor.getJtfNomeFantasia().setText(null);
        this.viewFornecedor.getJtfEndereco().setText(null);
        this.viewFornecedor.getJtfNumero().setText(null);
        this.viewFornecedor.getJtfBairro().setText(null);
        this.viewFornecedor.getJtfCidade().setText(null);
        this.viewFornecedor.getCbEstado().setSelectedIndex(0);
        this.viewFornecedor.getJtfCep().setText(null);
        this.viewFornecedor.getJtfTelefone().setText(null);
        this.viewFornecedor.getJtfCelular().setText(null);
        this.viewFornecedor.getJtfContato().setText(null);
        this.viewFornecedor.getJtfEmail().setText(null);
    }
}