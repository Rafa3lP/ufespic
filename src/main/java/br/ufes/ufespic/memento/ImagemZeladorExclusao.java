/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.memento;

import br.ufes.ufespic.model.ImagemMemento;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Heflain
 */
public class ImagemZeladorExclusao {
    private final Deque<ImagemMemento> elementos;
    private static ImagemZeladorExclusao instancia;

    private ImagemZeladorExclusao() {
        this.elementos = new ArrayDeque<>();
    }

    public static ImagemZeladorExclusao getInstancia() {
        if (instancia == null) {
            instancia = new ImagemZeladorExclusao();
        }
        return instancia;
    }

    public void add(ImagemMemento memento) {
        if (memento != null) {
            this.elementos.push(memento);
        }
    }

    public ImagemMemento get() {
        return elementos.pop();
    }

    public void limparHistorico() {
        this.elementos.clear();
        instancia = null;
    }
}
