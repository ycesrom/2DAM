//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.5 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.11.15 a las 02:16:31 PM CET 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para PedidoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PedidoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="facturarA" type="{}Direccion"/&gt;
 *         &lt;element ref="{}comentario" minOccurs="0"/&gt;
 *         &lt;element name="articulos" type="{}Articulos"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="fechaPedido" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PedidoType", propOrder = {
    "facturarA",
    "comentario",
    "articulos"
})
public class PedidoType {

    @XmlElement(required = true)
    protected Direccion facturarA;
    protected String comentario;
    @XmlElement(required = true)
    protected Articulos articulos;
    @XmlAttribute(name = "fechaPedido")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaPedido;

    /**
     * Obtiene el valor de la propiedad facturarA.
     * 
     * @return
     *     possible object is
     *     {@link Direccion }
     *     
     */
    public Direccion getFacturarA() {
        return facturarA;
    }

    /**
     * Define el valor de la propiedad facturarA.
     * 
     * @param value
     *     allowed object is
     *     {@link Direccion }
     *     
     */
    public void setFacturarA(Direccion value) {
        this.facturarA = value;
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
     * Obtiene el valor de la propiedad articulos.
     * 
     * @return
     *     possible object is
     *     {@link Articulos }
     *     
     */
    public Articulos getArticulos() {
        return articulos;
    }

    /**
     * Define el valor de la propiedad articulos.
     * 
     * @param value
     *     allowed object is
     *     {@link Articulos }
     *     
     */
    public void setArticulos(Articulos value) {
        this.articulos = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPedido.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPedido() {
        return fechaPedido;
    }

    /**
     * Define el valor de la propiedad fechaPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPedido(XMLGregorianCalendar value) {
        this.fechaPedido = value;
    }

}
