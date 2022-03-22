/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.state.escolherimagempresenter;

import br.ufes.ufespic.presenter.EscolherImagemPresenter;

/**
 *
 * @author Rafael
 */
public class ObtendoImagensState extends EscolherImagemState {
    
    public ObtendoImagensState(EscolherImagemPresenter presenter) {
        super(presenter);
        this.view.setTitle("Obtendo Imagens");
        this.view.getPainelImagens().setVisible(false);
        this.view.getBtnFechar().setEnabled(false);
        this.view.getProgressBar().setString("Obtendo Imagens...");
        this.view.getProgressBar().setVisible(true);
        
    }
    
}
