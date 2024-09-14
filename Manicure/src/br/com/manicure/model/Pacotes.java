package br.com.manicure.model;

import java.util.Date;

public class Pacotes {

    private int idPacote;
    private String Nome;
    private Double Valor;
    private String Descricao;
    private Date dataAtendimento;

    public int getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(int idPacote) {
        this.idPacote = idPacote;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

}
