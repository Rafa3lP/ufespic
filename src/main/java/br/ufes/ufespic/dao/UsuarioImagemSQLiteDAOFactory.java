/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.dao;

/**
 *
 * @author Heflain
 */
public class UsuarioImagemSQLiteDAOFactory implements IUsuarioImagemDAOFactory {

    @Override
    public IUsuarioImagemDAO cria(String bd) {
        switch (bd) {
            case "sqlite":
                return new UsuarioImagemSQLiteDAO();
            default:
                throw new RuntimeException("Tipo de DAO não suportado");
        }
    }

}
