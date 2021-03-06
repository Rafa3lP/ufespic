/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.state.manternotificacaopresenter;

import br.ufes.ufespic.command.manternotificacao.EnviarNotificacaoCommand;
import br.ufes.ufespic.model.Usuario;
import br.ufes.ufespic.presenter.Application;
import br.ufes.ufespic.presenter.ManterNotificacaoPresenter;
import br.ufes.ufespic.service.UsuarioService;

/**
 *
 * @author Rafael
 */
public class EnvioNotificacaoPresenterState extends ManterNotificacaoPresenterState {
    private UsuarioService service;
    private Usuario remetente;
    private Usuario destinatario;
    public EnvioNotificacaoPresenterState(ManterNotificacaoPresenter presenter, Usuario destinatario) {
        super(presenter);
        service = UsuarioService.getInstancia();
        this.view.setTitle("Enviar Notificação");
        this.remetente = Application.getSession().getUsuario();
        this.destinatario = destinatario;
        
        if(remetente.getId().longValue() == destinatario.getId().longValue()) {
            throw new RuntimeException(
                "Você não pode enviar uma notificação para você mesmo"
            );
        }
        
        this.view.getTxtRemetente().setText(this.remetente.getNome());
        this.view.getTxtDestinatario().setText(this.destinatario.getNome());
        this.view.getTxtRemetente().setEnabled(false);
        this.view.getTxtDestinatario().setEnabled(false);
        this.view.getBtnEnviar().setVisible(true);
        this.view.getBtnAprovar().setVisible(false);
        this.view.getBtnRecusar().setVisible(false);
        this.view.getBtnExcluir().setVisible(false);
    }
    
    @Override
    public void enviar() {
        new EnviarNotificacaoCommand(
            presenter, 
            remetente, 
            destinatario
        ).executar();
        fechar();
    }
    
}
