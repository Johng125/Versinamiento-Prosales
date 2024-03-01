package Modelo;

import javax.swing.JTable;

public interface Facturacion {
    //Constante del iva en Ecuador 2023
    double iva = 0.12;
    //Metodos que obligatoriamente seran declarados en donde se implementen
    public void crearFactura();
    public void guardarFactura(String ubicacion,JTable table);
}
