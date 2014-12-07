package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import modelo.Moto;

/**
 * Clase para poder acceder a la base de datos SQLite
 *
 * @author Mª Luz García Rodríguez
 * @author Luis Massó Saiz
 */
public class DBManager {

    private Connection conn;
    private String archivoBD;

    /**
     * Constructor: DBManager(String archivoBD)
     *
     * @param archivoBD
     */
    public DBManager(String archivoBD) throws Exception {
        this.archivoBD = archivoBD;
        try {
            this.conectar();
            this.cerrar();
        } catch (Exception e) {
            throw new Exception("No se ha podido crear la base de datos"/* + e.getMessage()*/);
        }
    }

    /**
     * ************* GETTERS AND SETTERS *****************
     */
     public String getArchivoBD() {
        return archivoBD;
    }
    
    /**
     * *************** MÉTODOS ****************************
     */
    /**
     * Método para hacer la conexión con la BD
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void conectar() throws ClassNotFoundException, SQLException {
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");

        // create a database connection
        conn = DriverManager.getConnection("jdbc:sqlite:" + archivoBD);
    }

    /**
     * Método para cerrar la conexión con la BD
     * @throws SQLException 
     */
    public void cerrar() throws SQLException {
        conn.close();
    }

    /**
     * Método que ejecuta una sentencia sql (INSERT, UPDATE, DELETE)
     * @param sql
     * @return
     * @throws SQLException 
     */
    public boolean ejecutarInsercion(String sql) throws SQLException {
        Statement st = conn.createStatement();
        int res = st.executeUpdate(sql);
        st.close();
        return res == 1;
    }

    /**
     * Método que realiza una consulta a la BD (SELECT)
     * @param sql
     * @return
     * @throws SQLException 
     */
    public List<Moto> realizarConsulta(String sql) throws SQLException {
        List<Moto> lista = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String mar = rs.getString("marca");
            String mod = rs.getString("modelo");
            int cil = rs.getInt("cilindros");
            double pot = rs.getDouble("potencia");
            int cili = rs.getInt("cilindros");
            String ref = rs.getString("refrigeracion");
            double pre = rs.getDouble("precio");
            String ima = rs.getString("imagen");

            lista.add(new Moto(mar,mod,cil,pot,cili,ref,pre,ima));
        }
        st.close();

        return lista;
    }

    /**
     * Métdoo para listar las tablas de la base de datos
     * @return
     * @throws SQLException 
     */
    public DefaultListModel listarTablas() throws SQLException {
        DefaultListModel lista = new DefaultListModel();
        // La SQL la dejamos con not in ('sqlite_sequence', '') porque hay más que quitar
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select name from sqlite_master where type='table' and name not in ('sqlite_sequence', ''); ");

        while (rs.next()) {
            String nombre = rs.getString("name");
            lista.addElement(nombre);
        }
        st.close();
        return lista;
    }
 
    /**
     * Método para listar los campos de una tabla de la base de datos
     * @param nombreTabla
     * @return
     * @throws SQLException 
     */
    public List<Object[]> listarCampos(String nombreTabla) throws SQLException {
        List<Object[]> lista = new ArrayList<Object[]>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("PRAGMA table_info('" + nombreTabla + "')");

        while (rs.next()) {
            Object[] obj = new Object[4];
            String nombre = rs.getString("name");
            obj[0] = nombre;
            obj[1] = rs.getString("type");
            int notnull = rs.getInt("notnull");
            obj[2] = (notnull == 0 ? "SI" : "NO");
            int pk = rs.getInt("pk");
            obj[3] = (pk == 0 ? "NO" : "SI");
            lista.add(obj);
        }

        return lista;
    }
    
    /**
     * Método para hacer una select * from tabla
     * @param nombreTabla
     * @return
     * @throws SQLException 
     */
    public DefaultTableModel SelectFromTabla(String nombreTabla) throws SQLException {
        DefaultTableModel lista = new DefaultTableModel();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from '" + nombreTabla + "'");

        List<Object[]> campos = this.listarCampos(nombreTabla);
        java.lang.Object[] colIdentifiers = new java.lang.Object[campos.size()];
        for(int i = 0; i<campos.size();i++)
        {
            Object[] c = campos.get(i);
            colIdentifiers[i]= c[0].toString();
        };
        lista.setColumnIdentifiers(colIdentifiers);
        while (rs.next()) {
            Object[] obj = new Object[campos.size()];
            for (int i = 0; i < campos.size(); i++)
            {
                Object[] campito = campos.get(i);
                obj[i] = rs.getString(String.valueOf(campito[0]));
            }
            lista.addRow(obj);
        }

        return lista;
    }
    
    /**
     * Método para listar los campos de una tabla de la base de datos
     * @param nombreTabla
     * @return
     * @throws SQLException 
     */
    public DefaultTableModel SelectFromTablaPersonalizado(String nombreTabla, String camposSql) throws SQLException {
        DefaultTableModel lista = new DefaultTableModel();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select "+ camposSql +" from '" + nombreTabla + "'");

        List<Object[]> campos = this.listarCampos(nombreTabla);
        java.lang.Object[] colIdentifiers = new java.lang.Object[campos.size()];
        for(int i = 0; i<campos.size();i++)
        {
            Object[] c = campos.get(i);
            colIdentifiers[i]= c[0].toString();
        };
        lista.setColumnIdentifiers(colIdentifiers);
        while (rs.next()) {
            Object[] obj = new Object[campos.size()];
            for (int i = 0; i < campos.size(); i++)
            {
                Object[] campito = campos.get(i);
                obj[i] = rs.getString(String.valueOf(campito[0]));
            }
            lista.addRow(obj);
        }

        return lista;
    }
}
