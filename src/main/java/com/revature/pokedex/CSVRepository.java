package com.revature.pokedex;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVRepository implements PokemonInterface
{
    private List<Pokemon> pokemonList;
    private InputStream file;

    public CSVRepository(String filename)
    {
        this.pokemonList = new ArrayList<>();
        this.file = getClass().getClassLoader().getResourceAsStream(filename);
        load();
    }

    private void load()
    {
        Scanner scanner = new Scanner(this.file);
        scanner.useDelimiter("\n");
        scanner.next();

        while(scanner.hasNext())
        {
            String[] pokemonColumns = scanner.next().split(",");
            Pokemon temp = Pokemon.of().name(pokemonColumns[2])
                    .id(Integer.parseInt((pokemonColumns[1])))
                    .type1(pokemonColumns[3])
                    .type2(pokemonColumns[4]);

            this.pokemonList.add(temp);
        }
    }

    public List<Pokemon> getPokemonList()
    {
        return pokemonList;
    }

    public Pokemon getPokemon(String name)
    {
        Pokemon result = null;

        for(Pokemon pokemon : this.pokemonList)
        {
            if(pokemon.getName().equalsIgnoreCase(name))
            {
                result = pokemon;
            }
        }

        return result;
    }
}
