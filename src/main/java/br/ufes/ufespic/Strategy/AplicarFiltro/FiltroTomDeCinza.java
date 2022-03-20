/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.Strategy.AplicarFiltro;

import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.TomDeCinzaDecorator;

/**
 *
 * @author Heflain
 */
public class FiltroTomDeCinza implements IFiltro{
    @Override
    public ImagemComponente execute(ImagemComponente imagem, int opc) throws InterruptedException{
        return new TomDeCinzaDecorator(imagem);
    }

    @Override
    public ImagemComponente execute(ImagemComponente imagem)throws InterruptedException{
        return new TomDeCinzaDecorator(imagem);
    }
    
    @Override
    public String necessita() {
        return "";
    }
}
