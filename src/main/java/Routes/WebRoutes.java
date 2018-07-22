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
            return new ModelAndView(attributes, "login.ftl");
        }, freeMarkerEngine);
    }
}
