import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pokemon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pokemon extends Actor
{
    private int hp;
    private int ap;
    private String name;
    private GreenfootImage img;
    private boolean outStatus;
    private Attack attack;
    private String type;

    public Pokemon(int hp, int ap, String name, String attack, String type)
    {
        this.hp = hp;
        this.ap = ap;
        this.name = name;
        this.attack = new Attack(attack);
        this.type = type;
        this.outStatus = false;

        img = new GreenfootImage(name.toLowerCase() + ".png");
        img.scale(200, 200);
        setImage(img);
    }

    public String getType()
    {
        return type;
    }

    public void attack(String attackName, User enemy)
    {
        int damage = getAttackPower(attackName, enemy);
        enemy.getPokemon().takeDamage(damage);
    }

    public void takeDamage(int amount)
    {
        hp = hp - amount;
        if (hp <= 0)
        {
            hp = 0;
            outStatus = true;
            img.setTransparency(70);
        }
    }

    public void heal()
    {
        if (!outStatus)
        {
            hp = hp + 20;
        }
    }

    public void printAttack()
    {
        System.out.println(name + " knows " + attack.getName() + " (power " + attack.getPower() + ")");
    }

    public int getAttackPower(String attackName, User enemy)
    {
        if (!attackName.equals(attack.getName()))
        {
            return 0;
        }

        int damage = ap + attack.getPower();
        String enemyType = enemy.getPokemon().getType();
        if ((type.equals("Fire") && enemyType.equals("Grass"))
            || (type.equals("Water") && enemyType.equals("Fire"))
            || (type.equals("Grass") && enemyType.equals("Water"))
            || (type.equals("Electric") && enemyType.equals("Water")))
        {
            damage = damage * 2;
        }
        return damage;
    }

    public int getHp()
    {
        return hp;
    }

    public int getAp()
    {
        return ap;
    }

    public String getName()
    {
        return name;
    }

    public boolean isOut()
    {
        return outStatus;
    }

    public Attack getAttack()
    {
        return attack;
    }
}
