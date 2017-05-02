package rest;

import jpa.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by Elev1 on 2017-04-10.
 */
@Path("/person")
public interface PersonResource {

    @GET
        //...
    @Path("/")
    List<Person> persons();

    @GET
    @Path("/{id}")
    Person getPerson(@PathParam("id") Long id);
}
