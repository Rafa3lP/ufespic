/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufes.ufespic.dao;

import br.ufes.ufespic.model.UsuarioImagem;

/**
 *
 * @author Heflain
 */
public interface IUsuarioImagemDAO {
    public void inserir(UsuarioImagem usuarioImg);
    public void alterar(UsuarioImagem usuarioImg);
    public void excluir(int codUsuarioImg);
    public UsuarioImagem get(int codUsuario, int codImagem);
}
