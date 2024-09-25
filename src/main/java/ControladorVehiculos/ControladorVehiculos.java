package ControladorVehiculos;

import Modelo.Bicicleta;
import Modelo.Camion;
import Modelo.Coche;
import Modelo.Moto;
import Modelo.Vehiculo;
import static MyApi.MyApi.pedirDoubleEntre;
import static MyApi.MyApi.pedirEnteroEntre;
import static MyApi.MyApi.verificacionTexto;
import java.util.ArrayList;
import java.util.Scanner;

public class ControladorVehiculos {

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        System.out.println("================= MENÚ =================");
        System.out.println("[1.] Añadir nuevo vehículo.");
        System.out.println("[2.] Mostrar flota.");
        System.out.println("[3.] Calcular alquiler.");
        System.out.println("[4.] Eliminar vehículo.");
        System.out.println("[5.] Modificar vehículo.");
        System.out.println("[6.] Salir.");
        opc = pedirEnteroEntre("Opción: ", "Opción no válida.\n", 1, 6);
        System.out.println();
        return opc;
    }

    public static int tiposVehiculo() {
        int opc;
        System.out.println("    -----------------------------");
        System.out.println("    -    vehículo disponibles   -");
        System.out.println("    -----------------------------");
        System.out.println("            |1|- Coche.      ");
        System.out.println("            |2|- Moto.       ");
        System.out.println("            |3|- Bicicleta.  ");
        System.out.println("            |4|- Camión.     ");
        opc = pedirEnteroEntre("\nElige un vehículo: ", "Opción no válida.\n", 1, 4);
        return opc;
    }

    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public static boolean verificacionMatricula(String matricula) {
        if (vehiculos.contains(new Vehiculo(matricula))) {
            System.out.println("Error: Matrícula ya en uso.\n");
            return false;
        } else {
            if (matricula.length() != 7) {
                System.out.println("*Formato no válido, la matrícula debe contener 4 números seguidos de 3 letras*\n");
                return false;
            }

            for (int i = 0; i < matricula.length() - 4; i++) {
                if (!Character.isDigit(matricula.charAt(i))) {
                    System.out.println("*Formato no válido, la matrícula debe contener 4 números seguidos de 3 letras*\n");
                    return false;
                }
            }
            for (int i = 4; i < matricula.length(); i++) {
                if (!Character.isLetter(matricula.charAt(i))) {
                    System.out.println("*Formato no válido, la matrícula debe contener 4 números seguidos de 3 letras*\n");
                    return false;
                }
            }
            return true;
        }
    }

    public static void AñadirVehiculo() {
        Scanner sc = new Scanner(System.in);
        String matricula, color, fabricante, respuesta;
        int cilindrada, plazas;
        boolean electrica = false;
        double PMA;

        switch (tiposVehiculo()) {
            case 1:
                System.out.println("\n<----------- Rellenar atributos del coche ----------->\n");
                do {
                    System.out.print("-> Matrícula del coche (formato: 4 números seguidos de 3 letras): ");
                    matricula = sc.nextLine();
                } while (!verificacionMatricula(matricula));
                plazas = pedirEnteroEntre("\nNº de plazas: ", "No hay un coche con esa cantidad de plazas.", 2, 5);
                color = verificacionTexto("\nColor del coche: ");
                fabricante = verificacionTexto("\nFabricante del coche: ");
                System.out.println();
                System.out.println("\n    >>>> Haz añadido un coche a la flota <<<<\n");
                vehiculos.add(new Coche(plazas, matricula, color, fabricante));
                break;
            //--------------------------------------------------------------------------------------------------------------------------------------
            case 2:
                System.out.println("\n<----------- Rellenar atributos de la moto ----------->\n");
                do {
                    System.out.print("-> Matrícula de la moto (formato: 4 números seguidos de 3 letras): ");
                    matricula = sc.nextLine();
                } while (!verificacionMatricula(matricula));
                cilindrada = pedirEnteroEntre("\nCilindradas de la moto: ", "Por favor, ingrese un valor válido.", 50, 2000);
                color = verificacionTexto("\nColor del coche: ");
                fabricante = verificacionTexto("\nFabricante del coche: ");
                System.out.println();
                System.out.println("\n    >>>> Haz añadido una moto a la flota <<<<\n");
                vehiculos.add(new Moto(cilindrada, matricula, color, fabricante));
                break;
            //--------------------------------------------------------------------------------------------------------------------------------------
            case 3:
                boolean correcto;
                System.out.println("\n<------- Rellenar atributos de la bicicleta ------->\n");
                do {
                    System.out.print("-> Matrícula de la bicicleta (formato: 4 numeros seguidos de 3 letras): ");
                    matricula = sc.nextLine();
                } while (!verificacionMatricula(matricula));
                System.out.println();
                do {
                    System.out.print("¿La bicicleta es eléctrica? [Sí / No]: ");
                    respuesta = sc.nextLine();
                    if (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("sí")) {
                        electrica = true;
                        correcto = true;
                    } else if (respuesta.equalsIgnoreCase("no")) {
                        electrica = false;
                        correcto = true;
                    } else {
                        System.out.println("Opción no válida, responde sí o no.\n");
                        correcto = false;
                    }
                } while (!correcto);
                color = verificacionTexto("\nColor de la bicicleta: ");
                fabricante = verificacionTexto("\nFabricante de la bicicleta: ");
                System.out.println();

                System.out.println("\n    >>>> Haz añadido una bicicleta a la flota <<<<\n");
                vehiculos.add(new Bicicleta(electrica, matricula, color, fabricante));
                break;
            //--------------------------------------------------------------------------------------------------------------------------------------
            case 4:
                System.out.println("\n<---------- Rellenar atributos del camión ---------->\n");
                do {
                    System.out.print("-> Matrícula del camión (formato: 4 numeros seguidos de 3 letras): ");
                    matricula = sc.nextLine();
                } while (!verificacionMatricula(matricula));
                PMA = pedirDoubleEntre("\nIntroduce el PMA del camión: ", "Error: Introduce un número en rango válido.", 0, 10000);
                color = verificacionTexto("\nColor del camión: ");
                fabricante = verificacionTexto("\nFabricante del camión: ");
                System.out.println();
                System.out.println("\n    >>>> Haz añadido un camión a la flota <<<<\n");
                vehiculos.add(new Camion(PMA, matricula, color, fabricante));
                break;
        }
    }

    public static void mostrarFlota() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados en la flota.\n");
        } else {
            for (Vehiculo v : vehiculos) {
                System.out.println(v);
                System.out.println();
            }
        }
    }

    public static void calcularAlquiler() {
        Scanner sc = new Scanner(System.in);
        String matricula;
        int posicion, diasAlquiler;
        boolean correcto = false;
        Vehiculo seleccionado;
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados en la flota.");
            System.out.println();
        } else {
            do {
                System.out.println("\nFlota de vehículos -----------------------------------------");
                mostrarFlota();
                System.out.println("Introduce la mátricula del vehículo para calcular su alquiler: ");
                matricula = sc.nextLine();
                if (vehiculos.contains(new Vehiculo(matricula))) { //Hace equals con un vehículo con esta matrícula
                    posicion = vehiculos.indexOf(new Vehiculo(matricula)); //Nos da la posicion del vehiculo con esa matrícula.
                    seleccionado = vehiculos.get(posicion);
                    seleccionado.precioBase(posicion);

                    diasAlquiler = pedirEnteroEntre("\nIntroduce la cantidad de días de alquiler (max 365): ", "", 0, 365);

                    System.out.println("\nEl precio del alquiler del vehículo es de: " + seleccionado.precioBase(diasAlquiler) + "€.\n");
                    correcto = true;
                } else {
                    System.out.println("Error: No hay un vehículo con esa matrícula.");
                    correcto = false;
                }
            } while (!correcto);
        }
    }

    public static void eliminarVehiculo() {
        Scanner sc = new Scanner(System.in);
        String matricula;
        int posicion;
        Vehiculo v;

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados en la flota.\n");
        } else {
            System.out.println("\nFlota de vehículos -----------------------------------------");
            mostrarFlota();

            System.out.println("Introduce la matrícula del vehículo que deseas eliminar: ");
            matricula = sc.nextLine();
            posicion = vehiculos.indexOf(new Vehiculo(matricula)); //Reaiza un equals nos da la posicion de un vehículo con esa matrícula.
            if (posicion != -1) { // Si el indesOf es diferente a -1 es decir que lo encontró, realizamos el proceso.
                v = vehiculos.get(posicion);
                vehiculos.remove(v);
                System.out.println("\n    >>>> El vehículo ha sido eliminado <<<<\n");
            } else {
                System.out.println("\nNo hay un vehículo con esa matrícula.\n");
            }
        }
    }

    public static void modificarVehiculo() {
        Scanner sc = new Scanner(System.in);
        int posicion;
        String matricula, color, fabricante, respuesta;
        int cilindrada, plazas;
        boolean electrica = false, correcto;
        double PMA;
        Vehiculo v;

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados en la flota.\n");
        } else {
            System.out.println("Flota de vehículos -----------------------------------------");
            mostrarFlota();
            
            System.out.println("\nIntroduce la matrícula del vehículo que deseas modificar: ");
            matricula = sc.nextLine();
            posicion = vehiculos.indexOf(new Vehiculo(matricula));
            if (posicion != -1) {
                v = vehiculos.get(posicion);
                if (v instanceof Coche) {
                    plazas = pedirEnteroEntre("\nNº de plazas: ", "El número de plazas es incorrecto.", 2, 5);
                    ((Coche) v).setPlazas(plazas);
                    color = verificacionTexto("\nColor del coche: ");
                    v.setColor(color);
                    fabricante = verificacionTexto("\nFabricante del coche: ");
                    v.setFabricante(fabricante);
                    System.out.println("\n   >>>> Los atributos del coche han sido modificados <<<<\n");
                } else if (v instanceof Moto) {
                    cilindrada = pedirEnteroEntre("\nCilindradas de la moto (mínimo 20 - máximo 2000): ", "Por favor, ingrese un valor válido.", 50, 2000);
                    ((Moto) v).setCilindrada(cilindrada);
                    color = verificacionTexto("\nColor del coche: ");
                    v.setColor(color);
                    fabricante = verificacionTexto("\nFabricante del coche: ");
                    v.setFabricante(fabricante);
                    System.out.println("\n   >>>> Los atributos de la moto han sido modificados <<<<\n");
                } else if (v instanceof Bicicleta) {
                    do {
                        System.out.print("¿La bicicleta es eléctrica? [Sí / No]: ");
                        respuesta = sc.nextLine();
                        if (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("sí")) {
                            electrica = true;
                            correcto = true;
                        } else if (respuesta.equalsIgnoreCase("no")) {
                            electrica = false;
                            correcto = true;
                        } else {
                            correcto = false;
                        }
                    } while (!correcto);
                    ((Bicicleta) v).setElectrica(electrica);
                    color = verificacionTexto("\nColor de la bicicleta: ");
                    v.setColor(color);
                    fabricante = verificacionTexto("\nFabricante de la bicicleta: ");
                    v.setFabricante(fabricante);
                    System.out.println("\n >>>> Los atributos de la bicicleta han sido modificados <<<<\n");
                } else if (v instanceof Camion) {
                    PMA = pedirDoubleEntre("\nIntroduce el PMA del camión: ", "Error: Introduce un número en rango válido.", 0, 10000);
                    ((Camion) v).setPMA(PMA);
                    color = verificacionTexto("\nColor del camión: ");
                    v.setColor(color);
                    fabricante = verificacionTexto("\nFabricante del camión: ");
                    v.setFabricante(fabricante);
                    System.out.println("\n  >>>> Los atributos del camión han sido modificados <<<<\n");
                }
            } else {
                System.out.println("\nNo hay un coche con esta matricula\n");
            }
        }
    }

}
