/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.command.Strategy.AplicarFiltro;

import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.PixeladaDecorator;

/**
 *
 * @author Heflain
 */
public class FiltroPixelada implements IFiltro{ 
    private final int tamanhoPadraoPixel = 5;
    
    @Override
    public ImagemComponente execute(ImagemComponente imagem, int opc) throws InterruptedException {
        return new PixeladaDecorator(imagem, opc);
    }

    @Override
    public ImagemComponente execute(ImagemComponente imagem) throws InterruptedException {
        return new PixeladaDecorator(imagem, tamanhoPadraoPixel);
    }
    
    @Override
    public String necessita() {
        return "tamanho pixel";
    }
}
