/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.memento;

import br.ufes.ufespic.model.ImagemMemento;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Heflain
 */
public class ImagemZelador {
    private final Deque<ImagemMemento> elementos;
    private ImagemMemento elementoOriginal;
    private static ImagemZelador instancia;

    private ImagemZelador() {
        this.elementos = new ArrayDeque<>();
    }

    public static ImagemZelador getInstancia() {
        if (instancia == null) {
            instancia = new ImagemZelador();
        }
        return instancia;
    }

    public void add(ImagemMemento memento) {
        this.elementos.push(memento);

    }

    public ImagemMemento get() {
        if (!elementos.isEmpty()) {
            return elementos.pop();
        }
        throw new IllegalArgumentException("Não há estados salvos");
    }
    
    public void setOriginal(ImagemMemento memento) {
        this.elementoOriginal = memento;
    }

    public ImagemMemento getOriginal() {
        return this.elementoOriginal;
    }

    public void limparHistorico() {
        this.elementos.clear();
        this.elementoOriginal = null;
        instancia = null;
    }
}
