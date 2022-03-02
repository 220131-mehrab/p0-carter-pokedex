package com.revature.pokedex;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchServlet extends HttpServlet
{
    PokemonServlet service;

    public SearchServlet(){}


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String userInput = request.getParameter("searchName");
        String line;
        String[] pokemonList = new String[15];

        ArrayList<Pokemon> results = new ArrayList<>();
        Pokemon pokemon = new Pokemon();

        InputStream fileName = getClass().getClassLoader().getResourceAsStream("NationalPokedex.csv");
        Scanner scanner = new Scanner(fileName, "UTF-8");
        scanner.useDelimiter("\n");

        try
        {
            response.getWriter().println("<html>\n" +
                    "<head>\n" +
                    "    <meta charset='UTF-8'>" +
                    "    \n" +
                    "    <title>Pok&eacute;mon Search Results</title>\n" +
                    "</head>\n" +
                    "<body style='background-color:#e7e7e7; color:#4d4d4d;'>\n" +
                    "<h1><u><b>Search Results</b></u></h1><br>\n" +
                    "<h2><a href='/pokemon'>" +
                    "<a href='/pokemon'>" +
                    "Return to Pok&eacute;mon search</e></a></h2>\n" +
                    "</html>");

            boolean tablePrinted = false;
            boolean addedToArray = false;
            boolean lineContains = false;
            boolean tableClean = false;

            results.clear();

            while (scanner.hasNext())
            {
                line = scanner.next();

                if (userInput == null || userInput.equals(" "))
                {
                    response.getWriter().println(line.replaceAll("Pok.mon", "Pokémon") + "<br><br>");
                }

                else if (pokemon.getName().equalsIgnoreCase(userInput))
                {
                    line.replaceAll("Pok.mon", "Pokémon");
                    line.replaceAll("Flab.b.", "Flabébé");
                    pokemonList = line.split(" , ");

                    if(pokemonList[4] == null || pokemonList[4].equals(""))
                    {
                        pokemonList[4] = "NONE";
                    }

                    results.add(new Pokemon(
                            Integer.parseInt(pokemonList[1]),
                            pokemonList[2],
                            Type.valueOf(pokemonList[3].toUpperCase()),
                            Type.valueOf(pokemonList[4].toUpperCase()),
                            Integer.parseInt(pokemonList[6]),
                            Integer.parseInt(pokemonList[7]),
                            Integer.parseInt(pokemonList[8]),
                            Integer.parseInt(pokemonList[9]),
                            Integer.parseInt(pokemonList[10]),
                            Integer.parseInt(pokemonList[11]),
                            pokemonList[12],
                            Float.parseFloat(pokemonList[13].replace(" m", "")),
                            Float.parseFloat(pokemonList[14].replace(" kg", ""))));

                    response.getWriter().println("<table name='Pokedex Entry' border=0 cellspacing=0 cellpadding=0>" +
                            "                   <tr valign='top'>" +
                            "                       <td><img src='https://www.serebii.net/swordshield/pokemon/"+pokemonList[1]+".png'></td>" +
                            "                       <td>"+pokemonList[2]+"</td>");
                }
            }
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
