/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.command.manternotificacao;

import br.ufes.ufespic.model.Notificacao;
import br.ufes.ufespic.presenter.ManterNotificacaoPresenter;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class RecusarNotificacaoCommand extends NotificacaoPresenterCommand {
    private Notificacao notificacao;
    public RecusarNotificacaoCommand(ManterNotificacaoPresenter presenter, Notificacao notificacao) {
        super(presenter);
        this.notificacao = notificacao;
    }

    @Override
    public void executar() {
        usuarioService.deletar(usuarioService.lerPorId(notificacao.getIdRemetente()));
        usuarioService.deletarNotificacao(notificacao);
        JOptionPane.showMessageDialog(
            view, 
            "Solicitação recusada!", 
            "Sucesso", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
}
