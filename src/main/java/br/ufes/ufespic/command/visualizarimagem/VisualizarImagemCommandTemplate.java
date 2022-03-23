/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.command.visualizarimagem;

import br.ufes.ufespic.command.ICommand;
import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.presenter.VisualizarImagemPresenter;
import br.ufes.ufespic.view.VisualizarImagemView;

/**
 *
 * @author Rafael
 */

public abstract class VisualizarImagemCommandTemplate implements ICommand {
    protected VisualizarImagemPresenter presenter;
    protected VisualizarImagemView view;
    protected ImagemProxy imagem;
    
    public VisualizarImagemCommandTemplate(VisualizarImagemPresenter presenter, ImagemProxy imagem) {
        this.presenter = presenter;
        this.view = presenter.getView();
        this.imagem = imagem;
    }
    
    public void onError(Exception ex) {
        
    }
    
    public void onSuccess() {
        
    }
    @Override
    public abstract void executar();
}
