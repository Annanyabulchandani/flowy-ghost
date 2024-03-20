import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public static int score;
    public Score()
    {
        score = 0;
    }
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        World myWorld = getWorld();
        myWorld.showText(String.valueOf(score), 580, 20);
    }
    public static void add(int num)
    {
        score += num;
    }
}
