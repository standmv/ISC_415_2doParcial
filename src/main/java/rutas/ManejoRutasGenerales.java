package rutas;

import modelos.Amigo;
import modelos.LikePublicacion;
import modelos.Publicacion;
import modelos.Usuario;
import services.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import javax.servlet.MultipartConfigElement;
import java.util.*;

import static java.lang.Math.max;
import static spark.Spark.get;
import static spark.Spark.post;


public class ManejoRutasGenerales {

    // Declaración para simplificar el uso del motor de template Thymeleaf.
    public static String renderThymeleaf(Map<String, Object> model, String templatePath) {
        return new ThymeleafTemplateEngine().render(new ModelAndView(model, templatePath));
    }


    public void rutas(){

       get("/", (request, response) -> {
           if(UsuarioServices.getLogUser(request) != null)
               response.redirect("/inicio");
           else
               response.redirect("/login");

           return "";
        });

        get("", (request, response) -> {
            if(UsuarioServices.getLogUser(request) != null)
                response.redirect("/inicio");
            else
                response.redirect("/login");

            return "";
        });


        post("/comentar", (request, response) -> {
            ComentarioServices cs = new ComentarioServices();
            Session session = request.session(true);
            long publicacionid = Long.parseLong(request.queryParams("publicacionid"));
            long usuarioid = ((Usuario)session.attribute("usuario")).getId();

            cs.crearComentario(request.queryParams("comentario"), usuarioid, publicacionid);
            response.redirect("/publicacion?id=" + publicacionid);

            return "";
        });


        post("/publicacion/likear", (request, response) -> {
           long publicacionid = Long.parseLong(request.queryParams("publicacionid"));
            long usuarioid = UsuarioServices.getLogUser(request).getId();
            LikePublicacionServices las = new LikePublicacionServices();

            las.setLikes(publicacionid, usuarioid);

            return "";
        });

        get("/publicacion", (request, response) -> {
            Map<String, Object> modelo = new HashMap<>();
            Publicacion publicacion = PublicacionServices.getInstancia().find(Long.parseLong(request.queryParams("id")));
            Usuario amigo = UsuarioServices.getInstancia().getUsuario( publicacion.getUsuario().getId() );

            modelo.put("usuario", UsuarioServices.getLogUser(request));
            modelo.put("amigo", amigo);

            if( publicacion.getAlbum_id() != null){
                modelo.put("album", AlbumServices.getInstancia().find(publicacion.getAlbum_id()));
            }else{
                modelo.put("publicacion", publicacion);
            }

            modelo.put("comentarios", ComentarioServices.getInstancia().getComentarioByPublicacionID(publicacion.getId()));

            return renderThymeleaf(modelo,"/perfil");
        });

        get("/solicitar", (request, response) -> {
            long amigoid = Long.parseLong(request.queryParams("amigo"));
            AmigoServices.getInstancia().solicitarAmigo(UsuarioServices.getLogUser(request), UsuarioServices.getInstancia().getUsuario(amigoid));
            response.redirect("/perfil?usuario=" + amigoid);
           return "";
        });

        get("/aceptar", (request, response) -> {
            long amigoid = Long.parseLong(request.queryParams("amigo"));
            System.out.println(amigoid);
            AmigoServices.getInstancia().aceptarAmigo(UsuarioServices.getLogUser(request), UsuarioServices.getInstancia().getUsuario(amigoid));
         //  response.redirect("/perfil?usuario=" + amigoid);
            return "";
        });

        get("/rechazar", (request, response) -> {
            long amigoid = Long.parseLong(request.queryParams("amigo"));
            AmigoServices.getInstancia().rechazarAmigo(UsuarioServices.getLogUser(request), UsuarioServices.getInstancia().getUsuario(amigoid));
          // response.redirect("/perfil?usuario=" + amigoid);
            return "";
        });


        /*
        get("/amigos", (request, response) -> {
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("hola", AmigoServices.getInstancia().getAmigosByUsuarioID(UsuarioServices.getLogUser(request).getId()));
            return modelo;
        });
        */
    }

    private static Object procesarParametros(Request request, Response response){
      //  System.out.println("Recibiendo mensaje por el metodo: "+request.requestMethod());
        Set<String> parametros = request.queryParams();
        String salida="";

        for(String param : parametros){
            salida += String.format("Parametro[%s] = %s <br/>", param, request.queryParams(param));
        }

        return salida;
    }



}
