package service;

import database.ClienteDatabase;
import database.VendedorDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import models.Cliente;
import models.Vendedor;

public class ClienteService {
    private Map<String, Cliente> clientes = ClienteDatabase.getAll();
    
    public List<Cliente> getAll(){
        return new ArrayList<Cliente>(clientes.values());
    }
    
    public List<Cliente> getByVendedor(String CDVEND){
    List<Cliente> clientesByVendedor = new ArrayList<Cliente>();
    String vendedor;

    for(Cliente cliente: clientes.values()){
        vendedor = cliente.getCDVEND();
        
        if(vendedor != null){
            if(vendedor.equals(CDVEND)){
                clientesByVendedor.add(cliente);
            }
        }
    }
        return clientesByVendedor;
    }
    
    public Cliente get(String CDCL){
        Cliente cliente = clientes.get(CDCL);
        
        return cliente;
    }
    
    public Cliente save(Cliente cliente){
        ClienteDatabase.save(cliente);
        return cliente;
    }
    
    public Cliente update(Cliente cliente){
        ClienteDatabase.update(cliente);
        return cliente;
    }
    
    public void remove(String CDCL){
        ClienteDatabase.remove(CDCL);
    }
}