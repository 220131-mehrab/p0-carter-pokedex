package com.revature.pokedex;

public class Pokemon
{
    private int id, hp, atk, def, spAtk, spDef, speed;
    private float ht, wt;
    private String name, species;
    private Enum<Type> type1, type2;

    public Pokemon(int id, String name, Enum<Type> type1, Enum<Type> type2, int hp, int atk, int def, int sAtk, int sDef, int spd, String species, float ht, float wt){
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spAtk = sAtk;
        this.spDef = sDef;
        this.speed = spd;
        this.species = species;
        this.ht = ht;
        this.wt = wt;
    }

    public Pokemon() { }

    public Pokemon build()
    {
        return new Pokemon();
    }

    public int getId()
    {
        return id;
    }

    public Pokemon setId(int id)
    {
        this.id = id;
        return this;
    }

    public int getHp()
    {
        return hp;
    }

    public Pokemon setHp(int hp)
    {
        this.hp = hp;
        return this;
    }

    public int getAtk()
    {
        return atk;
    }

    public Pokemon setAtk(int atk)
    {
        this.atk = atk;
        return this;
    }

    public int getDef()
    {
        return def;
    }

    public Pokemon setDef(int def)
    {
        this.def = def;
        return this;
    }

    public int getSpAtk()
    {
        return spAtk;
    }

    public Pokemon setSpAtk(int spAtk)
    {
        this.spAtk = spAtk;
        return this;
    }

    public int getSpDef()
    {
        return spDef;
    }

    public Pokemon setSpDef(int spDef)
    {
        this.spDef = spDef;
        return this;
    }

    public int getSpeed()
    {
        return speed;
    }

    public Pokemon setSpeed(int speed)
    {
        this.speed = speed;
        return this;
    }

    public String getName()
    {
        return name;
    }

    public Pokemon setName(String name)
    {
        this.name = name;
        return this;
    }

    public float getHt()
    {
        return ht;
    }

    public Pokemon setHt(int ht)
    {
        this.ht = ht;
        return this;
    }

    public float getWt()
    {
        return wt;
    }

    public Pokemon setWt(int wt)
    {
        this.wt = wt;
        return this;
    }

    public Enum<Type> getType1()
    {
        return type1;
    }

    public Pokemon setType1(Enum<Type> type1)
    {
        this.type1 = type1;
        return this;
    }

    public Enum<Type> getType2()
    {
        return type2;
    }

    public Pokemon setType2(Enum<Type> type2)
    {
        this.type2 = type2;
        return this;
    }

    public String getSpecies()
    {
        return species;
    }

    public Pokemon setSpecies(String species)
    {
        this.species = species;
        return this;
    }
}