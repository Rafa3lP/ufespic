/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.state.escolherimagempresenter;

import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.model.PermissaoImagem;
import br.ufes.ufespic.presenter.Application;
import br.ufes.ufespic.presenter.EscolherImagemPresenter;
import br.ufes.ufespic.presenter.VisualizarImagemPresenter;
import br.ufes.ufespic.service.ImagemService;
import br.ufes.ufespic.service.UsuarioService;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class ProntoParaEscolherState extends EscolherImagemState {
    
    public ProntoParaEscolherState(EscolherImagemPresenter presenter) {
        super(presenter);
        this.view.setTitle("Escolher Imagem");
        this.view.getPainelImagens().setVisible(true);
        this.view.getBtnFechar().setEnabled(true);
        this.view.getProgressBar().setVisible(false);
        
    }
    
    @Override
    public void visualizar(ImagemProxy imagem) {
        PermissaoImagem permissao = UsuarioService.getInstancia().getPermissao(
            Application.getSession().getUsuario(), 
            imagem
        );
        
        if(!permissao.isPermitidoVisualizar()){
            JOptionPane.showMessageDialog(view, "Você não tem permissao para visualizar essa imagem", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
            //implementar notificacao para adm
        }
        
        new VisualizarImagemPresenter(presenter.getMainPresenter(), imagem);
        fechar();
    }
    
}
