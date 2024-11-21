/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author sergi
 */
public class MenuView extends javax.swing.JFrame {

    /**
     * Creates new form MenuView
     */
    public MenuView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Menu principal");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_consultarBibilioteca1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_ConsultarSocio = new javax.swing.JButton();
        btn_Administracion = new javax.swing.JButton();
        btn_cerrarSesion = new javax.swing.JButton();
        btn_GestionPrincipal = new javax.swing.JButton();
        btn_consultarBibilioteca = new javax.swing.JButton();

        btn_consultarBibilioteca1.setText("Consultar biblioteca");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Gestion de bibliotecas");

        btn_ConsultarSocio.setText("Consultas socios");
        btn_ConsultarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsultarSocioActionPerformed(evt);
            }
        });

        btn_Administracion.setText("Administracion");

        btn_cerrarSesion.setText("Cerrar sesión");

        btn_GestionPrincipal.setText("Gestion");

        btn_consultarBibilioteca.setText("Consultar biblioteca");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_ConsultarSocio, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(btn_Administracion, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(btn_GestionPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(btn_consultarBibilioteca, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                        .addGap(154, 154, 154))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cerrarSesion)
                .addGap(185, 185, 185))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(btn_consultarBibilioteca)
                .addGap(12, 12, 12)
                .addComponent(btn_ConsultarSocio)
                .addGap(18, 18, 18)
                .addComponent(btn_Administracion)
                .addGap(18, 18, 18)
                .addComponent(btn_GestionPrincipal)
                .addGap(18, 18, 18)
                .addComponent(btn_cerrarSesion)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ConsultarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsultarSocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ConsultarSocioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    public JButton getBtn_Administracion() {
        return btn_Administracion;
    }

    public JButton getBtn_ConsultarSocio() {
        return btn_ConsultarSocio;
    }

    public JButton getBtn_GestionPrincipal() {
        return btn_GestionPrincipal;
    }

    public JButton getBtn_cerrarSesion() {
        return btn_cerrarSesion;
    }

    public JButton getBtn_consultarBibilioteca() {
        return btn_consultarBibilioteca;
    }

    


    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Administracion;
    private javax.swing.JButton btn_ConsultarSocio;
    private javax.swing.JButton btn_GestionPrincipal;
    private javax.swing.JButton btn_cerrarSesion;
    private javax.swing.JButton btn_consultarBibilioteca;
    private javax.swing.JButton btn_consultarBibilioteca1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
