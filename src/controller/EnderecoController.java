package controller;

import dao.EnderecoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe de controle das ações de ENDEREÇO
 *
 * @author Diego Munhoz
 */
public class EnderecoController {

    public void updateEndereco(Object objeto) {
        try {
            new EnderecoDAO().salvar(objeto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir endereço!");
            Logger.getLogger(EnderecoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirEndereco(Object objeto) {
        try {
            new EnderecoDAO().excluir(objeto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir endereço!");
            Logger.getLogger(EnderecoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}