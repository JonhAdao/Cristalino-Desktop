package br.com.manicure.model;

import java.util.Date;

public class Financeiro {

    // Quem vai mexer nessa classe vai ser o Gestor
    private Double Entrada;
    private Double Saida;
    private Date dataEntrada;
    private Date dataSaida;
    private Orcamento orcamento;

    public Double getEntrada() {
        return Entrada;
    }

    public void setEntrada(Double Entrada) {
        this.Entrada = Entrada;
    }

    public Double getSaida() {
        return Saida;
    }

    public void setSaida(Double Saida) {
        this.Saida = Saida;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

}
