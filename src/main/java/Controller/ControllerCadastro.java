package Controller;

import DAO.Conexao;
import DAO.UsuarioDao;
import Model.Usuario;
import View.ViewCadastroUsuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControllerCadastro {
    private ViewCadastroUsuario view;

    public ControllerCadastro(ViewCadastroUsuario view) {
        this.view = view;
    }
    
    public void salvarUsuario(){
         Usuario usuario = new Usuario(view.getTxtLogin().getText(), view.getTxtSenha().getText(), view.getTxtEmail().getText(), view.getTxtCurso().getText());
        
        try {
            UsuarioDao uDao = new UsuarioDao(new Conexao().getConnection());
            uDao.insert(usuario);
            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ViewCadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
