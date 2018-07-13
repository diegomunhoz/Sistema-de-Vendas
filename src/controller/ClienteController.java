package controller;

import dao.ClienteDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Endereco;
import view.ClientePrincipal;

/**
 * Classe de controle das ações de CLIENTE
 *
 * @author Diego Munhoz
 */
public class ClienteController {

    private ClientePrincipal viewCliente;
    private Cliente cliente = new Cliente();
    private Endereco endereco = new Endereco();
    private List<Cliente> listaClientes;
    private boolean alterarTrue;

    public ClienteController(ClientePrincipal viewCliente) {
        this.viewCliente = viewCliente;
    }

    public void salvarCliente() {
        if (alterarTrue == false) {
            if (validarSalvar()) {
                Endereco endereco = new Endereco();
                endereco.setLogradouro(this.viewCliente.getJtfEndereco().getText().toUpperCase());
                endereco.setNumero(this.viewCliente.getJtfNumero().getText().toUpperCase());
                endereco.setBairro(this.viewCliente.getJtfBairro().getText().toUpperCase());
                endereco.setCidade(this.viewCliente.getJtfCidade().getText().toUpperCase());
                endereco.setEstado("" + this.viewCliente.getCbEstado().getSelectedItem());
                endereco.setCep(this.viewCliente.getJtfCep().getText());
                new EnderecoController().updateEndereco(endereco);

                Cliente cliente = new Cliente();
                cliente.setCpf(this.viewCliente.getJtfCpf().getText());
                cliente.setRg(this.viewCliente.getJtfRg().getText());
                cliente.setDtNascimento(this.viewCliente.getJtfDataNascimento().getText());
                cliente.setNome(this.viewCliente.getJtfNome().getText().toUpperCase());
                cliente.setTelefone(this.viewCliente.getJtfTelefone().getText());
                cliente.setCelular(this.viewCliente.getJtfCelular().getText());
                cliente.setEmail(this.viewCliente.getJtfEmail().getText());
                cliente.setEnderecoIdEndereco(endereco);
                try {
                    new ClienteDAO().salvar(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir cliente!");
                    Logger.getLogger(ClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                listarClientes();
                bloqueioInicial();
                alterarTrue = false;
            }
        } else {
            if (validarSalvar()) {
                endereco.setLogradouro(this.viewCliente.getJtfEndereco().getText().toUpperCase());
                endereco.setNumero(this.viewCliente.getJtfNumero().getText().toUpperCase());
                endereco.setBairro(this.viewCliente.getJtfBairro().getText().toUpperCase());
                endereco.setCidade(this.viewCliente.getJtfCidade().getText().toUpperCase());
                endereco.setEstado("" + this.viewCliente.getCbEstado().getSelectedItem());
                endereco.setCep(this.viewCliente.getJtfCep().getText());
                new EnderecoController().updateEndereco(endereco);

                cliente.setCpf(this.viewCliente.getJtfCpf().getText());
                cliente.setRg(this.viewCliente.getJtfRg().getText());
                cliente.setDtNascimento(this.viewCliente.getJtfDataNascimento().getText());
                cliente.setNome(this.viewCliente.getJtfNome().getText().toUpperCase());
                cliente.setTelefone(this.viewCliente.getJtfTelefone().getText());
                cliente.setCelular(this.viewCliente.getJtfCelular().getText());
                cliente.setEmail(this.viewCliente.getJtfEmail().getText());
                cliente.setEnderecoIdEndereco(endereco);
                try {
                    new ClienteDAO().salvar(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar cliente!");
                    Logger.getLogger(ClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                listarClientes();
                bloqueioInicial();
                alterarTrue = false;
            }
        }
    }

    public void alterarCliente() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewCliente.getTabelaCliente().getModel();
        if (this.viewCliente.getTabelaCliente().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um cliente!");
        } else {
            cliente = listaClientes.get(this.viewCliente.getTabelaCliente().getSelectedRow());
            this.viewCliente.getJtfCpf().setText(cliente.getCpf());
            this.viewCliente.getJtfRg().setText(cliente.getRg());
            this.viewCliente.getJtfDataNascimento().setText(cliente.getDtNascimento().toUpperCase());
            this.viewCliente.getJtfNome().setText(cliente.getNome().toUpperCase());
            this.viewCliente.getJtfEndereco().setText(cliente.getEnderecoIdEndereco().getLogradouro().toUpperCase());
            this.viewCliente.getJtfNumero().setText(cliente.getEnderecoIdEndereco().getNumero().toUpperCase());
            this.viewCliente.getJtfBairro().setText(cliente.getEnderecoIdEndereco().getBairro().toUpperCase());
            this.viewCliente.getJtfCidade().setText(cliente.getEnderecoIdEndereco().getCidade().toUpperCase());
            this.viewCliente.getCbEstado().setSelectedItem(cliente.getEnderecoIdEndereco().getEstado().toUpperCase());
            this.viewCliente.getJtfCep().setText(cliente.getEnderecoIdEndereco().getCep());
            this.viewCliente.getJtfTelefone().setText(cliente.getTelefone());
            this.viewCliente.getJtfCelular().setText(cliente.getCelular());
            this.viewCliente.getJtfEmail().setText(cliente.getEmail());
            alterarTrue = true;
            acaoBotaoAlterar();
        }
    }

    public void excluirCliente() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewCliente.getTabelaCliente().getModel();
        if (this.viewCliente.getTabelaCliente().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um cliente!");
        } else {
            cliente = listaClientes.get(this.viewCliente.getTabelaCliente().getSelectedRow());
            endereco.setIdEndereco(cliente.getEnderecoIdEndereco().getIdEndereco());
            int x = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if ((x == JOptionPane.YES_OPTION)) {
                new EnderecoController().excluirEndereco(endereco);
                try {
                    new ClienteDAO().excluir(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir cliente!");
                    Logger.getLogger(ClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void pesquisarCliente() {
        ClienteDAO dao = new ClienteDAO();
        try {
            listaClientes = dao.buscarPorNome(this.viewCliente.getJtfPesquisarNome().getText());
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(ClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarClientes() {
        try {
            listaClientes = new ClienteDAO().buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(ClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewCliente.getTabelaCliente().getModel();
        modelo.setRowCount(0);
        for (Cliente cliente : listaClientes) {
            modelo.addRow(new String[]{cliente.getNome(), cliente.getEnderecoIdEndereco().getCidade(), cliente.getCelular(), cliente.getEmail()});
        }
    }

    public boolean validarSalvar() {
        if (this.viewCliente.getJtfCpf().equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(null, "Informe o CPF, campo obrigatório!");
            return false;
        }
        if (this.viewCliente.getJtfRg().equals("  .   .   ")) {
            JOptionPane.showMessageDialog(null, "Informe o RG, campo obrigatório!");
            return false;
        }
        if (this.viewCliente.getJtfDataNascimento().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Informe o nome, campo obrigatório!");
            return false;
        }
        if (this.viewCliente.getJtfNome().equals(null) || this.viewCliente.getJtfNome().equals("") || this.viewCliente.getJtfNome().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o nome, campo obrigatório!");
            return false;
        }
        if (this.viewCliente.getJtfEndereco().equals(null) || this.viewCliente.getJtfEndereco().equals("") || this.viewCliente.getJtfEndereco().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o endereço, campo obrigatório!");
            return false;
        }
        if (this.viewCliente.getJtfBairro().equals(null) || this.viewCliente.getJtfBairro().equals("") || this.viewCliente.getJtfBairro().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o bairro, campo obrigatório!");
            return false;
        }
        if (this.viewCliente.getJtfCidade().equals(null) || this.viewCliente.getJtfCidade().equals("") || this.viewCliente.getJtfCidade().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe a cidade, campo obrigatório!");
            return false;
        }
        if (this.viewCliente.getCbEstado().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Informe o estado, campo obrigatório!");
            return false;
        }
        if (this.viewCliente.getJtfTelefone().equals("(  )    -    ")) {
            JOptionPane.showMessageDialog(null, "Informe o nome, campo obrigatório!");
            return false;
        }
        if (this.viewCliente.getJtfCelular().equals("(  )     -    ")) {
            JOptionPane.showMessageDialog(null, "Informe o celular, campo obrigatório!");
            return false;
        }
        return true;
    }

    public void bloqueioInicial() {
        this.viewCliente.getJbtNovo().setEnabled(true);
        this.viewCliente.getJbtAlterar().setEnabled(true);
        this.viewCliente.getJbtExcluir().setEnabled(true);
        this.viewCliente.getJbtSair().setEnabled(true);
        this.viewCliente.getJbtSalvar().setEnabled(false);
        this.viewCliente.getJbtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void acaoBotaoCancelar() {
        this.viewCliente.getJbtSalvar().setEnabled(false);
        this.viewCliente.getJbtCancelar().setEnabled(false);
        this.viewCliente.getJbtNovo().setEnabled(true);
        this.viewCliente.getJbtAlterar().setEnabled(true);
        this.viewCliente.getJbtExcluir().setEnabled(true);
        this.viewCliente.getJbtSair().setEnabled(true);
        this.viewCliente.getJtfPesquisarNome().setEditable(true);
        limparCampos();
    }

    public void acaoBotaoAlterar() {
        this.viewCliente.getJbtNovo().setEnabled(false);
        this.viewCliente.getJbtAlterar().setEnabled(false);
        this.viewCliente.getJbtExcluir().setEnabled(false);
        this.viewCliente.getJbtSair().setEnabled(false);
        this.viewCliente.getJbtSalvar().setEnabled(true);
        this.viewCliente.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewCliente.getJtfCpf().setEditable(false);
        this.viewCliente.getJtfRg().setEditable(false);
        this.viewCliente.getJtfDataNascimento().setEditable(false);
        this.viewCliente.getJtfNome().setEditable(false);
    }

    public void acaoBotaoNovo() {
        this.viewCliente.getJbtNovo().setEnabled(false);
        this.viewCliente.getJbtAlterar().setEnabled(false);
        this.viewCliente.getJbtExcluir().setEnabled(false);
        this.viewCliente.getJbtSair().setEnabled(false);
        this.viewCliente.getJbtSalvar().setEnabled(true);
        this.viewCliente.getJbtCancelar().setEnabled(true);
        this.viewCliente.getJtfPesquisarNome().setEditable(false);
        liberarCampos();
        alterarTrue = false;
    }

    public void bloquearCampos() {
        this.viewCliente.getJtfCpf().setEditable(false);
        this.viewCliente.getJtfRg().setEditable(false);
        this.viewCliente.getJtfDataNascimento().setEditable(false);
        this.viewCliente.getJtfNome().setEditable(false);
        this.viewCliente.getJtfEndereco().setEditable(false);
        this.viewCliente.getJtfNumero().setEditable(false);
        this.viewCliente.getJtfBairro().setEditable(false);
        this.viewCliente.getJtfCidade().setEditable(false);
        this.viewCliente.getJtfCep().setEditable(false);
        this.viewCliente.getCbEstado().setEnabled(false);
        this.viewCliente.getJtfCelular().setEditable(false);
        this.viewCliente.getJtfTelefone().setEditable(false);
        this.viewCliente.getJtfEmail().setEditable(false);
        this.viewCliente.getJtfPesquisarNome().setEnabled(true);
        this.viewCliente.getJtfPesquisarNome().grabFocus();
    }

    public void liberarCampos() {
        this.viewCliente.getJtfCpf().grabFocus();
        this.viewCliente.getJtfCpf().setEditable(true);
        this.viewCliente.getJtfRg().setEditable(true);
        this.viewCliente.getJtfDataNascimento().setEditable(true);
        this.viewCliente.getJtfNome().setEditable(true);
        this.viewCliente.getJtfEndereco().setEditable(true);
        this.viewCliente.getJtfNumero().setEditable(true);
        this.viewCliente.getJtfBairro().setEditable(true);
        this.viewCliente.getJtfCidade().setEditable(true);
        this.viewCliente.getJtfCep().setEditable(true);
        this.viewCliente.getCbEstado().setEnabled(true);
        this.viewCliente.getJtfCelular().setEditable(true);
        this.viewCliente.getJtfTelefone().setEditable(true);
        this.viewCliente.getJtfEmail().setEditable(true);
    }

    public void limparCampos() {
        this.viewCliente.getJtfCpf().setText(null);
        this.viewCliente.getJtfRg().setText(null);
        this.viewCliente.getJtfDataNascimento().setText(null);
        this.viewCliente.getJtfNome().setText(null);
        this.viewCliente.getJtfEndereco().setText(null);
        this.viewCliente.getJtfNumero().setText(null);
        this.viewCliente.getJtfBairro().setText(null);
        this.viewCliente.getJtfCidade().setText(null);
        this.viewCliente.getCbEstado().setSelectedIndex(0);
        this.viewCliente.getJtfCep().setText(null);
        this.viewCliente.getJtfTelefone().setText(null);
        this.viewCliente.getJtfCelular().setText(null);
        this.viewCliente.getJtfEmail().setText(null);
    }
}