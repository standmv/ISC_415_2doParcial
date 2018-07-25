package Routes;

import encapsulation.User;
import spark.ModelAndView;
import spark.QueryParamsMap;
import Dao.*;
import spark.Session;
import spark.template.freemarker.FreeMarkerEngine;

import encapsulation.*;
import Dao.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class WebRoutes {
    public WebRoutes(final FreeMarkerEngine freeMarkerEngine){
        UserDaoImpl usuarioDao;
        ProfileDaoImpl profileDao;
        WallDaoImpl wallDao;
        PostDaoImpl postDao;

        usuarioDao = new UserDaoImpl(User.class);
        profileDao = new ProfileDaoImpl(Profile.class);
        wallDao = new WallDaoImpl(Wall.class);
        postDao = new PostDaoImpl(Post.class);

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            User user = new User();

            if(request.cookie("username")==null){


                response.redirect("/login");


            }
            user = usuarioDao.searchByUsername(request.cookie("username"));
            return new ModelAndView(attributes, "home.ftl");//login
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

        get("/informacion", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "informacion.ftl");//infomacion
        }, freeMarkerEngine);

        get("/album", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "fotos.ftl");//fotos
        }, freeMarkerEngine);

        get("/home", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "home.ftl");//home
        }, freeMarkerEngine);


        get("/login", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            return new ModelAndView(attributes, "login.ftl");
        }, freeMarkerEngine);

        get("/signup", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "registrar.ftl");//registrar
        }, freeMarkerEngine);

        post("/registrarse", (request, response) -> {

            QueryParamsMap map = request.queryMap();
            SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
            User usuario = new User();
            Profile profile = new Profile();
            usuario.setUsername(map.get("username").value());
            usuario.setEmail(map.get("email").value());
            usuario.setPassword(map.get("password").value());
            usuarioDao.getProfile(usuario).setNombre(map.get("nombre").value());
            usuarioDao.getProfile(usuario).setApellido(map.get("apellido").value());
            usuarioDao.getProfile(usuario).setDireccion(map.get("ciudad").value());
            java.util.Date fechanacimiento = format.parse(request.queryParams("fechanacimiento"));
            usuarioDao.getProfile(usuario).setLugarestudio(map.get("lugarestudio").value());
            usuarioDao.getProfile(usuario).setTrabajo(map.get("trabajo").value());
            usuarioDao.getProfile(usuario).setSexo(map.get("sexo").value());
            usuarioDao.getProfile(usuario).setPais(map.get("pais").value());
            usuarioDao.getProfile(usuario).setCiudadnacimiento(map.get("ciudadnacimiento").value());
            usuario.setPriviledge(false);
            UserDaoImpl userDao = null;

            if(userDao.searchByUsername(usuario.getUsername())==null){

                userDao.add(usuario);
                profileDao.add(userDao.getProfile(usuario));
                response.redirect("/");

                return null;
            }
            else {
                return "Usuario ya existe!";
            }

        });

        post("/createPost", (request, response) -> {

            QueryParamsMap map = request.queryMap();
            boolean autenticado=false;
            Integer id;
            Post post = new Post();
            User usuario = new User();

            if(request.cookie("username")!=null)
            {autenticado=true;
                usuario = usuarioDao.searchByUsername(request.cookie("username"));


            }
            else if(usuarioDao.searchByUsername(request.session().attribute("username"))!=null && request.cookie("username")==null){
                autenticado=true;
                usuario = usuarioDao.searchByUsername(request.session().attribute("username"));}

            post.setFecha(LocalDate.now());
            post.setLikes(0);
            post.setTexto(map.get("texto").value());
            post.setUser(usuario);
            post.setWall(wallDao.findWallByUser(usuario.getId()));

            postDao.add(post);
            response.redirect("/");

            return "Ok";
        });
        //Rutas Logout
        get("/logout", (request,response) ->{
            Session session = request.session();
            session.removeAttribute("username");
            response.removeCookie("username");
            response.redirect("/");

            Map<String, Object> attributes = new HashMap<>();

            attributes.put("usuariodentro","Huesped");
            attributes.put("admin", false);
            attributes.put("autenticado", false);

            return new ModelAndView(attributes, "login.ftl");
        },freeMarkerEngine);
    }
}
