package controller;

import dao.EnderecoDAO;
import dao.FuncionarioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Funcionario;
import view.FuncionarioPrincipal;

/**
 * Classe de controle das ações de FUNCIONARIO
 *
 * @author Diego Munhoz
 */
public class FuncionarioController {

    private FuncionarioPrincipal viewFuncionario;
    private Funcionario funcionario = new Funcionario();
    private Endereco endereco = new Endereco();
    private List<Funcionario> listaFuncionarios;
    private boolean alterarTrue;

    public FuncionarioController(FuncionarioPrincipal viewFuncionario) {
        this.viewFuncionario = viewFuncionario;
    }

    public void salvarFuncionario() {
        if (alterarTrue == false) {
            if (validarSalvar()) {
                Endereco endereco = new Endereco();
                endereco.setLogradouro(this.viewFuncionario.getJtfEndereco().getText().toUpperCase());
                endereco.setNumero(this.viewFuncionario.getJtfNumero().getText().toUpperCase());
                endereco.setBairro(this.viewFuncionario.getJtfBairro().getText().toUpperCase());
                endereco.setCidade(this.viewFuncionario.getJtfCidade().getText().toUpperCase());
                endereco.setEstado("" + this.viewFuncionario.getCbEstado().getSelectedItem());
                endereco.setCep(this.viewFuncionario.getJtfCep().getText());
                new EnderecoController().updateEndereco(endereco);

                Funcionario funcionario = new Funcionario();
                funcionario.setCpf(this.viewFuncionario.getJtfCpf().getText());
                funcionario.setRg(this.viewFuncionario.getJtfRg().getText());
                funcionario.setDataNascimento(this.viewFuncionario.getJtfDataNascimento().getText());
                funcionario.setNome(this.viewFuncionario.getJtfNome().getText().toUpperCase());
                funcionario.setTelefone(this.viewFuncionario.getJtfTelefone().getText());
                funcionario.setCelular(this.viewFuncionario.getJtfCelular().getText());
                funcionario.setLogin(this.viewFuncionario.getJtfLogin().getText());
                funcionario.setSenha(this.viewFuncionario.getJtfSenha().getText());
                funcionario.setEnderecoIdEndereco(endereco);
                try {
                    new FuncionarioDAO().salvar(funcionario);
                    JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir funcionário!");
                    Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                listarFuncionarios();
                bloqueioInicial();
                alterarTrue = false;
            }
        } else {
            if (validarSalvar()) {
                endereco.setLogradouro(this.viewFuncionario.getJtfEndereco().getText().toUpperCase());
                endereco.setNumero(this.viewFuncionario.getJtfNumero().getText().toUpperCase());
                endereco.setBairro(this.viewFuncionario.getJtfBairro().getText().toUpperCase());
                endereco.setCidade(this.viewFuncionario.getJtfCidade().getText().toUpperCase());
                endereco.setEstado("" + this.viewFuncionario.getCbEstado().getSelectedItem());
                endereco.setCep(this.viewFuncionario.getJtfCep().getText());
                new EnderecoController().updateEndereco(endereco);
                
                funcionario.setCpf(this.viewFuncionario.getJtfCpf().getText());
                funcionario.setRg(this.viewFuncionario.getJtfRg().getText());
                funcionario.setDataNascimento(this.viewFuncionario.getJtfDataNascimento().getText());
                funcionario.setNome(this.viewFuncionario.getJtfNome().getText().toUpperCase());
                funcionario.setTelefone(this.viewFuncionario.getJtfTelefone().getText());
                funcionario.setCelular(this.viewFuncionario.getJtfCelular().getText());
                funcionario.setLogin(this.viewFuncionario.getJtfLogin().getText());
                funcionario.setSenha(this.viewFuncionario.getJtfSenha().getText());
                funcionario.setEnderecoIdEndereco(endereco);
                try {
                    new FuncionarioDAO().salvar(funcionario);
                    JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar funcionário!");
                    Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                listarFuncionarios();
                bloqueioInicial();
                alterarTrue = false;
            }
        }
    }

    public void alterarFuncionario() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFuncionario.getTabelaFuncionario().getModel();
        if (this.viewFuncionario.getTabelaFuncionario().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um funcionario!");
        } else {
            funcionario = listaFuncionarios.get(this.viewFuncionario.getTabelaFuncionario().getSelectedRow());
            this.viewFuncionario.getJtfCpf().setText(funcionario.getCpf());
            this.viewFuncionario.getJtfRg().setText(funcionario.getRg());
            this.viewFuncionario.getJtfDataNascimento().setText(funcionario.getDataNascimento());
            this.viewFuncionario.getJtfNome().setText(funcionario.getNome().toUpperCase());
            this.viewFuncionario.getJtfEndereco().setText(funcionario.getEnderecoIdEndereco().getLogradouro().toUpperCase());
            this.viewFuncionario.getJtfNumero().setText(funcionario.getEnderecoIdEndereco().getNumero().toUpperCase());
            this.viewFuncionario.getJtfBairro().setText(funcionario.getEnderecoIdEndereco().getBairro().toUpperCase());
            this.viewFuncionario.getJtfCidade().setText(funcionario.getEnderecoIdEndereco().getCidade().toUpperCase());
            this.viewFuncionario.getCbEstado().setSelectedItem(funcionario.getEnderecoIdEndereco().getEstado().toUpperCase());
            this.viewFuncionario.getJtfCep().setText(funcionario.getEnderecoIdEndereco().getCep());
            this.viewFuncionario.getJtfTelefone().setText(funcionario.getTelefone());
            this.viewFuncionario.getJtfCelular().setText(funcionario.getCelular());
            this.viewFuncionario.getJtfLogin().setText(funcionario.getLogin());
            this.viewFuncionario.getJtfSenha().setText(funcionario.getSenha());
            alterarTrue = true;
            acaoBotaoAlterar();
        }
    }

    public void excluirFuncionario() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFuncionario.getTabelaFuncionario().getModel();
        if (this.viewFuncionario.getTabelaFuncionario().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um funcionario!");
        } else {
            funcionario = listaFuncionarios.get(this.viewFuncionario.getTabelaFuncionario().getSelectedRow());
            endereco = funcionario.getEnderecoIdEndereco();
            int x = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if ((x == JOptionPane.YES_OPTION)) {
                try {
                    new EnderecoDAO().excluir(endereco);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir endereço!");
                    Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new FuncionarioDAO().excluir(funcionario);
                    JOptionPane.showMessageDialog(null, "Funcionario excluído com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir funcionário!");
                    Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void pesquisarFuncionario() {
        if (this.viewFuncionario.getJtfPesquisarNome().getText().equals("") || this.viewFuncionario.getJtfPesquisarNome().getText().equals(null) || this.viewFuncionario.getJtfPesquisarNome().getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o nome para consulta!");
        } else {
            FuncionarioDAO dao = new FuncionarioDAO();
            try {
                listaFuncionarios = dao.buscarPorNome(this.viewFuncionario.getJtfPesquisarNome().getText());
                carregarTabela();
            } catch (Exception ex) {
                Logger.getLogger(FuncionarioPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void listarFuncionarios() {
        FuncionarioDAO dao = new FuncionarioDAO();
        try {
            listaFuncionarios = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFuncionario.getTabelaFuncionario().getModel();
        modelo.setRowCount(0);
        for (Funcionario funcionario : listaFuncionarios) {
            modelo.addRow(new String[]{funcionario.getNome(), funcionario.getEnderecoIdEndereco().getCidade(), funcionario.getTelefone(), funcionario.getCelular()});
        }
    }

    public boolean validarSalvar() {
        if (this.viewFuncionario.getJtfCpf().equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(null, "Informe o CPF, campo obrigatório!");
            return false;
        }
        if (this.viewFuncionario.getJtfRg().equals("  .   .   ")) {
            JOptionPane.showMessageDialog(null, "Informe o RG, campo obrigatório!");
            return false;
        }
        if (this.viewFuncionario.getJtfDataNascimento().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Informe o nome, campo obrigatório!");
            return false;
        }
        if (this.viewFuncionario.getJtfNome().equals(null) || this.viewFuncionario.getJtfNome().equals("") || this.viewFuncionario.getJtfNome().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o nome, campo obrigatório!");
            return false;
        }
        if (this.viewFuncionario.getJtfEndereco().equals(null) || this.viewFuncionario.getJtfEndereco().equals("") || this.viewFuncionario.getJtfEndereco().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o endereço, campo obrigatório!");
            return false;
        }
        if (this.viewFuncionario.getJtfBairro().equals(null) || this.viewFuncionario.getJtfBairro().equals("") || this.viewFuncionario.getJtfBairro().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o bairro, campo obrigatório!");
            return false;
        }
        if (this.viewFuncionario.getJtfCidade().equals(null) || this.viewFuncionario.getJtfCidade().equals("") || this.viewFuncionario.getJtfCidade().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe a cidade, campo obrigatório!");
            return false;
        }
        if (this.viewFuncionario.getCbEstado().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Informe o estado, campo obrigatório!");
            return false;
        }
        if (this.viewFuncionario.getJtfTelefone().equals("(  )    -    ")) {
            JOptionPane.showMessageDialog(null, "Informe o nome, campo obrigatório!");
            return false;
        }
        if (this.viewFuncionario.getJtfCelular().equals("(  )     -    ")) {
            JOptionPane.showMessageDialog(null, "Informe o celular, campo obrigatório!");
            return false;
        }
        if (this.viewFuncionario.getJtfLogin().equals(null) || this.viewFuncionario.getJtfLogin().equals("") || this.viewFuncionario.getJtfLogin().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o login, campo obrigatório!");
            return false;
        }
        if (this.viewFuncionario.getJtfSenha().equals(null) || this.viewFuncionario.getJtfSenha().equals("") || this.viewFuncionario.getJtfSenha().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe a senha, campo obrigatório!");
            return false;
        }
        return true;
    }

    public void bloqueioInicial() {
        this.viewFuncionario.getJbtNovo().setEnabled(true);
        this.viewFuncionario.getJbtAlterar().setEnabled(true);
        this.viewFuncionario.getJbtExcluir().setEnabled(true);
        this.viewFuncionario.getJbtSair().setEnabled(true);
        this.viewFuncionario.getJbtPesquisarFuncionario().setEnabled(true);
        this.viewFuncionario.getJbtSalvar().setEnabled(false);
        this.viewFuncionario.getJbtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void acaoBotaoCancelar() {
        this.viewFuncionario.getJbtSalvar().setEnabled(false);
        this.viewFuncionario.getJbtCancelar().setEnabled(false);
        this.viewFuncionario.getJbtNovo().setEnabled(true);
        this.viewFuncionario.getJbtAlterar().setEnabled(true);
        this.viewFuncionario.getJbtExcluir().setEnabled(true);
        this.viewFuncionario.getJbtSair().setEnabled(true);
        liberarPesquisa();
        limparCampos();
    }

    public void acaoBotaoAlterar() {
        this.viewFuncionario.getJbtNovo().setEnabled(false);
        this.viewFuncionario.getJbtAlterar().setEnabled(false);
        this.viewFuncionario.getJbtExcluir().setEnabled(false);
        this.viewFuncionario.getJbtSair().setEnabled(false);
        this.viewFuncionario.getJbtSalvar().setEnabled(true);
        this.viewFuncionario.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewFuncionario.getJtfCpf().setEditable(false);
        this.viewFuncionario.getJtfRg().setEditable(false);
        this.viewFuncionario.getJtfDataNascimento().setEditable(false);
        this.viewFuncionario.getJtfNome().setEditable(false);
    }

    public void acaoBotaoNovo() {
        this.viewFuncionario.getJbtNovo().setEnabled(false);
        this.viewFuncionario.getJbtAlterar().setEnabled(false);
        this.viewFuncionario.getJbtExcluir().setEnabled(false);
        this.viewFuncionario.getJbtSair().setEnabled(false);
        this.viewFuncionario.getJbtSalvar().setEnabled(true);
        this.viewFuncionario.getJbtCancelar().setEnabled(true);
        bloquearPesquisa();
        liberarCampos();
        alterarTrue = false;
    }

    public void bloquearPesquisa() {
        this.viewFuncionario.getJtfPesquisarNome().setEditable(false);
        this.viewFuncionario.getJbtPesquisarFuncionario().setEnabled(false);
    }

    public void liberarPesquisa() {
        this.viewFuncionario.getJtfPesquisarNome().setEditable(true);
        this.viewFuncionario.getJbtPesquisarFuncionario().setEnabled(true);
    }

    public void bloquearCampos() {
        this.viewFuncionario.getJtfCpf().setEditable(false);
        this.viewFuncionario.getJtfRg().setEditable(false);
        this.viewFuncionario.getJtfDataNascimento().setEditable(false);
        this.viewFuncionario.getJtfNome().setEditable(false);
        this.viewFuncionario.getJtfEndereco().setEditable(false);
        this.viewFuncionario.getJtfNumero().setEditable(false);
        this.viewFuncionario.getJtfBairro().setEditable(false);
        this.viewFuncionario.getJtfCidade().setEditable(false);
        this.viewFuncionario.getJtfCep().setEditable(false);
        this.viewFuncionario.getCbEstado().setEnabled(false);
        this.viewFuncionario.getJtfCelular().setEditable(false);
        this.viewFuncionario.getJtfTelefone().setEditable(false);
        this.viewFuncionario.getJtfLogin().setEditable(false);
        this.viewFuncionario.getJtfSenha().setEditable(false);
        this.viewFuncionario.getJtfPesquisarNome().setEnabled(true);
        this.viewFuncionario.getJtfPesquisarNome().grabFocus();
    }

    public void liberarCampos() {
        this.viewFuncionario.getJtfCpf().grabFocus();
        this.viewFuncionario.getJtfCpf().setEditable(true);
        this.viewFuncionario.getJtfRg().setEditable(true);
        this.viewFuncionario.getJtfDataNascimento().setEditable(true);
        this.viewFuncionario.getJtfNome().setEditable(true);
        this.viewFuncionario.getJtfEndereco().setEditable(true);
        this.viewFuncionario.getJtfNumero().setEditable(true);
        this.viewFuncionario.getJtfBairro().setEditable(true);
        this.viewFuncionario.getJtfCidade().setEditable(true);
        this.viewFuncionario.getJtfCep().setEditable(true);
        this.viewFuncionario.getCbEstado().setEnabled(true);
        this.viewFuncionario.getJtfCelular().setEditable(true);
        this.viewFuncionario.getJtfTelefone().setEditable(true);
        this.viewFuncionario.getJtfLogin().setEditable(true);
        this.viewFuncionario.getJtfSenha().setEditable(true);
    }

    public void limparCampos() {
        this.viewFuncionario.getJtfCpf().setText(null);
        this.viewFuncionario.getJtfRg().setText(null);
        this.viewFuncionario.getJtfDataNascimento().setText(null);
        this.viewFuncionario.getJtfNome().setText(null);
        this.viewFuncionario.getJtfEndereco().setText(null);
        this.viewFuncionario.getJtfNumero().setText(null);
        this.viewFuncionario.getJtfBairro().setText(null);
        this.viewFuncionario.getJtfCidade().setText(null);
        this.viewFuncionario.getCbEstado().setSelectedIndex(0);
        this.viewFuncionario.getJtfCep().setText(null);
        this.viewFuncionario.getJtfTelefone().setText(null);
        this.viewFuncionario.getJtfCelular().setText(null);
        this.viewFuncionario.getJtfLogin().setText(null);
        this.viewFuncionario.getJtfSenha().setText(null);
    }
}