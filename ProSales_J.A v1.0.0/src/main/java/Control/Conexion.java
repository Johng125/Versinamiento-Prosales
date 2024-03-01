package Control;

//Se importa las librerias a utilizar
import com.mongodb.client.*;
import com.mongodb.client.MongoClients;
import javax.swing.JOptionPane;

public class Conexion {
    //Url de que contiene la direccion y autentificacion del mongo Atlas
    private String connectionString="mongodb+srv://johngalarza1970:RztSpDg2Tgs7ULVV@cluster0.zjdlkp3.mongodb.net/";
    
    //Metodo que devuelve un MongoClient conectada a la base de datos
    public MongoClient crearConexion(){
        try{
            MongoClient mongo=MongoClients.create(connectionString);
            System.out.println("Se realizo la conexion con Mongo Atlas");
            return mongo;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Fallo la conexion con la base de datos");
        }
        return null;
    }
}