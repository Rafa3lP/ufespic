/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.decorator.AplicarFiltro;

import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.RGBDecorator;

/**
 *
 * @author Heflain
 */
public class FiltroTesteTres extends RGBDecorator {

    public FiltroTesteTres(ImagemComponente elementoDecorado) throws InterruptedException {
        super(elementoDecorado);
    }

    @Override
    public void alteraCor() {
        a = (rgb >> 24) & 0xff;
        red = (rgb >> 16) & 0xff;

        this.rgb = (a << 24) | (red << 16);
    }

}
