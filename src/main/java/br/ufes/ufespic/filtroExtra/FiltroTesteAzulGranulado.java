/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.filtroExtra;

import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.RGBDecorator;

/**
 *
 * @author Heflain
 */
public class FiltroTesteAzulGranulado extends RGBDecorator{
    
    public FiltroTesteAzulGranulado(ImagemComponente elementoDecorado) throws InterruptedException {
        super(elementoDecorado);
    }

    @Override
    public void alteraCor() {
        a = (rgb >> 24) & 0xff;
        blue = (rgb >> 10) & 0xff;
        red = rgb & 0xff;
        rgb = (a << 24) | blue | red;
    }
    
}
