/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.presenter;

import br.ufes.ufespic.command.Strategy.AplicarFiltro.FiltroAzul;
import br.ufes.ufespic.command.Strategy.AplicarFiltro.IFiltro;
import br.ufes.ufespic.memento.ImagemZelador;
import br.ufes.ufespic.model.ImagemMemento;
import br.ufes.ufespic.view.AplicarFiltroView;
import com.pss.imagem.processamento.decorator.AzulDecorator;
import com.pss.imagem.processamento.decorator.BrilhoDecorator;
import com.pss.imagem.processamento.decorator.EspelhadaDecorator;
import com.pss.imagem.processamento.decorator.Imagem;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Heflain
 */
public class AplicarFiltroPresenter {

    private ImagemComponente imagem;
    private ImagemComponente imagemOld;
    private AplicarFiltroView view;
    private ImagemZelador zelador;

    public AplicarFiltroPresenter() {
        this.zelador = ImagemZelador.getInstancia();
        try {
            imagem = new Imagem("imagens/boys-fun.jpg");
            view = new AplicarFiltroView();
            view.getBtnFechar().addActionListener((e) -> {
                view.dispose();
            });
            view.getChkImagemAzul().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (view.getChkImagemAzul().isSelected()) {
                        aplicarFiltro(new FiltroAzul());
                    } else {
                        restore();
                    }
                }
            });
            view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));
            new MainPresenter().addToDesktopPane(view);
            view.setVisible(true);
            //imagem = new PixeladaDecorator(imagem, 5);
            //imagem.visualizar();
        } catch (InterruptedException | IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void aplicarFiltro(IFiltro filtro) {
        int aux = 0;
        
        //implementa o JOPION para pedir o argumento necessário para filtro
        
        try {
            //imagem = imagem.reverter();
            this.addImagemZelador();
            imagem = filtro.execute(imagem, 0);
            view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));
            view.repaint();
            view.setVisible(true);

        } catch (InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addImagemZelador(){
        this.zelador.add(new ImagemMemento(this.imagem));
    }

    public void restore() {
        try {
            imagem = this.zelador.get().getImagem();
            view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));
            view.repaint();
            view.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
