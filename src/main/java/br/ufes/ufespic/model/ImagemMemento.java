/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.model;

import br.ufes.ufespic.view.AplicarFiltroView;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author Heflain
 */
public class ImagemMemento implements Serializable {

    private final ImagemComponente imagem;
    //private final JPanel filtrosAplicados;

    private final boolean estadoAzul;
    private final boolean estadoVerde;
    private final boolean estadoVermelho;
    private final boolean estadoEspelhada;
    private final boolean estadoRotacao;
    private final boolean estadoNegativo;
    private final boolean estadoSerpia;
    private final boolean estadoPixelar;
    private final boolean estadoTonsDeCinza;
    private final boolean estadoBrilho;

    public ImagemMemento(ImagemComponente imagem, AplicarFiltroView view) {
        this.imagem = imagem;

        this.estadoAzul = view.getChkImagemAzul().isSelected();
        this.estadoVerde = view.getChkImagemVerde().isSelected();
        this.estadoVermelho = view.getChkImagemVermelha().isSelected();
        this.estadoEspelhada = view.getChkImagemEspelhada().isSelected();
        this.estadoRotacao = view.getChkRotacao().isSelected();
        this.estadoNegativo = view.getChkNegativo().isSelected();
        this.estadoSerpia = view.getChkCorSepia().isSelected();
        this.estadoPixelar = view.getChkPixelar().isSelected();
        this.estadoTonsDeCinza = view.getChkTonsDeCinza().isSelected();
        this.estadoBrilho = view.getChkBrilho().isSelected();

    }
    
    /*public ImagemMemento(ImagemComponente imagem, JPanel painel){
        this.imagem = imagem;
        this.filtrosAplicados = painel;
    }*/

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

    public boolean isEstadoPixelar() {
        return estadoPixelar;
    }

    public boolean isEstadoTonsDeCinza() {
        return estadoTonsDeCinza;
    }

    public boolean isEstadoBrilho() {
        return estadoBrilho;
    }

    /*public JPanel getFiltrosAplicados() {
        return filtrosAplicados;
    }*/
}
