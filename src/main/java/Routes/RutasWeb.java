package Routes;

import Encapsulation.Album;
import Encapsulation.Publicacion;
import Encapsulation.Usuario;
import Services.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;


public class RutasWeb {

    // Declaración para simplificar el uso del motor de template Thymeleaf.
    public static String renderThymeleaf(Map<String, Object> model, String templatePath) {
        return new ThymeleafTemplateEngine().render(new ModelAndView(model, templatePath));
    }


    public void rutas(){

        File uploadDir = new File("fotos");
        uploadDir.mkdir();


        //Usuario admin por defecto
        if (new UsuarioServices().getUsuarioByEmail("admin@admin.com") == null) {
            Usuario usuario = new Usuario();
            usuario.setPassword("admin");
            usuario.setNombre("Stanley");
            usuario.setApellido("De Moya");
            usuario.setCorreo("admin@admin.com");
            usuario.setLugar_nacimiento("Santiago");
            usuario.setCiudad_residencia("Santiago");
            usuario.setFotoPerfil("/img/badge4.png");
            usuario.setFotoPortada("img/top-header1.jpg");
            usuario.setAdmin(true);
            usuario.setWebsite("sysservices.site");
            usuario.setTelefono("8095820000");
            usuario.setPais("Republica Dominicana");
            usuario.setProvincia("Santiago");
            usuario.setCiudad("Santiago de los caballeros");
            usuario.setDescripcion_personal("Soy una joven normal... aveces");
            usuario.setGenero("Femenino");
            usuario.setReligion("Catolica");
            usuario.setLugar_de_nacimiento("Santiago de los caballeros");
            usuario.setOcupacion("Estudiante");
            usuario.setInclinacion_politica("ninguna");
            usuario.setFacebook("www.facebook.com/admin");
            usuario.setTwitter("www.twitter.com/admin");
            usuario.setSpotify("www.spotify.com/sgiron");

            new UsuarioServices().crearUsuario(usuario);
        }

        get("/login", (request, response) -> {
            Map<String, Object> modelo = new HashMap<>();

            String mensaje = "";

            if (request.queryMap().hasKeys() ) {
                if (request.queryMap("register").booleanValue())
                    mensaje = "Usuario registrado satisfactoriamente.";
            }

            modelo.put("mensaje", mensaje);

            return renderThymeleaf(modelo,"/login");
        });

        post("/login", (request, response) -> {

            String correo = request.queryParams("username");
            String contrasena = request.queryParams("password");

            Usuario user = new UsuarioServices().autenticarUsuario(correo, contrasena);

            Session session = request.session(true);
            session.attribute("usuario", user);
            response.redirect("/inicio");


            return null;
        });

        get("/inicio", (request, response) -> {
            Map<String, Object> modelo = new HashMap<>();
            Usuario u = UsuarioServices.getLogUser(request);
            modelo.put("usuario", u);
            /*System.out.println(u.getAmigos());
            List<Publicacion> publicaciones = new PublicacionServices().listaPublicacion(u.getId());

            for( Publicacion p:publicaciones ){
                p.setLeGusta(LikePublicacionServices.getInstancia().getLikesByPublicacionYUsuarioID(p.getId(), u.getId()));
            }

            modelo.put("publicaciones", publicaciones );
            modelo.put("usuario", u);
            modelo.put("usuarios", UsuarioServices.getInstancia().findAll());*/
            return renderThymeleaf(modelo,"/home");
        });

        post("/publicacion", (request, response) -> {

            //super importante, para leer los campos ya se se codifican diferente gracias a la imagen
            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

            String descripcion = request.queryParams("descripcion");

            Publicacion publicacion = new Publicacion();

            publicacion.setDescripcion(descripcion);
            publicacion.setUsuario(UsuarioServices.getLogUser(request));
            publicacion.setFecha(new Date());

            String img = RutasImagen.guardarImagen("foto", uploadDir, request);

            publicacion.setImg(img);

            publicacion.setMuro_de(Long.parseLong(request.queryParams("muro")));

            if(!"-1".equalsIgnoreCase(img)) publicacion.setNaturaleza("FOTO");


            PublicacionServices.getInstancia().crear(publicacion);


            response.redirect("/inicio");

            return "";
        });

        post("/ubicacion", (request, response) -> {
            String descripcion = request.queryParams("descripcion");
            Publicacion publicacion = new Publicacion();
            publicacion.setDescripcion(descripcion);
            publicacion.setUsuario(UsuarioServices.getLogUser(request));
            publicacion.setFecha(new Date());
            String img = request.queryParams("ubicacion");
            publicacion.setImg(img);
            publicacion.setMuro_de(Long.parseLong(request.queryParams("muro")));
            publicacion.setNaturaleza("UBICACION");
            PublicacionServices.getInstancia().crear(publicacion);

            response.redirect("/inicio");

            return "";
        });

        post("/album", (request, response) -> {
            //super importante, para leer los campos ya se se codifican diferente gracias a la imagen
            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

            String titulo = request.queryParams("titulo");

            List<Publicacion> publicaciones = new ArrayList<>();

            for(int i = 1; i<=5; i++){
                String img = RutasImagen.guardarImagen("foto" + i, uploadDir, request);

                if( "-1".equalsIgnoreCase(img)) continue;
                Publicacion publicacion = new Publicacion();

                publicacion.setDescripcion("Foto: " + i);
                publicacion.setUsuario(UsuarioServices.getLogUser(request));
                publicacion.setFecha(new Date());
                publicacion.setImg(img);
                publicacion.setMuro_de(Long.parseLong(request.queryParams("muro")));

                if(i == 1){
                    publicacion.setNaturaleza("ALBUM");
                    publicacion.setDescripcion(titulo);
                } else publicacion.setNaturaleza("ALBUM_FOTO");

                PublicacionServices.getInstancia().crear(publicacion);
                publicaciones.add(publicacion);
            }

            Album album = new Album( new HashSet<>(publicaciones) );
            AlbumServices.getInstancia().crear(album);

            publicaciones.get(0).setAlbum_id(album.getId());
            PublicacionServices.getInstancia().editar( publicaciones.get(0) );

            response.redirect("/inicio");

            return "";
        });

        get("/perfil", (request, response) -> {
            Map<String, Object> modelo = new HashMap<>();
            String usuarioid = request.queryParams("usuario");
            String publicacionid = request.queryParams("publicacion");
            modelo.put("usuario", UsuarioServices.getLogUser(request));

            if(usuarioid != null) {
                Usuario amigo = UsuarioServices.getInstancia().getUsuario(Long.parseLong(usuarioid));

                modelo.put("amigo", amigo);
                List<Publicacion> publicaciones =  PublicacionServices.getInstancia().listaPublicacionByUduarioID(amigo.getId());
                Long usuario_id = Long.parseLong(usuarioid);
                for( Publicacion p:publicaciones ){
                    p.setLeGusta(LikePublicacionServices.getInstancia().getLikesByPublicacionYUsuarioID(p.getId(), usuario_id));
                }

                modelo.put("publicaciones",publicaciones);
            }

            if( publicacionid != null ){
                Publicacion publicacion = PublicacionServices.getInstancia().find(Long.parseLong(publicacionid));
                publicacion.setLikeCount(LikePublicacionServices.getInstancia().getLikesByPublicacionID(publicacion.getId()));
                publicacion.setLeGusta(LikePublicacionServices.getInstancia().getLikesByPublicacionYUsuarioID(publicacion.getId(), Long.parseLong(usuarioid)));
                Usuario amigo = UsuarioServices.getInstancia().getUsuario( publicacion.getUsuario().getId() );
                modelo.put("amigo", amigo);


                if( publicacion.getAlbum_id() != null){
                    modelo.put("album", AlbumServices.getInstancia().find(publicacion.getAlbum_id()));
                }else{
                    modelo.put("publicacion", publicacion);
                }
                modelo.put("comentarios", ComentarioServices.getInstancia().getComentarioByPublicacionID(publicacion.getId()));
            }

            return renderThymeleaf(modelo,"/perfil");
        });

        get("/cerrarsesion", (request, response) -> {
            request.session().invalidate();
            response.redirect("/login");
            return null;
        });

        post("/registrarme", (request, response) -> {
            Usuario usuario = new Usuario();

            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String correo = request.queryParams("email");
            String contrasena = request.queryParams("password");
            String cumpleanos = request.queryParams("fechanacimiento");


            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setCorreo(correo);
            usuario.setPassword(contrasena);
            usuario.setFecha_nacimiento(new SimpleDateFormat("yyyy-mm-dd").parse(cumpleanos));
            usuario.setFotoPerfil("/img/badge3.png");
            usuario.setFotoPortada("/img/top-header1.jpg");
            //usuario.setAdmin(true);

            new UsuarioServices().crearUsuario(usuario);

            Usuario user =  UsuarioServices.getInstancia().getUsuarioByEmail(correo);

            Session session = request.session(true);
            session.attribute("usuario", user);
            response.redirect("/inicio");
            return null;
        });

        get("/registrarme", (request, response) -> {
            Map<String, Object> modelo = new HashMap<>();

            return renderThymeleaf(modelo,"/registrar");
        });

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
