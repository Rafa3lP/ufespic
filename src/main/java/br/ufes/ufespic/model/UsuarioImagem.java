/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.model;

/**
 *
 * @author Heflain
 */
public class UsuarioImagem {
    private int codImagemUsuario;
    private int codUsuario;
    private int codImagem;
    private boolean visualizar;
    private boolean aplicarFiltro;
    private boolean salvar;
    private boolean excluir;
    private boolean exporta;

    public UsuarioImagem(int codImagemUsuario, int codUsuario, int codImagem, boolean visualizar, boolean aplicarFiltro, boolean salvar, boolean excluir, boolean exporta) {
        this.codImagemUsuario = codImagemUsuario;
        this.codUsuario = codUsuario;
        this.codImagem = codImagem;
        this.visualizar = visualizar;
        this.aplicarFiltro = aplicarFiltro;
        this.salvar = salvar;
        this.excluir = excluir;
        this.exporta = exporta;
    }

    public UsuarioImagem(int codUsuario, int codImagem, boolean visualizar, boolean aplicarFiltro, boolean salvar, boolean excluir, boolean exporta) {
        this.codUsuario = codUsuario;
        this.codImagem = codImagem;
        this.visualizar = visualizar;
        this.aplicarFiltro = aplicarFiltro;
        this.salvar = salvar;
        this.excluir = excluir;
        this.exporta = exporta;
    }

    public UsuarioImagem() {
    }

    public int getCodImagemUsuario() {
        return codImagemUsuario;
    }

    public void setCodImagemUsuario(int codImagemUsuario) {
        this.codImagemUsuario = codImagemUsuario;
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

    public boolean isVisualizar() {
        return visualizar;
    }

    public void setVisualizar(boolean visualizar) {
        this.visualizar = visualizar;
    }

    public boolean isAplicarFiltro() {
        return aplicarFiltro;
    }

    public void setAplicarFiltro(boolean aplicarFiltro) {
        this.aplicarFiltro = aplicarFiltro;
    }

    public boolean isSalvar() {
        return salvar;
    }

    public void setSalvar(boolean salvar) {
        this.salvar = salvar;
    }

    public boolean isExcluir() {
        return excluir;
    }

    public void setExcluir(boolean excluir) {
        this.excluir = excluir;
    }

    public boolean isExporta() {
        return exporta;
    }

    public void setExporta(boolean exporta) {
        this.exporta = exporta;
    }
    
}
