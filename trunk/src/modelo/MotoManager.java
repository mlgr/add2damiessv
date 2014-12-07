package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

/**
 * @author Mª Luz García Rodríguez
 * @author Luis Massó
 * @date 17-oct-2014 -- @time 1:09:08
 */
public class MotoManager {

    // Attributos
    private ArrayList<Moto> colection;

    /**
     * @return the colection
     */
    public ArrayList<Moto> getColection() {
        return colection;
    }

    /**
     * Constructor
     */
    public MotoManager() {
        this.colection = new ArrayList<Moto>();
        this.readTextFile("Motos.txt");
    }

//    /**
//     * Overrided method toString
//     */
//    @Override
//    public String toString()
//    {
//        String cadena = "";
//
//        for (Moto moto : this.colection)
//        {
//            cadena = cadena + moto.toString() + "\n";
//        }
//        return cadena;
//
//    }
        
    /**
     * Metodo para mostrar toda la coleccion de motos
     * @return 
     */
    public String showColection() {
        String cadena = "";
        Iterator it = this.colection.iterator();
        while (it.hasNext()) {
            cadena += it.next().toString() + "\n";
        }

        return cadena;
    }
    
    /**
     * Metodo para leer un archivo binario con los datos de las motos
     * @param fileName
     * @throws IOException 
     */
    public void readBinaryFile(String fileName) throws IOException {
        colection.clear();
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            ObjectInputStream reader = new ObjectInputStream(inputStream);

            colection = (ArrayList<Moto>) reader.readObject();

            reader.close();
            inputStream.close();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Error leyendo el archivo");
        }
    }

    /**
     * Metodo para guardar los datos del array en un archivo binario
     * @param fileName
     * @throws IOException 
     */
    public void writeBinaryFile(String fileName) throws IOException {
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream writer = new ObjectOutputStream(outputStream);

            writer.writeObject(this.colection);

            writer.close();
            outputStream.close();
        } catch (Exception ex) {
            throw new IOException("Error escribiendo el archivo");
        }
    }

    /**
     * Metodo para leer los datos del array de un archivo de texto
     * @param fileName 
     */
    public void readTextFile(String fileName) {
        String linea;
        this.colection.clear();

        try {
            FileReader fichero = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fichero);

            while ((linea = reader.readLine()) != null) {
                Moto moto = new Moto();
                moto.setMarca(linea);
                moto.setModelo(reader.readLine());
                moto.setCilindrada(Integer.parseInt(reader.readLine()));
                moto.setPotencia(Float.parseFloat(reader.readLine()));
                moto.setCilindros(Integer.parseInt(reader.readLine()));
                moto.setRefrigeracion(reader.readLine());
                moto.setPrecio(Float.parseFloat(reader.readLine()));
                moto.setImagen(reader.readLine());

                colection.add(moto);
            }
            reader.close();
            fichero.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encontró el fichero");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Algo fue mal al leer o cerrar el fichero");
        }
    }

    /**
     * Metodo para mostrar los datos de un archivo de texto
     * @param fileName
     * @return 
     */
    public String showTextFile(String fileName) {
        String linea;
        String cadena = "";

        try {
            FileReader fichero = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fichero);

            while ((linea = reader.readLine()) != null) {
                cadena += linea + "\n";
            }
            reader.close();
            fichero.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encontró el fichero");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Algo fue mal al leer o cerrar el fichero");
        }

        return cadena;
    }

    /**
     * Metodo para guardar los datos del array en un archivo de texto
     * @param fileName 
     */
    public void writeTextFile(String fileName) {
        try {
            FileWriter fichero = new FileWriter(fileName);
            BufferedWriter buffer = new BufferedWriter(fichero);
            PrintWriter writer = new PrintWriter(buffer);

            for (Moto elemento : colection) {
                writer.println(elemento.getMarca());
                writer.println(elemento.getModelo());
                writer.println(elemento.getCilindrada());
                writer.println(elemento.getPotencia());
                writer.println(elemento.getCilindros());
                writer.println(elemento.getRefrigeracion());
                writer.println(elemento.getPrecio());
                writer.println(elemento.getImagen());
            }
            writer.close();
            buffer.close();
            fichero.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error en la escritura del fichero");
        }
    }

    /**
     * Metodo para crear y escribir un documento XML document con DOM
     *
     * @param filename
     * @throws ParserConfigurationException
     */
    public void writeXML(String filename) throws ParserConfigurationException {
        DomManager mydom = new DomManager();

        mydom.CreateDom(this, filename);
    }

    /**
     * Metodo para leer un fichero Xml
     *
     * @param fileName
     */
    public void ReadXML(String fileName) {
        DomManager mydom = new DomManager();

        this.colection.clear();  //initialize the array
        colection = mydom.XMLtoArray(fileName);
    }

    /**
     * Metodo para mostrar un fichero Xml
     *
     * @param fileName
     */
    public String showXML(String fileName) {
        DomManager mydom = new DomManager();

        this.colection.clear();  //initialize the array
        colection = mydom.XMLtoArray(fileName);

        return this.showColection();
    }

    /**
     * Metodo para leer un archivo xml con SAX
     *
     * @param fileName
     */
    public String ReadXML_Sax(String fileName) {
        String cadena;

        // Recharge colection with DOM
        this.ReadXML(fileName);
        // show on textArea file with SAX

        SaxManager mySax = new SaxManager(fileName);
        cadena = mySax.recorrerSAXyMostrar();

        return cadena;
    }
    
    /**
     * Metodo que añade una moto a la coleccion
     * @param m 
     */
    public void Add (Moto m) {
        colection.add(m);
    }
}
