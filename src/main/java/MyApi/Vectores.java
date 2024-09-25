package MyApi;

public class Vectores {

    public static boolean isEmpty(Object obj[]) {
        boolean vacio = false;
        int contador = 0;
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] == null) {
                contador++;
            }
            if (contador == obj.length) {
                vacio = true;
                break;
            }
        }
        return vacio;
    }

}
