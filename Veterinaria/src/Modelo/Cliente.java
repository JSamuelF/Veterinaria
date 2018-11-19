
package Modelo;

import Vista.vista;
import java.util.Scanner;

public class Cliente implements vista{
    private int id;
    private String nombre;
    private int edad;
    private String sexo;
    private String fecha;
    private String direccion;
    private int idContador;
    
    Scanner read = new Scanner(System.in);
        public Cliente(int id, String nombre, int edad, String sexo, String fecha, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.fecha = fecha;
        this.direccion = direccion;
    }
    
    Cliente(){}
       @Override
    public Object Registro(){ 
        String string;
        
        id=idContador++;
        System.out.print("Nombre de Empledo: ");
        nombre=read.nextLine();
        System.out.print("Edad: ");
        string = read.nextLine();
        edad= Integer.parseInt(string);
        System.out.print("Sexo: ");
        sexo=read.nextLine();  
        System.out.print("Direccion: ");
        direccion=read.nextLine();
        System.out.print("Fecha de Nacimiento: ");
        fecha=read.nextLine();
        
        return new Cliente(id,nombre,edad,sexo,direccion,fecha);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
 
}
