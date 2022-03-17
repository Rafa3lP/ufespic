/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.state.manterusuariopresenter;

import br.ufes.ufespic.command.manterusuario.SalvarUsuarioCommand;
import br.ufes.ufespic.presenter.Application;
import br.ufes.ufespic.presenter.LoginPresenter;
import br.ufes.ufespic.presenter.ManterUsuarioPresenter;

/**
 *
 * @author Rafael
 */
public class InclusaoUsuarioState extends ManterUsuarioPresenterState {
    
    public InclusaoUsuarioState(ManterUsuarioPresenter presenter) {
        super(presenter);
        this.view.setTitle("Criar Usuário");
        this.view.getLblDataCadastro().setVisible(false);
        this.view.getTxtDataCadastro().setVisible(false);
        this.view.getBtnExcluir().setVisible(false);
        this.view.getBtnEditar().setVisible(false);
        this.view.getBtnCancelar().setVisible(false);
        this.view.getChkAdm().setVisible(false);
    }
    
    @Override
    public void salvar() {
        new SalvarUsuarioCommand(presenter).executar();
        if(Application.getSession().isAutenticado()) {
            limpaCampos();
        } else {
            fechar();
            // solicitar autenticacao
            new LoginPresenter(presenter.getMainPresenter());
        }
        
    }
    
}
