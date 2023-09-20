import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Randomly has trucks spawn that drive down the road, will not let two trucks spawn on top of eachother
 * also truck will explode if it hits a laser.
 * @author Hubert Jackson Black III
 * @version v0.10
 */
public class Vehicle  extends Move
{
    /**
     * Act - do whatever the Vehicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() // main act checks for collisions, makes trucks drive down scree, and removes them at end of world.
    {
        checkCollision();
        driveDown();
        endOfRoad();
       // checkLaser(); // code for later use.
    } 
    
    public void removeExplosion() // removes explosion from screen after truck blows up.
    {
        getWorld().removeObject(this);
    }
    
    public void driveDown() // moves trucks down the screen at 3 units.
    {
        setLocation(getX(), getY() + 3);
    }
    
    public void checkCollision() // checks if the trucks spawn on top of eachother. will remove one.
    {
        Actor truck = getOneIntersectingObject(Vehicle.class);
        if(truck != null)
        {
            getWorld().removeObject(truck);
        }
     }
     
     public void checkLaser() //removes truck and bomb blows up.
     {
         Laser laser = (Laser) getOneIntersectingObject(Laser.class);
         if(laser != null)
         {
             Explode e = new Explode();
             getWorld().addObject(e, getX(), getY());
             Greenfoot.playSound("bomb.wav");
             Greenfoot.delay(3);
             getWorld().removeObject(e);
             removeExplosion();
         }
     }
     
    public void endOfRoad() // removes truck once it hits end of the world.
    {
        if(getY() >= getWorld().getHeight() -1)
        {
            getWorld().removeObject(this);
        }
        else
        {
            checkLaser();
        }
    }
}
