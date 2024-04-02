package br.com.manicure.model;

import java.util.Date;
import java.util.Scanner;

public class Cliente extends Contato implements operacaoCadastro {

    private String Login;
    private String Senha;
    private int quantAtendimento;
    private Pacotes pacote;
    private Endereco endereco;
    private String observacao;

    Scanner entrada = new Scanner(System.in);
    Scanner entrada1 = new Scanner(System.in);
    Scanner entrada2 = new Scanner(System.in);
    Scanner entrada5 = new Scanner(System.in);
    Scanner entrada6 = new Scanner(System.in);
    Scanner entrada7 = new Scanner(System.in);
    Scanner entrada8 = new Scanner(System.in);
    Scanner entrada9 = new Scanner(System.in);
    Scanner entrada12 = new Scanner(System.in);
    Scanner entrada13 = new Scanner(System.in);
    Scanner entrada14 = new Scanner(System.in);
    Scanner entrada15 = new Scanner(System.in);

    public Cliente() {
    }

    public Cliente(String Nome, String Cpf, String Rg, String Celular, String Email, String Rua, String Bairro, String Cep, int Numero, String Login, String Senha, int quantAtendimento) {
        this.nome = Nome;
        this.cpf = Cpf;
        this.rg = Rg;
        this.celular = Celular;
        this.email = Email;
        this.rua = Rua;
        this.numero = Numero;
        this.cep = Cep;
        this.bairro = Bairro;
        this.Login = Login;
        this.Senha = Senha;
        this.quantAtendimento = quantAtendimento;

    }

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

    public int getQuantAtendimento() {
        return quantAtendimento;
    }

    public void setQuantAtendimento(int quantAtendimento) {
        this.quantAtendimento = quantAtendimento;
    }

    public Pacotes getPacote() {
        return pacote;
    }

    public void setPacote(Pacotes pacote) {
        this.pacote = pacote;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public void fazCadastro() {

        System.out.println("\nCadastro de Clientes ");
        System.out.println("-----------------------");

        System.out.print("\nNome - ");
        this.setNome(entrada.nextLine());

        System.out.print("CPF - ");
        this.setCpf(entrada1.nextLine());

        System.out.print("RG - ");
        this.setRg(entrada2.nextLine());

        System.out.print("Celular - ");
        this.setCelular(entrada5.nextLine());

        System.out.print("Email - ");
        this.setEmail(entrada6.nextLine());

        System.out.print("Rua - ");
        this.setRua(entrada7.nextLine());

        System.out.print("N° - ");
        this.setNumero(entrada8.nextInt());

        System.out.print("CEP - ");
        this.setCep(entrada9.nextLine());

        System.out.print("Bairro - ");
        this.setBairro(entrada12.nextLine());

        System.out.print("\nQuantidade de atendimentos realizados: ");
        this.setQuantAtendimento(entrada15.nextInt());
    }

    @Override
    public void alteraCadastro() {
    }

    @Override
    public void excluiCadastro() {
    }

    @Override
    public void mostrarDados() {
        System.out.println();
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("RG: " + this.getRg());
        System.out.println("Celular: " + this.getCelular());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Rua: " + this.getRua());
        System.out.println("Número: " + this.getNumero());
        System.out.println("Cep: " + this.getCep());
        System.out.println("Ponto de Referência: " + this.bairro);
        System.out.println("Numero de atendimentos: " + this.getQuantAtendimento());

        System.out.println("------------------------------------------------------");
    }

}
