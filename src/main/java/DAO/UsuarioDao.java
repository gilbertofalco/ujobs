/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gilberto
 */
public class UsuarioDao {
    private final Connection con;

    public UsuarioDao(Connection con) {
        this.con = con;
    }
    
    public void insert(Usuario u) throws SQLException{
            PreparedStatement pstm = con.prepareStatement("insert into usuario(login,senha,email,curso) values(?,?,?,?)");
            pstm.setString(1, u.getLogin());
            pstm.setString(2, u.getSenha());
            pstm.setString(3, u.getEmail());
                 pstm.setString(4, u.getCurso());
            pstm.execute();
    }
    
    public void update(Usuario u) throws SQLException{
            PreparedStatement pstm = con.prepareStatement("update usuario set = ?, senha = ?, email = ?, curso = ? where id = ?");
            pstm.setString(1, u.getLogin());
            pstm.setString(2, u.getSenha());
            pstm.setString(3, u.getEmail());
            pstm.setString(4, u.getCurso());
            pstm.setInt(5, u.getId());
            pstm.execute();
    }
    
    public void delete(Usuario u) throws SQLException{
            PreparedStatement pstm = con.prepareStatement("delete from usuario where id = ?");
            pstm.setInt(1, u.getId());
            pstm.execute();
    }

    public boolean existeUsuario(Usuario u) throws SQLException {
            PreparedStatement pstm = con.prepareStatement("select * from usuario where login = ? and senha = ?");
            pstm.setString(1, u.getLogin());
            pstm.setString(2, u.getSenha());
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            return rs.next();            
    }

    public ArrayList<Usuario> selectAll() throws SQLException{
        PreparedStatement pstm = con.prepareStatement("select * from usuario");
        return search(pstm);
    }

    private ArrayList<Usuario> search(PreparedStatement pstm) throws SQLException {
        ArrayList<Usuario> uList = new ArrayList<>();
        pstm.execute();
        while(pstm.getResultSet().next()){
            uList.add(new Usuario(pstm.getResultSet().getInt("id"),
                    pstm.getResultSet().getString("login"),
                    pstm.getResultSet().getString("senha"),
                    pstm.getResultSet().getString("email"),
                    pstm.getResultSet().getString("curso")
            )
            );
        }
        return uList;
    }
    
    public Usuario selectId(Usuario u) throws SQLException{
        PreparedStatement pstm = con.prepareStatement("select from usuario where id = ?");
        pstm.setInt(1, u.getId());
        pstm.execute();
        return search(pstm).get(0);
    }

    
}
