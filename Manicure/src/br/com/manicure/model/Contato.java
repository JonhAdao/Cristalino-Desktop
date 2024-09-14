package br.com.manicure.model;

public class Contato {

    protected int idContato;
    protected String email;
    protected String celular;

    public Contato() {
    }

    public Contato(String email, String celular) {
        this.email = email;
        this.celular = celular;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}
