/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DBManager;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Z510
 */
public class JFrameTablasBD extends javax.swing.JFrame {

    // variables de clase
    private JTable tabla;
    private DefaultTableModel dtm;
    private DBManager BdManager;

    public void setBdManager(DBManager ArchivoBd) {
        this.BdManager = ArchivoBd;
    }

    /**
     * Creates new form JFrameTablasBD
     */
    public JFrameTablasBD() {
        initComponents();

        dtm = new DefaultTableModel();
        InicializarDtm();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTNombreTabla = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCampos = new javax.swing.JTable();
        jBAgregarCampo = new javax.swing.JButton();
        jBCrearTabla = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTNombreCampo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCBTipoDatos = new javax.swing.JComboBox();
        jChClaveP = new javax.swing.JCheckBox();
        jChNulos = new javax.swing.JCheckBox();
        jChUnica = new javax.swing.JCheckBox();
        jChAutoinc = new javax.swing.JCheckBox();
        jBcancelar = new javax.swing.JButton();
        jBTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Creación de Tablas");

        jLabel1.setText("Nombre Tabla");

        jTableCampos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableCampos);

        jBAgregarCampo.setText("Agregar campo");
        jBAgregarCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarCampoActionPerformed(evt);
            }
        });

        jBCrearTabla.setText("Crear tabla");
        jBCrearTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCrearTablaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setText("Nombre campo");

        jLabel3.setText("Tipo Datos");

        jCBTipoDatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INTEGER", "BOOL", "DOUBLE", "FLOAT", "REAL", "CHAR", "TEXT", "VARCHAR", "BLOB", "NUMERIC", "DATETIME", "INTEGER (strict)", "REAL (strict)", "TEXT (strict)" }));

        jChClaveP.setText("Clave Primaria");
        jChClaveP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jChClavePStateChanged(evt);
            }
        });

        jChNulos.setText("Permitir Nulo");

        jChUnica.setText("Unica");
        jChUnica.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jChUnicaStateChanged(evt);
            }
        });
        jChUnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChUnicaActionPerformed(evt);
            }
        });

        jChAutoinc.setText("Autoincrementar");
        jChAutoinc.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jChAutoincStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTNombreCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jCBTipoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChClaveP)
                    .addComponent(jChNulos))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChAutoinc)
                    .addComponent(jChUnica))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBTipoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTNombreCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jChClaveP)
                                .addComponent(jChUnica)))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jChNulos)
                            .addComponent(jChAutoinc))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jBcancelar.setText("Cancelar");
        jBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarActionPerformed(evt);
            }
        });

        jBTerminar.setText("Terminar");
        jBTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTNombreTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jBAgregarCampo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBCrearTabla)
                        .addGap(18, 18, 18)
                        .addComponent(jBTerminar)
                        .addGap(18, 18, 18)
                        .addComponent(jBcancelar)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTNombreTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregarCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCrearTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para cancelar la creación de la tabla
     *
     * @param evt
     */
    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "Se eliminará la base de datos creada\n¿Está seguro de que desea cancelar?", "¿Eliminar?", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            File file = new File(BdManager.getArchivoBD());
            if (file.delete()) {
                JOptionPane.showMessageDialog(null, "Archivo borrado correctamenre.");
                LimpiarCampos();
                InicializarDtm();
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido borrar el archivo");
            }
        }

    }

    /**
     * Método para limpiar todos los campos del formulario
     */
    private void LimpiarCampos() {
        jTNombreTabla.setText("");
        jTNombreCampo.setText("");
        jCBTipoDatos.setSelectedIndex(0);

        jChAutoinc.setSelected(false);
        jChClaveP.setSelected(false);
        jChNulos.setSelected(false);
        jChUnica.setSelected(false);
    }//GEN-LAST:event_jBcancelarActionPerformed

    /**
     * Método para agregar los campos al grid
     *
     * @param evt
     */
    private void jBAgregarCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarCampoActionPerformed
        Object[] obj = new Object[6];
        obj[0] = jTNombreCampo.getText().replace(" ", "_");
        obj[1] = jCBTipoDatos.getSelectedItem().toString();
        obj[2] = (jChClaveP.isSelected()) ? "X" : "";
        obj[3] = (jChAutoinc.isSelected()) ? "X" : "";
        obj[4] = (jChNulos.isSelected()) ? "X" : "";
        obj[5] = (jChUnica.isSelected()) ? "X" : "";

        dtm.addRow(obj);
        String nombreTabla = jTNombreTabla.getText();
        LimpiarCampos();
        jTNombreTabla.setText(nombreTabla);
    }//GEN-LAST:event_jBAgregarCampoActionPerformed

    private void jBTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTerminarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBTerminarActionPerformed

    /**
     * Método que controla los CheckButton cuando se marca el autoincremento
     *
     * @param evt
     */
    private void jChAutoincStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jChAutoincStateChanged
        if (jChAutoinc.isSelected()) {
            jChClaveP.setSelected(true);
            jCBTipoDatos.setSelectedIndex(0);
            jChNulos.setSelected(false);
            jChUnica.setSelected(false);

            jChClaveP.setEnabled(false);
            jCBTipoDatos.setEnabled(false);
            jChNulos.setEnabled(false);
            jChUnica.setEnabled(false);

        } else {
            jChClaveP.setEnabled(true);
            jCBTipoDatos.setEnabled(true);
            jChNulos.setEnabled(true);
            jChUnica.setEnabled(true);
        }
    }//GEN-LAST:event_jChAutoincStateChanged

    private void jChUnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChUnicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChUnicaActionPerformed

    /**
     * Método que controla los CheckButton cuando se marca el de Única
     *
     * @param evt
     */
    private void jChUnicaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jChUnicaStateChanged
        if (jChUnica.isSelected()) {
            jChNulos.setSelected(false);
            jChClaveP.setSelected(false);
            jChAutoinc.setSelected(false);
            jChNulos.setEnabled(false);
            jChClaveP.setEnabled(false);
            jChAutoinc.setEnabled(false);
        } else {
            jChNulos.setEnabled(true);
            jChClaveP.setEnabled(true);
            jChAutoinc.setEnabled(true);
        }
    }//GEN-LAST:event_jChUnicaStateChanged

    /**
     * Método que controla los CheckButton cuando se marca el de Clave Primaria
     *
     * @param evt
     */
    private void jChClavePStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jChClavePStateChanged
        if (jChClaveP.isSelected()) {
            jChNulos.setSelected(false);
            jChUnica.setSelected(false);
            jChNulos.setEnabled(false);
            jChUnica.setEnabled(false);
        } else {
            jChNulos.setEnabled(true);
            jChUnica.setEnabled(true);
        }
    }//GEN-LAST:event_jChClavePStateChanged

    private void jBCrearTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCrearTablaActionPerformed

        if (jTNombreTabla.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe introducir un nombre para la tabla");
        } else {
            String pkString = "\nPRIMARY KEY (";
            String uniqueString = "\nUNIQUE (";
            Integer num_pk = 0;
            Integer num_unique = 0;
            String cadenaSql = "CREATE TABLE " + jTNombreTabla.getText() + " (";
            for (int i = 0; i < tabla.getRowCount(); i++) {
                String atributos = "";
                String nombre = String.valueOf(dtm.getValueAt(i, 0));
                String tipo = String.valueOf(dtm.getValueAt(i, 1));

                boolean pk = (String.valueOf(dtm.getValueAt(i, 2))).equals("X") ? true : false;
                pkString += (pk) ? nombre + ", " : "";
                num_pk += (pk) ? 1 : 0;
                boolean autoinc = (String.valueOf(dtm.getValueAt(i, 3))).equals("X") ? true : false;
                atributos += (autoinc) ? " AUTOINCREMENT " : "";
                boolean nulo = (String.valueOf(dtm.getValueAt(i, 4))).equals("X") ? true : false;
                atributos += (nulo) ? "" : " NOT NULL ";
                boolean unica = (String.valueOf(dtm.getValueAt(i, 5))).equals("X") ? true : false;
                uniqueString += (unica) ? nombre + ", " : "";
                num_unique += (unica) ? 1 : 0;
                cadenaSql = cadenaSql + "\n" + nombre + " " + tipo + " " + atributos + ",";
            }

            pkString = pkString.substring(0, pkString.length() - 2);

            cadenaSql =  (num_pk > 0 ? cadenaSql + pkString : cadenaSql.substring(0, cadenaSql.length()-1)) + "),";

            if (num_pk > 1) {
                cadenaSql = cadenaSql.replace(" AUTOINCREMENT ", "");
                JOptionPane.showMessageDialog(this, "No se permite tener un campo "
                    + "AUTOINCREMENT si la clave primaria tiene más de un campo\n"
                    + "Se eliminará esa opción");
            } else if (num_pk == 1) {
                cadenaSql = cadenaSql.replace(" AUTOINCREMENT ", " PRIMARY KEY AUTOINCREMENT ");
                cadenaSql = cadenaSql.replace(pkString + "),", "");
            } else {
                cadenaSql = cadenaSql.substring(0, cadenaSql.length()-1);
            }

            if (num_unique > 0) {
                cadenaSql += uniqueString.substring(0, uniqueString.length() - 2) + ")";
            } else {
                cadenaSql = cadenaSql.substring(0, cadenaSql.length() - 1);
            }

            JOptionPane.showConfirmDialog(this, cadenaSql);

            cadenaSql += "\n);";

            pkString = "\nPRIMARY KEY (";
            num_pk = 0;
            num_unique = 0;

            try {
                BdManager.conectar();
                BdManager.ejecutarInsercion(cadenaSql);
                BdManager.cerrar();
                JOptionPane.showMessageDialog(rootPane, "Tabla "
                    + jTNombreTabla.getText() + " creada correctamente");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JFrameTablasBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(JFrameTablasBD.class.getName()).log(Level.SEVERE, null, ex);
            }

            jTNombreTabla.setText("");
            InicializarDtm();

        }
    }//GEN-LAST:event_jBCrearTablaActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameTablasBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTablasBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTablasBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTablasBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameTablasBD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarCampo;
    private javax.swing.JButton jBCrearTabla;
    private javax.swing.JButton jBTerminar;
    private javax.swing.JButton jBcancelar;
    private javax.swing.JComboBox jCBTipoDatos;
    private javax.swing.JCheckBox jChAutoinc;
    private javax.swing.JCheckBox jChClaveP;
    private javax.swing.JCheckBox jChNulos;
    private javax.swing.JCheckBox jChUnica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTNombreCampo;
    private javax.swing.JTextField jTNombreTabla;
    private javax.swing.JTable jTableCampos;
    // End of variables declaration//GEN-END:variables

    private void InicializarDtm() {
        // Eliminamos  las filas del dtm
        tabla = this.jTableCampos;

        tabla.setModel(dtm);
        for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }

        java.lang.Object[] colIdentifiers = {"CAMPO", "TIPO DE DATOS", "PK", "AUTOINC.", "NULL", "ÚNICA"};

        dtm.setColumnIdentifiers(colIdentifiers);
    }
}
