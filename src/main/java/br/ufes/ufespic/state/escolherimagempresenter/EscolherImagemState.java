/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.state.escolherimagempresenter;

import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.presenter.EscolherImagemPresenter;
import br.ufes.ufespic.view.EscolherImagemView;

/**
 *
 * @author Rafael
 */
public abstract class EscolherImagemState {
    protected EscolherImagemPresenter presenter;
    protected EscolherImagemView view;
    
    public EscolherImagemState(EscolherImagemPresenter presenter) {
        this.presenter = presenter;
        this.view = this.presenter.getView();
    }
    
    public void visualizar(ImagemProxy imagem) {
        throw new RuntimeException("Método cadastrar não pode ser executado");
    }
  
    public void fechar() {
        this.view.dispose();
    }
}
