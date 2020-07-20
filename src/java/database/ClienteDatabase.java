package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import models.Cliente;

public class ClienteDatabase {
    
    public static Map<String, Cliente> getAll(){
        Map<String, Cliente> clientes = new HashMap<>();
        
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("select * from clientes");
            ResultSet data = statement.executeQuery();
            
            while(data.next()){
                Cliente cliente = new Cliente();
                cliente.setCDCL(data.getString(1));
                cliente.setDSNOME(data.getString(2));
                cliente.setIDTIPO(data.getString(3));
                cliente.setCDVEND(data.getString(4));
                cliente.setDSLIM(data.getDouble(5));
                clientes.put(cliente.getCDCL(), cliente);
            }
            
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return clientes;
    }
    
    public static void save(Cliente cliente){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("insert into clientes (CDCL, DSNOME, IDTIPO, CDVEND, DSLIM) values (?, ?, ?, ?, ?)");
            statement.setString(1, cliente.getCDCL());
            statement.setString(2, cliente.getDSNOME());
            statement.setString(3, cliente.getIDTIPO());
            statement.setString(4, cliente.getCDVEND());
            statement.setDouble(5, cliente.getDSLIM());
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void update(Cliente cliente){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("update clientes set CDCL = ?, DSNOME = ?, IDTIPO = ?, CDVEND = ?, DSLIM = ? where CDCL = ? ");
            statement.setString(1, cliente.getCDCL());
            statement.setString(2, cliente.getDSNOME());
            statement.setString(3, cliente.getIDTIPO());
            statement.setString(4, cliente.getCDVEND());
            statement.setDouble(5, cliente.getDSLIM());
            statement.setString(6, cliente.getCDCL());
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void remove(String CDCL){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("delete from clientes where CDCL = ?");
            statement.setString(1, CDCL);
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
