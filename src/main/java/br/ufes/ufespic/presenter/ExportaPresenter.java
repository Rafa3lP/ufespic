/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.presenter;

import br.ufes.ufespic.decorator.exportaImagem.ExportarImagemFiltroDecorator;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Heflain
 */
public class ExportaPresenter {

    private ImagemComponente imagem;

    public ExportaPresenter(ImagemComponente imagem) {
        this.imagem = imagem;
        exporta();
    }
    
    private void exporta(){
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int i = fc.showSaveDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            File diretorio = fc.getCurrentDirectory();
            String nome = JOptionPane.showInputDialog(null, "Nome do arquivo");
            try {
                new ExportarImagemFiltroDecorator(imagem, nome, diretorio);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExportaPresenter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ExportaPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "entrada vazia", "Entrada vazia", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
