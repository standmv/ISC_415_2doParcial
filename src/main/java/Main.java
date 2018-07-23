import Dao.ProfileDaoImpl;
import Dao.UserDaoImpl;
import Hibernate.HibernateUtil;
import Routes.WebRoutes;
import encapsulation.Profile;
import encapsulation.User;
import freemarker.template.Configuration;


import freemarker.template.Version;

import services.ConnectionService;

import java.sql.SQLException;

import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.staticFileLocation;


public class Main {


    public static void main(String[] args) {

        UserDaoImpl usuarioadmin = new UserDaoImpl(User.class);
        ProfileDaoImpl profileadmin = new ProfileDaoImpl(Profile.class);

        try{
            ConnectionService.startDb();
        }
        catch (SQLException e){

            e.printStackTrace();
        }

        HibernateUtil.buildSessionFactory().openSession().close();
        User temp = usuarioadmin.searchByUsername("admin");

        if(temp == null){

            User usuarioPorDefecto = new User(1, "admin", "admin", "admin@gwebmaster.me",true,null,null,null);
            usuarioadmin.add(usuarioPorDefecto);
            Profile perfil = new Profile();
            perfil.setUser(usuarioPorDefecto);
            profileadmin.add(perfil);


        }

        HibernateUtil.openSession().close();

        final Configuration configuration = new Configuration(new Version(2, 3, 26));

        configuration.setClassForTemplateLoading(Main.class, "/templates");

        staticFileLocation("/public/assets");


        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);
        new WebRoutes(freeMarkerEngine);

    }
}