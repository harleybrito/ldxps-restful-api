package resource;

import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import models.Cliente;
import service.ClienteService;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {
    ClienteService clienteService = new ClienteService();
    
    @GET
    public List<Cliente> get(){
        return clienteService.getAll();
    }
    
    @GET
    @Path("/byVendedor/{CDVEND}")
    public List<Cliente> getByVendedor(@PathParam("CDVEND") String CDVEND){
        System.out.print("call");
        return clienteService.getByVendedor(CDVEND);
    }
      
    @GET
    @Path("/{CDCL}")
    public Cliente getCliente(@PathParam("CDCL") String CDCL){
        return clienteService.get(CDCL);
    }
    
    @POST
    public Response save(Cliente cliente, @Context UriInfo uriInfo){
        System.out.print(cliente.getDSNOME());
        Cliente newCliente = clienteService.save(cliente);
        String newId = String.valueOf(newCliente.getCDCL());
        URI url = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(url).entity(newCliente).build();
    }
    
    @PUT
    @Path("/{CDCL}")
    public Response update(@PathParam("CDCL") String CDCL, Cliente cliente, @Context UriInfo uriInfo){
        cliente.setCDCL(CDCL);
        Cliente newCliente = clienteService.update(cliente);
        return Response.created(uriInfo.getAbsolutePath()).entity(newCliente).build();
    }
    
    @DELETE
    @Path("/{CDCL}")
    public void delete(@PathParam("CDCL") String CDCL){
        clienteService.remove(CDCL);
    }
}
