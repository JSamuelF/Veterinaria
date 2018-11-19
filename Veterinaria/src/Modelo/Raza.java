
package Modelo;

/**
 *
 * @author Flores
 */
public class Raza {
    private int id;
    private int tipoAnimal;
    private String raza;
    private String descripcion;
    
    public Raza(int id, int tipoAnimal, String raza, String descripcion){
        this.id = id;
        this.tipoAnimal = tipoAnimal;
        this.raza = raza;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(int tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
