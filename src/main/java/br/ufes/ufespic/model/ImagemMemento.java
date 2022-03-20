/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.model;

import br.ufes.ufespic.view.AplicarFiltroView;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.io.Serializable;

/**
 *
 * @author Heflain
 */
public class ImagemMemento implements Serializable{
    private final ImagemComponente imagem;
    
    private final boolean estadoAzul;
    private final boolean estadoVerde;
    private final boolean estadoVermelho;
    private final boolean estadoEspelhada;
    private final boolean estadoRotacao;
    private final boolean estadoNegativo;
    private final boolean estadoSerpia;
    private final boolean estadoPexelar;
    private final boolean estadoTonsDeCinza;
    private final boolean estadoBrilho;

    public ImagemMemento(ImagemComponente imagem, AplicarFiltroView view){
        this.imagem = imagem;
        this.estadoAzul = view.getChkImagemAzul().isSelected();
        this.estadoVerde = view.getChkImagemVerde().isSelected();
        this.estadoVermelho = view.getChkImagemVermelha().isSelected();
        this.estadoEspelhada = view.getChkImagemEspelhada().isSelected();
        this.estadoRotacao = view.getChkRotacao().isSelected();
        this.estadoNegativo = view.getChkNegativo().isSelected();
        this.estadoSerpia = view.getChkCorSepia().isSelected();
        this.estadoPexelar = view.getChkPixelar().isSelected();
        this.estadoTonsDeCinza = view.getChkTonsDeCinza().isSelected();
        this.estadoBrilho = view.getChkBrilho().isSelected();
    }

    public ImagemComponente getImagem() {
        return imagem;
    }

    public boolean isEstadoAzul() {
        return estadoAzul;
    }

    public boolean isEstadoVerde() {
        return estadoVerde;
    }

    public boolean isEstadoVermelho() {
        return estadoVermelho;
    }

    public boolean isEstadoEspelhada() {
        return estadoEspelhada;
    }

    public boolean isEstadoRotacao() {
        return estadoRotacao;
    }

    public boolean isEstadoNegativo() {
        return estadoNegativo;
    }

    public boolean isEstadoSerpia() {
        return estadoSerpia;
    }

    public boolean isEstadoPexelar() {
        return estadoPexelar;
    }

    public boolean isEstadoTonsDeCinza() {
        return estadoTonsDeCinza;
    }

    public boolean isEstadoBrilho() {
        return estadoBrilho;
    }
    
    
}
