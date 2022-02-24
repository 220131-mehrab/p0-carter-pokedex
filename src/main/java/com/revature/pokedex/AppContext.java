package com.revature.pokedex;

import org.apache.catalina.startup.Tomcat;

import java.sql.Connection;

public class AppContext
{
    private static final String pokedexCSVFile = "NationalPokedex.csv";
    private static Tomcat server;
    private static Connection connection;

    public static void build()
    {
        server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
    }

    public static Tomcat getTomcat()
    {
        return server;
    }
}
