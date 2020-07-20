package service;

import database.VendedorDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import models.Vendedor;

public class VendedorService {
    private Map<String, Vendedor> vendedores = VendedorDatabase.getAll();
    
    public List<Vendedor> getAll(){
        return new ArrayList<Vendedor>(vendedores.values());
    }
    
    public Vendedor get(String CDVEND){
        Vendedor vendedor = vendedores.get(CDVEND);
        
        return vendedor;
    }
    
    public Vendedor save(Vendedor vendedor){
        VendedorDatabase.save(vendedor);
        return vendedor;
    }
    
    public Vendedor update(Vendedor vendedor){
        VendedorDatabase.update(vendedor);
        return vendedor;
    }
    
    public void remove(String CDVEND){
        VendedorDatabase.remove(CDVEND);
    }
}