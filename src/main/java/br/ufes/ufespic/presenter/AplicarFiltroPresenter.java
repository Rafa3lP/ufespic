/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.presenter;

import br.ufes.ufespic.decorator.AplicarFiltro.FiltroAzul;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroBrilho;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroDois;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroEspelhada;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroNegativa;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroPixelada;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroRotaciona;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroSepia;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroTomDeCinza;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroRosa;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroAzulGranulado;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroVerde;
import br.ufes.ufespic.decorator.AplicarFiltro.FiltroVermelho;
import br.ufes.ufespic.decorator.AplicarFiltro.IFiltro;
import br.ufes.ufespic.decorator.salvarimagem.SalvarImagemFiltroDecorator;
import br.ufes.ufespic.memento.ImagemZelador;
import br.ufes.ufespic.model.ImagemMemento;
import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.view.AplicarFiltroView;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Heflain
 */
public class AplicarFiltroPresenter {

    private ImagemComponente imagemComponente;
    private ImagemComponente imagemOld;
    private AplicarFiltroView view;
    private ImagemZelador zelador;
    private MainPresenter mainPresenter;
    private ImagemProxy imagemProxy;

    public AplicarFiltroPresenter(MainPresenter mainPresenter, ImagemProxy imagemProxy) {
        this.mainPresenter = mainPresenter;
        this.imagemProxy = imagemProxy;
        this.zelador = ImagemZelador.getInstancia();

        try {
            imagemComponente = imagemProxy.getImagem();
            view = new AplicarFiltroView();

            zelador.setOriginal(new ImagemMemento(imagemComponente, view));
            this.addImagemZelador();

            view.getBtnFechar().addActionListener((e) -> {
                view.dispose();
            });

            view.getChkImagemAzul().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkImagemAzul().setEnabled(false);
                    aplicarFiltro(new FiltroAzul());
                    
                    addImagemZelador();
                }
            });

            view.getChkImagemVerde().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkImagemVerde().setEnabled(false);
                    aplicarFiltro(new FiltroVerde());
                    addImagemZelador();
                }
            });

            view.getChkImagemVermelha().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkImagemVermelha().setEnabled(false);
                    
                    addImagemZelador();
                }
            });

            view.getChkImagemEspelhada().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkImagemEspelhada().setEnabled(false);
                    aplicarFiltro(new FiltroAzulGranulado());
                    addImagemZelador();
                }
            });

            view.getChkRotacao().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkRotacao().setEnabled(false);
                    aplicarFiltro(new FiltroDois());
                    addImagemZelador();
                }
            });

            view.getChkNegativo().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkNegativo().setEnabled(false);
                    //aplicarFiltro(new FiltroNegativa());
                    aplicarFiltro(new FiltroRosa());
                    addImagemZelador();
                }
            });

            view.getChkCorSepia().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkCorSepia().setEnabled(false);
                    aplicarFiltro(new FiltroSepia());
                    addImagemZelador();
                }
            });

            view.getChkPixelar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkPixelar().setEnabled(false);
                    try {
                        aplicarFiltro(new FiltroPixelada());
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(view, "Esse filtro est?? passando por alguns problemas tente usa-lo antes dos demais filtro", "Desculpa",  JOptionPane.INFORMATION_MESSAGE);
                        view.getChkPixelar().setEnabled(true);
                        view.getChkPixelar().setSelected(false);
                        return;
                    }
                    addImagemZelador();
                }
            });

            view.getChkTonsDeCinza().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkTonsDeCinza().setEnabled(false);
                    aplicarFiltro(new FiltroTomDeCinza());
                    addImagemZelador();
                }
            });

            view.getChkBrilho().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkBrilho().setEnabled(false);
                    aplicarFiltro(new FiltroBrilho());
                    addImagemZelador();
                }
            });

            this.view.getBtnDesfazer().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    restore();
                }

            });

            this.view.getBtnRestaurarPadrao().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    restorePadrao();
                }

            });

            view.getLblImagem().setIcon(new ImageIcon(imagemComponente.getImagem()));
            mainPresenter.addToDesktopPane(view);
            view.setVisible(true);

        } catch (InterruptedException | IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void aplicarFiltro(IFiltro filtro) {
        int aux = -1;
        String necessita = filtro.necessita();

        try {
            //imagem = imagem.reverter();

            if (necessita == "") {
                imagemComponente = filtro.execute(imagemComponente);
            } else {
                aux = Integer.parseInt(JOptionPane.showInputDialog("entre com " + necessita).trim());
                imagemComponente = filtro.execute(imagemComponente, aux);
            }

            new SalvarImagemFiltroDecorator(imagemComponente, "boys");
            view.getLblImagem().setIcon(new ImageIcon(imagemComponente.getImagem()));
            view.repaint();
            view.setVisible(true);

        } catch (InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void restore() {
        this.aplicaEstadoMemento(this.zelador.get());
    }

    public void restorePadrao() {
        this.aplicaEstadoMemento(this.zelador.getOriginal());
    }

    public void addImagemZelador() {
        this.zelador.add(new ImagemMemento(this.imagemComponente, view));
    }

    public void aplicaEstadoMemento(ImagemMemento memento) {
        try {
            imagemComponente = memento.getImagem();

            view.getChkImagemAzul().setSelected(memento.isEstadoAzul());
            view.getChkImagemAzul().setEnabled(!memento.isEstadoAzul());

            view.getChkImagemVerde().setSelected(memento.isEstadoVerde());
            view.getChkImagemVerde().setEnabled(!memento.isEstadoVerde());

            view.getChkImagemVermelha().setSelected(memento.isEstadoVermelho());
            view.getChkImagemVermelha().setEnabled(!memento.isEstadoVermelho());

            view.getChkImagemEspelhada().setSelected(memento.isEstadoEspelhada());
            view.getChkImagemEspelhada().setEnabled(!memento.isEstadoEspelhada());

            view.getChkRotacao().setSelected(memento.isEstadoRotacao());
            view.getChkRotacao().setEnabled(!memento.isEstadoRotacao());

            view.getChkNegativo().setSelected(memento.isEstadoNegativo());
            view.getChkNegativo().setEnabled(!memento.isEstadoNegativo());

            view.getChkCorSepia().setSelected(memento.isEstadoSerpia());
            view.getChkCorSepia().setEnabled(!memento.isEstadoSerpia());

            view.getChkPixelar().setSelected(memento.isEstadoPixelar());
            view.getChkPixelar().setEnabled(!memento.isEstadoPixelar());

            view.getChkTonsDeCinza().setSelected(memento.isEstadoTonsDeCinza());
            view.getChkTonsDeCinza().setEnabled(!memento.isEstadoTonsDeCinza());

            view.getChkBrilho().setSelected(memento.isEstadoBrilho());
            view.getChkBrilho().setEnabled(!memento.isEstadoBrilho());

            view.getLblImagem().setIcon(new ImageIcon(imagemComponente.getImagem()));
            view.repaint();
            view.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
