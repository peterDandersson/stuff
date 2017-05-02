package rest;


import jpa.Person;
import jpa.PersonList;

import javax.ws.rs.*;
import java.util.List;


import javax.ws.rs.core.MediaType;

@Path("/persons")
public interface PersonResource {

    @GET
     //   @Produces({MediaType.APPLICATION_XML})
    @Path("/")
    List<Person> getPersons();

    @GET
    @Path("/{id}")
    Person getPerson(@PathParam("id") Long id);

    @DELETE
    @Path("/{id}")
    void removePerson(@PathParam("id") Long id);

    @POST
    @Path("/")
    Person addPerson(Person p);

    @POST
    @Path("/")
    void addPersons(String persons);

    @PUT
    @Path("/{id}")
    Person updatePerson(@PathParam("id") Long id,Person p);
}
