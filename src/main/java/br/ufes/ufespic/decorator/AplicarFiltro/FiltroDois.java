/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.decorator.AplicarFiltro;

import br.ufes.ufespic.filtroExtra.FiltroTesteDois;
import com.pss.imagem.processamento.decorator.ImagemComponente;

/**
 *
 * @author Heflain
 */
public class FiltroDois implements IFiltro{

    @Override
    public ImagemComponente execute(ImagemComponente imagem, int opc) throws InterruptedException {
        return new FiltroTesteDois(imagem);
    }

    @Override
    public ImagemComponente execute(ImagemComponente imagem) throws InterruptedException {
        return new FiltroTesteDois(imagem);
    }

    @Override
    public String necessita() {
        return "";
    }
    
}
