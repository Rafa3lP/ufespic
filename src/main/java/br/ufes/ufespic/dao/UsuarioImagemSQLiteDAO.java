/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.dao;

import br.ufes.ufespic.connection.ConnectionSQLiteFactory;
import br.ufes.ufespic.model.UsuarioImagem;
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
public class UsuarioImagemSQLiteDAO implements IUsuarioImagemDAO {

    public UsuarioImagemSQLiteDAO() {
        try {
            criaTUsuarioImagem();
        } catch (SQLException ex) {
            Logger.getLogger(ImagemSQLiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void criaTUsuarioImagem() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS usuarioImagem("
                + " codUsuarioImagem INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " codImagem INTEGER NOT NULL,"
                + " codUsuario INTEGER NOT NULL,"
                + " visualizar  BOOLEAN DEFAULT FALSE NOT NULL,"
                + " aplicarFiltro BOOLEAN DEFAULT FALSE NOT NULL,"
                + " salvar BOOLEAN DEFAULT FALSE NOT NULL,"
                + " excluir BOOLEAN DEFAULT FALSE NOT NULL,"
                + " exporta BOOLEAN DEFAULT FALSE NOT NULL,"
                + " FOREIGN KEY codImagem REFERENCES imagem(codImagem),"
                + " FOREIGN KEY codUsuario REFERENCES usuario(idUsuario)"
                + ");";

        Connection con = ConnectionSQLiteFactory.getConnection();
        Statement st = con.createStatement();
        st.execute(sql);
        st.close();
        ConnectionSQLiteFactory.closeConnection(con);
    }

    @Override
    public void inserir(UsuarioImagem usuarioImg) {
        String sql = "INSERT INTO usuarioImagem(codImagem, codUsuario, visualizar, aplicarFiltro, salvar, excluir, exporta)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?);";
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConnectionSQLiteFactory.getConnection();
            pst = con.prepareStatement(sql);

            pst.setInt(1, usuarioImg.getCodImagem());
            pst.setInt(2, usuarioImg.getCodUsuario());
            pst.setBoolean(3, usuarioImg.isVisualizar());
            pst.setBoolean(4, usuarioImg.isAplicarFiltro());
            pst.setBoolean(5, usuarioImg.isSalvar());
            pst.setBoolean(6, usuarioImg.isExcluir());
            pst.setBoolean(7, usuarioImg.isExporta());

            pst.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, pst);
        }
    }

    @Override
    public void alterar(UsuarioImagem usuarioImg) {
        String sql = "UPDATE usuarioImagem"
                + " SET visualizar = ?, aplicarFiltro = ?, salvar = ?, excluir = ?, exporta = ?"
                + " WHERE codImagem = ? AND codUsuario = ?;";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionSQLiteFactory.getConnection();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, usuarioImg.isVisualizar());
            ps.setBoolean(2, usuarioImg.isAplicarFiltro());
            ps.setBoolean(3, usuarioImg.isSalvar());
            ps.setBoolean(4, usuarioImg.isExcluir());
            ps.setBoolean(5, usuarioImg.isExporta());

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, ps);
        }
    }

    @Override
    public void excluir(int codUsuarioImg) {
        String sql = "DELETE FROM usuarioImagem WHERE codUsuarioImagem = ?;";
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = ConnectionSQLiteFactory.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, codUsuarioImg);
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, pst);
        }
    }

    @Override
    public UsuarioImagem get(int codUsuario, int codImagem) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UsuarioImagem usuarioImagem = null;
        try {
            String sql = "SELECT * FROM usuarioImagem WHERE codUsuario = ? AND codImagem = ?;";

            con = ConnectionSQLiteFactory.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, codUsuario);
            ps.setLong(2, codImagem);
            rs = ps.executeQuery();

            while (rs.next()) {
                usuarioImagem = new UsuarioImagem(
                        rs.getInt("codUsuarioImagem"),
                        rs.getInt("codUsuario"),
                        rs.getInt("codImagem"),
                        rs.getBoolean("visualizar"),
                        rs.getBoolean("aplicarFiltro"),
                        rs.getBoolean("salvar"),
                        rs.getBoolean("excluir"),
                        rs.getBoolean("exporta")
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
