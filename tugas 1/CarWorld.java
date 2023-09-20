import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CarWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarWorld  extends World
{

    /**
     * Constructor for objects of class CarWorld.
     * 
     */
    public CarWorld()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(600, 600, 1); 
        addObject(new Car(), 305, 550); //will need this later to make car appear.
    }
    
    public void act()
    {
        if(Greenfoot.getRandomNumber(100) < 2) //this will make trucks randomley apear.
        {        
            addObject(new Vehicle(), Greenfoot.getRandomNumber(200) + 200, 0); //this keeps trucks on the road   
        }
        if(Greenfoot.getRandomNumber(10) < 2) //this makes trees randomly appear.
        {
            addObject(new Trees(), Greenfoot.getRandomNumber(170), 0);  // keep them on left hand side of road
            addObject(new Trees(), Greenfoot.getRandomNumber(170) + 440, 0); //keep them on right hand side of road
        }
    }
}
