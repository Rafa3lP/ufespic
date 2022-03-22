/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.dao;

import br.ufes.ufespic.connection.ConnectionSQLiteFactory;
import br.ufes.ufespic.model.SolicitacaoImagem;
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
public class SolicitacaoImagemSQLiteDAO implements ISolicitacaoImagemDAO {

    public SolicitacaoImagemSQLiteDAO() {
        try {
            criaTSolicitacaoImagem();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitacaoImagemSQLiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void criaTSolicitacaoImagem() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS solicitacaoImagem("
                + " codSolicitacaoImagem INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " codUsuario INTEGER NOT NULL,"
                + " codImagem INTEGER NOT NULL,"
                + " solicitacao VARCHAR(100) NOT NULL,"
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
    public void inserir(SolicitacaoImagem solicitacaoImagem) {
        String sql = "INSERT INTO solicitacaoImagem(codUsuario, codImagem, solicitacao)"
                + " VALUES (?, ?, ?);";
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConnectionSQLiteFactory.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, solicitacaoImagem.getCodUsuario());
            pst.setInt(2, solicitacaoImagem.getCodImagem());
            pst.setString(3, solicitacaoImagem.getSolicitacao());
            pst.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, pst);
        }
    }

    @Override
    public List<SolicitacaoImagem> get() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SolicitacaoImagem solicitacaoImagem;
        List<SolicitacaoImagem> resposta = new ArrayList<SolicitacaoImagem>();
        try {
            String sql = "SELECT * FROM solicitacaoImagem;";

            con = ConnectionSQLiteFactory.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                solicitacaoImagem = new SolicitacaoImagem(
                        rs.getInt("codUsuario"),
                        rs.getInt("codImagem"),
                        rs.getString("solicitacao")
                );

                resposta.add(solicitacaoImagem);
            }

            return resposta;

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, ps, rs);
        }
    }

    @Override
    public void excluir(int codSolicitacaoImagem) {
        String sql = "DELETE FROM solicitacaoImagem WHERE codSolicitacaoImagem = ?;";
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = ConnectionSQLiteFactory.getConnection();
            pst = con.prepareStatement(sql);
            pst.setLong(1, codSolicitacaoImagem);
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } finally {
            ConnectionSQLiteFactory.closeConnection(con, pst);
        }
    }
}
