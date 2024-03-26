package br.com.manicure.model;

public class Assinatura {
    
    // Quem vai mexer nessa classe vai ser o Gestor e o Cliente


    private String Nome;
    private Double Valor;
    private Double Credito;
    private String Descricao;

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

    public Double getCredito() {
        return Credito;
    }

    public void setCredito(Double Credito) {
        this.Credito = Credito;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

}
