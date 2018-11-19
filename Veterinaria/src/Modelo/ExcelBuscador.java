
package Modelo;

//Librerias para el excel
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBuscador {
    //Regresa la longitud de la hoja (mas 1)
    public static int obtenerLongitud(String objeto) throws IOException{
        int n;
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("IDs");
        XSSFRow row = sheet.getRow(1);
        
        switch(objeto){
            case "TipoAnimal":
                n=0;
                break;
            case "Mascotas":
                n=1;
                break;
            case "Clientes":
                n=2;
                break;
            case "Razas":
                n=3;
                break;
            default:
                book.close();
                return -1;
        }
        
        XSSFCell cell = row.getCell(n);
        
        int longitud = (int) cell.getNumericCellValue();
        
        book.close();
        
        return longitud;
    }
    
    //Tipo Animal
    
    public static TipoAnimal buscarTipoAnimalID(int ID) throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("TipoAnimal");
        if(longitud==-1)
            return null;
        
        int id = 0;
        String tipo = null, descripcion = null;
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("TipoAnimal");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            cell = row.getCell(0);
            id = (int) cell.getNumericCellValue();
            
            if(ID == id){
                cell = row.getCell(0);
                id = (int) cell.getNumericCellValue();
                cell = row.getCell(1);
                tipo = cell.getStringCellValue();
                cell = row.getCell(3);
                descripcion = cell.getStringCellValue();
            }
        }
        
        book.close();
        
        if(i==longitud)
            return null;
        
        return (new TipoAnimal(id, tipo, descripcion));
    }
    
    public static LinkedList buscarTipoAnimalTodos() throws IOException{
        int longitud;
        longitud = obtenerLongitud("TipoAnimal");
        if(longitud==-1)
            return null;
        
        LinkedList<TipoAnimal> listaTipo = new LinkedList<>();
        
        int id = 0;
        String tipo = null, descripcion = null;
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("TipoAnimal");
        XSSFRow row;
        XSSFCell cell;
        
        for(int i=1; i<longitud; i++){
            row = sheet.getRow(i);
            
            cell = row.getCell(0);
            id = (int) cell.getNumericCellValue();
            cell = row.getCell(1);
            tipo = cell.getStringCellValue();
            cell = row.getCell(3);
            descripcion = cell.getStringCellValue();
            listaTipo.add((new TipoAnimal(id,tipo,descripcion)));
        }
        
        book.close();
        
        return listaTipo;
    }
    
    //Raza
    public static Raza buscarRazaID(int ID) throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("Razas");
        if(longitud==-1)
            return null;
        
        int id = 0, tipo =0 ;
        String descripcion = null, raza = null;
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Razas");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            cell = row.getCell(0);
            id = (int) cell.getNumericCellValue();
            if(ID == (int) cell.getNumericCellValue()){
                cell = row.getCell(0);
                id = (int) cell.getNumericCellValue();
                cell = row.getCell(1);
                tipo = (int) cell.getNumericCellValue();
                cell = row.getCell(2);
                raza = cell.getStringCellValue();
                cell = row.getCell(3);
                descripcion = cell.getStringCellValue();
            }
        }
        
        book.close();
        
        if(i==longitud)
            return null;
        
        return (new Raza(id, tipo, raza, descripcion));
    }
    
    public static LinkedList buscarRazaTipoAnimal(int IDt) throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("Razas");
        if(longitud==-1)
            return null;
        
        LinkedList<Raza> listaRaza = new LinkedList<>();
        
        int id = 0, tipo =0;
        String descripcion = null, raza = null;
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Razas");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            cell = row.getCell(1);
            tipo = (int) cell.getNumericCellValue();
            
            if(IDt == tipo){
                cell = row.getCell(0);
                id = (int) cell.getNumericCellValue();
                cell = row.getCell(1);
                tipo = (int) cell.getNumericCellValue();
                cell = row.getCell(2);
                raza = cell.getStringCellValue();
                cell = row.getCell(3);
                descripcion = cell.getStringCellValue();
                
                listaRaza.add((new Raza(id,tipo,raza,descripcion)));
            }
        }
        
        book.close();
        
        return listaRaza;
    }
    
    public static LinkedList buscarRazaTodos() throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("Razas");
        if(longitud==-1)
            return null;
        
        LinkedList<Raza> listaRaza = new LinkedList<>();
        
        int id = 0, tipo =0 ;
        String descripcion = null, raza = null;
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Razas");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            
            cell = row.getCell(0);
            id = (int) cell.getNumericCellValue();
            cell = row.getCell(1);
            tipo = (int) cell.getNumericCellValue();
            cell = row.getCell(2);
            raza = cell.getStringCellValue();
            cell = row.getCell(3);
            descripcion = cell.getStringCellValue();
            
            listaRaza.add((new Raza(id,tipo,raza,descripcion)));
        }
        
        book.close();
        
        return listaRaza;
    }
    
    //Cliente
    public static Cliente buscarClienteID(int ID) throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("Clientes");
        if(longitud==-1)
            return null;
        
        int id = 0, edad =0 ;
        String nombre = null, domicilio = null, fecha = null, sexo = null;
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Clientes");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            cell = row.getCell(0);
            id = (int) cell.getNumericCellValue();
            
            if(ID == id){
                cell = row.getCell(0);
                id = (int) cell.getNumericCellValue();
                cell = row.getCell(1);
                nombre = cell.getStringCellValue();
                cell = row.getCell(2);
                edad= (int) cell.getNumericCellValue();
                cell = row.getCell(3);
                domicilio = cell.getStringCellValue();
                cell = row.getCell(4);
                fecha = cell.getStringCellValue();
                cell = row.getCell(5);
                sexo = cell.getStringCellValue();
            }
        }
        
        book.close();
        
        if(i==longitud)
            return null;
        
        return (new Cliente(id, nombre, edad, sexo, fecha, domicilio));
    }
    
    public static Cliente buscarClienteNombre(String name) throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("Clientes");
        if(longitud==-1)
            return null;
        
        int id = 0, edad =0 ;
        String nombre = null, domicilio = null, fecha = null, sexo = null;
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Clientes");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            cell = row.getCell(1);
            nombre = cell.getStringCellValue();
            
            if(name.equals(nombre)){
                cell = row.getCell(0);
                id = (int) cell.getNumericCellValue();
                cell = row.getCell(1);
                nombre = cell.getStringCellValue();
                cell = row.getCell(2);
                edad= (int) cell.getNumericCellValue();
                cell = row.getCell(3);
                domicilio = cell.getStringCellValue();
                cell = row.getCell(4);
                fecha = cell.getStringCellValue();
                cell = row.getCell(5);
                sexo = cell.getStringCellValue();
            }
        }
        
        book.close();
        
        if(i==longitud)
            return null;
        
        return (new Cliente(id, nombre, edad, sexo, fecha, domicilio));
    }
    
    public static LinkedList buscarClienteTodos() throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("Clientes");
        if(longitud==-1)
            return null;
        
        int id = 0, edad =0 ;
        String nombre = null, domicilio = null, fecha = null, sexo = null;
        
        LinkedList<Cliente> listaClientes = new LinkedList<>();
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Clientes");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            
            cell = row.getCell(0);
            id = (int) cell.getNumericCellValue();
            cell = row.getCell(1);
            nombre = cell.getStringCellValue();
            cell = row.getCell(2);
            edad= (int) cell.getNumericCellValue();
            cell = row.getCell(3);
            domicilio = cell.getStringCellValue();
            cell = row.getCell(4);
            fecha = cell.getStringCellValue();
            cell = row.getCell(5);
            sexo = cell.getStringCellValue();
            
            listaClientes.add((new Cliente(id, nombre, edad, sexo, fecha, domicilio)));
        }
        
        book.close();
        
        
        
        return listaClientes;
    }
    
    //Mascotas
    public static Mascota buscarMascotaID(int ID) throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("Mascotas");
        if(longitud==-1)
            return null;
        
        int id = 0, edad =0 , raza = 0;
        String nombre = null, fecha = null;
        boolean estatus = false;
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Mascotas");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            cell = row.getCell(0);
            id = (int) cell.getNumericCellValue();
            
            if(ID == id){
                cell = row.getCell(0);
                id = (int) cell.getNumericCellValue();
                cell = row.getCell(1);
                raza = (int) cell.getNumericCellValue();
                cell = row.getCell(2);
                nombre = cell.getStringCellValue();
                cell = row.getCell(3);
                edad = (int) cell.getNumericCellValue();
                cell = row.getCell(4);
                fecha = cell.getStringCellValue();
                cell = row.getCell(5);
                estatus = cell.getBooleanCellValue();
            }
        }
        
        book.close();
        
        if(i==longitud)
            return null;
        
        return (new Mascota(id, raza, edad, nombre, fecha, estatus));
    }
    
    public static Mascota buscarMascotaNombre(String name) throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("Mascotas");
        if(longitud==-1)
            return null;
        
        int id = 0, edad =0 , raza = 0;
        String nombre = null, fecha = null;
        boolean estatus = false;
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Mascotas");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            cell = row.getCell(2);
            nombre = cell.getStringCellValue();
            
            if(name.equals(nombre)){
                cell = row.getCell(0);
                id = (int) cell.getNumericCellValue();
                cell = row.getCell(1);
                raza = (int) cell.getNumericCellValue();
                cell = row.getCell(2);
                nombre = cell.getStringCellValue();
                cell = row.getCell(3);
                edad = (int) cell.getNumericCellValue();
                cell = row.getCell(4);
                fecha = cell.getStringCellValue();
                cell = row.getCell(5);
                estatus = cell.getBooleanCellValue();
            }
        }
        
        book.close();
        
        if(i==longitud)
            return null;
        
        return (new Mascota(id, raza, edad, nombre, fecha, estatus));
    }
    
    public static LinkedList buscarMascotaTipoAnimal(int IDt) throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("Mascotas");
        if(longitud==-1)
            return null;
        
        int id = 0, edad =0 , raza = 0;
        String nombre = null, fecha = null;
        boolean estatus = false;
        int idTipo = 0;
        
        LinkedList<Mascota> listaMascotas = new LinkedList<>();
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Mascotas");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            cell = row.getCell(1);
            raza = (int) cell.getNumericCellValue();
            
            idTipo = buscarRazaID(raza).getTipoAnimal();
            
            if(IDt == idTipo){
                cell = row.getCell(0);
                id = (int) cell.getNumericCellValue();
                cell = row.getCell(1);
                raza = (int) cell.getNumericCellValue();
                cell = row.getCell(2);
                nombre = cell.getStringCellValue();
                cell = row.getCell(3);
                edad = (int) cell.getNumericCellValue();
                cell = row.getCell(4);
                fecha = cell.getStringCellValue();
                cell = row.getCell(5);
                estatus = cell.getBooleanCellValue();
                
                listaMascotas.add((new Mascota(id, raza, edad, nombre, fecha, estatus)));
            }
        }
        
        book.close();
        
        
        
        return listaMascotas;
    }
    
    public static LinkedList buscarMascotaRaza(int IDr) throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("Mascotas");
        if(longitud==-1)
            return null;
        
        int id = 0, edad =0 , raza = 0;
        String nombre = null, fecha = null;
        boolean estatus = false;
        
        LinkedList<Mascota> listaMascotas = new LinkedList<>();
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Mascotas");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            cell = row.getCell(1);
            if(IDr == (int) cell.getNumericCellValue()){
                cell = row.getCell(0);
                id = (int) cell.getNumericCellValue();
                cell = row.getCell(1);
                raza = (int) cell.getNumericCellValue();
                cell = row.getCell(2);
                nombre = cell.getStringCellValue();
                cell = row.getCell(3);
                edad = (int) cell.getNumericCellValue();
                cell = row.getCell(4);
                fecha = cell.getStringCellValue();
                cell = row.getCell(5);
                estatus = cell.getBooleanCellValue();
                
                listaMascotas.add((new Mascota(id, raza, edad, nombre, fecha, estatus)));
            }
        }
        
        book.close();
        
        
        
        return listaMascotas;
    }
    
    public static LinkedList buscarMascotaEstatus(boolean stat) throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("Mascotas");
        if(longitud==-1)
            return null;
        
        int id = 0, edad =0 , raza = 0;
        String nombre = null, fecha = null;
        boolean estatus = false;
        
        LinkedList<Mascota> listaMascotas = new LinkedList<>();
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Mascotas");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            cell = row.getCell(5);
            estatus = cell.getBooleanCellValue();
            if(stat == estatus){
                cell = row.getCell(0);
                id = (int) cell.getNumericCellValue();
                cell = row.getCell(1);
                raza = (int) cell.getNumericCellValue();
                cell = row.getCell(2);
                nombre = cell.getStringCellValue();
                cell = row.getCell(3);
                edad = (int) cell.getNumericCellValue();
                cell = row.getCell(4);
                fecha = cell.getStringCellValue();
                cell = row.getCell(5);
                estatus = cell.getBooleanCellValue();
                
                listaMascotas.add((new Mascota(id, raza, edad, nombre, fecha, estatus)));
            }
        }
        
        book.close();
        
        
        
        return listaMascotas;
    }
    
    public static LinkedList buscarMascotaTodos() throws IOException{
        int longitud, i;
        longitud = obtenerLongitud("Mascotas");
        if(longitud==-1)
            return null;
        
        int id = 0, edad =0 , raza = 0;
        String nombre = null, fecha = null;
        boolean estatus = false;
        
        LinkedList<Mascota> listaMascotas = new LinkedList<>();
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Mascotas");
        XSSFRow row;
        XSSFCell cell;
        
        for(i=1; i<longitud; i++){
            row = sheet.getRow(i);
            
            cell = row.getCell(0);
            id = (int) cell.getNumericCellValue();
            cell = row.getCell(1);
            raza = (int) cell.getNumericCellValue();
            cell = row.getCell(2);
            nombre = cell.getStringCellValue();
            cell = row.getCell(3);
            edad = (int) cell.getNumericCellValue();
            cell = row.getCell(4);
            fecha = cell.getStringCellValue();
            cell = row.getCell(5);
            estatus = cell.getBooleanCellValue();
               
            listaMascotas.add((new Mascota(id, raza, edad, nombre, fecha, estatus)));
        }
        
        book.close();
        
        
        
        return listaMascotas;
    }
}
