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

        PokemonInterface pokemonInterface;
        pokemonInterface = new CSVRepository("NationalPokedex.csv");
        PokemonService pokemonService = new PokemonService(pokemonInterface);

        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.setPort(0);
        server.getConnector();
        server.addContext(webAppName, null);

        server.addServlet(webAppName, "defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet(webAppName, "pokemonServlet", new PokemonServlet(pokemonService)).addMapping("/pokemon");

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
