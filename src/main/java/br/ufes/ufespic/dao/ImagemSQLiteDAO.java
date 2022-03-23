/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.dao;

import br.ufes.ufespic.connection.ConnectionSQLiteFactory;
import br.ufes.ufespic.model.ImagemProxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heflain
 */
public class ImagemSQLiteDAO implements IImagemDAO {

    public ImagemSQLiteDAO() {
        try {
            criaTImagem();
        } catch (SQLException ex) {
            Logger.getLogger(ImagemSQLiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void criaTImagem() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS imagem("
                + " codImagem INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " caminhoImagem VARCHAR(100) NOT NULL,"
                + " caminhoMiniatura VARCHAR(100) NOT NULL,"
                + " nomeArquivo VARCHAR(100) NOT NULL"
                + " );";

        Connection con = ConnectionSQLiteFactory.getConnection();
        Statement st = con.createStatement();
        st.execute(sql);
        sql = "INSERT OR IGNORE INTO imagem(codImagem, caminhoImagem, caminhoMiniatura, nomeArquivo) " +
        "VALUES " +
        "(1,\"imagens\\\\boys-fun.jpg\", \"imagens\\\\thumb\\\\boys-fun-thumb.jpg\", \"Boys Fun\")," +
        "(2,\"imagens\\\\children-outdoors.jpg\", \"imagens\\\\thumb\\\\children-outdoors-thumb.jpg\", \"Children Outdoors\")," +
        "(3,\"imagens\\\\cirsium-arvense.jpg\", \"imagens\\\\thumb\\\\cirsium-arvense-thumb.jpg\", \"Cirsium\")," +
        "(4,\"imagens\\\\city-bridge-wroclaw.jpg\", \"imagens\\\\thumb\\\\city-bridge-wroclaw-thumb.jpg\", \"Bridge\")," +
        "(5,\"imagens\\\\dog-man.jpg\", \"imagens\\\\thumb\\\\dog-man-thumb.jpg\", \"Dog\"),\n" +
        "(6,\"imagens\\\\fly-agaric.jpg\", \"imagens\\\\thumb\\\\fly-agaric-thumb.jpg\", \"Fly Agaric\")," +
        "(7,\"imagens\\\\little-cat-play.jpg\", \"imagens\\\\thumb\\\\little-cat-play-thumb.jpg\", \"Cat\")," +
        "(8,\"imagens\\\\naan-bread-lunch.jpg\", \"imagens\\\\thumb\\\\naan-bread-lunch-thumb.jpg\", \"Lunch\")," +
        "(9,\"imagens\\\\panoramic-of-mississippi.jpg\", \"imagens\\\\thumb\\\\panoramic-of-mississippi-thumb.jpg\", \"Mississipi\")," +
        "(10,\"imagens\\\\pink-hydrangea.jpg\", \"imagens\\\\thumb\\\\pink-hydrangea-thumb.jpg\", \"Hydrangea\")," +
        "(11,\"imagens\\\\prison-building-wroclaw.jpg\", \"imagens\\\\thumb\\\\prison-building-wroclaw-thumb.jpg\", \"Prision\");";
        st.execute(sql);
        st.close();
        ConnectionSQLiteFactory.closeConnection(con);
    }

    @Override
    public void inserir(ImagemProxy imagem) {
        String sql = "INSERT INTO imagem(caminhoImagem, caminhoMiniatura, nomeArquivo)"
                + " VALUES (?, ?, ?);";
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConnectionSQLiteFactory.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, imagem.getCaminhoImagem());
            pst.setString(2, imagem.getCaminhoMiniatura());
            pst.setString(3, imagem.getNomeArquivo());
            pst.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, pst);
        }
    }

    @Override
    public void excluir(int codImagem) {
        String sql = "DELETE FROM imagem WHERE codImagem = ?;";
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = ConnectionSQLiteFactory.getConnection();
            pst = con.prepareStatement(sql);
            pst.setLong(1, codImagem);
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, pst);
        }
    }

    @Override
    public List<ImagemProxy> getImagens() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ImagemProxy imagem;
        List<ImagemProxy> resposta = new ArrayList<>();
        try {
            String sql = "SELECT * FROM imagem;";

            con = ConnectionSQLiteFactory.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                imagem = new ImagemProxy(
                        rs.getInt("codImagem"),
                        rs.getString("caminhoImagem"),
                        rs.getString("caminhoMiniatura"),
                        rs.getString("nomeArquivo")
                );

                resposta.add(imagem);
            }

            return resposta;

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, ps, rs);
        }
    }

    @Override
    public List<ImagemProxy> getImagens(List<Integer> idImagens) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ImagemProxy imagem;
        List<ImagemProxy> resposta = new ArrayList<ImagemProxy>();
        try {
            String sql = "SELECT * FROM imagem WHERE codImagem = ?;";

            con = ConnectionSQLiteFactory.getConnection();
            ps = con.prepareStatement(sql);
            for (int x : idImagens) {
                ps.setInt(1, x);
                rs = ps.executeQuery();

                while (rs.next()) {
                    imagem = new ImagemProxy(
                            rs.getInt("codImagem"),
                            rs.getString("caminhoImagem"),
                            rs.getString("caminhoMiniatura"),
                            rs.getString("nomeArquivo")
                    );

                    resposta.add(imagem);
                }
            }

            return resposta;

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, ps, rs);
        }
    }
}
