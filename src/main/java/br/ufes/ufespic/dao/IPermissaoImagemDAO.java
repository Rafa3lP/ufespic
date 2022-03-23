/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufes.ufespic.dao;

import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.model.PermissaoImagem;
import br.ufes.ufespic.model.Usuario;

/**
 *
 * @author Heflain
 */
public interface IPermissaoImagemDAO {
    public void inserir(Usuario usuario, ImagemProxy imagem, PermissaoImagem permissao);
    public void alterar(Usuario usuario, ImagemProxy imagem, PermissaoImagem permissao);
    public void excluir(Usuario usuario, ImagemProxy imagem);
    public PermissaoImagem consultarPermissao(Usuario usuario, ImagemProxy imagem);
}
