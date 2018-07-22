import Routes.WebRoutes;
import freemarker.template.Configuration;


import freemarker.template.Version;

import services.ConnectionService;
import java.sql.SQLException;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.staticFileLocation;


public class Main {


    public static void main(String[] args) {



        /*try{
            ConnectionService.startDb();
        }
        catch (SQLException e){

            e.printStackTrace();
        }
        */

        final Configuration configuration = new Configuration(new Version(2, 3, 26));

        configuration.setClassForTemplateLoading(Main.class, "/templates");

        staticFileLocation("/public/assets");


        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);
        new WebRoutes(freeMarkerEngine);

    }
}