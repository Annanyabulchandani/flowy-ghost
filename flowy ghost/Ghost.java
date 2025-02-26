import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    private double g = 1; 
    private int y = 300;
    private boolean haspressed = false;
    private boolean isalive = true;
    private boolean isacross = false;
    private boolean hasaddscore = false;
    public Ghost(){
        GreenfootImage image = getImage();
        image.scale(60, 60);
    }
    /**
     * Act - do whatever the Flappybird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(spacePressed())
        {
            g=-2;
        }
        g +=0.1;
        y += g;
        setLocation(getX(), (int)(y));
        if(isTouchpipe())
        {
            isalive = false;
        }
        if(isAtEdge())
        {
            Greenfoot.playSound("womp.mp3");
            isalive = false;
        }
        if(!isalive)
        {
            getWorld().addObject(new Gameover(), 300, 200);
            getWorld().removeObject(this);
        }
        if(!hasaddscore && isacross && isalive){
            Greenfoot.playSound("score.mp3");
            Score.add(1);
        }
        hasaddscore = isacross;
    }
    public boolean spacePressed(){
        boolean pressed = false;
        if(Greenfoot.isKeyDown("space"))
        {
            if(!haspressed)
            {
                Greenfoot.playSound("swish.mp3");
                pressed = true;
            }
            haspressed = true;
        }
        else
        {
            haspressed = false;
        }
        return pressed;
    }
    public boolean isTouchpipe()
    {
        isacross = false;
        for(Pipe pipe : getWorld().getObjects(Pipe.class))
        {
            if(Math.abs(pipe.getX() - getX()) < 60 )
            {
                if(Math.abs(pipe.getY() + 30 - getY()) > 37)
                {
                    Greenfoot.playSound("womp.mp3");
                    isalive = false;
                }
                isacross = true; 
            }
        }
        return !isalive;
    }
}
