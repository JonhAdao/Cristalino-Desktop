package br.com.manicure.model;

public class Esmalte {

    private int idEsmalte;
    private String Cor;
    private boolean Disponivel;

    public int getIdEsmalte() {
        return idEsmalte;
    }

    public void setIdEsmalte(int idEsmalte) {
        this.idEsmalte = idEsmalte;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public boolean isDisponivel() {
        return Disponivel;
    }

    public void isDisponivel(boolean Disponivel) {
        this.Disponivel = Disponivel;
    }

}
