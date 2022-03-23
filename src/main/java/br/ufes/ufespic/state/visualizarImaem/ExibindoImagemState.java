/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.state.visualizarImaem;

import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.model.PermissaoImagem;
import br.ufes.ufespic.presenter.AplicarFiltroPresenter;
import br.ufes.ufespic.presenter.Application;
import br.ufes.ufespic.presenter.VisualizarImagemPresenter;

/**
 *
 * @author Rafael
 */
public class ExibindoImagemState extends VisualizarImagemState {
    
    public ExibindoImagemState(VisualizarImagemPresenter presenter, ImagemProxy imagem) {
        super(presenter, imagem);
        this.view.setTitle("Visualizando Imagem");
        
        PermissaoImagem permissao = usuarioService.getPermissao(
            Application.getSession().getUsuario(), 
            imagem
        );
        this.view.getProgressBar().setVisible(false);
        this.view.getBtnFechar().setEnabled(true);
        this.view.getBtnExcluir().setEnabled(permissao.isPermitidoExcluir());
        this.view.getBtnAplicarFiltros().setEnabled(permissao.isPermitidoAplicarFiltro());
        this.view.getBtnExportar().setEnabled(permissao.isPermitidoExportar());
        
    }
    
    @Override
    public void aplicarFiltros() {
        new AplicarFiltroPresenter(presenter.getMainPresenter(), imagem);
        fechar();
    }
    
    @Override
    public void excluir() {
        throw new RuntimeException("Método excluir não pode ser executado");
    }
    
}
