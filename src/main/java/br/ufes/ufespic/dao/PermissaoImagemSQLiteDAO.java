/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.dao;

import br.ufes.ufespic.connection.ConnectionSQLiteFactory;
import br.ufes.ufespic.model.ImagemProxy;
import br.ufes.ufespic.model.PermissaoImagem;
import br.ufes.ufespic.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heflain
 */
public class PermissaoImagemSQLiteDAO implements IPermissaoImagemDAO {

    public PermissaoImagemSQLiteDAO() {
        try {
            criaTUsuarioImagem();
        } catch (SQLException ex) {
            Logger.getLogger(ImagemSQLiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void criaTUsuarioImagem() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS usuarioImagem("
                + " idUsuario INTEGER NOT NULL,"
                + " idImagem INTEGER NOT NULL,"
                + " visualizar  BOOLEAN DEFAULT FALSE NOT NULL,"
                + " aplicarFiltro BOOLEAN DEFAULT FALSE NOT NULL,"
                + " excluir BOOLEAN DEFAULT FALSE NOT NULL,"
                + " exportar BOOLEAN DEFAULT FALSE NOT NULL,"
                + " PRIMARY KEY (idUsuario, idImagem),"
                + " FOREIGN KEY (idImagem) REFERENCES imagem(codImagem),"
                + " FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)"
                + ");";

        Connection con = ConnectionSQLiteFactory.getConnection();
        Statement st = con.createStatement();
        st.execute(sql);
        st.close();
        ConnectionSQLiteFactory.closeConnection(con);
    }

    @Override
    public void inserir(Usuario usuario, ImagemProxy imagem, PermissaoImagem permissao) {
        String sql = "INSERT INTO usuarioImagem(idUsuario, idImagem, visualizar, aplicarFiltro, excluir, exportar)"
                + " VALUES (?, ?, ?, ?, ?, ?);";
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConnectionSQLiteFactory.getConnection();
            pst = con.prepareStatement(sql);

            pst.setLong(1, usuario.getId());
            pst.setInt(2, imagem.getCodImagem());
            pst.setBoolean(3, permissao.isPermitidoVisualizar());
            pst.setBoolean(4, permissao.isPermitidoAplicarFiltro());
            pst.setBoolean(5, permissao.isPermitidoExcluir());
            pst.setBoolean(6, permissao.isPermitidoExportar());

            pst.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, pst);
        }
    }

    @Override
    public void alterar(Usuario usuario, ImagemProxy imagem, PermissaoImagem permissao) {
        String sql = "UPDATE usuarioImagem"
                + " SET visualizar = ?, aplicarFiltro = ?, excluir = ?, exportar = ?"
                + " WHERE idImagem = ? AND idUsuario = ?;";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionSQLiteFactory.getConnection();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, permissao.isPermitidoVisualizar());
            ps.setBoolean(2, permissao.isPermitidoAplicarFiltro());
            ps.setBoolean(3, permissao.isPermitidoExcluir());
            ps.setBoolean(4, permissao.isPermitidoExportar());

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, ps);
        }
    }

    @Override
    public void excluir(Usuario usuario) {
        String sql = "DELETE FROM usuarioImagem WHERE idUsuario = ?;";
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = ConnectionSQLiteFactory.getConnection();
            pst = con.prepareStatement(sql);
            pst.setLong(1, usuario.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, pst);
        }
    }

    @Override
    public PermissaoImagem consultarPermissao(Usuario usuario, ImagemProxy imagem) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PermissaoImagem usuarioImagem = null;
        try {
            String sql = "SELECT * FROM usuarioImagem WHERE idUsuario = ? AND idImagem = ?;";

            con = ConnectionSQLiteFactory.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, usuario.getId());
            ps.setLong(2, imagem.getCodImagem());
            rs = ps.executeQuery();

            while(rs.next()) {
                usuarioImagem = new PermissaoImagem(
                    rs.getBoolean("visualizar"),
                    rs.getBoolean("aplicarFiltro"),
                    rs.getBoolean("exportar"),
                    rs.getBoolean("excluir")
                );
            }

            return usuarioImagem;

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, ps, rs);
        }
    }
}
