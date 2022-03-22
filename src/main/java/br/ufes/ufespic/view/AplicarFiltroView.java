/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.ufes.ufespic.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rafael
 */
public class AplicarFiltroView extends javax.swing.JInternalFrame {

    /**
     * Creates new form AplicarFiltroView
     */
    public AplicarFiltroView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        btnRestaurarPadrao = new javax.swing.JButton();
        btnDesfazer = new javax.swing.JButton();
        painelFiltros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chkImagemAzul = new javax.swing.JCheckBox();
        chkImagemVerde = new javax.swing.JCheckBox();
        chkImagemVermelha = new javax.swing.JCheckBox();
        chkImagemEspelhada = new javax.swing.JCheckBox();
        chkRotacao = new javax.swing.JCheckBox();
        chkNegativo = new javax.swing.JCheckBox();
        chkCorSepia = new javax.swing.JCheckBox();
        chkPixelar = new javax.swing.JCheckBox();
        chkTonsDeCinza = new javax.swing.JCheckBox();
        chkBrilho = new javax.swing.JCheckBox();
        cbFiltroPersonalizado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblImagem = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setTitle("Aplicar filtro");

        btnFechar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close_30px.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        btnRestaurarPadrao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRestaurarPadrao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restore_30px.png"))); // NOI18N
        btnRestaurarPadrao.setText("Restaurar Padrão");
        btnRestaurarPadrao.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btnRestaurarPadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarPadraoActionPerformed(evt);
            }
        });

        btnDesfazer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDesfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/undo_30px.png"))); // NOI18N
        btnDesfazer.setText("Desfazer");
        btnDesfazer.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btnDesfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesfazerActionPerformed(evt);
            }
        });

        painelFiltros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Filtros");

        chkImagemAzul.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkImagemAzul.setText("Imagem Azul");

        chkImagemVerde.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkImagemVerde.setText("Imagem Verde");
        chkImagemVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkImagemVerdeActionPerformed(evt);
            }
        });

        chkImagemVermelha.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkImagemVermelha.setText("Imagem Vemelha");

        chkImagemEspelhada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkImagemEspelhada.setText("Imagem Espelhada");

        chkRotacao.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkRotacao.setText("Rotação da imagem em graus °");

        chkNegativo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkNegativo.setText("Negativo da Imagem");

        chkCorSepia.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkCorSepia.setText("Aplicar a cor Sépia");

        chkPixelar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkPixelar.setText("Pixelar Imagem");

        chkTonsDeCinza.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkTonsDeCinza.setText("Tons de cinza");

        chkBrilho.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkBrilho.setText("Aplicar brilho");

        javax.swing.GroupLayout painelFiltrosLayout = new javax.swing.GroupLayout(painelFiltros);
        painelFiltros.setLayout(painelFiltrosLayout);
        painelFiltrosLayout.setHorizontalGroup(
            painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkBrilho)
                    .addComponent(chkTonsDeCinza)
                    .addComponent(chkPixelar)
                    .addComponent(chkCorSepia)
                    .addComponent(chkNegativo)
                    .addComponent(chkRotacao)
                    .addComponent(chkImagemEspelhada)
                    .addComponent(chkImagemVermelha)
                    .addComponent(jLabel1)
                    .addComponent(chkImagemAzul)
                    .addComponent(chkImagemVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        painelFiltrosLayout.setVerticalGroup(
            painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkImagemAzul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkImagemVerde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkImagemVermelha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkImagemEspelhada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkRotacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkNegativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkCorSepia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkPixelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkTonsDeCinza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkBrilho)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        cbFiltroPersonalizado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Conjunto de filtros personalizado");

        lblImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(lblImagem);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDesfazer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRestaurarPadrao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(painelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbFiltroPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFiltroPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(painelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRestaurarPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesfazer, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRestaurarPadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarPadraoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRestaurarPadraoActionPerformed

    private void btnDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesfazerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesfazerActionPerformed

    private void chkImagemVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkImagemVerdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkImagemVerdeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesfazer;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRestaurarPadrao;
    private javax.swing.JComboBox<String> cbFiltroPersonalizado;
    private javax.swing.JCheckBox chkBrilho;
    private javax.swing.JCheckBox chkCorSepia;
    private javax.swing.JCheckBox chkImagemAzul;
    private javax.swing.JCheckBox chkImagemEspelhada;
    private javax.swing.JCheckBox chkImagemVerde;
    private javax.swing.JCheckBox chkImagemVermelha;
    private javax.swing.JCheckBox chkNegativo;
    private javax.swing.JCheckBox chkPixelar;
    private javax.swing.JCheckBox chkRotacao;
    private javax.swing.JCheckBox chkTonsDeCinza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JPanel painelFiltros;
    // End of variables declaration//GEN-END:variables
    
    public JLabel getLblImagem() {
        return lblImagem;
    }

    public JButton getBtnFechar() {
        return btnFechar;
    }

    public JCheckBox getChkImagemAzul() {
        return chkImagemAzul;
    }

    public JCheckBox getChkImagemVerde() {
        return chkImagemVerde;
    }

    public JCheckBox getChkBrilho() {
        return chkBrilho;
    }

    public JCheckBox getChkCorSepia() {
        return chkCorSepia;
    }

    public JCheckBox getChkImagemEspelhada() {
        return chkImagemEspelhada;
    }

    public JCheckBox getChkImagemVermelha() {
        return chkImagemVermelha;
    }

    public JCheckBox getChkNegativo() {
        return chkNegativo;
    }

    public JCheckBox getChkPixelar() {
        return chkPixelar;
    }

    public JCheckBox getChkRotacao() {
        return chkRotacao;
    }

    public JCheckBox getChkTonsDeCinza() {
        return chkTonsDeCinza;
    }

    public JButton getBtnDesfazer() {
        return btnDesfazer;
    }

    public JButton getBtnRestaurarPadrao() {
        return btnRestaurarPadrao;
    }

    public JPanel getPainelFiltros() {
        return painelFiltros;
    }  
}