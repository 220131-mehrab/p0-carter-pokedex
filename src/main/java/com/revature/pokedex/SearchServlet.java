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
        String userInput = request.getParameter("searchName").toUpperCase();
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

            while (scanner.hasNext())
            {
                line = scanner.next();

                if (line.substring(0, 2).equalsIgnoreCase("ID"))
                {
                    line = scanner.next();
                }

                if (userInput == null || userInput.equals(" ") || userInput.equals(""))
                {
                    response.getWriter().println(line + "<br><br>");
                }

                else if (line.toUpperCase().contains(userInput))
                {
                    response.getWriter().println(line);
                }
            }
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
