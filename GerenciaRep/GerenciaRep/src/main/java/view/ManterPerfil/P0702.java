/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ManterPerfil;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Davidson
 */
public class P0702 extends javax.swing.JInternalFrame {

    /**
     * Creates new form P0702
     */
    public P0702() {
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

        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        perfilPublico = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        perfilPrivado = new javax.swing.JRadioButton();
        nome = new javax.swing.JTextField();
        linkRedeSocial = new javax.swing.JTextField();
        confirmarPerfil = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        apelido = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        telefone = new javax.swing.JFormattedTextField();
        telefoneResponsavel1 = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        telefoneResponsavel2 = new javax.swing.JFormattedTextField();

        setClosable(true);
        setMaximizable(true);

        jLabel15.setText("Telefone do Responsável 2:");

        jLabel16.setText("Perfil:");

        perfilPublico.setText("Público");
        perfilPublico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilPublicoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        perfilPrivado.setText("Privado");

        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomeKeyTyped(evt);
            }
        });

        confirmarPerfil.setText("Confirmar");
        confirmarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarPerfilActionPerformed(evt);
            }
        });

        jLabel12.setText("Link da Rede Social:");

        jLabel13.setText("Telefone:");

        jLabel5.setText("Apelido:");

        telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefoneKeyTyped(evt);
            }
        });

        jLabel14.setText("Telefone do Responsável 1:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel1))
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(apelido, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel12)
                        .addComponent(linkRedeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(telefoneResponsavel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(telefoneResponsavel2))
                        .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(perfilPublico)
                            .addGap(12, 12, 12)
                            .addComponent(perfilPrivado))
                        .addComponent(jLabel16))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(apelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel13)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel12)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(linkRedeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel14)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(telefoneResponsavel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel15)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(telefoneResponsavel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel16)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(perfilPublico)
                        .addComponent(perfilPrivado))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmarPerfil)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void perfilPublicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilPublicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfilPublicoActionPerformed

    private void confirmarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmarPerfilActionPerformed

    public JTextField getApelido() {
        return apelido;
    }

    public JButton getConfirmarPerfil() {
        return confirmarPerfil;
    }

    public JTextField getLinkRedeSocial() {
        return linkRedeSocial;
    }

    public JTextField getNome() {
        return nome;
    }

    public JRadioButton getPerfilPrivado() {
        return perfilPrivado;
    }

    public JRadioButton getPerfilPublico() {
        return perfilPublico;
    }

    public JFormattedTextField getTelefone() {
        return telefone;
    }

    public JFormattedTextField getTelefoneResponsavel1() {
        return telefoneResponsavel1;
    }

    public JFormattedTextField getTelefoneResponsavel2() {
        return telefoneResponsavel2;
    }

    private void telefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefoneKeyTyped
        
    }//GEN-LAST:event_telefoneKeyTyped

    private void nomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyTyped
        
    }//GEN-LAST:event_nomeKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apelido;
    private javax.swing.JButton confirmarPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField linkRedeSocial;
    private javax.swing.JTextField nome;
    private javax.swing.JRadioButton perfilPrivado;
    private javax.swing.JRadioButton perfilPublico;
    private javax.swing.JFormattedTextField telefone;
    private javax.swing.JFormattedTextField telefoneResponsavel1;
    private javax.swing.JFormattedTextField telefoneResponsavel2;
    // End of variables declaration//GEN-END:variables
}
