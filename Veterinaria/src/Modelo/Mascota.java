
package Modelo;

public class Mascota {
    private int id;
    private int raza;
    private int edad;
    private String nombre;
    private String fecha;
    private boolean estatus;
    
    public Mascota(int id, int raza, int edad, String nombre, String fecha, boolean estatus){
        this.id = id;
        this.raza = raza;
        this.edad = edad;
        this.nombre = nombre;
        this.fecha = fecha;
        this.estatus = estatus;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaza() {
        return raza;
    }

    public void setRaza(int raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
    
}
