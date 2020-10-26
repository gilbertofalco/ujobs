/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Vaga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gilberto
 */
public class VagaDao {
     private final Connection con;

    public VagaDao(Connection con) {
        this.con = con;
    }
//    
//        private int id;
//    private String descricao;
//    private Usuario empresa;
//    private String candidatos[];
    
    public void insert(Vaga v) throws SQLException{
            PreparedStatement pstm = con.prepareStatement("insert into vaga(descricao,empresa) values(?,?)");
            pstm.setString(1, v.getDescricao());
            pstm.setString(2, v.getEmpresa());
            pstm.execute();
    }
    
    public void update(Vaga v) throws SQLException{
            PreparedStatement pstm = con.prepareStatement("update vaga set descricao = ?, empresa = ? where id = ?");
            pstm.setString(1, v.getDescricao());
            pstm.setString(2, v.getEmpresa());
            pstm.setInt(3, v.getId());
            pstm.execute();
    }
    
    public void delete(Vaga v) throws SQLException{
            PreparedStatement pstm = con.prepareStatement("delete from vaga where id = ?");
            pstm.setInt(1, v.getId());
            pstm.execute();
    }

    public boolean vagaPorEmpresa(Vaga v) throws SQLException {
            PreparedStatement pstm = con.prepareStatement("select * from vaga where empresa = ?");
            pstm.setString(1, v.getEmpresa());
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            return rs.next();            
    }

    public ArrayList<Vaga> selectAll() throws SQLException{
        PreparedStatement pstm = con.prepareStatement("select * from vaga");
        return search(pstm);
    }

    private ArrayList<Vaga> search(PreparedStatement pstm) throws SQLException {
        ArrayList<Vaga> uList = new ArrayList<>();
        pstm.execute();
        while(pstm.getResultSet().next()){
            uList.add(new Vaga(pstm.getResultSet().getInt("id"),
                    pstm.getResultSet().getString("descricao"),
                    pstm.getResultSet().getString("empresa")
                    
            )
            );
        }
        return uList;
    }
    
    public Vaga selectId(Vaga u) throws SQLException{
        PreparedStatement pstm = con.prepareStatement("select from vaga where id = ?");
        pstm.setInt(1, u.getId());
        pstm.execute();
        return search(pstm).get(0);
    }

}
