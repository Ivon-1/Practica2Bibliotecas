/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author sergi
 */
public class AdministracionView extends javax.swing.JFrame {

    /**
     * Creates new form AdministracionView
     */
    public AdministracionView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Menu Trabajadores");
    }

    public JButton getBtn_agregarTrabajador() {
        return btn_agregarTrabajador;
    }

    public JButton getBtn_buscarTrabajador() {
        return btn_buscarTrabajador;
    }

    public JButton getBtn_eliminarTrabajador() {
        return btn_eliminarTrabajador;
    }

    public JButton getBtn_modificarTrabajador() {
        return btn_modificarTrabajador;
    }

    public JButton getBtn_volverTrabajador() {
        return btn_volverTrabajador;
    }

    public JComboBox<String> getCmb_trabajador() {
        return cmb_trabajador;
    }

    public JTable getTable_trabajadores() {
        return table_trabajadores;
    }

    public JTextField getTxt_busquedaTrabajador() {
        return txt_busquedaTrabajador;
    }

    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_busquedaTrabajador = new javax.swing.JTextField();
        cmb_trabajador = new javax.swing.JComboBox<>();
        btn_buscarTrabajador = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_trabajadores = new javax.swing.JTable();
        btn_agregarTrabajador = new javax.swing.JButton();
        btn_eliminarTrabajador = new javax.swing.JButton();
        btn_modificarTrabajador = new javax.swing.JButton();
        btn_volverTrabajador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Trabajadores");

        cmb_trabajador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nombre", "Apellido", "ID" }));

        btn_buscarTrabajador.setText("Buscar");

        table_trabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idTrabajador", "Nombre", "Apellidos", "Correo", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_trabajadores.setToolTipText("");
        jScrollPane1.setViewportView(table_trabajadores);

        btn_agregarTrabajador.setText("Agregar");

        btn_eliminarTrabajador.setText("Eliminar");

        btn_modificarTrabajador.setText("Modificar");

        btn_volverTrabajador.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addComponent(txt_busquedaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(cmb_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btn_buscarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(283, 283, 283)
                            .addComponent(btn_agregarTrabajador)
                            .addGap(45, 45, 45)
                            .addComponent(btn_eliminarTrabajador)
                            .addGap(40, 40, 40)
                            .addComponent(btn_modificarTrabajador)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_volverTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_busquedaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscarTrabajador))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregarTrabajador)
                    .addComponent(btn_eliminarTrabajador)
                    .addComponent(btn_modificarTrabajador)
                    .addComponent(btn_volverTrabajador))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AdministracionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministracionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministracionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministracionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministracionView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregarTrabajador;
    private javax.swing.JButton btn_buscarTrabajador;
    private javax.swing.JButton btn_eliminarTrabajador;
    private javax.swing.JButton btn_modificarTrabajador;
    private javax.swing.JButton btn_volverTrabajador;
    private javax.swing.JComboBox<String> cmb_trabajador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_trabajadores;
    private javax.swing.JTextField txt_busquedaTrabajador;
    // End of variables declaration//GEN-END:variables
}
