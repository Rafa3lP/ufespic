/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.decorator.AplicarFiltro;

import com.pss.imagem.processamento.decorator.BrilhoDecorator;
import com.pss.imagem.processamento.decorator.ImagemComponente;

/**
 *
 * @author Heflain
 */
public class FiltroBrilho implements IFiltro{
    private final int escalaPadrao = 80;
    
    @Override
    public ImagemComponente execute(ImagemComponente imagem, int opc) throws InterruptedException {
        return new BrilhoDecorator(imagem, opc);
    }

    @Override
    public ImagemComponente execute(ImagemComponente imagem) throws InterruptedException {
        return new BrilhoDecorator(imagem, escalaPadrao);
    }

    @Override
    public String necessita() {
        return "escala de brilho";
    }
}
