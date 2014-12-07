package modelo;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @author Mª Luz García Rodríguez
 * @author Luis Massó
 * @date 17-oct-2014 -- @time 0:53:36
 */
public class Moto implements Serializable
{

    /**
     * Attributes
     */
    private String marca;
    private String modelo;
    private int cilindrada;
    private double potencia;
    private int cilindros;
    private String refrigeracion;
    private double precio;
    private String imagen;

    /**
     * @return the marca
     */
    public String getMarca()
    {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo()
    {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    /**
     * @return the cilindrada
     */
    public int getCilindrada()
    {
        return cilindrada;
    }

    /**
     * @param cilindrada the cilindrada to set
     */
    public void setCilindrada(int cilindrada)
    {
        this.cilindrada = cilindrada;
    }

    /**
     * @return the potencia
     */
    public double getPotencia()
    {
        return potencia;
    }

    /**
     * @param potencia the potencia to set
     */
    public void setPotencia(double potencia)
    {
        this.potencia = potencia;
    }

    /**
     * @return the cilindros
     */
    public int getCilindros()
    {
        return cilindros;
    }

    /**
     * @param cilindros the cilindros to set
     */
    public void setCilindros(int cilindros)
    {
        this.cilindros = cilindros;
    }

    /**
     * @return the refrigeracion
     */
    public String getRefrigeracion()
    {
        return refrigeracion;
    }

    /**
     * @param refrigeracion the refrigeracion to set
     */
    public void setRefrigeracion(String refrigeracion)
    {
        this.refrigeracion = refrigeracion;
    }

    /**
     * @return the precio
     */
    public double getPrecio()
    {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    /**
     * @return the imagen
     */
    public String getImagen()
    {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen)
    {
        this.imagen = imagen;
    }

    /**
     * Constructor without parameters
     */
    public Moto()
    {
        this.marca = "";
        this.modelo = "";
        this.cilindrada = 0;
        this.potencia = 0;
        this.cilindros = 0;
        this.refrigeracion = "";
        this.precio = 0;
        this.imagen = "";
    }

    /**
     * Constructor with parameters
     *
     * @param Marca
     * @param Modelo
     * @param cilindrada
     * @param potencia
     * @param cilindros
     * @param refrigeracion
     * @param precio
     * @param imagen
     */
    public Moto(String Marca, String Modelo, int cilindrada, double potencia,
            int cilindros, String refrigeracion, double precio, String imagen)
    {
        this.marca = Marca;
        this.modelo = Modelo;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.cilindros = cilindros;
        this.refrigeracion = refrigeracion;
        this.precio = precio;
        this.imagen = imagen;
    }

    /**
     * Overrided method to return a data string
     *
     * @return
     */
    @Override
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("#.##");

        return "Moto{" + "Marca=" + marca + ", Modelo=" + modelo
                + ", cilindrada=" + cilindrada + ", potencia=" + df.format(potencia)
                + ", cilindros=" + cilindros + ", refrigeracion=" + refrigeracion
                + ", precio=" + precio + ", imagen=" + imagen + '}';
    }

   

}
