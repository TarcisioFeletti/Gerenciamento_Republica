/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ManterMoradores;

import javax.swing.JButton;
import javax.swing.JTable;
import static View.TelaInicialView.Desktop;

/**
 *
 * @author Davidson
 */
public class P0201 extends javax.swing.JInternalFrame {

    /**
     * Creates new form P0203
     */
    public P0201() {
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

        convidarMoradorSemTeto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMoradores = new javax.swing.JTable();
        editar = new javax.swing.JButton();
        removerDaRepublica = new javax.swing.JButton();
        verHistorico = new javax.swing.JButton();

        setClosable(true);

        convidarMoradorSemTeto.setText("Convidar Morador / Sem Teto");
        convidarMoradorSemTeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convidarMoradorSemTetoActionPerformed(evt);
            }
        });

        tabelaMoradores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Data de Ingresso", "Rateio %"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaMoradores.setRowHeight(25);
        jScrollPane1.setViewportView(tabelaMoradores);

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        removerDaRepublica.setText("Remover da República");

        verHistorico.setText("Ver Histórico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removerDaRepublica)
                .addGap(18, 18, 18)
                .addComponent(verHistorico)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(convidarMoradorSemTeto)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(convidarMoradorSemTeto)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editar)
                    .addComponent(removerDaRepublica)
                    .addComponent(verHistorico))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void convidarMoradorSemTetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convidarMoradorSemTetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_convidarMoradorSemTetoActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        P0202 a = new P0202();
        Desktop.add(a);
        a.setVisible(true);
    }//GEN-LAST:event_editarActionPerformed

    public JButton getConvidarMoradorSemTeto() {
        return convidarMoradorSemTeto;
    }

    public JButton getEditar() {
        return editar;
    }

    public JButton getRemoverDaRepublica() {
        return removerDaRepublica;
    }

    public JTable getTabelaMoradores() {
        return tabelaMoradores;
    }

    public JButton getVerHistorico() {
        return verHistorico;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton convidarMoradorSemTeto;
    private javax.swing.JButton editar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removerDaRepublica;
    private javax.swing.JTable tabelaMoradores;
    private javax.swing.JButton verHistorico;
    // End of variables declaration//GEN-END:variables
}
