/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.ufes.ufespic.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;

/**
 *
 * @author Rafael
 */
public class ConfiguracoesView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManterUsuarioView
     */
    public ConfiguracoesView() {
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
        lblFormatoLog = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        cbFormatoLog = new javax.swing.JComboBox<>();
        progressConfiguracoes = new javax.swing.JProgressBar();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        setTitle("Configurações");

        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblFormatoLog.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFormatoLog.setForeground(new java.awt.Color(51, 51, 51));
        lblFormatoLog.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFormatoLog.setText("Formato de log");

        btnFechar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close_30px.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save_30px.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        cbFormatoLog.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbFormatoLog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSV", "JSON", "XML" }));
        cbFormatoLog.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        progressConfiguracoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        progressConfiguracoes.setForeground(new java.awt.Color(51, 204, 0));
        progressConfiguracoes.setToolTipText("");
        progressConfiguracoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        progressConfiguracoes.setFocusable(false);
        progressConfiguracoes.setIndeterminate(true);
        progressConfiguracoes.setString("Configurando");
        progressConfiguracoes.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(progressConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFormatoLog, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbFormatoLog, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormatoLog)
                    .addComponent(cbFormatoLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(progressConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbFormatoLog;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFormatoLog;
    private javax.swing.JProgressBar progressConfiguracoes;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnFechar() {
        return btnFechar;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JComboBox<String> getCbFormatoLog() {
        return cbFormatoLog;
    }

    public JProgressBar getProgressConfiguracoes() {
        return progressConfiguracoes;
    }
}
