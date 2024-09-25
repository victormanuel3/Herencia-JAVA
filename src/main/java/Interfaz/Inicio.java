package Interfaz;

import static ControladorVehiculos.ControladorVehiculos.AñadirVehiculo;
import static ControladorVehiculos.ControladorVehiculos.calcularAlquiler;
import static ControladorVehiculos.ControladorVehiculos.eliminarVehiculo;
import static ControladorVehiculos.ControladorVehiculos.menu;
import static ControladorVehiculos.ControladorVehiculos.modificarVehiculo;
import static ControladorVehiculos.ControladorVehiculos.mostrarFlota;

public class Inicio {
    public static void main(String[] args) {
        boolean exit = false;
        int opc = 0;
        
        while (!exit) {
            opc = menu();
            switch (opc) {             
                case 1: AñadirVehiculo();
                    break;
                    
                case 2: mostrarFlota();
                    break;
                    
                case 3: calcularAlquiler();
                    break;
                
                case 4: eliminarVehiculo();
                    break;
                
                case 5: modificarVehiculo();
                    break;
                
                case 6: 
                    System.out.println(">> Haz salido de la aplicación, hasta luego. :) <<");
                    exit = true;
                    break;                          
            }
        }
    }
}
