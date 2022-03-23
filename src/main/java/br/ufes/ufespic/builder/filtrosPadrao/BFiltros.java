/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.builder.filtrosPadrao;

import br.ufes.ufespic.decorator.AplicarFiltro.FiltroAzul;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroEspelhada;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroRotaciona;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroVerde;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heflain
 */
public class BFiltros implements IBFiltrosPadrao {

    private ImagemComponente imagem;

    public BFiltros(ImagemComponente imagem) {
        reset(imagem);
    }

    @Override
    public void reset(ImagemComponente imagem) {
        this.imagem = imagem;
    }

    @Override
    public void aplicarFiltroUm() {
        try {
            this.imagem = new FiltroAzul().execute(this.imagem);
        } catch (InterruptedException ex) {
            Logger.getLogger(BFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void aplicarFiltroDois() {
        try {
            this.imagem = new FiltroEspelhada().execute(this.imagem);
        } catch (InterruptedException ex) {
            Logger.getLogger(BFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void aplicarFiltroTres() {
        try {
            this.imagem = new FiltroVerde().execute(this.imagem);
        } catch (InterruptedException ex) {
            Logger.getLogger(BFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void aplicarFiltroQuatro() {
        try {
            this.imagem = new FiltroRotaciona().execute(this.imagem);
        } catch (InterruptedException ex) {
            Logger.getLogger(BFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ImagemComponente getResult() {
        return this.imagem;
    }
}
