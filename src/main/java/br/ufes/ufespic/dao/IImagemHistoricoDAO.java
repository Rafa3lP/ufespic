/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufes.ufespic.dao;

import br.ufes.ufespic.model.ImagemHistorico;
import java.util.List;

/**
 *
 * @author Heflain
 */
public interface IImagemHistoricoDAO {
    public void inserir(ImagemHistorico ImagemHistorico);
    public ImagemHistorico get(int codImagemHis);
}
