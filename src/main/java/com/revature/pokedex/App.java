package com.revature.pokedex;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;

public class App
{
    public static void main(String[] args)
    {
        //Setting the context path to a default blank name
        String webAppName = "";

        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.setPort(8081);
        server.getConnector();
        server.addContext(webAppName, null);

        server.addServlet(webAppName, "defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet(webAppName, "pokemonServlet", new PokemonServlet()).addMapping("/pokemon");
        server.addServlet(webAppName, "searchServlet", new SearchServlet()).addMapping("/search");

        try
        {
            server.start();
            System.out.println("Server now running on http://localhost:" + server.getConnector().getLocalPort());
            server.getServer().await();
        }

        catch (LifecycleException e)
        {
            e.printStackTrace();
        }
    }
}
