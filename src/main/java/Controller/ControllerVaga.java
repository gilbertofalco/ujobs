/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Conexao;
import DAO.VagaDao;
import Model.Vaga;
import View.ViewCadastroVaga;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gilberto
 */
public class ControllerVaga {
        private ViewCadastroVaga view;

    public ControllerVaga(ViewCadastroVaga view) {
        this.view = view;
    }


    
    public void salvarVaga(){
         Vaga vaga = new Vaga(view.getTxtEmpresa().getText(), view.getTxtDescricao().getText());
        
        try {
            VagaDao uDao = new VagaDao(new Conexao().getConnection());
            uDao.insert(vaga);
            JOptionPane.showMessageDialog(null, "Vaga adicionada com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ViewCadastroVaga.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluirVaga() {
        
        Vaga vaga = new Vaga(view.getTxtEmpresa().getText(), view.getTxtDescricao().getText());
        int opt = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Exlcuir", JOptionPane.YES_NO_OPTION);
        int row = view.getjTable1().getSelectedRow();
        int id = (int) (view.getjTable1().getModel().getValueAt(row, 0));
        if(opt == 0){
            try {
            VagaDao uDao = new VagaDao(new Conexao().getConnection());
            uDao.insert(vaga);
            JOptionPane.showMessageDialog(null, "Vaga adicionada com sucesso!");
                
           } catch (Exception e) {
            }
        }
    }
}
