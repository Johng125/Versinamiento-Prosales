package Modelo;

//Librerias 
import Control.Conexion;
import static Vista.Productos.TablaProducto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static Vista.CajeroVenta.*;
import static Vista.CajeroFactura.*;
import static Vista.CajeroCliente.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mongodb.client.*;
import java.io.FileOutputStream;
import javax.swing.JTable;
import org.bson.Document;

public class Cajero implements Facturacion{
    //Se instancias los objetos que permiten conectar con la base de datos SQL
    Conexion con = new Conexion();
    MongoClient mongo = con.crearConexion();
    MongoDatabase base = mongo.getDatabase("ProSales");
    
    //Se define una tabla default
    String titulos[]={"ID","Producto","Precio","Cantidad"};
    DefaultTableModel factura=new DefaultTableModel(null, titulos);
    
    //Declaracion de variables publicas
    double precioNeto;
    int ct;
    String nombreCliente;

    // Declaración de variables privadas
    private String idCliente;

    // Registro de cliente
    public void guardarDatos(){
        nombreCliente=txtNombreCliente.getText();
        idCliente=txtCedulaCliente.getText();
    }
    
    //Metodo que genera una factura
    @Override
    public void crearFactura(){
        ct++;
        labelFactura.setText("FACTURA N°"+ct);
        labelCliente.setText(nombreCliente);
        labelCedula.setText(idCliente);
        tablaFacturacion.setModel(factura);
        labelSubtotal.setText(String.valueOf(precioNeto));
        labelIva.setText(String.valueOf(iva*precioNeto));
        labelTotal.setText(String.valueOf(iva*precioNeto+precioNeto));
    }

    //Metodo que guarda la factura en PDF
    @Override
    public void guardarFactura(String ubicacion,JTable table){
        Rectangle dimension = new Rectangle(400,800);
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(dimension);
        System.out.println("Guardado en: "+ubicacion+"\\Factura "+ct+".pdf");
        try{
            PdfWriter.getInstance(document, new FileOutputStream(ubicacion+"\\Factura "+ct+".pdf"));
            document.open();
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            
            document.add(new Paragraph("_______________________________________________"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("FACTURA  N°"+ct));
            document.add(new Paragraph("_______________________________________________"));
            document.add(new Paragraph("Cliente: " + nombreCliente));
            document.add(new Paragraph("Cedula: " + idCliente));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Descripcion:"));
            document.add(new Paragraph(" "));
            // Agregar la fila de títulos del JTable al PDF
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(new Phrase(table.getColumnName(i)));
            }
            // Agregar las celdas del JTable a la tabla PDF
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    pdfTable.addCell(table.getValueAt(i, j).toString());
                }
            }
            // Agregar la tabla PDF al documento
            document.add(pdfTable);
            
            document.add(new Paragraph("_______________________________________________"));
            document.add(new Paragraph("                                                    Subtotal: " + precioNeto + "$"));
            document.add(new Paragraph("                                                    Iva 12%:  " + Math.round(precioNeto * iva*100.0)/100.0 + "$"));
            document.add(new Paragraph("_______________________________________________"));
            document.add(new Paragraph("TOTAL:                                              " +(precioNeto + Math.round(precioNeto * iva*100.0)/100.0)+"$"));
            document.close();
            JOptionPane.showMessageDialog(null, "Factura Guardada");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    //Metodo que muestra los datos en la tabla Producto
    public void mostrarDatosProducto(){
        //Se crea los titulos de la tabla y el nombre de la base de datos
        String titulos[]={"ID","Producto","Precio"};
        String registro[]=new String [3];
        DefaultTableModel modelo=new DefaultTableModel(null, titulos);
        MongoCollection<Document> coleccion = base.getCollection("Producto");
        MongoCursor<Document> cursor = coleccion.find().iterator();
        
        while(cursor.hasNext()){
            Document dato = cursor.next();
            registro[0]=dato.get("ID").toString();
            registro[1]=dato.get("Producto").toString();
            registro[2]=dato.get("Precio").toString();
            modelo.addRow(registro);
        }
        TablaProducto.setModel(modelo);
    }
    
    //Metodo que agrega datos de producto a la base de datos NoSQL
    public void agregarProducto(){
        try{
            String registro[]=new String [4];
            Document ProductoBuscado=new Document("Producto",txtProductoFact.getText());
            MongoCollection<Document> coleccion = base.getCollection("Producto");
            MongoCursor<Document> cursor = coleccion.find(ProductoBuscado).iterator();
            Document rs = cursor.next();
            registro[0]=rs.getString("ID");
            registro[1]=rs.getString("Producto");
            registro[2]=rs.getString("Precio");
            registro[3]=txtCantidadFact.getText();
            factura.addRow(registro);
            TablaFactura.setModel(factura);
            precioNeto+=Double.valueOf(txtCantidadFact.getText())*Double.valueOf(rs.getString("Precio"));
            txtPrecio.setText(String.valueOf(precioNeto));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se encontro el producto");
        }
            
    }
    
    //Metodo que inserta datos del clientes a la base de datos Cliente
    public void insertarDatosCliente(){
        MongoCollection<Document> coleccion = base.getCollection("Cliente");
        Document documento = new Document();
        documento.put("Nombre",nombreCliente);
        documento.put("Cedula",idCliente);
        coleccion.insertOne(documento);
    }
}