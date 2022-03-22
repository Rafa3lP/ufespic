/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.presenter;

import br.ufes.ufespic.view.EscolherImagemView;
import com.pss.imagem.processamento.decorator.Imagem;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Rafael
 */
public class EscolherImagemPresenter {
    private EscolherImagemView view;
    private MainPresenter mainPresenter;
    public EscolherImagemPresenter(MainPresenter mainPresenter) {
        try {
            view = new EscolherImagemView();
            this.mainPresenter = mainPresenter;
            
            Imagem imagem = new Imagem("imagens/thumb/boys-fun-thumb.jpg");
            
            this.view.getPainelImagens().add(new JButton(new ImageIcon(imagem.getImagem())));
            
            Imagem imagem2 = new Imagem("imagens/thumb/children-outdoors-thumb.jpg");
          
            this.view.getPainelImagens().add(new JButton(new ImageIcon(imagem2.getImagem())));
            
            this.view.getPainelImagens().add(new JButton(new ImageIcon(imagem.getImagem())));
            this.view.getPainelImagens().add(new JButton(new ImageIcon(imagem2.getImagem())));
            this.view.getPainelImagens().add(new JButton(new ImageIcon(imagem.getImagem())));
            this.view.getPainelImagens().add(new JButton(new ImageIcon(imagem2.getImagem())));
            
            view.setVisible(true);
            mainPresenter.addToDesktopPane(view);
        } catch (IOException ex) {
            Logger.getLogger(EscolherImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(EscolherImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
