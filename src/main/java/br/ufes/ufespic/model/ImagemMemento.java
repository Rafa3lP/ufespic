/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.model;

import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.io.Serializable;

/**
 *
 * @author Heflain
 */
public class ImagemMemento implements Serializable{
    private final ImagemComponente imagem;

    public ImagemMemento(ImagemComponente imagem) {
        this.imagem = imagem;
    }

    public ImagemComponente getImagem() {
        return imagem;
    }
}
