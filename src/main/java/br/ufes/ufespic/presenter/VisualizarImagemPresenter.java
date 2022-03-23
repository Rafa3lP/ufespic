/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.presenter;

import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.state.visualizarImaem.PreparandoImagemState;
import br.ufes.ufespic.state.visualizarImaem.VisualizarImagemState;
import br.ufes.ufespic.view.VisualizarImagemView;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class VisualizarImagemPresenter {
    private MainPresenter mainPresenter;
    private VisualizarImagemView view;
    private ImagemProxy imagemProxy;
    private VisualizarImagemState state;

    public VisualizarImagemPresenter(MainPresenter mainPresenter, ImagemProxy imagemProxy) {
        this.view = new VisualizarImagemView();
        this.mainPresenter = mainPresenter;
        this.imagemProxy = imagemProxy;

        this.view.getBtnFechar().addActionListener((e) -> {
            state.fechar();
        });
        this.view.getBtnExcluir().addActionListener((e) -> {
            try{
                state.excluir();
            }catch(RuntimeException ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        this.view.getBtnAplicarFiltros().addActionListener((e) -> {
            try{
                state.aplicarFiltros();
            }catch(RuntimeException ex){
                JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.view.setVisible(true);
        this.mainPresenter.addToDesktopPane(view);

        setState(new PreparandoImagemState(this, imagemProxy));

    }

    public MainPresenter getMainPresenter() {
        return mainPresenter;
    }

    public VisualizarImagemView getView() {
        return view;
    }

    public VisualizarImagemState getState() {
        return state;
    }

    public void setState(VisualizarImagemState state) {
        this.state = state;
    }
    
}
