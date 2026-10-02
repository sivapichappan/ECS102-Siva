import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Topping here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Topping extends Actor
{
    private String name;
    public Topping(String name){
        this.name=name;
        setImage(name+".png");
    }
    public void act(){}
    public void fall(){
        setLocation(getX(), getY() +2);
        if (getY() >= getWorld().getHeight() -1)
        {
        int randomX = (int)(Math.random()*(getWorld().getWidth()) );
        setLocation(randomX, 0);
        }
    }
}
