package resource;

import java.net.URI;
import java.sql.Date;
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
import models.Vendedor;
import service.VendedorService;

@Path("/vendedor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VendedorResource {
    VendedorService vendedorService = new VendedorService();
    
    @GET
    public List<Vendedor> get(){
        return vendedorService.getAll();
    }
      
    @GET
    @Path("/{CDVEND}")
    public Vendedor getVendedor(@PathParam("CDVEND") String CDVEND){
        return vendedorService.get(CDVEND);
    }
    
    @POST
    public Response save(Vendedor vendedor, @Context UriInfo uriInfo){
        Date newDate = new Date(2020, 15, 07);
        System.out.print(newDate);
        Vendedor newVendedor = vendedorService.save(vendedor);
        String newId = String.valueOf(newVendedor.getCDVEND());
        URI url = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(url).entity(newVendedor).build();
    }
    
    @PUT
    @Path("/{CDVEND}")
    public Response update(@PathParam("CDVEND") String CDVEND, Vendedor vendedor, @Context UriInfo uriInfo){
        vendedor.setCDVEND(CDVEND);
        Vendedor newVendedor = vendedorService.update(vendedor);
        return Response.created(uriInfo.getAbsolutePath()).entity(newVendedor).build();
    }
    
    @DELETE
    @Path("/{CDVEND}")
    public void delete(@PathParam("CDVEND") String CDVEND){
        System.out.print("remove");
        vendedorService.remove(CDVEND);
    }
}
