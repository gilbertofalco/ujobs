/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.HelperVaga;
import DAO.Conexao;
import DAO.VagaDao;
import Model.Vaga;
import View.ViewVagas;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gilberto
 */
public class ControllerMenu {
    private final ViewVagas view;
    private HelperVaga helper;
    
    public ControllerMenu(ViewVagas view) {
        this.view = view;
        this.helper = new HelperVaga(view);
    }
    
    public void atualizaTabela() throws SQLException{
        VagaDao vagaDao = new VagaDao(new Conexao().getConnection());
        ArrayList<Vaga> vagas = vagaDao.selectAll();
        helper.preencherTabela(vagas);
    }
}
