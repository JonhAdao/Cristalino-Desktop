package br.com.manicure.model;

public class Orcamento {

    // Quem vai mexer nessa classe vai ser o Gestor
    private Double valorFrete;
    private Double valorDesconto;
    private Procedimento valorProcedimento;
    private Cliente cliente;
    private CartaoCredito Cartao;

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Procedimento getValorProcedimento() {
        return valorProcedimento;
    }

    public void setValorProcedimento(Procedimento valorProcedimento) {
        this.valorProcedimento = valorProcedimento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CartaoCredito getCartao() {
        return Cartao;
    }

    public void setCartao(CartaoCredito Cartao) {
        this.Cartao = Cartao;
    }

}
