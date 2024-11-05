package jaxb;

import generated.PedidoType;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Jaxb {

    public static void main(String[] args) {
        try {
            // Crear el contexto JAXB basado en la clase raíz generada PedidoType
            JAXBContext context = JAXBContext.newInstance(PedidoType.class);
            // Crear el unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // Leer el archivo XML
            File file = new File("C:\\Users\\Yerai\\Documents\\2DAM\\AAD\\jaxb\\src\\jaxb\\jaxbXml.xml");

            // Hacer el unmarshalling del archivo XML a un objeto PedidoType
            PedidoType pedido = (PedidoType) unmarshaller.unmarshal(file);

            // Imprimir los datos leídos del XML
            System.out.println("Fecha del pedido: " + pedido.getFechaPedido());
            System.out.println("Nombre del cliente: " + pedido.getFacturarA().getNombre());
            System.out.println("Calle: " + pedido.getFacturarA().getCalle());

        } catch (JAXBException e) {
            System.err.println("Error durante el unmarshalling del archivo XML:");
            e.printStackTrace();
        }
    }
}
