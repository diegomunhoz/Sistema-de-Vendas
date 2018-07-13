package controller;

import dao.FuncionarioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Funcionario;
import view.LoginSistema;
import view.MenuPrincipal;

/**
 *
 * @author Diego Munhoz
 */
public class LoginController {

    private FuncionarioDAO dao = new FuncionarioDAO();
    private LoginSistema viewLoginSistema;
    private List<Funcionario> listaFuncionario;
    private Funcionario fucionario;

    public LoginController(LoginSistema viewLoginSistema) {
        this.viewLoginSistema = viewLoginSistema;
        try {
            this.listaFuncionario = this.dao.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logar() {
        if (this.viewLoginSistema.getJtfLogin().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo login é obrigatório!");
        } else if (this.viewLoginSistema.getJtfSenha().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo senha é obrigatório!");
        } else {
            int aux = 0;
            for (Funcionario func : this.listaFuncionario) {
                if (func.getLogin().equals(this.viewLoginSistema.getJtfLogin().getText()) && func.getSenha().equals(this.viewLoginSistema.getJtfSenha().getText())) {
                    this.fucionario = func;
                    aux = 1;
                    break;
                }
            }
            if (aux == 1) {
                this.viewLoginSistema.dispose();
                new MenuPrincipal().getJblUsuario().setText(fucionario.getNome());
            } else {
                JOptionPane.showMessageDialog(null, "Login ou Senha inválidos!!!");
            }
        }
    }
}