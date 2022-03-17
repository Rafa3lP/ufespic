/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.command.manternotificacao;

import br.ufes.ufespic.command.ICommand;
import br.ufes.ufespic.model.Notificacao;
import br.ufes.ufespic.presenter.ManterNotificacaoPresenter;
import br.ufes.ufespic.service.UsuarioService;
import br.ufes.ufespic.view.ManterNotificacaoView;

/**
 *
 * @author Rafael
 */
public abstract class NotificacaoPresenterCommand implements ICommand {
    protected ManterNotificacaoPresenter presenter;
    protected ManterNotificacaoView view;
    protected UsuarioService usuarioService = UsuarioService.getInstancia();

    public NotificacaoPresenterCommand(ManterNotificacaoPresenter presenter) {
        this.presenter = presenter;
        this.view = presenter.getView();
    }
    
    @Override
    public abstract void executar();
    
    protected final void validarNotificacao(Notificacao notificacao) {
        if(notificacao.getTitulo().trim().isEmpty()) {
            throw new RuntimeException("A Notificação deve conter um título");
        }
        if(notificacao.getMensagem().trim().isEmpty()) {
            throw new RuntimeException("A Notificação deve conter uma mensagem");
        }
        if(notificacao.getTitulo().length() > 100) {
            throw new RuntimeException("O Título não deve ultrapassar 100 caracteres");
        }
        if(notificacao.getMensagem().length() > 250) {
            throw new RuntimeException("A mensagem não deve ultrapassar 250 caracteres");
        }
    }
    
}
