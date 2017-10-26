package edu.matc.week8RestExercise.controller;

import edu.matc.week8RestExercise.entity.User;
import edu.matc.week8RestExercise.persistence.UserDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/userSelect")
public class UserSelect {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage() {
        // Return a simple message
        List<User> users = new ArrayList<User>();
        UserDao userDao = new UserDao();

        users = userDao.getAllUsers();

        return Response.status(200).entity(users).build();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg(@PathParam("name") String msg) {
        UserDao userDao = new UserDao();
        User user = new User();

        user = userDao.getUser(msg);

        return Response.status(200).entity(user).build();
    }

}