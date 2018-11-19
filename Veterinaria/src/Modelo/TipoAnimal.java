
package Modelo;


public class TipoAnimal {
    private int id;
    private String tipoAnimal;
    private String descripcion; 
    
    public TipoAnimal(int id, String tipoAnimal, String descripcion){
        this.id = id;
        this.tipoAnimal = tipoAnimal;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
