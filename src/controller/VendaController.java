package controller;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.ProdutoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Funcionario;
import model.Produto;
import view.ClientePrincipal;
import view.VendaPrincipal;

/**
 *
 * @author Diego Munhoz
 */
public class VendaController {

    private VendaPrincipal viewVenda;
    private Cliente cliente;
    private Funcionario funcionario;
    private Produto produto;
    private List<Cliente> listaClientes;
    private List<Funcionario> listaFuncionarios;
    private List<Produto> listaProdutos;

    public VendaController(VendaPrincipal viewVenda) {
        this.viewVenda = viewVenda;
    }

    public void listarCliente() {
        try {
            listaClientes = new ClienteDAO().buscarTodos();
            for (Cliente c : listaClientes) {
                this.viewVenda.getCbCliente().addItem(c.getNome());
            }
        } catch (Exception ex) {
            Logger.getLogger(ClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarFuncionario() {
        try {
            listaFuncionarios = new FuncionarioDAO().buscarTodos();
            for (Funcionario f : listaFuncionarios) {
                this.viewVenda.getCbFuncionario().addItem(f.getNome());
            }
        } catch (Exception ex) {
            Logger.getLogger(ClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarProduto() {
        try {
            listaProdutos = new ProdutoDAO().buscarTodos();
            for (Produto p : listaProdutos) {
                this.viewVenda.getCbFuncionario().addItem(p.getDescricao());
            }
        } catch (Exception ex) {
            Logger.getLogger(ClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}