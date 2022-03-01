package com.revature.pokedex;

import java.util.List;

public interface PokemonInterface
{
    Pokemon getPokemon(String name);
    List<Pokemon> getPokemonList();
}
