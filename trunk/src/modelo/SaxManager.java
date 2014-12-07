package modelo;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Clase para manejar los archivos xml con SAX
 * @author Mª Luz García Rodríguez
 * @author Luis Massó
 * @date 29-oct-2014 -- @time 9:47:17
 */
public class SaxManager extends DefaultHandler
{
    private SAXParser parser;
    private File fl;
    private File ficheroXML;
    int ultimoElemento;
    String cadena_resultado;

    /**
     * Constructor
     * @param fileName 
     */
    public SaxManager(String fileName)
    {
        ultimoElemento = 0;
        cadena_resultado = "";
        fl = new File(fileName);
        crear_XML_SAX();
    }

    /**
     * Método para crear el documento SAX
     * @return 
     */
    private int crear_XML_SAX()
    {
        try
        {
            SAXParserFactory factory = SAXParserFactory.newInstance();

            //Create a SAXParser object to read the XML document
            parser = factory.newSAXParser();
            ficheroXML = fl;
            return 0;
        } catch (ParserConfigurationException | SAXException e)
        {
            return -1;
        }
    }

    /**
     * Se da la salida al parser para que comience a manejar el documento XML
     * que se le pasa como parámetro con el manejador que también se le pasa.
     * Esto recorrera secuencialmente el documento XML y cuando detecte un
     * comienzo o fin de elemento o un texto entonces lo tratará (según la
     * implementación hecha del manejador)
     */
    public String recorrerSAXyMostrar()
    {
        try
        {
            parser.parse(ficheroXML, this);
            return this.cadena_resultado;
        } catch (SAXException | IOException e)
        {
            return "Error al parsear con SAX" + e.getMessage();
            // return "Error en la lectura de archivos";
        }
    }

    /**
     * A continuación se sobrecargan los eventos de la clase DafaultHandler para
     * recuperar el documento XML. En la implementación de estos eventos se
     * indica qué se hace cuando se encuentre el comienzo de un
     * elemento(startElement), el final de un elemento (endElement) y caracteres
     * texto (characters) Este handler detecta el comienzo de un elemento, final
     * y cadenas string (texto)
     *
     * @param uri.
     * @param localName
     * @param qName
     * @param atts
     * @throws org.xml.sax.SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException
    {
        switch (qName)
        {
            case "marca":
                ultimoElemento = 1;
                cadena_resultado = cadena_resultado + "Marca: ";
                break;
            case "modelo":
                ultimoElemento = 2;
                cadena_resultado = cadena_resultado + "Modelo: ";
                break;
            case "cilindrada":
                ultimoElemento = 3;
                cadena_resultado = cadena_resultado + "Cilindrada: ";
                break;
            case "potencia":
                ultimoElemento = 4;
                cadena_resultado = cadena_resultado + "Potencia: ";
                break;
            case "cilindros":
                ultimoElemento = 5;
                cadena_resultado = cadena_resultado + "Cilindros: ";
                break;
            case "refrigeracion":
                ultimoElemento = 6;
                cadena_resultado = cadena_resultado + "Refrigeracion: ";
                break;
            case "precio":
                ultimoElemento = 7;
                cadena_resultado = cadena_resultado + "Precio: ";
                break;
            case "imagen":
                ultimoElemento = 8;
                cadena_resultado = cadena_resultado + "Imagen: ";
                break;
        }
    }

    /**
     * When end of element <moto> is detected, writes a dotted line
     *
     * @param uri
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (qName.equals("moto"))
        {
            cadena_resultado = cadena_resultado + "\n  --------------------------------\n";
        }
    }

    /**
     * Cuando se detecta una cadena de texto posterior a uno de los elementos
     * <marca>, <modelo>, <cilindrada>, <potencia>, <cilindros> o <refrigeracion> 
     * entonces guarda ese texto en la variable correspondiente.
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
       if (ultimoElemento >= 1 && ultimoElemento <= 6)
        {
            for (int i = start; i < length + start; i++)
            {
                cadena_resultado = cadena_resultado + ch[i];
            }
        }
    }
}
