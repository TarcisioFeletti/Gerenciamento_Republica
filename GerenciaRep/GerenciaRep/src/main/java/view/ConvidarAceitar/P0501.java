/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConvidarAceitar;

/**
 *
 * @author Davidson
 */
public class P0501 extends javax.swing.JInternalFrame {

    /**
     * Creates new form P0501
     */
    public P0501() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        recusarPerfil = new javax.swing.JButton();
        aceitarPerfil = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        convidarPerfil = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Solução de Reclamação", "Realização de Tarefas", "Compromisso com Pagamentos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 410));

        recusarPerfil.setText("Recusar");
        recusarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recusarPerfilActionPerformed(evt);
            }
        });
        jPanel2.add(recusarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 120, -1));

        aceitarPerfil.setText("Aceitar Solicitação");
        aceitarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceitarPerfilActionPerformed(evt);
            }
        });
        jPanel2.add(aceitarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, -1, -1));

        jTabbedPane1.addTab("Aceitar Solicitações", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Solução de Reclamação", "Realização de Tarefas", "Compromisso com Pagamentos", "Convidado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 410));

        convidarPerfil.setText("Convidar");
        convidarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convidarPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(convidarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 110, -1));

        jTabbedPane1.addTab("Convidar Usuários", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 475));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recusarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recusarPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recusarPerfilActionPerformed

    private void aceitarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceitarPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aceitarPerfilActionPerformed

    private void convidarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convidarPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_convidarPerfilActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceitarPerfil;
    private javax.swing.JButton convidarPerfil;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton recusarPerfil;
    // End of variables declaration//GEN-END:variables
}
