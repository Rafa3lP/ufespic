/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.presenter;

import br.ufes.ufespic.logger.adapter.LoggerAdapter;
import br.ufes.ufespic.logger.adapter.LoggerAdapterFactory;
import br.ufes.ufespic.session.Session;
import br.ufes.ufespic.util.PropertyManager;
import br.ufes.ufespic.view.AplicarFiltroView;
import com.pss.imagem.processamento.decorator.AzulDecorator;
import com.pss.imagem.processamento.decorator.Imagem;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.PixeladaDecorator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rafael
 */
public class Application {
    private static Session session;
    private static LoggerAdapter logger;
    private static String logFormat;
    private static PropertyManager propertyManager;
    
    private static ImagemComponente imagem;
    private static ImagemComponente imagemOld;
    private static AplicarFiltroView view;
    
    public Application() {
        session = Session.getInstancia();
        propertyManager = new PropertyManager();
        
        getProperties();
        
        logger = new LoggerAdapterFactory().cria(logFormat);
        
        try {
            imagem = new Imagem("imagens/boys-fun.jpg");
            view = new AplicarFiltroView();
            view.getBtnFechar().addActionListener((e) -> {
                view.dispose();
            });
            view.getChkImagemAzul().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(view.getChkImagemAzul().isSelected()) {
                        change();
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
        
        
        //new MainPresenter();
    }
    
    public static void change() {
        try {
            imagemOld = imagem;
            imagem = new AzulDecorator(imagem);
            view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));
            view.repaint();
            view.setVisible(true);

        } catch (InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void restore() {
        try {
            imagem = imagemOld;
            view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));
            view.repaint();
            view.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getLogFormat() {
        return logFormat;
    }
    
    public static void setLogFormat(String logFormat) {
        Application.logFormat = logFormat;
    }
    
    private static void getProperties() {
        setLogFormat(propertyManager.getProperty("logFormat"));
    }
    
    public static void changeLogFormat(String logFormat) {
        LoggerAdapter loggerOld = Application.logger;
        Application.logger = new LoggerAdapterFactory().cria(logFormat);
        Application.logger.migraLogger(loggerOld);
        propertyManager.setProp("logFormat", logFormat);
        Application.logFormat = logFormat;
        
    }
    
    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        try {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                new Application();
            }
        });
    }

    public static Session getSession() {
        return session;
    }

    public static LoggerAdapter getLogger() {
        return logger;
    }

    public static void setLogger(LoggerAdapter logger) {
        Application.logger = logger;
    }
}
