package rest;


import jpa.Person;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

@Path("/persons")
public interface PersonResource {

    @GET
     //   @Produces({MediaType.APPLICATION_XML})
    @Path("/")
    List<Person> getPersons();

    @GET
    @Path("/{id}")
    Person getPerson(@PathParam("id") Long id);
}
