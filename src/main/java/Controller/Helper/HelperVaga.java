/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Vaga;
import View.ViewVagas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gilberto
 */
public class HelperVaga {
    private final ViewVagas view;
    
    public HelperVaga(ViewVagas view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Vaga> vagas) {
           DefaultTableModel tblModel = (DefaultTableModel) view.getjTable1().getModel();
           tblModel.setNumRows(0);
           
           vagas.forEach(vaga -> {
               tblModel.addRow(new Object[]{
                   vaga.getId(),
                   vaga.getDescricao(),
                   vaga.getEmpresa()
               });
        });
    }
    
    

}
