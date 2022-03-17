/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.command.manterusuario;

import br.ufes.ufespic.command.ICommand;
import br.ufes.ufespic.model.Usuario;
import br.ufes.ufespic.presenter.ManterUsuarioPresenter;
import br.ufes.ufespic.service.UsuarioService;
import br.ufes.ufespic.view.ManterUsuarioView;
import com.pss.senha.validacao.ValidadorSenha;
import java.util.List;

/**
 *
 * @author Rafael
 */
public abstract class ManterUsuarioCommand implements ICommand {
    protected UsuarioService service = UsuarioService.getInstancia();
    protected ManterUsuarioPresenter presenter;
    protected ManterUsuarioView view;
    
    public ManterUsuarioCommand(ManterUsuarioPresenter presenter) {
        this.presenter = presenter;
        this.view = presenter.getView();
    }
    
    @Override
    public abstract void executar();
    
    public final void validar(Usuario usuario, boolean validarSenha) {
        if(usuario.getNome().trim().isEmpty()) {
            throw new RuntimeException("O usuário deve ter um nome!");
        }
        
        if(usuario.getNome().length() > 60 || usuario.getNome().length() < 3) {
            throw new RuntimeException("O nome deve ter entre 3 e 60 caracteres!");
        }
        
        if(usuario.getUsuario().length() > 45 || usuario.getUsuario().length() < 3) {
            throw new RuntimeException("O nome de usuario deve ter entre 3 e 45 caracteres!");
        }
        
        if(validarSenha) {
            //validar senha
            List<String> errosSenha = new ValidadorSenha().validar(usuario.getSenha());
            if(!errosSenha.isEmpty()) {
                throw new RuntimeException(errosSenha.get(0));
            }
        }
        
    }
}
