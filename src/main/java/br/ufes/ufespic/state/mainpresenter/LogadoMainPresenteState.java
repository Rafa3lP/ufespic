/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.state.mainpresenter;

import br.ufes.ufespic.model.Usuario;
import br.ufes.ufespic.presenter.Application;
import br.ufes.ufespic.presenter.BuscarNotificacaoPresenter;
import br.ufes.ufespic.presenter.BuscarUsuarioPresenter;
import br.ufes.ufespic.presenter.ConfiguracoesPresenter;
import br.ufes.ufespic.presenter.EscolherImagemPresenter;
import br.ufes.ufespic.presenter.MainPresenter;
import br.ufes.ufespic.presenter.ManterUsuarioPresenter;

/**
 *
 * @author Rafael
 */
public class LogadoMainPresenteState extends MainPresenterState {
    private Usuario usuarioAutenticado;
    public LogadoMainPresenteState(MainPresenter presenter) {
        super(presenter);
        usuarioAutenticado = Application.getSession().getUsuario();
        this.view.getLblNomeUsuario().setText(usuarioAutenticado.getNome());
        String tipo;
        if(usuarioAutenticado.isAdmin()) {
            this.view.getBtnUsuarios().setVisible(true);
            tipo = "Administrador";
        } else {
            tipo = "Usuario";
        }
        
        this.view.getLblNomeTipoUsuario().setText(tipo);
        this.view.getBtnNotificacoes().setVisible(true);
        this.view.getBtnOpcoes().setVisible(true);
        this.view.getLblNomeTipoUsuario().setVisible(true);
        this.view.getLblNomeUsuario().setVisible(true);
        this.view.getBtnImagens().setVisible(true);
   
        setNumNotificacoes();
    }
    
    @Override
    public void cadastrar() {
        new ManterUsuarioPresenter(presenter, null);
    }
    
    @Override
    public void buscarUsuarios() {
        new BuscarUsuarioPresenter(presenter);
    }
    
    @Override
    public void buscarNotificacoes() {
        new BuscarNotificacaoPresenter(presenter);
    }
    
    @Override
    public void configurar() {
        new ConfiguracoesPresenter(presenter);
    }
    
    @Override
    public void meuUsuario() {
        new ManterUsuarioPresenter(presenter, usuarioAutenticado);
    }
    
    @Override
    public void escolherImagem() {
        new EscolherImagemPresenter(presenter);
    }
    
    @Override
    public void setNumNotificacoes() {
        this.usuarioAutenticado = Application.getSession().getUsuario();
        this.view.getBtnNotificacoes().setText(
            Integer.toString(
               this.usuarioAutenticado.getNotificacoes().size()
            )
        );
    }
    
}
