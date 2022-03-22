/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.presenter;

import br.ufes.ufespic.Strategy.AplicarFiltro.FiltroAzul;
import br.ufes.ufespic.Strategy.AplicarFiltro.FiltroBrilho;
import br.ufes.ufespic.Strategy.AplicarFiltro.FiltroEspelhada;
import br.ufes.ufespic.Strategy.AplicarFiltro.FiltroNegativa;
import br.ufes.ufespic.Strategy.AplicarFiltro.FiltroPixelada;
import br.ufes.ufespic.Strategy.AplicarFiltro.FiltroRotaciona;
import br.ufes.ufespic.Strategy.AplicarFiltro.FiltroSepia;
import br.ufes.ufespic.Strategy.AplicarFiltro.FiltroTomDeCinza;
import br.ufes.ufespic.Strategy.AplicarFiltro.FiltroVerde;
import br.ufes.ufespic.Strategy.AplicarFiltro.FiltroVermelho;
import br.ufes.ufespic.Strategy.AplicarFiltro.IFiltro;
import br.ufes.ufespic.decorator.salvarimagem.SalvarImagemFiltroDecorator;
import br.ufes.ufespic.memento.ImagemZelador;
import br.ufes.ufespic.model.ImagemMemento;
import br.ufes.ufespic.view.AplicarFiltroView;
import com.pss.imagem.processamento.decorator.Imagem;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Heflain
 */
public class AplicarFiltroPresenter {

    private ImagemComponente imagem;
    private ImagemComponente imagemOld;
    private AplicarFiltroView view;
    private ImagemZelador zelador;
    private MainPresenter mainPresenter;

    public AplicarFiltroPresenter(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
        this.zelador = ImagemZelador.getInstancia();

        try {
            imagem = new Imagem("imagens/boys-fun.jpg");
            view = new AplicarFiltroView();

            zelador.setOriginal(new ImagemMemento(imagem, view));
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
                    aplicarFiltro(new FiltroVermelho());
                    addImagemZelador();
                }
            });

            view.getChkImagemEspelhada().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkImagemEspelhada().setEnabled(false);

                    aplicarFiltro(new FiltroEspelhada());

                    addImagemZelador();
                }
            });

            view.getChkRotacao().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkRotacao().setEnabled(false);
                    aplicarFiltro(new FiltroRotaciona());
                    addImagemZelador();
                }
            });

            view.getChkNegativo().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.getChkNegativo().setEnabled(false);
                    aplicarFiltro(new FiltroNegativa());
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
                        JOptionPane.showMessageDialog(view, "Esse filtro está passando por alguns problemas tente usa-lo antes dos demais filtro", "Desculpa",  JOptionPane.INFORMATION_MESSAGE);
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

            view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));
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
                imagem = filtro.execute(imagem);
            } else {
                aux = Integer.parseInt(JOptionPane.showInputDialog("entre com " + necessita).trim());
                imagem = filtro.execute(imagem, aux);
            }

            new SalvarImagemFiltroDecorator(imagem, "boys");
            view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));
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
        this.zelador.add(new ImagemMemento(this.imagem, view));
    }

    public void aplicaEstadoMemento(ImagemMemento memento) {
        try {
            imagem = memento.getImagem();

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

            view.getChkPixelar().setSelected(memento.isEstadoPexelar());
            view.getChkPixelar().setEnabled(!memento.isEstadoPexelar());

            view.getChkTonsDeCinza().setSelected(memento.isEstadoTonsDeCinza());
            view.getChkTonsDeCinza().setEnabled(!memento.isEstadoTonsDeCinza());

            view.getChkBrilho().setSelected(memento.isEstadoBrilho());
            view.getChkBrilho().setEnabled(!memento.isEstadoBrilho());

            view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));
            view.repaint();
            view.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
