package Modelo;

import Control.Conexion;
import static Vista.AdminClient.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static Vista.AdminProducto.*;
import com.mongodb.client.*;
import javax.swing.JTable;
import org.bson.Document;

public class Sistema {
    Conexion con = new Conexion();
    MongoClient mongo = con.crearConexion();
    MongoDatabase base = mongo.getDatabase("ProSales");
    
    //Metodo que permite mostrar los datos de los productos dentro de la tabla producto
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
    
    //Metodo que permite mostrar los datos de los clientes dentro de la tabla cliente
    public void mostrarDatosCliente(){
        //Se crea los titulos de la tabla y el nombre de la base de datos
        String titulos[]={"Nombre","Cedula","Total Gastado"};
        String registro[]=new String [3];
        DefaultTableModel modelo=new DefaultTableModel(null, titulos);
        MongoCollection<Document> coleccion = base.getCollection("Cliente");
        MongoCursor<Document> cursor = coleccion.find().iterator();
        
        while(cursor.hasNext()){
            Document dato = cursor.next();
            registro[0]=dato.get("Nombre").toString();
            registro[1]=dato.get("Cedula").toString();
            registro[2]=dato.get("Total Gastado").toString();
            modelo.addRow(registro);
        }
        TablaCliente.setModel(modelo);
    }
        
    //Metodo que inserta datos dentro de la base de datos NoSQL
    public void insertarDatosProducto(){
        MongoCollection<Document> coleccion = base.getCollection("Producto");
        Document documento = new Document();
        documento.put("Producto",txtProducto.getText());
        documento.put("Precio",txtPrecio.getText());
        coleccion.insertOne(documento);
    }
    
    //Metodo que elimina los datos dentro de la base de datos NoSQL Productos
    public void eliminarDatosProducto(){
        int fila=TablaProducto.getSelectedRow();
        String ID = TablaProducto.getValueAt(fila, 0).toString();
        String Producto = TablaProducto.getValueAt(fila, 1).toString();
        String Precio = TablaProducto.getValueAt(fila, 2).toString();
        
        MongoCollection<Document> coleccion = base.getCollection("Producto");
        Document antiguo = new Document();
        antiguo.append("ID",ID).append("Producto", Producto).append("Precio", Precio);
        coleccion.deleteOne(antiguo);
    }
    
    
    //Metodo que elmina los datos dentro de la base de datos SQL Cliente
    public void eliminarDatosCliente(){
        int fila=TablaCliente.getSelectedRow();
        String Nombre = TablaCliente.getValueAt(fila, 0).toString();
        String Cedula = TablaCliente.getValueAt(fila, 1).toString();
        String Total = TablaCliente.getValueAt(fila, 2).toString();
        
        MongoCollection<Document> coleccion = base.getCollection("Cliente");
        Document antiguo = new Document();
        antiguo.append("Nombre",Nombre).append("Cedula", Cedula).append("Total Gastado", Total);
        coleccion.deleteOne(antiguo);
    }
    
    //Metodo que actualiza los datos de la base de datos Producto
    public void actualizarDatosProducto(){
        int fila = TablaProducto.getSelectedRow();
        String ID = TablaProducto.getValueAt(fila, 0).toString();
        String Producto = TablaProducto.getValueAt(fila, 1).toString();
        String Precio = TablaProducto.getValueAt(fila, 2).toString();
        
        MongoCollection<Document> coleccion = base.getCollection("Producto");
        Document antiguo = new Document();
        antiguo.append("Producto", Producto).append("Precio", Precio);
        Document nuevo = new Document();
        nuevo.append("Producto", txtProducto.getText()).append("Precio", txtPrecio.getText());
        coleccion.updateOne(antiguo, nuevo);
    }
    
    //Metodo que busca datos dentro de una tabla
    public void buscarDatos(JTable tabla, String dato){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int fila = modelo.getRowCount();
        int columna = modelo.getColumnCount();
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                Object celda = modelo.getValueAt(i, j);
                if (celda != null && celda.toString().contains(dato)) {
                    tabla.setRowSelectionInterval(i, i);
                    tabla.scrollRectToVisible(tabla.getCellRect(i, j, true));
                    return;
                }
            }
        }
         JOptionPane.showMessageDialog(null, "No se encontro");
    }
}
