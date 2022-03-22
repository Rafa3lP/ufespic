/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufes.ufespic.dao;

import br.ufes.ufespic.model.SolicitacaoImagem;
import java.util.List;

/**
 *
 * @author Heflain
 */
public interface ISolicitacaoImagemDAO {
    public void inserir(SolicitacaoImagem solicitacaoImagem);
    public List<SolicitacaoImagem> get();
    public void excluir(int codSolicitacaoImagem);
}
