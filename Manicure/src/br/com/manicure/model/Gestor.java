package br.com.manicure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gestor extends Contato implements operacaoCadastro {

    private String login;
    private String senha;

    Cliente cliente = new Cliente();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void fazCadastro() {
    }

    @Override
    public void alteraCadastro() {
    }

    @Override
    public void excluiCadastro() {
    }

    @Override
    public void mostrarDados() {
    }

    public void ordenaPorAtendimento(ArrayList L) {
        Collections.sort(L, new Comparator<Cliente>() {
            public int compare(Cliente o1, Cliente o2) {
                int atendimento = o2.getQuantAtendimento() - o1.getQuantAtendimento();
                return atendimento;
            }
        });
    }

}
