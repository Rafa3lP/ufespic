/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.command.configuracoes;

import br.ufes.ufespic.command.ICommand;
import br.ufes.ufespic.presenter.ConfiguracoesPresenter;
import br.ufes.ufespic.view.ConfiguracoesView;

/**
 *
 * @author Rafael
 */

/*
    criei um command com template de teste para que 
    o state possa injetar operações durante o processo de execução
*/
public abstract class ConfiguracoesCommandTemplate implements ICommand {
    protected ConfiguracoesPresenter presenter;
    protected ConfiguracoesView view;
    
    public ConfiguracoesCommandTemplate(ConfiguracoesPresenter presenter) {
        this.presenter = presenter;
        this.view = presenter.getView();
    }
    
    public void onStart() {
        
    }
    public void onFinish() {
        
    }
    
    public void onError(Exception ex) {
        
    }
    
    public void onSuccess() {
        
    }
    @Override
    public abstract void executar();
}
