/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufes.ufespic.dao;

import br.ufes.ufespic.model.Imagem;
import java.util.List;

/**
 *
 * @author Heflain
 */
public interface IImagemDAO {
    public void inserir(Imagem imagem);
    public void excluir(int codImagem);
    public List<Imagem> getImagens();
    public List<Imagem> getImagens(List<Integer> idImagens);
}
