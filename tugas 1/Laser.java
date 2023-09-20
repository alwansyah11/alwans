import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Laser comes from the car and owns anything it hits $$
 * Laser has a set amount of live then it is removed.
 * @author Hubert Jackson Black III
 * @version v0.10
 */
public class Laser  extends Move
{
    // instance varialbe for life of laser.
   private int life;
  
   public Laser() // sets life of laser to 60 
   {
        life = 60;
   }
   
    public void act() // this is so the laser has a limited life before it dissapears off screen.
    {
        if ( life <= 0 )
        {
            getWorld().removeObject(this);
        } 
        else 
        {
            setLocation ( getX(), getY() - 7 );
            life--;
        }  
    }
    
   
    
}
        


