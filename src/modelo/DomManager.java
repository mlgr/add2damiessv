package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * @author Mª Luz García Rodríguez
 * @author Luis Massó
 * @date 20-oct-2014 -- @time 11:41:24
 */
public class DomManager
{

    //Attributes
    private Document dom;

    //Constructors
    public DomManager()
    {
        dom = null;
    }

    /**
     * Method to create a DOM tree calling a addColection method
     *
     * @param motoManager
     * @param fileName
     * @throws ParserConfigurationException
     */
    public void CreateDom(MotoManager motoManager, String fileName)
            throws ParserConfigurationException
    {
        dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        // create root element asigning a name
        Element colection = dom.createElement("coleccion");
        addColection(motoManager.getColection(), colection);

        // add root (colection) to dom
        dom.appendChild(colection);

        toFile(fileName);
    }

    /**
     * Method to create a tree of nodes, reading all motos of array. Call
     * AddMoto() method.
     *
     * @param coleccion
     * @param nodoColeccion
     */
    private void addColection(ArrayList<Moto> coleccion, Element nodoColeccion)
    {
        for (Moto moto : coleccion)                        //crossover the collection
        {
            Element nodeMoto = dom.createElement("moto");  //create a type element var
            nodeMoto = AddMoto(moto, nodeMoto);            //add data fields to node
            nodoColeccion.appendChild(nodeMoto);           //append to father node
        }
    }

    /**
     * Method to create a node with moto attributes Added child nodes to Element
     * type parameter
     *
     * @param moto
     * @param nodeMoto
     * @return Element nodeMoto
     */
    private Element AddMoto(Moto moto, Element nodeMoto)
    {
        Element marca = dom.createElement("marca");
        Text marcaT = dom.createTextNode(moto.getMarca());
        marca.appendChild(marcaT);

        Element modelo = dom.createElement("modelo");
        Text modeloT = dom.createTextNode(moto.getModelo());
        modelo.appendChild(modeloT);

        Element cilindrada = dom.createElement("cilindrada");
        Text cilindradaT = dom.createTextNode(String.valueOf(moto.getCilindrada()));
        cilindrada.appendChild(cilindradaT);

        Element potencia = dom.createElement("potencia");
        Text potenciaT = dom.createTextNode(String.valueOf(moto.getPotencia()));
        potencia.appendChild(potenciaT);

        Element cilindros = dom.createElement("cilindros");
        Text cilindrosT = dom.createTextNode(String.valueOf(moto.getCilindros()));
        cilindros.appendChild(cilindrosT);

        Element refrigeracion = dom.createElement("refrigeracion");
        Text refrigeracionT = dom.createTextNode(moto.getRefrigeracion());
        refrigeracion.appendChild(refrigeracionT);

        Element precio = dom.createElement("precio");
        Text precioT = dom.createTextNode(String.valueOf(moto.getPrecio()));
        precio.appendChild(precioT);

        Element imagen = dom.createElement("imagen");
        Text imagenT = dom.createTextNode(moto.getImagen());
        imagen.appendChild(imagenT);

        nodeMoto.appendChild(marca);
        nodeMoto.appendChild(modelo);
        nodeMoto.appendChild(cilindrada);
        nodeMoto.appendChild(potencia);
        nodeMoto.appendChild(cilindros);
        nodeMoto.appendChild(refrigeracion);
        nodeMoto.appendChild(precio);
        nodeMoto.appendChild(imagen);

        return nodeMoto;
    }

    /**
     * Write into text file the XML tree
     *
     * @param sw
     * @param fileName
     */
    private void write(StringWriter sw, String fileName)
    {
        try
        {
            //create file to write 
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));

            // write whole tree on XML file
            writer.println(sw.toString());

            writer.close();   // close file
        } catch (Exception e)
        {
        }
    }

    /**
     * Prepare dom to write on file Transform the tree, adding the header and
     * tabs
     *
     * @param ruta
     */
    private void toFile(String fileName)
    {
        try
        {
            // create the transformer object
            TransformerFactory transFact = TransformerFactory.newInstance();

            // add tabs to tree
            transFact.setAttribute("indent-number", 3);
            Transformer trans = transFact.newTransformer();
            // include XML header and tabs
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            // make the transform
            StringWriter sw = new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource domSource = new DOMSource(dom);
            trans.transform(domSource, sr);

            // call method to write the file
            write(sw, fileName);
        } catch (IllegalArgumentException | TransformerException ex)
        {
        }
    }

    /**
     * Method to open a XML DOM
     *
     * @param fileName
     * @param dom
     * @return
     */
    private Document openXmlDom(String fileName, Document dom)
    {
        File file = new File(fileName);

        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setIgnoringComments(true);                  // to avoid comments on xml file         
            dbf.setIgnoringElementContentWhitespace(true);  //to avoid blank spaces on xml file

            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(file);
            dom.getDocumentElement().normalize();  //to avoid trucked lines

        } catch (ParserConfigurationException | SAXException | IOException e)
        {
        }
        return dom;
    }

    /**
     * Method to read a XML file and return an arrayList<Moto>
     *
     * @param fileName
     */
    public ArrayList<Moto> XMLtoArray(String fileName)
    {
        ArrayList<Moto> auxColection = new ArrayList<>();
        File file = new File(fileName);

        dom = openXmlDom(fileName, dom);

        // get root element
        Element root = dom.getDocumentElement();

        // seleccionamos todos las motos y vamos leyendo
        NodeList listaNodos = root.getElementsByTagName("moto");

        for (int i = 0; i < listaNodos.getLength(); i++)
        {
            Node nodeMoto = listaNodos.item(i);
            auxColection.add(readMoto(nodeMoto));
        }
        return auxColection;
    }

    /**
     * Method to convert a node (nodoMoto) into an object(Moto)
     *
     * @param nodeMoto
     * @return variable of type Moto
     */
    private Moto readMoto(Node nodeMoto)
    {
        String auxS;

        Element elementMoto = (Element) nodeMoto;
        Moto auxMoto = new Moto();

        auxS = elementMoto.getElementsByTagName("marca").item(0).getTextContent();
        auxMoto.setMarca(auxS);

        auxS = elementMoto.getElementsByTagName("modelo").item(0).getTextContent();
        auxMoto.setModelo(auxS);

        auxS = elementMoto.getElementsByTagName("cilindrada").item(0).getTextContent();
        auxMoto.setCilindrada(Integer.parseInt(auxS));

        auxS = elementMoto.getElementsByTagName("potencia").item(0).getTextContent();
        auxMoto.setPotencia(Double.parseDouble(auxS));

        auxS = elementMoto.getElementsByTagName("cilindros").item(0).getTextContent();
        auxMoto.setCilindros(Integer.parseInt(auxS));

        auxS = elementMoto.getElementsByTagName("refrigeracion").item(0).getTextContent();
        auxMoto.setRefrigeracion(auxS);

        auxS = elementMoto.getElementsByTagName("precio").item(0).getTextContent();
        auxMoto.setPrecio(Double.parseDouble(auxS));

        auxS = elementMoto.getElementsByTagName("imagen").item(0).getTextContent();
        auxMoto.setImagen(auxS);

        return auxMoto;
    }
}
