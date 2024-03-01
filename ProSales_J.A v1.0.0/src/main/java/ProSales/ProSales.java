package ProSales;

//Se importa el formulario menu del paquete vista
//para poder mostrarlo al momento de ejecutar
import Vista.Menu;

public class ProSales {

    public static void main(String[] args) {
        //Se crea un objeto del formulario menu
        Menu menu = new Menu();
        //Se habilita la visibilidad del formulario
        menu.setVisible(true);
    }
}
