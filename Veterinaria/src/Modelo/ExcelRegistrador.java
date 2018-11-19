
package Modelo;

//Librerias para el excel
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelRegistrador {
    //Metodo para obtener la id y aumentarla en 1 para el siguiente registro
    private static int obtenerIDYAumentar(String objeto) throws IOException{
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
        
        int ID = (int) cell.getNumericCellValue();
        cell.setCellValue(ID+1);
        
        FileOutputStream out = new FileOutputStream("Veterinaria.xlsx");
        book.write(out);
        book.close();
        
        return ID;
    }
    
    public static void registrarTipoAnimal(TipoAnimal tipo) throws IOException{
        int longitud, ID;
        ID = obtenerIDYAumentar("TipoAnimal");
        if(ID==-1)
            return;
        longitud = ID+1;
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("TipoAnimal");
        XSSFRow row = sheet.createRow(longitud);
        
        XSSFCell cell = row.createCell(0);
        cell.setCellValue(ID);
        cell = row.createCell(1);
        cell.setCellValue(tipo.getTipoAnimal());
        cell = row.createCell(2);
        cell.setCellValue(tipo.getDescripcion());
          
        
        FileOutputStream out = new FileOutputStream("Veterinaria.xlsx");
        book.write(out);
        book.close();
    }
    
    public static void registrarRaza(Raza raza) throws IOException{
        int longitud, ID;
        ID = obtenerIDYAumentar("Razas");
        if(ID==-1)
            return;
        longitud = ExcelBuscador.obtenerLongitud("Razas");
        
        
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Razas");
        XSSFRow row = sheet.createRow(longitud);
        
        XSSFCell cell = row.createCell(0);
        cell.setCellValue(ID);
        cell = row.createCell(1);
        cell.setCellValue(raza.getTipoAnimal());
        cell = row.createCell(2);
        cell.setCellValue(raza.getRaza());
        cell = row.createCell(3);
        cell.setCellValue(raza.getDescripcion());
          
        
        FileOutputStream out = new FileOutputStream("Veterinaria.xlsx");
        book.write(out);
        book.close();
    }
    
    public static void registrarCliente(Cliente cliente) throws IOException{
        int longitud, ID;
        ID = obtenerIDYAumentar("Clientes");
        if(ID==-1)
            return;
        longitud = ExcelBuscador.obtenerLongitud("Clientes");
        
        
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Clientes");
        XSSFRow row = sheet.createRow(longitud);
        
        XSSFCell cell = row.createCell(0);
        cell.setCellValue(ID);
        cell = row.createCell(1);
        cell.setCellValue(cliente.getNombre());
        cell = row.createCell(2);
        cell.setCellValue(cliente.getEdad());
        cell = row.createCell(3);
        cell.setCellValue(cliente.getDireccion());
        cell = row.createCell(4);
        cell.setCellValue(cliente.getFecha());
        cell = row.createCell(5);
        cell.setCellValue(cliente.getSexo());
          
        
        FileOutputStream out = new FileOutputStream("Veterinaria.xlsx");
        book.write(out);
        book.close();
    }
    
    public static void registrarMascota(Mascota mascota) throws IOException{
        int longitud, ID;
        ID = obtenerIDYAumentar("Mascotas");
        if(ID==-1)
            return;
        longitud = ExcelBuscador.obtenerLongitud("Mascotas");
        
        
        
        FileInputStream file = new FileInputStream(new File("Veterinaria.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("Mascotas");
        XSSFRow row = sheet.createRow(longitud);
        
        XSSFCell cell = row.createCell(0);
        cell.setCellValue(ID);
        cell = row.createCell(1);
        cell.setCellValue(mascota.getRaza());
        cell = row.createCell(2);
        cell.setCellValue(mascota.getNombre());
        cell = row.createCell(3);
        cell.setCellValue(mascota.getEdad());
        cell = row.createCell(4);
        cell.setCellValue(mascota.getFecha());
        cell = row.createCell(5);
        cell.setCellValue(mascota.isEstatus());
          
        
        FileOutputStream out = new FileOutputStream("Veterinaria.xlsx");
        book.write(out);
        book.close();
    }
}
