package Modelo;

public class Bicicleta extends Vehiculo {
    private boolean electrica;

    public Bicicleta(boolean electrica, String matricula, String color, String fabricante) {
        super(matricula, color, fabricante);
        this.electrica = electrica;
    }

    public boolean isElectrica() {
        return electrica;
    }

    public void setElectrica(boolean electrica) {
        this.electrica = electrica;
    }

    @Override
    public double precioBase(int dias) {
        double aumento;
        if (!isElectrica()) {
            aumento = 10;
        } else {
            aumento = 15;
        }
        return super.precioBase(dias) + aumento;
    }
    
    @Override
    public String toString() {
        return "Bicicleta: " + super.toString() + " - eléctrica: " + (electrica ? "Sí" : "No");
    }

}
