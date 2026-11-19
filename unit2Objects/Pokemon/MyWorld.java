import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private User player;
    private Computer computer;
    private Pokemon[] team;
    private int waitTimer;
    private boolean gameOver;

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld()
    {
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        team = new Pokemon[4];
        team[0] = new Pokemon(90, 18, "Pikachu", "Thunderbolt", "Electric");
        team[1] = new Pokemon(100, 15, "Charmander", "Ember", "Fire");
        team[2] = new Pokemon(110, 13, "Squirtle", "Water Gun", "Water");
        team[3] = new Pokemon(105, 14, "Bulbasaur", "Vine Whip", "Grass");
        for (int i = 0; i < team.length; i++)
        {
            team[i].getImage().mirrorHorizontally();
        }

        player = new User("Ash");
        player.setPokemon(team[0]);
        addObject(player.getPokemon(), 180, 350);
        addObject(player, 180, 470);

        computer = new Computer("Gary");
        computer.switchPokemon();
        addObject(computer.getPokemon(), 620, 180);
        addObject(computer, 620, 25);

        showText("A = Attack     H = Heal\n1 Pikachu   2 Charmander   3 Squirtle   4 Bulbasaur", 400, 565);
        showText("Your turn!", 560, 400);
        updateHp();
    }

    public void act()
    {
        String key = Greenfoot.getKey();
        if (gameOver)
        {
            return;
        }

        if (waitTimer > 0)
        {
            waitTimer--;
            if (waitTimer == 0)
            {
                computerTurn();
            }
            return;
        }

        if (key != null)
        {
            playerTurn(key);
        }
    }

    private void playerTurn(String key)
    {
        Pokemon mine = player.getPokemon();
        String message;
        if (key.equals("a"))
        {
            message = useAttack(player, computer);
        }
        else if (key.equals("h"))
        {
            player.heal();
            message = player.getName() + "'s " + mine.getName() + " healed 20 HP!";
        }
        else if (key.equals("1") || key.equals("2") || key.equals("3") || key.equals("4"))
        {
            Pokemon chosen = team[Integer.parseInt(key) - 1];
            if (chosen == mine)
            {
                showText(mine.getName() + " is already battling!", 560, 400);
                return;
            }
            player.switchPokemon(chosen);
            message = player.getName() + " sent out " + chosen.getName() + "!";
        }
        else
        {
            return;
        }

        showText(message, 560, 400);
        updateHp();
        if (computer.isEndGame())
        {
            endGame("You win! " + computer.getName() + "'s " + computer.getPokemon().getName() + " is out!");
        }
        else
        {
            waitTimer = 50;
        }
    }

    private void computerTurn()
    {
        Pokemon theirs = computer.getPokemon();
        String message;
        int roll = Greenfoot.getRandomNumber(100);
        if (theirs.getHp() <= 30 && roll < 40)
        {
            computer.heal();
            message = computer.getName() + "'s " + theirs.getName() + " healed 20 HP!";
        }
        else if (roll < 10)
        {
            computer.switchPokemon();
            message = computer.getName() + " sent out " + computer.getPokemon().getName() + "!";
        }
        else
        {
            message = useAttack(computer, player);
        }

        showText(message + "\nYour turn!", 560, 400);
        updateHp();
        if (player.isEndGame())
        {
            endGame("You lose! " + player.getName() + "'s " + player.getPokemon().getName() + " is out!");
        }
    }

    private String useAttack(User attacker, User defender)
    {
        Pokemon pokemon = attacker.getPokemon();
        Attack move = pokemon.getAttack();
        int damage = pokemon.getAttackPower(move.getName(), defender);
        attacker.attack(move.getName(), defender);

        String message = attacker.getName() + "'s " + pokemon.getName() + " used " + move.getName() + "!\n" + damage + " damage";
        if (damage > pokemon.getAp() + move.getPower())
        {
            message = message + ". It's super effective!";
        }
        else
        {
            message = message + "!";
        }
        return message;
    }

    private void updateHp()
    {
        Pokemon mine = player.getPokemon();
        Pokemon theirs = computer.getPokemon();
        showText(mine.getName() + " (" + mine.getType() + ")  HP: " + mine.getHp(), 180, 503);
        showText(theirs.getName() + " (" + theirs.getType() + ")  HP: " + theirs.getHp(), 620, 60);
    }

    private void endGame(String text)
    {
        gameOver = true;
        showText(text + "\nPress Reset to play again.", 400, 300);
        Greenfoot.stop();
    }
}
