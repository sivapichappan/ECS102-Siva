import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Computer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computer extends User
{
    public Computer(String name)
    {
        super(name);
    }

    public void switchPokemon()
    {
        String oldName = "";
        if (getPokemon() != null)
        {
            oldName = getPokemon().getName();
        }

        Pokemon newPokemon = null;
        while (newPokemon == null || newPokemon.getName().equals(oldName))
        {
            int pick = Greenfoot.getRandomNumber(6);
            if (pick == 0)
            {
                newPokemon = new Pokemon(100, 15, "Charmander", "Ember", "Fire");
            }
            else if (pick == 1)
            {
                newPokemon = new Pokemon(110, 13, "Squirtle", "Water Gun", "Water");
            }
            else if (pick == 2)
            {
                newPokemon = new Pokemon(105, 14, "Bulbasaur", "Vine Whip", "Grass");
            }
            else if (pick == 3)
            {
                newPokemon = new Pokemon(95, 16, "Vulpix", "Flamethrower", "Fire");
            }
            else if (pick == 4)
            {
                newPokemon = new Pokemon(110, 13, "Psyduck", "Bubble", "Water");
            }
            else
            {
                newPokemon = new Pokemon(100, 14, "Oddish", "Razor Leaf", "Grass");
            }
        }
        switchPokemon(newPokemon);
    }
}
