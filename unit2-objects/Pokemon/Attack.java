import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack extends Actor
{
    private String name;
    private int power;

    public Attack(String name)
    {
        this.name = name;
        this.power = 10;
    }

    public Attack(String name, int power)
    {
        this.name = name;
        this.power = power;
    }

    public String getName()
    {
        return name;
    }

    public int getPower()
    {
        return power;
    }
}
