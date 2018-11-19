/*
 */
package Controlador;

/**
    @author Samuel
 */
import Vista.Menu;

public class Controlador {
    
    private Menu menu = new Menu();
    private String opcion;
    
/*     Central muestra el menú principal y pide la opcion para llamar
        las funciones correspondientes                                              */
    public void central(){
        int op;
        do{
            menu.menuPrincipal();
            opcion = menu.opcion();

            try{
                op = Integer.parseInt(opcion);
            }catch(NumberFormatException e1){
                System.out.println("ERROR");
                op = 0;
            }
            switch(op){
                case 1:{ registro(); break; }
                case 2:{  adopcion(); break;  }
                case 3:{ busqueda(); break; }
                case 4:{ System.out.println("Terminar"); }
            }
            if(op!=4)
                    menu.espacio();
        }while(op!=4);
    }
    
    
    public void registro(){
        //op: El objeto que elige para registrar(Tipo animal, Raza, Mascota, Cliente)
        int op;
        //Muestra las opciones de registro
        menu.menuRegistro();
        opcion = menu.opcion(); //Pide la opción
        op = Integer.parseInt(opcion);
       
        if(op<5){
            switch (op) {
                case 1:{ accionRegistro("TipoAnimal"); break;}
                case 2:{ accionRegistro("Raza"); break;}
                case 3:{ accionRegistro("Mascota"); break;}
                case 4:{ accionRegistro("Cliente");  break; }
            }//switch
        }//if
    }
    private void busqueda(){
        int op;
        menu.menuBusqueda();
        opcion= menu.opcion();
        op= Integer.parseInt(opcion);
        switch(op){
            case 1: {  busquedaTipoAnimal(); break;}
            case 2: { busquedaRaza(); break;}
            case 3: { busquedaMascotas(); break;}
            case 4: { busquedaClientes(); break;}
        }
    }
    public void accionRegistro(String objetoNombre){
        //op: Lo que desea hacer con el objeto( Alta, Baja, Cambio)
        int op;
        menu.subRegistro(); //Muestra las opciones
        opcion = menu.opcion();
        op = Integer.parseInt(opcion);
        /* En el paquete modelo debemos hacer una clase que con recibir el nombre de la clase como string, haga un switch
        para cada caso y haga la acción que se elija según el objeto                                                                                           */
        if(op<4)
            switch(op){
                case 1:{ /*modelo.alta(objetoNombre) */  break;}
                case 2:{ /*modelo.baja(objetoNombre) */  break;}
                case 3:{ /*modelo.cambio(objetoNombre) */  break;}
            }
    }
    private void adopcion(){ /*Modelo.adopcion();*/ }
    
    private void busquedaTipoAnimal(){ /*Función que muestre todos*/}
    
    private void busquedaRaza(){
            int op;
            menu.menuBusquedaRaza();
            opcion = menu.opcion();
            op = Integer.parseInt(opcion);
            switch(op){
                case 1: {/*Todos*/ break;}
                case 2:{ /*Tipo de animal*/ break;}
            }
    }
    private void busquedaMascotas(){
            int op;
            menu.menuBusquedaMascotas();
            opcion = menu.opcion();
            op = Integer.parseInt(opcion);
            switch(op){
                case 1: {/*Todos*/ break;}
                case 2:{ /*Pedir Tipo de animal*/ break;}
                case 3: {/*Pedir Raza*/ break;}
                case 4:{ /*Pedir Id*/ break;}
                case 5: {/*Pedir Nombre*/ break;}
                case 6:{ /*Estatus*/ break;}
            }
    }
     private void busquedaClientes(){
            int op;
            menu.menuBusquedaClientes();
            opcion = menu.opcion();
            op = Integer.parseInt(opcion);
            switch(op){
                case 1: {/*Todos*/ break;}
                case 2:{ /*Pedir Tipo de animal*/ break;}
                case 3: {/*Pedir Nombre*/ break;}
            }
    }
       
}