/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.model;

import com.pss.imagem.processamento.decorator.Imagem;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Heflain
 */
public class ImagemProxy {
    private int codImagem;
    private String caminhoImagem;
    private String caminhoMiniatura;
    private String nomeArquivo;
    private ImagemComponente miniatura = null;
    private ImagemComponente imagem = null;
    
    public ImagemProxy(int codImagem, String caminhoImagem, String caminhoMiniatura, String nomeArquivo) {
        this.codImagem = codImagem;
        this.caminhoImagem = caminhoImagem;
        this.caminhoMiniatura = caminhoMiniatura;
        this.nomeArquivo = nomeArquivo;
    }

    public ImagemProxy(String caminhoImagem, String caminhoMiniatura, String nomeArquivo) {
        this.caminhoImagem = caminhoImagem;
        this.caminhoMiniatura = caminhoMiniatura;
        this.nomeArquivo = nomeArquivo;
    }

    public ImagemProxy() {
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

    public ImagemComponente getImagem() throws IOException, InterruptedException {
        if(imagem == null) {
            imagem = new Imagem(caminhoImagem);
        }
        return imagem;
    }

    public ImagemComponente getMiniatura() throws IOException, InterruptedException {
        if(miniatura == null) {
            miniatura = new Imagem(caminhoMiniatura);
        }
        return miniatura;
    }
}
