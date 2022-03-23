/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.decorator.salvarimagem;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.ImagemDecorator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Rafael
 */

public class SalvarImagemFiltroDecorator extends ImagemDecorator {

    private String nome;

    public SalvarImagemFiltroDecorator(ImagemComponente elementoDecorado, String nome) throws InterruptedException, IOException {
        super(elementoDecorado);
        this.nome = nome;
        salvarImagem();
    }

    @Override
    public BufferedImage getImagem() throws IOException {
        return salvarImagem();
    }

    private BufferedImage salvarImagem() throws IOException {
        imagem = elementoDecorado.getImagem();

        String caminho = new File("imagens").getAbsolutePath();
        File arquivo = new File(caminho + "\\" + this.nome + ".jpg");

        ImageIO.write(elementoDecorado.getImagem(), "png", arquivo);

        return imagem;

    }

    @Override
    public ImagemComponente reverter() {
        throw new IllegalArgumentException("A imagem foi salva, nao e possivel reverter");
    }

}
