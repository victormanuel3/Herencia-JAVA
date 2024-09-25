package Modelo;

public class Moto extends Vehiculo {

    private int cilindrada;

    public Moto(int cilindrada, String matricula, String color, String fabricante) {
        super(matricula, color, fabricante);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public double precioBase(int dias) {
        return super.precioBase(dias) + (0.05 * getCilindrada()); 
    }
    
    @Override
    public String toString() {
        return "Moto: " + super.toString() + " - cilindrada: " + cilindrada;
    }
}
