/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.command.visualizarimagem;

import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.presenter.VisualizarImagemPresenter;
import br.ufes.ufespic.service.ImagemService;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Rafael
 */
public class CarregarImagemCommandTemplate extends VisualizarImagemCommandTemplate {
    private ImagemService imagemService;
    public CarregarImagemCommandTemplate(VisualizarImagemPresenter presenter, ImagemProxy imagem) {
        super(presenter, imagem);
        imagemService = ImagemService.getInstancia();
    }

    @Override
    public void executar() {
        new Thread(){
            @Override
            public void run() {
                try {
                    view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem().getImagem()));        
                    onSuccess();
                }catch(IOException | InterruptedException ex) {
                    onError(ex);
                }

            }
        }.start();
    }

}
