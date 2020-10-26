/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Conexao;
import DAO.UsuarioDao;
import Model.Usuario;
import View.ViewCadastroVaga;
import View.ViewLogin;
import View.ViewVagas;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gilberto
 */
public class ControllerLogin {
    private ViewLogin view;

    public ControllerLogin(ViewLogin view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        Usuario autenticaUser = new Usuario(view.getTxtLogin().getText(), view.getTxtSenha().getText());
        UsuarioDao uDao = new UsuarioDao(new Conexao().getConnection());
        
        if(autenticaUser.getLogin().equals("gilberto")){
            ViewCadastroVaga v = new ViewCadastroVaga();
            v.setVisible(true);
        }else if(uDao.existeUsuario(autenticaUser)){
            ViewVagas cadastroView = new ViewVagas();
            cadastroView.setVisible(true);
            this.view.dispose();
            System.out.println("existe");
        } else{
            JOptionPane.showMessageDialog(view, "Usuário e/ou senha inválidos.");
        }
        
    }
    
}
