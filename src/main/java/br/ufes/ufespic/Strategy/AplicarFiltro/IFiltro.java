/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufes.ufespic.Strategy.AplicarFiltro;

import com.pss.imagem.processamento.decorator.ImagemComponente;

/**
 *
 * @author Heflain
 */
public interface IFiltro {
    public ImagemComponente execute(ImagemComponente imagem, int opc) throws InterruptedException;
    public ImagemComponente execute(ImagemComponente imagem) throws InterruptedException;
    public String necessita();
}
