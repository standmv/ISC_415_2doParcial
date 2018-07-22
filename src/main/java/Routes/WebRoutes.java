package Routes;

import encapsulation.User;
import spark.ModelAndView;
import spark.QueryParamsMap;
import Dao.*;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class WebRoutes {
    public WebRoutes(final FreeMarkerEngine freeMarkerEngine){
        UserDaoImpl usuarioDao;

        usuarioDao = new UserDaoImpl(User.class);

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "login.ftl");//login
        }, freeMarkerEngine);

        post("/login", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            String username = request.queryParams("username");
            String password = request.queryParams("password");
            User user = usuarioDao.searchByUsername(username);

            if( user.getPassword().equals(password)) {
                response.cookie("username", username, 604800);
            }

            return new ModelAndView(attributes, "home.ftl");
        }, freeMarkerEngine);

        get("/signup", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "registrar.ftl");//registrar
        }, freeMarkerEngine);

        get("/home", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "home.ftl");//home
        }, freeMarkerEngine);

        get("/informacion", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "informacion.ftl");//infomacion
        }, freeMarkerEngine);

        get("/album", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "fotos.ftl");//fotos
        }, freeMarkerEngine);




    }
}
