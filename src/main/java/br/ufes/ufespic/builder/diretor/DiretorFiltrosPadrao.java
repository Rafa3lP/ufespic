/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.builder.diretor;

import br.ufes.ufespic.builder.filtrosPadrao.IBFiltrosPadrao;
import com.pss.imagem.processamento.decorator.ImagemComponente;

/**
 *
 * @author Heflain
 */
public class DiretorFiltrosPadrao {
    public ImagemComponente padraoUm(IBFiltrosPadrao filtros){
        filtros.aplicarFiltroUm();
        filtros.aplicarFiltroDois();
        return filtros.getResult();
    }
    public ImagemComponente padraoDois(IBFiltrosPadrao filtros){
        filtros.aplicarFiltroTres();
        filtros.aplicarFiltroQuatro();
        return filtros.getResult();
    }
}
