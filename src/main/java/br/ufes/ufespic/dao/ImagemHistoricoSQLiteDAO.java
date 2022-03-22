/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.dao;

import br.ufes.ufespic.connection.ConnectionSQLiteFactory;
import br.ufes.ufespic.model.ImagemHistorico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heflain
 */
public class ImagemHistoricoSQLiteDAO implements IImagemHistoricoDAO {

    public ImagemHistoricoSQLiteDAO() {
        try {
            criaTImagemHistorico();
        } catch (SQLException ex) {
            Logger.getLogger(ImagemHistoricoSQLiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void criaTImagemHistorico() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS imagemHistorico("
                + " codImagemHistorico INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " codUsuario INTEGER NOT NULL,"
                + " codImagem INTEGER NOT NULL,"
                + " filtro VARCHAR(100) NOT NULL,"
                + " dataHora DATETIME NOT NULL,"
                + " FOREIGN KEY codUsuario REFERENCES usuario(idUsuario),"
                + " FOREIGN KEY codImagem REFERENCES imagem(codImagem)"
                + ");";

        Connection con = ConnectionSQLiteFactory.getConnection();
        Statement st = con.createStatement();
        st.execute(sql);
        st.close();
        ConnectionSQLiteFactory.closeConnection(con);
    }

    @Override
    public void inserir(ImagemHistorico ImagemHistorico) {
        String sql = "INSERT INTO imagemHistorico(codUsuario, codImagem, filtro, dataHora)"
                + " VALUES (?, ?, ?, ?);";
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConnectionSQLiteFactory.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, ImagemHistorico.getCodUsuario());
            pst.setInt(2, ImagemHistorico.getCodImagem());
            pst.setString(3, ImagemHistorico.getFiltro());
            pst.setDate(4, (Date) Date.from(ImagemHistorico.getDataHora().atZone(ZoneId.systemDefault()).toInstant()));
            pst.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, pst);
        }
    }

    @Override
    public ImagemHistorico get(int codImagemHis) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ImagemHistorico imagemHistorico = null;
        try {
            String sql = "SELECT * FROM imagemHistorico"
                    + " WHERE codImagem = ?;";

            con = ConnectionSQLiteFactory.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codImagemHis);
            rs = ps.executeQuery();

            while (rs.next()) {
                imagemHistorico = new ImagemHistorico(
                        rs.getInt("codImagemHistorico"),
                        rs.getInt("codUsuario"),
                        rs.getInt("codImagem"),
                        rs.getString("filtro"),
                        rs.getDate("dataHora").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                );
            }

            return imagemHistorico;

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, ps, rs);
        }
    }

}
