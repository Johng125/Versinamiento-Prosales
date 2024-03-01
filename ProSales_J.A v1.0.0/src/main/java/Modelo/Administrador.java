package Modelo;

import static Vista.AdminProducto.*;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Administrador extends Sistema{
    
    //Sobreescritura 
    @Override
    public void insertarDatosProducto(){
        MongoCollection<Document> coleccion = base.getCollection("Producto");
        Document documento = new Document();
        documento.put("Producto",txtProducto.getText());
        documento.put("Precio",txtPrecio.getText());
        coleccion.insertOne(documento);
    }
}
