package Routes;

import spark.ModelAndView;
import spark.QueryParamsMap;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class WebRoutes {
    public WebRoutes(final FreeMarkerEngine freeMarkerEngine){

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "login.ftl");//login
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
