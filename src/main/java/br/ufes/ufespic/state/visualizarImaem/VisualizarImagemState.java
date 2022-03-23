/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.state.visualizarImaem;

import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.presenter.VisualizarImagemPresenter;
import br.ufes.ufespic.service.UsuarioService;
import br.ufes.ufespic.view.VisualizarImagemView;

/**
 *
 * @author Rafael
 */
public abstract class VisualizarImagemState {
    protected VisualizarImagemPresenter presenter;
    protected VisualizarImagemView view;
    protected UsuarioService usuarioService;
    protected ImagemProxy imagem;
    
    public VisualizarImagemState(VisualizarImagemPresenter presenter, ImagemProxy imagem) {
        this.presenter = presenter;
        this.view = this.presenter.getView();
        this.imagem = imagem;
        this.usuarioService = UsuarioService.getInstancia();
    }
    
    public void aplicarFiltros() {
        throw new RuntimeException("Método aplicarFiltros não pode ser executado");
    }
    
    public void excluir() {
        throw new RuntimeException("Método excluir não pode ser executado");
    }
  
    public void fechar() {
        this.view.dispose();
    }
}
