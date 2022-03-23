/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.decorator.exportaImagem;

import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.ImagemDecorator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Heflain
 */
public class ExportaImagemFiltroDecorator extends ImagemDecorator{
    private String nome;
    private File caminho;

    public ExportaImagemFiltroDecorator(ImagemComponente elementoDecorado, String nome, File caminho) throws InterruptedException, IOException {
        super(elementoDecorado);
        this.nome = nome;
        this.caminho = caminho;
        salvarImagem();
    }

    @Override
    public BufferedImage getImagem() throws IOException {
        return salvarImagem();
    }

    private BufferedImage salvarImagem() throws IOException {
        imagem = elementoDecorado.getImagem();
        File arquivo = new File(caminho.getAbsolutePath() + "\\" + this.nome + ".jpg");

        ImageIO.write(elementoDecorado.getImagem(), "png", arquivo);

        return imagem;

    }

    @Override
    public ImagemComponente reverter() {
        throw new IllegalArgumentException("A imagem foi exportada, nao e possivel reverter");
    }
}
