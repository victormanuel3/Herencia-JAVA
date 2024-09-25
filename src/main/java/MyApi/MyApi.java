package MyApi;

import java.util.Scanner;

public class MyApi {

    public static int pedirEnteroEntre(String texto, String alerta, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int valor;
        do {
            try {
                System.out.print(texto);
                valor = sc.nextInt();
                if (valor < min || valor > max) {
                    System.out.println(alerta);
                }
            } catch (java.util.InputMismatchException ex) {
                System.out.println("Dato sin conversión.");
                valor = min - 1;
                sc.nextLine();
            }
        } while (valor < min || valor > max);

        return valor;
    }
    
        public static double pedirDoubleEntre(String texto, String alerta, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double valor;
        do {
            try {
                System.out.print(texto);
                valor = sc.nextDouble();
                if (valor < min || valor > max) {
                    System.out.println(alerta);
                }
            } catch (java.util.InputMismatchException ex) {
                System.out.println("Dato sin conversión.");
                valor = min - 1;
                sc.nextLine();
            }
        } while (valor < min || valor > max);

        return valor;
    }
    
    public static double pedirEnteroMayorA(String texto, String alerta, int min) {
        Scanner sc = new Scanner(System.in);
        double valor;
        do {
            try {
                System.out.print(texto);
                valor = sc.nextDouble();
                if (valor < min) {
                    System.out.println(alerta);
                }
            } catch (java.util.InputMismatchException ex) {
                System.out.println("Dato sin conversión.");
                valor = min - 1;
                sc.nextLine();
            }
        } while (valor < min);

        return valor;
    }

    public static String contieneNumero(String texto, String alerta) {
        Scanner sc = new Scanner(System.in);
        char letra;
        boolean contieneNumero;
        String dato = "";

        do {
            System.out.print(texto);
            dato = sc.nextLine();
            contieneNumero = false;
            for (int i = 0; i < dato.length(); i++) {
                letra = dato.charAt(i);
                if (letra >= '0' && letra <= '9') {
                    contieneNumero = true;
                    break;
                }
            }
            if (contieneNumero) {
                System.out.println(alerta);
            }
        } while (contieneNumero);

        return dato;
    }

    public static int validarDato(String texto, String alerta) {
        Scanner sc = new Scanner(System.in);
        int ID = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(texto);
                ID = sc.nextInt();
                correcto = true;
            } catch (java.util.InputMismatchException ex) {
                System.out.println(alerta);
                sc.nextLine();
            }
        }
        return ID;
    }

    public static String verificacionTexto(String texto) {
        Scanner sc = new Scanner(System.in);
        char letra;
        String dato = "";
        boolean correcto;
        
        do {
            correcto = true;
            System.out.print(texto);
            dato = sc.nextLine();
            if (dato.isBlank()) {
                System.out.println("No puedes dejar el campo vacío.");
                correcto = false;
            } else {
                for (int i = 0; i < dato.length(); i++) {
                    letra = dato.charAt(i);
                    if (letra >= '0' && letra <= '9') {
                        System.out.println("Error: no puedes introducir números.");
                        correcto = false;
                        break;
                    }
                }     
            }
        } while (!correcto);
        return dato;
    }
    
    public static boolean YesNo(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int valor;
        boolean respuesta = false;
        do {
            try {
                System.out.println("[1]: SI / [2]: NO");
                valor = sc.nextInt();
                if (valor < min || valor > max) {
                    System.out.println("Valor incorrecto ");
                }
                if (valor == 1) {
                    respuesta = true;
                }
                if (valor == 2) {
                    break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Dato sin conversión");
                valor = min - 1;
                sc.nextLine();
            }
        } while (valor < min || valor > max);
 
        return respuesta;
    }
}
