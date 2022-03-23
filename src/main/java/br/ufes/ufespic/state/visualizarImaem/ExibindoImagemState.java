/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.state.visualizarImaem;

import br.ufes.ufespic.decorator.exportaImagem.ExportarImagemFiltroDecorator;
import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.model.PermissaoImagem;
import br.ufes.ufespic.presenter.AplicarFiltroPresenter;
import br.ufes.ufespic.presenter.Application;
import br.ufes.ufespic.presenter.VisualizarImagemPresenter;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class ExibindoImagemState extends VisualizarImagemState {
    
    public ExibindoImagemState(VisualizarImagemPresenter presenter, ImagemProxy imagem) {
        super(presenter, imagem);
        this.view.setTitle("Visualizando Imagem");
        
        PermissaoImagem permissao = usuarioService.getPermissao(
            Application.getSession().getUsuario(), 
            imagem
        );
        this.view.getProgressBar().setVisible(false);
        this.view.getBtnFechar().setEnabled(true);
        this.view.getBtnExcluir().setEnabled(permissao.isPermitidoExcluir());
        this.view.getBtnAplicarFiltros().setEnabled(permissao.isPermitidoAplicarFiltro());
        this.view.getBtnExportar().setEnabled(permissao.isPermitidoExportar());
        
    }
    
    @Override
    public void aplicarFiltros() {
        new AplicarFiltroPresenter(presenter.getMainPresenter(), imagem);
        fechar();
    }
    
    @Override
    public void excluir() {
        throw new RuntimeException("Método excluir não pode ser executado");
    }
    
    @Override
    public void exportar() {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new java.io.File("."));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showSaveDialog(view);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File localEscolhido = fc.getSelectedFile();
                new ExportarImagemFiltroDecorator(imagem.getImagem(), imagem.getNomeArquivo(), localEscolhido);
                JOptionPane.showMessageDialog(view, "Imagem Exportada", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException("Erro ao exportar imagem");
            }
        } else {
            throw new RuntimeException("Caminho inválido");
        }
        
        
    }
    
}
