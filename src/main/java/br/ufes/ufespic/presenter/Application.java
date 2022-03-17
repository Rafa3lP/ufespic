/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.presenter;

import br.ufes.ufespic.logger.adapter.LoggerAdapter;
import br.ufes.ufespic.logger.adapter.LoggerAdapterFactory;
import br.ufes.ufespic.session.Session;
import br.ufes.ufespic.util.PropertyManager;
import com.pss.imagem.processamento.decorator.Imagem;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.PixeladaDecorator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public Application() {
        session = Session.getInstancia();
        propertyManager = new PropertyManager();
        
        getProperties();
        
        logger = new LoggerAdapterFactory().cria(logFormat);
        
        try {
            ImagemComponente imagem = new Imagem("imagens/boys-fun.jpg");
            //imagem = new PixeladaDecorator(imagem, 5);
            imagem.visualizar();
        } catch (InterruptedException | IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        
        //new MainPresenter();
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
