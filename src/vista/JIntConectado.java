/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DBManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumno
 */
public class JIntConectado extends javax.swing.JInternalFrame
{

    private DBManager mydb;
    private DefaultListModel modeloLista;

    private JTable tabla;
    private DefaultTableModel dtm;

    private MdiPrueba padre;

    public void setPadre(MdiPrueba padre)
    {
        this.padre = padre;
    }

    public DBManager getMydb()
    {
        return mydb;
    }

    /**
     * Método para establecer la base de datos actual y cargar los datos en la
     * tabla y en la lista
     *
     * @param mydb
     * @throws Exception
     */
    public void setMydb(DBManager mydb) throws Exception
    {
        this.mydb = mydb;
        try
        {
            mydb.conectar();
            modeloLista = mydb.listarTablas();
            jListTablas.setModel(modeloLista);
            jListTablas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jListTablas.setSelectedIndex(0);
        } catch (Exception ex)
        {
            try
            {
                this.cerrar();
            } catch (SQLException ex1)
            {
                JOptionPane.showMessageDialog(null, "No se ha podido cerrar la ventana\nLA aplicación se cerrará");
                System.exit(0);
            }
            JOptionPane.showMessageDialog(null, "Error accediendo a la base de datos, se cerrará la ventana\n" + ex.getMessage());
            throw new Exception("NOTADB");
        }
    }

    /**
     * Método para mostrar en el label superior el archivo de base de datos
     * actual
     *
     * @param texto
     */
    public void setjLabel1Text(String texto)
    {
        this.jLabel1.setText(texto);
    }

