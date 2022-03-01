package com.revature.pokedex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pokemon
{
    private int id;
    private String name;
    private List<Type> types;

    public Pokemon()
    {
        this.types = new ArrayList<>();
    }

    public static Pokemon of()
    {
        return new Pokemon();
    }

    public Pokemon id(int id)
    {
        this.id = id;
        return this;
    }

    public Pokemon name(String name)
    {
        this.name = name;
        return this;
    }

    public Pokemon type1(String type1)
    {
        types.add(0, Type.valueOf(type1.toUpperCase()));
        return this;
    }

    public Pokemon type2(String type2)
    {
        try
        {
            types.add(1, Type.valueOf(type2.toUpperCase()));
        }
        catch (IllegalArgumentException ex) {}

        return this;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Type> getTypes() { return types; }

    public void setTypes(List<Type> types) { this.types = types; }

    @Override
    public String toString()
    {
        return "Pokemon {" + "id=" + id + ", name='" + name + '\'' + ", types=" + types + '}';
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Pokemon pokemon = (Pokemon) object;

        return id == pokemon.id && name.equals(pokemon.name) && types.equals(pokemon.types);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, types);
    }

    public int compareTo(Pokemon pokemon)
    {
        return Integer.compare(this.id, pokemon.getId());
    }
}
