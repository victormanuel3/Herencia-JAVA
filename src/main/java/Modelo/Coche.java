package Modelo;

public class Coche extends Vehiculo {
    
    private int plazas;

    public Coche(int plazas, String matricula, String color, String fabricante) {
        super(matricula, color, fabricante);
        this.plazas = plazas;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    @Override
    public double precioBase(int dias) {
        return super.precioBase(dias) + (getPlazas() * 1.5); 
    }
    
    @Override
    public String toString() {
        return "Coche: " + super.toString() + " - Nº plazas: " + plazas;
    }
      
}
