///**
// * Clase usada inicialmente para hacer pruebas en consola. No se utiliza actualmente
// */


//package modelo;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.TransformerException;
//
///**
// * 
// * @author Mª Luz García Rodríguez
// * @author Luis Massó Saiz -- 2º DAM
// */
//public class Principal
//{
//
//    /**
//     * @param args the command line arguments
//     */
//
//        ArrayList<Moto> exposicion = new ArrayList<>();
//
//        exposicion.add(new Moto("Honda", "CBR 1000 RR Fireblade", 1000, 178.2, 4, "Liquida", 16119, "honda1100rr.jpeg"));
//        exposicion.add(new Moto("Honda", "MSX 125", 125, 9.8, 1, "Aire", 3699, "hondamsx125.jpeg"));
//        exposicion.add(new Moto("Honda", "CRF 250X", 249, 29.8, 1, "Liquida", 7839, "hondacrf250x.jpeg"));
//        exposicion.add(new Moto("Honda", "CRF  50F", 49, 3, 1, "Aire", 2129, "hondacrf50f.jpeg"));
//        exposicion.add(new Moto("Honda", "VT 750 S", 745, 44, 2, "Liquida", 7489, "hondavt750s.jpeg"));
//        exposicion.add(new Moto("Yamaha", "X enter 125 Moto Gp", 125, 12.2, 1, "Liquida", 3179, "yamahaxenter125motogp.jpeg"));
//        exposicion.add(new Moto("Yamaha", "X Max 250", 250, 20.4, 1, "Liquida", 4999, "yamahaxmax250.jpeg"));
//        exposicion.add(new Moto("Yamaha", "XJ6 Diversion F ABS", 600, 77.5, 4, "Liquida", 8799, "yamahaxj6diversionfabs.jpeg"));
//        exposicion.add(new Moto("Yamaha", "YBR 125", 124, 10, 1, "Aire", 2619, "yamahaybr125.jpeg"));
//        exposicion.add(new Moto("Yamaha", "XT 660 X", 660, 48, 1, "Liquida", 7199, "yamahaxt660x.jpeg"));
//        exposicion.add(new Moto("Triumph", "Daytona 675", 675, 131, 3, "Liquida", 10695, "triumphdaytona675.jpeg"));
//        exposicion.add(new Moto("Triumph", "Spring GT", 1050, 128, 3, "Liquida", 13695, "triumphspringgt.jpeg"));
//        exposicion.add(new Moto("Triumph", "Bonneville SE", 865, 67, 2, "Aire", 8995, "triumphbonnevillese.jpeg"));
//        exposicion.add(new Moto("Triumph", "Bonneville T100 Especial Edition", 865, 68, 2, "Aire", 9865, "triumphbonnevillet100ee.jpeg"));
//        exposicion.add(new Moto("Triumph", "Street Triple R ABS", 675, 106, 3, "Liquida", 8695, "triumphstreettriplerabs.jpeg"));
//        exposicion.add(new Moto("Harley Davidson", "Dyna Street Bob", 1584, 0, 2, "Aire", 14850, "harleydynastreetbob.jpeg"));
//        exposicion.add(new Moto("Harley Davidson", "Dyna Wide Glide", 1585, 0, 2, "Aire", 17600, "dynawideglide.jpeg"));
//        exposicion.add(new Moto("Harley Davidson", "Sportster Seventy-Two", 1202, 0, 2, "Aire", 12400, "sportsterseventytwo.jpeg"));
//        exposicion.add(new Moto("Harley Davidson", "Sportster Superlow 1200T", 1203, 67, 2, "Aire", 12750, "sportstersuperlow1200t.jpeg"));
//        exposicion.add(new Moto("Harley Davidson", "VRSC V-Rod Muscle", 1246, 112, 2, "Liquida", 20250, "vrscvrodmuscle.jpeg"));
//        exposicion.add(new Moto("Moto Guzzi", "Norge 850", 850, 72.1, 2, "Aire", 12030, "guzzinorge850.jpeg"));
//        exposicion.add(new Moto("Moto Guzzi", "Breva 750", 744, 48.3, 2, "Aire", 7990, "guzzibreva750.jpeg"));
//        exposicion.add(new Moto("Moto Guzzi", "V7 Cafe Classic", 744, 48.8, 2, "Aire", 0, "guzziv7cafeclassic.jpeg"));
//        exposicion.add(new Moto("Moto Guzzi", "Stelvio 1200 NTX", 1151, 102, 2, "Aire", 14990, "guzzistelvio1200ntx.jpeg"));
//        exposicion.add(new Moto("Moto Guzzi", "V7 Clubman Racer", 744, 48.8, 2, "Aire", 9890, "v7clubmanracer.jpeg"));
//
//        // Show on screen the array
//        System.out.println("     COLECCION DE MOTOS. Salida directa");
//        System.out.println("--------------------------------------------------");
//        Iterator it = exposicion.iterator();
//        while (it.hasNext())
//        {
//            System.out.println(it.next().toString());
//
//        }
//        System.out.println("****************************************************\n");
//        // Show on screen the text file
//
//        // Show on screen the binary file
//        MotoManager myManager = new MotoManager(exposicion);
//
//        myManager.writeTextFile("Motos.txt");
//
//        System.out.println("     COLECCION DE MOTOS. Fichero de Texto");
//        System.out.println("--------------------------------------------------");
//        myManager.readTextFile("Motos.txt");
//        myManager.showColection();
//        System.out.println("****************************************************\n");
//        
//        //Show on screen the xml file
//        System.out.println("     COLECCION DE MOTOS. Fichero XML");
//        System.out.println("--------------------------------------------------");
//
//        myManager.writeXML("MotosDom.xml");
//
//        myManager.ReadXML("MotosDom.xml");
//        System.out.println(myManager.toString());
//
//        System.out.println("****************************************************\n");
//
//         MotosSax.xml
//        //Show on screen as Android variable string
//        System.out.println("     COLECCION DE MOTOS. Android String");
//        System.out.println("--------------------------------------------------");
//
//        myManager.toAndroidString();
//
//        System.out.println("****************************************************\n");
//    }
//
//}
