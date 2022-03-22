/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufes.ufespic.dao;

import br.ufes.ufespic.model.ImagemProxy;
import java.util.List;

/**
 *
 * @author Heflain
 */
public interface IImagemDAO {
    public void inserir(ImagemProxy imagem);
    public void excluir(int codImagem);
    public List<ImagemProxy> getImagens();
    public List<ImagemProxy> getImagens(List<Integer> idImagens);
}
