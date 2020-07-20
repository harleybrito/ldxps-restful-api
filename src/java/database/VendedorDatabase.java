package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import models.Vendedor;

public class VendedorDatabase {
    
    public static Map<String, Vendedor> getAll(){
        Map<String, Vendedor> vendedores = new HashMap<>();
        
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("select * from vendedores");
            ResultSet data = statement.executeQuery();
            
            while(data.next()){
                Vendedor vendedor = new Vendedor();
                vendedor.setCDVEND(data.getString(1));
                vendedor.setDSNOME(data.getString(2));
                vendedor.setCDTAB(data.getInt(3));
                vendedor.setDTNASC(data.getDate(4));
                vendedores.put(vendedor.getCDVEND(), vendedor);
            }
            
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return vendedores;
    }
    
    public static void save(Vendedor vendedor){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("insert into vendedores (CDVEND, DSNOME, CDTAB, DTNASC) values (?, ?, ?, ?)");
            statement.setString(1, vendedor.getCDVEND());
            statement.setString(2, vendedor.getDSNOME());
            statement.setInt(3, vendedor.getCDTAB());
            statement.setDate(4, vendedor.getDTNASC());
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void update(Vendedor vendedor){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("update vendedores set CDVEND = ?, DSNOME = ?, CDTAB = ?, DTNASC = ? where CDVEND = ? ");
            statement.setString(1, vendedor.getCDVEND());
            statement.setString(2, vendedor.getDSNOME());
            statement.setInt(3, vendedor.getCDTAB());
            statement.setDate(4, vendedor.getDTNASC());
            statement.setString(5, vendedor.getCDVEND());
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void remove(String CDVEND){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("delete from vendedores where CDVEND = ?");
            statement.setString(1, CDVEND);
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
