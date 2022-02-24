package com.revature.pokedex;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PokemonRepository
{
    private List<Pokemon> pokemon;
    private Connection connection;

    public PokemonRepository(String csvFile)
    {
        pokemon = new ArrayList<>();
        parsePokemon(loadCSV(csvFile));
    }

    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }

    public List<Pokemon> getPokemon()
    {
        return pokemon;
    }

    public void save(Pokemon pokemon)
    {
        try
        {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO POKEMON VALUES(" + pokemon.getId() + ", '" + pokemon.getName() + "')");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private BufferedReader loadCSV(String csvFile)
    {
        if (!csvFile.endsWith(".csv"))
            throw new IllegalArgumentException("Must be a CSV File");

        try
        {
            URI uri = Objects.requireNonNull(App.class.getClassLoader().getResource(csvFile).toURI());
            Path filepath = Paths.get(Objects.requireNonNull(uri));
            return Files.newBufferedReader(filepath);
        } 
        catch (URISyntaxException e) 
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.err.println("Couldn't load file");
        }

        return null;
    }

    private void parsePokemon(BufferedReader br)
    {
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1).build();
        List<String[]> lines = null;

        try
        {
            lines = reader.readAll();
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (CsvException e)
        {
            e.printStackTrace();
        }

        for (String[] columns : lines)
        {
            pokemon.add(new Pokemon(Integer.parseInt(columns[0]), columns[1]));
        }
    }
}
