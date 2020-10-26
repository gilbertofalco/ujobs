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
public class Vaga {

    public Vaga(String descricao, String empresa) {
        this.descricao = descricao;
        this.empresa = empresa;
    }
    private int id;
    private String descricao;
    private String empresa;
    private String candidatos[];

    public Vaga(int id, String descricao, String empresa) {
        this.id = id;
        this.descricao = descricao;
        this.empresa = empresa;

    }

    public Vaga(int id, String descricao, String empresa, String[] candidatos) {
        this.id = id;
        this.descricao = descricao;
        this.empresa = empresa;
        this.candidatos = candidatos;
    }

    public String[] getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(String[] candidatos) {
        this.candidatos = candidatos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

}
