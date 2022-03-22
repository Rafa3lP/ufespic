/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.model;

/**
 *
 * @author Heflain
 */
public class SolicitacaoImagem {
    private int codSolicitacaoImagem;
    private int codUsuario;
    private int codImagem;
    private String solicitacao;

    public SolicitacaoImagem(int codSolicitacaoImagem, int codUsuario, int codImagem, String solicitacao) {
        this.codSolicitacaoImagem = codSolicitacaoImagem;
        this.codUsuario = codUsuario;
        this.codImagem = codImagem;
        this.solicitacao = solicitacao;
    }

    public SolicitacaoImagem(int codUsuario, int codImagem, String solicitacao) {
        this.codUsuario = codUsuario;
        this.codImagem = codImagem;
        this.solicitacao = solicitacao;
    }

    public SolicitacaoImagem() {
    }

    public int getCodSolicitacaoImagem() {
        return codSolicitacaoImagem;
    }

    public void setCodSolicitacaoImagem(int codSolicitacaoImagem) {
        this.codSolicitacaoImagem = codSolicitacaoImagem;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getCodImagem() {
        return codImagem;
    }

    public void setCodImagem(int codImagem) {
        this.codImagem = codImagem;
    }

    public String getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(String solicitacao) {
        this.solicitacao = solicitacao;
    }
    
    
}
