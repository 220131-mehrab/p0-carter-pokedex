package com.revature.pokedex;

import java.util.List;

public class PokemonService
{
    private PokemonInterface pokemonInterface;

    public PokemonService(PokemonInterface pokemonInterface)
    {
        this.pokemonInterface = pokemonInterface;
    }

    public String searchForm()
    {
        String HTMLForm = "<Html>\n" +
                "<Head>\n" +
                "    <Title>Search Pokedex" +
                "</Title>\n" +
                "</Head>\n" +
                "<Body>\n" +
                "    <h1>Pokedex Search</h1>\n" +
                "    <form action='pokemon' method='get'>\n" +
                "        <input type='name' name='searchName'/>\n" +
                "        <input type='submit' value='Search'/>\n" +
                "    " +
                "    <a href='pokemon'>See Full Pokedex</a>\n" +
                "</form>\n" +
                "</Body>\n" +
                "</Html>";
        return HTMLForm;
    }

    public List<Pokemon> getPokemon() {
        return pokemonInterface.getPokemonList();
    }

    public Pokemon getPokemon(String userInput) {
        return pokemonInterface.getPokemon(userInput.trim().toLowerCase());
    }
}
