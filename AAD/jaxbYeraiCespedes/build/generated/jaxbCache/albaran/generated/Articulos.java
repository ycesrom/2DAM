//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.5 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.11.15 a las 02:16:31 PM CET 
//


package generated;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Articulos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Articulos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articulo" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="nombreProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="cantidad"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                         &lt;maxExclusive value="100"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *                   &lt;element ref="{}comentario" minOccurs="0"/&gt;
 *                   &lt;element name="fechaEnvio" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="codigo" use="required" type="{}PER" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Articulos", propOrder = {
    "articulo"
})
public class Articulos {

    @XmlElement(required = true)
    protected List<Articulos.Articulo> articulo;

    /**
     * Gets the value of the articulo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articulo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticulo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Articulos.Articulo }
     * 
     * 
     */
    public List<Articulos.Articulo> getArticulo() {
        if (articulo == null) {
            articulo = new ArrayList<Articulos.Articulo>();
        }
        return this.articulo;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="nombreProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="cantidad"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *               &lt;maxExclusive value="100"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
     *         &lt;element ref="{}comentario" minOccurs="0"/&gt;
     *         &lt;element name="fechaEnvio" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="codigo" use="required" type="{}PER" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nombreProducto",
        "cantidad",
        "precio",
        "comentario",
        "fechaEnvio"
    })
    public static class Articulo {

        @XmlElement(required = true)
        protected String nombreProducto;
        protected int cantidad;
        @XmlElement(required = true)
        protected BigDecimal precio;
        protected String comentario;
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fechaEnvio;
        @XmlAttribute(name = "codigo", required = true)
        protected String codigo;

        /**
         * Obtiene el valor de la propiedad nombreProducto.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombreProducto() {
            return nombreProducto;
        }

        /**
         * Define el valor de la propiedad nombreProducto.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombreProducto(String value) {
            this.nombreProducto = value;
        }

        /**
         * Obtiene el valor de la propiedad cantidad.
         * 
         */
        public int getCantidad() {
            return cantidad;
        }

        /**
         * Define el valor de la propiedad cantidad.
         * 
         */
        public void setCantidad(int value) {
            this.cantidad = value;
        }

        /**
         * Obtiene el valor de la propiedad precio.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPrecio() {
            return precio;
        }

        /**
         * Define el valor de la propiedad precio.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPrecio(BigDecimal value) {
            this.precio = value;
        }

        /**
         * Obtiene el valor de la propiedad comentario.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComentario() {
            return comentario;
        }

        /**
         * Define el valor de la propiedad comentario.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComentario(String value) {
            this.comentario = value;
        }

        /**
         * Obtiene el valor de la propiedad fechaEnvio.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFechaEnvio() {
            return fechaEnvio;
        }

        /**
         * Define el valor de la propiedad fechaEnvio.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFechaEnvio(XMLGregorianCalendar value) {
            this.fechaEnvio = value;
        }

        /**
         * Obtiene el valor de la propiedad codigo.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodigo() {
            return codigo;
        }

        /**
         * Define el valor de la propiedad codigo.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodigo(String value) {
            this.codigo = value;
        }

    }

}
