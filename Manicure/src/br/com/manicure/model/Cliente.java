package br.com.manicure.model;

public class Cliente extends Pessoa {

    private String Login;
    private String Senha;
    private Pacotes pacote;
    private int Atendimentos;
    private String observacao;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public Pacotes getPacote() {
        return pacote;
    }

    public void setPacote(Pacotes pacote) {
        this.pacote = pacote;
    }

    public int getAtendimentos() {
        return Atendimentos;
    }

    public void setAtendimentos(int Atendimentos) {
        this.Atendimentos = Atendimentos;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
