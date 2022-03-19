/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.command.Strategy.AplicarFiltro;

import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.RotacionaDecorator;

/**
 *
 * @author Heflain
 */
public class FiltroRotaciona implements IFiltro{
    private final int grauPadrao = 180;
    
    @Override
    public ImagemComponente execute(ImagemComponente imagem, int opc) throws InterruptedException {
        return new RotacionaDecorator(imagem, opc);
    }

    @Override
    public ImagemComponente execute(ImagemComponente imagem) throws InterruptedException {
        return new RotacionaDecorator(imagem, grauPadrao);
    }
    
    @Override
    public String necessita() {
        return "grau rotação";
    }
}
