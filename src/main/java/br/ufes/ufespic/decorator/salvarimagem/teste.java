/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.decorator.salvarimagem;

import br.ufes.ufespic.presenter.ExportaPresenter;
import com.pss.imagem.processamento.decorator.Imagem;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heflain
 */
public class teste {

    public static void main(String[] args) {
        ImagemComponente imagem = null;
        try {
            imagem = new Imagem("imagens/thumb/boys-fun-thumb.jpg");
        } catch (IOException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (imagem == null) {
            System.out.println("vazio");
        } else {
            new ExportaPresenter(imagem);
        }
    }
}
