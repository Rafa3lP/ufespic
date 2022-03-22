/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.model;

/**
 *
 * @author Heflain
 */
public class Imagem {
    private int codImagem;
    private String caminhoImagem;
    private String caminhoMiniatura;
    private String nomeArquivo;

    public Imagem(int codImagem, String caminhoImagem, String caminhoMiniatura, String nomeArquivo) {
        this.codImagem = codImagem;
        this.caminhoImagem = caminhoImagem;
        this.caminhoMiniatura = caminhoMiniatura;
        this.nomeArquivo = nomeArquivo;
    }

    public Imagem(String caminhoImagem, String caminhoMiniatura, String nomeArquivo) {
        this.caminhoImagem = caminhoImagem;
        this.caminhoMiniatura = caminhoMiniatura;
        this.nomeArquivo = nomeArquivo;
    }

    public Imagem() {
    }

    public int getCodImagem() {
        return codImagem;
    }

    public void setCodImagem(int codImagem) {
        this.codImagem = codImagem;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public String getCaminhoMiniatura() {
        return caminhoMiniatura;
    }

    public void setCaminhoMiniatura(String caminhoMiniatura) {
        this.caminhoMiniatura = caminhoMiniatura;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
}
