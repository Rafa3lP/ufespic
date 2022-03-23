/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.state.visualizarImaem;

import br.ufes.ufespic.command.visualizarimagem.CarregarImagemCommandTemplate;
import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.presenter.VisualizarImagemPresenter;

/**
 *
 * @author Rafael
 */
public class PreparandoImagemState extends VisualizarImagemState {
    
    public PreparandoImagemState(VisualizarImagemPresenter presenter, ImagemProxy imagem) {
        super(presenter, imagem);
        this.view.setTitle("Carregando Imagem");
        this.view.getProgressBar().setString("Carregando");
        this.view.getProgressBar().setVisible(true);
        this.view.getBtnFechar().setEnabled(false);
        this.view.getBtnExcluir().setEnabled(false);
        this.view.getBtnExportar().setEnabled(false);
        this.view.getBtnAplicarFiltros().setEnabled(false);
        
        carregarImagem();
        
    }
    
    private void carregarImagem(){
        new CarregarImagemCommandTemplate(presenter, imagem){
            @Override
            public void onError(Exception ex) {
                throw new RuntimeException(ex.getMessage(), ex.getCause());
            }

            @Override
            public void onSuccess() {
                view.repaint();
                presenter.setState(new ExibindoImagemState(presenter, imagem));
            }
        }.executar();
    }
    
}
