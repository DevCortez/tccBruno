package com.tcc.brunopinela.model;

public class M_usuario {
    private int id;
    private String nome;
    private String datanasc;
    private String altura;
    private String peso;
    private String email;
    private String telefoneResp;
    private String telefoneMed;

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

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneResp() {
        return telefoneResp;
    }

    public void setTelefoneResp(String telefoneResp) {
        this.telefoneResp = telefoneResp;
    }

    public String getTelefoneMed() {
        return telefoneMed;
    }

    public void setTelefoneMed(String telefoneMed) {
        this.telefoneMed = telefoneMed;
    }
}
