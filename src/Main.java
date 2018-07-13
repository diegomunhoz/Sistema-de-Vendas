import javax.swing.UIManager;
import view.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new MenuPrincipal();
        //new LoginSistema();
        //new FornecedorPrincipal();
        //new ProdutoPrincipal();
        //new EstoquePrincipal();
        //new FuncionarioPrincipal();
        //new VendaPrincipal();
    }
}