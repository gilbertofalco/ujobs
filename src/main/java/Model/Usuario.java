/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author gilberto
 */
public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String email;
    private String curso;

    public Usuario(String login, String senha, String email, String curso) {

        this.login = login;
        this.senha = senha;
        this.email = email;
        this.curso = curso;
    }

    public Usuario(int id, String login, String senha, String email, String curso) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.curso = curso;
    }


    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    
    
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }


   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
