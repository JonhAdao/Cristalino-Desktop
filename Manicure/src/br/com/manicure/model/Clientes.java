package br.com.manicure.model;

/**
 *
 * @author John
 */
public class Clientes {

    public Clientes() {

    }

    private int id;
    private String nome;
    private String endereco;
    private String cpf;
    private String email;
    private String celular;
    private String Pacote_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getPacote_id() {
        return Pacote_id;
    }

    public void setPacote_id(String Pacote_id) {
        this.Pacote_id = Pacote_id;
    }

}
