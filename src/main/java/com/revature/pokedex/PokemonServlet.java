package com.revature.pokedex;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokemonServlet extends HttpServlet
{
    PokemonService service;

    public PokemonServlet(PokemonService service)
    {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String userInput = request.getParameter("searchName");
        response.getWriter().println(service.searchForm());

        List<Pokemon> results = new ArrayList<>();

        if(userInput != null)
        {
            results.add(service.getPokemon(userInput));
        }

        else
        {
            results.addAll(service.getPokemon());
        }

        for(Pokemon pokemon : results)
        {
            response.getWriter().println(pokemon + "<br/>");
        }
    }
}
