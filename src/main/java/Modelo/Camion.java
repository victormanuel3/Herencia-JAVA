package Modelo;

public class Camion extends Vehiculo {
    
    private double PMA;

    public Camion(double PMA, String matricula, String color, String fabricante) {
        super(matricula, color, fabricante);
        this.PMA = PMA;
    }

    public double getPMA() {
        return PMA;
    }

    public void setPMA(double PMA) {
        this.PMA = PMA;
    }

    @Override
    public double precioBase(int dias) {
        return super.precioBase(dias) + (20 * getPMA()); 
    }

    @Override
    public String toString() {
        return "Camión: " + super.toString() + " - PMA: " + PMA;
    } 

}
