/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.model;

import java.time.LocalDateTime;

/**
 *
 * @author Heflain
 */
public class ImagemHistorico {
    private int codImagemHistorico;
    private int codUsuario;
    private int codImagem;
    private String filtro;
    private LocalDateTime dataHora;

    public ImagemHistorico(int codImagemHistorico, int codUsuario, int codImagem, String filtro, LocalDateTime dataHora) {
        this.codImagemHistorico = codImagemHistorico;
        this.codUsuario = codUsuario;
        this.codImagem = codImagem;
        this.filtro = filtro;
        this.dataHora = dataHora;
    }

    public ImagemHistorico(int codUsuario, int codImagem, String filtro, LocalDateTime dataHora) {
        this.codUsuario = codUsuario;
        this.codImagem = codImagem;
        this.filtro = filtro;
        this.dataHora = dataHora;
    }

    public ImagemHistorico() {
    }

    public int getCodImagemHistorico() {
        return codImagemHistorico;
    }

    public void setCodImagemHistorico(int codImagemHistorico) {
        this.codImagemHistorico = codImagemHistorico;
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

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
