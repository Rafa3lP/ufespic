/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.presenter;

import br.ufes.ufespic.command.escolherImagem.ObterImagensCommandTemplate;
import br.ufes.ufespic.state.escolherimagempresenter.EscolherImagemState;
import br.ufes.ufespic.state.escolherimagempresenter.ObtendoImagensState;
import br.ufes.ufespic.state.escolherimagempresenter.ProntoParaEscolherState;
import br.ufes.ufespic.view.EscolherImagemView;

/**
 *
 * @author Rafael
 */
public class EscolherImagemPresenter {
    private EscolherImagemView view;
    private MainPresenter mainPresenter;
    
    private EscolherImagemState state;
    
    public EscolherImagemPresenter(MainPresenter mainPresenter) {
        
        view = new EscolherImagemView();
        this.mainPresenter = mainPresenter;
        this.view.getBtnFechar().addActionListener((e) -> {
            state.fechar();
        });
        
        obterImagens();
        
        view.setVisible(true);
        mainPresenter.addToDesktopPane(view);
        
    }
    
    public EscolherImagemView getView() {
        return this.view;
    }

    public void setState(EscolherImagemState state) {
        this.state = state;
    }
    
    private void obterImagens() {
        EscolherImagemPresenter presenter = this;
        new ObterImagensCommandTemplate(this){
            @Override
            public void onStart() {
                setState(new ObtendoImagensState(presenter));
            }

            @Override
            public void onError(Exception ex) {
                throw new RuntimeException(ex.getMessage(), ex.getCause());
            }

            @Override
            public void onSuccess() {
                setState(new ProntoParaEscolherState(presenter));
                view.repaint();
            }
        }.executar();
    }

    public EscolherImagemState getState() {
        return state;
    }

    public MainPresenter getMainPresenter() {
        return mainPresenter;
    }
    
}