    /**
     * Creates new form JIntConectado
     */
    public JIntConectado()
    {
        initComponents();

        dtm = new DefaultTableModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPopupTablas = new javax.swing.JPopupMenu();
        jMc1Modificar = new javax.swing.JMenuItem();
        jMc2Renombrar = new javax.swing.JMenuItem();
        jMc3Borrar = new javax.swing.JMenuItem();
        jMc4Examinar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTablas = new javax.swing.JList();
        jBAgregarTabla = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCampos = new javax.swing.JTable();
        jBtnMostrarCampos = new javax.swing.JButton();
        jTEjecutarComando = new javax.swing.JTextField();
        jBEjecutarComando = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();

        jMc1Modificar.setText("Modificar Tabla");
        jPopupTablas.add(jMc1Modificar);

        jMc2Renombrar.setText("Renombrar Tabla");
        jMc2Renombrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMc2RenombrarActionPerformed(evt);
            }
        });
        jPopupTablas.add(jMc2Renombrar);

        jMc3Borrar.setText("Borrar Tabla");
        jMc3Borrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMc3BorrarActionPerformed(evt);
            }
        });
        jPopupTablas.add(jMc3Borrar);

        jMc4Examinar.setText("Examinar Tabla");
        jMc4Examinar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMc4ExaminarActionPerformed(evt);
            }
        });
        jPopupTablas.add(jMc4Examinar);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        setTitle("Propiedades de Tabla");

        jLabel1.setText(".");

        jListTablas.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListTablas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListTablas.setAutoscrolls(false);
        jListTablas.setComponentPopupMenu(jPopupTablas);
        jScrollPane1.setViewportView(jListTablas);

        jBAgregarTabla.setText("Agregar tabla");
        jBAgregarTabla.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBAgregarTablaActionPerformed(evt);
            }
        });

        jLabel2.setText("TABLAS");

        jLabel3.setText("CAMPOS");

        jTableCampos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableCampos);

        jBtnMostrarCampos.setText("Ver campos");
        jBtnMostrarCampos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnMostrarCamposActionPerformed(evt);
            }
        });

        jBEjecutarComando.setText("Ejecutar Comando");
        jBEjecutarComando.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBEjecutarComandoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel4.setText("Comando Sql:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(200, 200, 200))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBAgregarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnMostrarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBEjecutarComando)
                    .addComponent(jTEjecutarComando, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBAgregarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnMostrarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTEjecutarComando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBEjecutarComando, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para mostrar los campos y sus propiedades en la tabla
     *
     * @param evt
     */
    private void jBtnMostrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMostrarCamposActionPerformed

        List<Object[]> obj;
        obj = new ArrayList<>();
        String nombreTabla = jListTablas.getSelectedValue().toString();

        InicializarDtm();
        try
        {
            mydb.conectar();
            obj = mydb.listarCampos(nombreTabla);
            mydb.cerrar();
        } catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(JIntConectado.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < obj.size(); i++)
        {
            Object[] o = obj.get(i);
            dtm.addRow(o);
        }

        jLabel3.setText("CAMPOS DE LA TABLA " + nombreTabla);
    }//GEN-LAST:event_jBtnMostrarCamposActionPerformed
    /**
     * Método para agregar una nueva tabla a la BD actual. Se muestra el
     * formulario correspondiente.
     *
     * @param evt
     */
    private void jBAgregarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarTablaActionPerformed
        JIntTablasBd tabla = new JIntTablasBd();
        tabla.setBdManager(mydb);
        padre.setTablas(tabla, "Control");
    }//GEN-LAST:event_jBAgregarTablaActionPerformed

    /**
     * Método para renombrar la tabla desde el menú contextual de la lista de
     * tablas
     *
     * @param evt
     */
    private void jMc2RenombrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMc2RenombrarActionPerformed
    {//GEN-HEADEREND:event_jMc2RenombrarActionPerformed
        String viejoNombre = jListTablas.getSelectedValue().toString();
        String nuevoNombre = JOptionPane.showInputDialog(null, "Escriba el nuevo nombre de la tabla");

        if (!nuevoNombre.isEmpty())
        {
            try
            {
                String sql = String.format("ALTER TABLE %s RENAME TO %s", viejoNombre, nuevoNombre);
                boolean r = mydb.ejecutarInsercion(sql);

                JOptionPane.showMessageDialog(null, "Tabla renombrada correctamente");
                refrescar();
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "No se ha podido renombrar la tabla");
            }
        }
    }//GEN-LAST:event_jMc2RenombrarActionPerformed

    /**
     * Método para eliminar una tabla de la base de datos actual
     *
     * @param evt
     */
    private void jMc3BorrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMc3BorrarActionPerformed
    {//GEN-HEADEREND:event_jMc3BorrarActionPerformed
        String nombreTabla = jListTablas.getSelectedValue().toString();

        if (JOptionPane.showConfirmDialog(null, "¿Está seguro de borrar la tabla " + nombreTabla,
                "Eliminar Tabla", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            try
            {
                String sql = String.format("DROP TABLE %s ", nombreTabla);
                boolean r = mydb.ejecutarInsercion(sql);
                JOptionPane.showMessageDialog(null, "Tabla eliminada correctamente");
                refrescar();
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "No se ha podido eliminar la tabla");
            }
        }
    }//GEN-LAST:event_jMc3BorrarActionPerformed

    /**
     * Método para mostrar en un formulario aparte que contiene una tabla el
     * resultado de una select genérica sobre la tabla seleccionada
     *
     * @param evt
     */
    private void jMc4ExaminarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMc4ExaminarActionPerformed
    {//GEN-HEADEREND:event_jMc4ExaminarActionPerformed
        String nombreTabla = jListTablas.getSelectedValue().toString();
        DefaultTableModel dtm2;
        try
        {
            mydb.conectar();
            dtm2 = mydb.SelectFromTabla(nombreTabla);
            JFrameExaminarTabla jfeT = new JFrameExaminarTabla(dtm2);
            jfeT.setTitle("Select * from " + nombreTabla);
            jfeT.setVisible(true);
            mydb.cerrar();
        } catch (SQLException | ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "No se ha podido consultar la tabla");
        }
    }//GEN-LAST:event_jMc4ExaminarActionPerformed

    /**
     * Método que llama a ejecutarConsulta si no está vacío el text box
     *
     * @param evt
     */
    private void jBEjecutarComandoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBEjecutarComandoActionPerformed
    {//GEN-HEADEREND:event_jBEjecutarComandoActionPerformed
        if (!jTEjecutarComando.getText().isEmpty())
        {
            String sentencia = jTEjecutarComando.getText();
            ejecutarComando(sentencia);
        } else
        {
            JOptionPane.showMessageDialog(null, "El campo Comando no puede estar vacío");
        }

    }//GEN-LAST:event_jBEjecutarComandoActionPerformed

    /**
     * Método que ejecuta un comando sql según el caso
     */
    private void ejecutarComando(String sql)
    {
        int caso = 0;
        caso = sql.toUpperCase().contains("SELECT") ? 1 : caso;
        caso = sql.toUpperCase().contains("INSERT") ? 2 : caso;
        caso = sql.toUpperCase().contains("UPDATE") ? 3 : caso;
        caso = sql.toUpperCase().contains("DELETE") ? 4 : caso;

        switch (caso)
        {
            case 1: // select
                int pos = sql.toUpperCase().lastIndexOf(" ");
                String nombreTabla = sql.toLowerCase().substring(pos + 1);

                try
                {
                    DefaultTableModel dtm2;
                    mydb.conectar();
                    dtm2 = mydb.SelectSqlFromTabla(sql, nombreTabla);
                    JFrameExaminarTabla jfeT = new JFrameExaminarTabla(dtm2);
                    jfeT.setTitle(sql);
                    jfeT.setVisible(true);
                    mydb.cerrar();
                } catch (SQLException | ClassNotFoundException ex)
                {
                    JOptionPane.showMessageDialog(null, "No se han podido realizar la SELECT, compruebe el comando SQL");
                }
                break;
            case 2: // insert
            case 3: // update
            case 4: // delete
                try
                {
                    mydb.ejecutarInsercion(sql);
                } catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "No se han podido guardar los datos, compruebe el comando SQL");

                }
                break;
            default:    // opción incorrecta
                JOptionPane.showMessageDialog(null, "El comando introducido no es un comando Sql correcto");
                break;
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarTabla;
    private javax.swing.JToggleButton jBEjecutarComando;
    private javax.swing.JButton jBtnMostrarCampos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jListTablas;
    private javax.swing.JMenuItem jMc1Modificar;
    private javax.swing.JMenuItem jMc2Renombrar;
    private javax.swing.JMenuItem jMc3Borrar;
    private javax.swing.JMenuItem jMc4Examinar;
    private javax.swing.JPopupMenu jPopupTablas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTEjecutarComando;
    private javax.swing.JTable jTableCampos;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para borrar todas las lineas del dtm
     */
    private void InicializarDtm()
    {
        // Eliminamos  las filas del dtm
        tabla = this.jTableCampos;

        tabla.setModel(dtm);
        for (int i = dtm.getRowCount() - 1; i >= 0; i--)
        {
            dtm.removeRow(i);
        }

        java.lang.Object[] colIdentifiers =
        {
            "Nombre campo", "Tipo de datos", "Valor nulo", "Es PK"
        };

        dtm.setColumnIdentifiers(colIdentifiers);
    }

    /**
     * Método para cerrar la base de datos actual
     *
     * @throws SQLException
     */
    public void cerrar() throws SQLException
    {
        try
        {
            mydb.cerrar();
            InicializarDtm();
            jLabel3.setText("CAMPOS");
            this.setVisible(false);
        } catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }

    /**
     * Método para abrir una base de datos
     *
     * @param md
     * @return
     */
    public boolean abrir(DBManager md)
    {
        jLabel3.setText("CAMPOS");

        try
        {
            jBtnMostrarCampos.setEnabled(false);
            this.setjLabel1Text("Conectado con la Base de Datos " + md.getArchivoBD());
            InicializarDtm();
            this.setMydb(md);

            if (jListTablas.getMaxSelectionIndex() > -1)
            {
                jBtnMostrarCampos.setEnabled(true);
            }
            return true;
        } catch (Exception ex)
        {
            return false;
        }
    }

    /**
     * Método para volver a cargar los campos de la tabla y de la lista
     */
    public void refrescar()
    {
        jLabel3.setText("CAMPOS");

        jBtnMostrarCampos.setEnabled(false);
        this.setjLabel1Text("Conectado con la Base de Datos " + mydb.getArchivoBD());
        InicializarDtm();
        try
        {
            mydb.conectar();
            modeloLista = mydb.listarTablas();
            jListTablas.setModel(modeloLista);
            jListTablas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jListTablas.setSelectedIndex(0);

            //mydb.cerrar();
        } catch (Exception ex)
        {
            try
            {
                this.cerrar();
            } catch (SQLException ex1)
            {
                JOptionPane.showMessageDialog(null, "No se ha podido cerrar la ventana\nLA aplicación se cerrará");
                System.exit(0);
            }

            JOptionPane.showMessageDialog(null, "Error accediendo nuevamente a la base de datos, se cerrará la ventana\n" + ex.getMessage());
        }

        //JOptionPane.showMessageDialog(this, jListTablas.getMaxSelectionIndex());
        if (jListTablas.getMaxSelectionIndex() > -1)
        {
            jBtnMostrarCampos.setEnabled(true);
        }
    }
}
