package Vista;

/**
 * @author Flores
 */
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    
    public void menuPrincipal(){
          System.out.println("\t.::MENU PRINCIPAL::.");
          System.out.println("1. Registro");
          System.out.println("2. Adopcion");
          System.out.println("3. Busquedas");
          System.out.println("4. Salir");
    }
    public void menuRegistro(){
        espacio();
        System.out.println(".::REGISTROS::.");
        menuObjetos();
    }
    public void menuBusqueda(){
        espacio();
        System.out.println(".::BUSQUEDAS::.");
        menuObjetos();
    }
    public void menuObjetos(){
          System.out.println("1. Tipo de animal");
          System.out.println("2. Raza");
          System.out.println("3. Mascotas");
          System.out.println("4. Clientes");
          System.out.println("5. Regresar al menu principal");
    }
    public void subRegistro(){
        espacio();
        System.out.println("\t.::ACCION::.");
          System.out.println("1. Alta");
          System.out.println("2. Baja");
          System.out.println("3. Cambio");
          System.out.println("4. Regresar al menu principal");
    }
    public void menuBusquedaTipo(){
        espacio();
        System.out.println(".::FILTRAR::.");
          System.out.println("1. Todos");
          System.out.println("2. Regresar al menu principal");
    }
    public void menuBusquedaRaza(){
        espacio();
        System.out.println(".::FILTRAR::.");
          System.out.println("1. Todos");
          System.out.println("2. Tipo de animal");
          System.out.println("3. Regresar al menu principal");
    }
    public void menuBusquedaMascotas(){
        espacio();
        System.out.println(".::FILTRAR::.");
          System.out.println("1. Todos");
          System.out.println("2. Tipo de animal");
          System.out.println("3. Raza");
          System.out.println("4. Id");
          System.out.println("5. Nombre");
          System.out.println("6. Estatus");
          System.out.println("7. Regresar al menu principal");
    }
    public void menuBusquedaClientes(){
        espacio();
        System.out.println(".::FILTRAR::.");
          System.out.println("1. Todos");
          System.out.println("2. Id");
          System.out.println("3. Nombre");
          System.out.println("4. Regresar al menu principal");
    }
    public  String opcion(){
          System.out.print("Opcion: ");
        return scan.nextLine();
    }
    public void espacio(){
        for(int i=0;i<15;i++)
            System.out.println("");
    }
    
    public String pedirId(){
        System.out.print("Id: ");
        return scan.nextLine();
    }
    public String pedirNombre(){
        System.out.print("Nombre: ");
        return scan.nextLine();
    }
    public String pedirTipo(){
        System.out.print("Tipo de animal: ");
        return scan.nextLine();
    }
    public String pedirEstatus(){
        System.out.print("Estatus: ");
        return scan.nextLine();
    }
    public String pedirRaza(){
        System.out.print("Raza: ");
        return scan.nextLine();
    }
    
    
}
