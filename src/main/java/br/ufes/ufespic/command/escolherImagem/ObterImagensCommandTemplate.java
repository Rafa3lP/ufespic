/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.command.escolherImagem;

import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.presenter.EscolherImagemPresenter;
import br.ufes.ufespic.service.ImagemService;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Rafael
 */
public class ObterImagensCommandTemplate extends EscolherImagemCommandTemplate {
    private ImagemService imagemService;
    public ObterImagensCommandTemplate(EscolherImagemPresenter presenter) {
        super(presenter);
        imagemService = ImagemService.getInstancia();
    }

    @Override
    public void executar() {
        new Thread(){
            @Override
            public void run() {
                try {
                    onStart();
                    for(ImagemProxy imagem: imagemService.getImagensDaPasta()) {
                        JButton cardImagem = new JButton(
                            new ImageIcon(
                                imagem.getMiniatura().getImagem()
                            )
                        );
                        cardImagem.setMargin(new Insets(1, 1, 1, 1));
                        
                        cardImagem.addActionListener((e) -> {
                            presenter.getState().visualizar(imagem);
                            
                        });
                        
                        view.getPainelImagens().add(cardImagem);
                     
                    }
                    onSuccess();
                }catch(IOException | InterruptedException ex) {
                    onError(ex);
                } finally {
                    onFinish();
                }

            }
        }.start();
    }

}
