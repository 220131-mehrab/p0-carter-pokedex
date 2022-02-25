package com.revature.pokedex;

public class PokemonService
{
    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository)
    {
        this.pokemonRepository = pokemonRepository;
    }

    public String searchName(String query)
    {
        for (Pokemon pokemon : pokemonRepository.getPokemon())
        {
            if (pokemon.getName().equalsIgnoreCase(query))
                return pokemon.getName();
        }

        return null;
    }

    public void savePokemon(Pokemon pokemon)
    {
        pokemonRepository.save(pokemon);
    }
}
