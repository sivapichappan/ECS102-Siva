import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class User here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class User extends Actor
{
    private String name;
    private Pokemon pokemon;

    public User(String name)
    {
        this.name = name;
        setImage(new GreenfootImage(" " + name + " ", 28, Color.WHITE, new Color(0, 0, 0, 160)));
    }

    public void setPokemon(Pokemon p)
    {
        pokemon = p;
    }

    public Pokemon getPokemon()
    {
        return pokemon;
    }

    public void switchPokemon(Pokemon newPokemon)
    {
        if (pokemon != null && pokemon.getWorld() != null)
        {
            World world = pokemon.getWorld();
            world.addObject(newPokemon, pokemon.getX(), pokemon.getY());
            world.removeObject(pokemon);
        }
        pokemon = newPokemon;
    }

    public void heal()
    {
        pokemon.heal();
    }

    public void attack(String name, User enemy)
    {
        pokemon.attack(name, enemy);
    }

    public boolean isEndGame()
    {
        return pokemon.isOut();
    }

    public String getName()
    {
        return name;
    }
}
