/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.presenter;

import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.view.VisualizarImagemView;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author Rafael
 */
public class VisualizarImagemPresenter {
    private MainPresenter mainPresenter;
    private VisualizarImagemView view;
    private ImagemProxy imagemProxy;

    public VisualizarImagemPresenter(MainPresenter mainPresenter, ImagemProxy imagemProxy) {
        try {
            this.view = new VisualizarImagemView();
            this.mainPresenter = mainPresenter;
            this.imagemProxy = imagemProxy;
            
            this.view.getLblImagem().setIcon(new ImageIcon(imagemProxy.getImagem().getImagem()));
            
            this.view.getBtnFechar().addActionListener((e) -> {
                view.dispose();
            });
            this.view.getBtnExcluir().addActionListener((e) -> {
                
            });
            this.view.getBtnAplicarFiltros().addActionListener((e) -> {
                new AplicarFiltroPresenter(mainPresenter, imagemProxy);
                view.dispose();
            });
            
            this.view.setVisible(true);
            this.mainPresenter.addToDesktopPane(view);
        } catch (IOException iOException) {
            /// implementar mensagem de erro
        } catch (InterruptedException interruptedException) {
        }
    }
    
    
}
