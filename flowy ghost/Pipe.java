import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pipe extends Actor
{
    public Pipe()
    {
        GreenfootImage img = getImage();
        img.scale(500,900);
    }
    /**
     * Act - do whatever the pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX() - 1, getY());
         if(getX() <= 1)
        {
            setLocation(getX() + 600, Greenfoot.getRandomNumber(175)+50);
        }
    }
}
