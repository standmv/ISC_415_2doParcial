package Filters;

import static spark.Spark.exception;

public class ManejoExcepciones {


    public void manejoExcepciones(){

        //ahora la aplicacion nunca estallará :)
        exception(Exception.class, (e, request, response) -> {
            response.status(404);
            response.redirect("/Page404Error.html");
            e.printStackTrace();
        });


    }
}