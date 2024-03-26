package br.com.manicure.model;

import java.sql.Timestamp;
import java.sql.Time;

public class Agendamentos {

    private int id;
    private Cliente cliente;
    private Procedimento procedimento;
    private Esmalte corEsmalte;
    private Timestamp dataAgendamento;
    private Time horario;
    private Double valoraPagar;
    private Double frete;
    private String observacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Esmalte getCorEsmalte() {
        return corEsmalte;
    }

    public void setCorEsmalte(Esmalte corEsmalte) {
        this.corEsmalte = corEsmalte;
    }

    public Timestamp getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Timestamp dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Double getValoraPagar() {
        return valoraPagar;
    }

    public void setValoraPagar(Double valoraPagar) {
        this.valoraPagar = valoraPagar;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
