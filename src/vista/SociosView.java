/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author IvanA
 */
public class SociosView extends javax.swing.JFrame {

    /**
     * Creates new form SociosView
     */
    public SociosView() {
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

        btn_modificarSocio = new javax.swing.JButton();
        txt_espBusquedaSocio = new javax.swing.JTextField();
        btn_buscarSocios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_agregarSocio = new javax.swing.JButton();
        btn_eliminarSocio = new javax.swing.JButton();
        cmb_filtroSocios = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_socios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_modificarSocio.setText("Modificar");
        btn_modificarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarSocioActionPerformed(evt);
            }
        });

        txt_espBusquedaSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_espBusquedaSocioActionPerformed(evt);
            }
        });

        btn_buscarSocios.setText("Buscar");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Socios");

        btn_agregarSocio.setText("Agregar");
        btn_agregarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarSocioActionPerformed(evt);
            }
        });

        btn_eliminarSocio.setText("Eliminar");
        btn_eliminarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarSocioActionPerformed(evt);
            }
        });

        cmb_filtroSocios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nombre", "Apellidos", "DNI" }));
        cmb_filtroSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_filtroSociosActionPerformed(evt);
            }
        });

        table_socios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idSocio", "nombre", "apellido", "correo", "telefono", "direccion", "dni"
            }
        ));
        jScrollPane2.setViewportView(table_socios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(txt_espBusquedaSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmb_filtroSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btn_buscarSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(btn_agregarSocio)
                .addGap(18, 18, 18)
                .addComponent(btn_eliminarSocio)
                .addGap(18, 18, 18)
                .addComponent(btn_modificarSocio)
                .addContainerGap(340, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_filtroSocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_espBusquedaSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscarSocios))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregarSocio)
                    .addComponent(btn_eliminarSocio)
                    .addComponent(btn_modificarSocio))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modificarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarSocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarSocioActionPerformed

    private void btn_agregarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarSocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarSocioActionPerformed

    private void btn_eliminarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarSocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarSocioActionPerformed

    private void cmb_filtroSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_filtroSociosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_filtroSociosActionPerformed

    private void txt_espBusquedaSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_espBusquedaSocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_espBusquedaSocioActionPerformed

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
            java.util.logging.Logger.getLogger(SociosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SociosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SociosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SociosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SociosView().setVisible(true);
            }
        });
    }

    // getters y setters
    public JButton getBtn_agregarSocio() {
        return btn_agregarSocio;
    }

    public JButton getBtn_buscarSocios() {
        return btn_buscarSocios;
    }

    public JButton getBtn_eliminarSocio() {
        return btn_eliminarSocio;
    }

    public JButton getBtn_modificarSocio() {
        return btn_modificarSocio;
    }

    public JComboBox<String> getCmb_filtroSocios() {
        return cmb_filtroSocios;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JTable getTable_socios() {
        return table_socios;
    }

    public JTextField getTxt_espBusquedaSocio() {
        return txt_espBusquedaSocio;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregarSocio;
    private javax.swing.JButton btn_buscarSocios;
    private javax.swing.JButton btn_eliminarSocio;
    private javax.swing.JButton btn_modificarSocio;
    private javax.swing.JComboBox<String> cmb_filtroSocios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_socios;
    private javax.swing.JTextField txt_espBusquedaSocio;
    // End of variables declaration//GEN-END:variables
}
