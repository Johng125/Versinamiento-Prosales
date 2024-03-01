package ProSales;

public class ProSales {

    public static void main(String[] args) {
        Menu menu = new Menu(); // Crea la instancia menu de la clase Menu
        menu.clean();  // Limpia la pantalla
        // Presentacion del proyecto
        System.out.println("=======Universidad de las Fuerzas Armadas ESPE=======");
        System.out.println("          Programacion Orientada a Objetos");
        System.out.println("====================ProSales J.A.====================");
        System.out.println("Integrantes: John Galarza,  Franco Joseph, Andres Pantoja, Andy Laglaguano.");
        System.out.println("Grupo: 1.");
        menu.esperar(6);
        menu.clean(); 
        menu.logo();
        menu.menu_Cuenta();
        System.out.println(".....Cerrando"); 
        menu.esperar(3);
        System.out.println("Hasta pronto....."); 
        menu.logo();
    }
}
