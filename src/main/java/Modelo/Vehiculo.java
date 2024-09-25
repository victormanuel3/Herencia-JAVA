package Modelo;

import java.util.Objects;

public class Vehiculo {

    final private String matricula;
    private String color;
    private String fabricante;
    

    public Vehiculo(String matricula, String color, String fabricante) {
        this.matricula = matricula;
        this.color = color;
        this.fabricante = fabricante;
    }

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }
    

/*GETTERS AND SETTERS-----------------------------------------------------*/
    public String getMatricula() {
        return matricula;
    }
// -------------------------------------------------------------------------
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
// -------------------------------------------------------------------------
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFabricante() {
        return fabricante;
    }
// -------------------------------------------------------------------------  

    public double precioBase(int dias) {
        return dias * 50;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return other.matricula.equals(this.matricula);
    }

    @Override
    public String toString() {
        return " matricula: " + matricula + " - fabricante: " +fabricante + " - color: " + color; 
    }
    
    
    
    
    
}
