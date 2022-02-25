package com.revature.pokedex;

import org.apache.catalina.startup.Tomcat;

import java.sql.Connection;

public class AppContext
{
    private static final String pokedexCSVFile = "NationalPokedex.csv";
    private static PokemonRepository pokemonRepository;
    private static PokemonService pokemonService;
    private static Tomcat server;
    private static PokemonController pokemonController;
    private static Connection connection;

    public static void build()
    {
        pokemonRepository = new PokemonRepository(pokedexCSVFile);
        pokemonService = new PokemonService(pokemonRepository);
        pokemonController = new PokemonController();
        server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "pokemonServlet", pokemonController).addMapping("/pokemon");
    }

    public static PokemonRepository getPokemonRepository()
    {
        return pokemonRepository;
    }

    public static PokemonService getPokemonService()
    {
        return pokemonService;
    }

    public static Tomcat getTomcat()
    {
        return server;
    }
}
