/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufes.ufespic.builder.filtrosPadrao;

import com.pss.imagem.processamento.decorator.ImagemComponente;

/**
 *
 * @author Heflain
 */
public interface IBFiltrosPadrao {
    public void reset(ImagemComponente imagem);
    public void aplicarFiltroUm();
    public void aplicarFiltroDois();
    public void aplicarFiltroTres();
    public void aplicarFiltroQuatro();
    public ImagemComponente getResult();
}
