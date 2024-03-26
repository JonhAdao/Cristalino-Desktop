package br.com.manicure.model;

class Contato extends Endereco {

    protected String email;
    protected String celular;

    public Contato() {
    }

    public Contato(String email, String celular) {
        this.email = email;
        this.celular = celular;
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

    public void alteraEmail() {

    }

    public void cadastraEmail() {

    }

}
