import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This makes trees appear on each side of the road and random points.
 * it will not allow the trees to spawn on top of eachother or on the road.
 * @author Hubert Jackson Black III
 * @version v0.10
 */
public class Trees  extends Move
{
    /**
     * Act - do whatever the Trees wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() // main for the trees it will keep doing these over and over
    {
        treesMove();
        treesGone();
    }  
    
    public void treesMove() //this moves the trees down the screen. I added a speed still working out bugs to make the trees move faster or slower depending on up or down.
    {
        setLocation(getX(), getY() + speed);   // was trying to adjust speed. work in progress variable does not seem to change.
        checkDoubleTree();
    }
    
     public void checkDoubleTree() // removes trees if they spawn on top of eachother.
     {
         Actor tree = getOneIntersectingObject(Trees.class);
         if(tree != null)
         {
             getWorld().removeObject(tree);
         }
     }
    
     public void treesGone() // removes trees when they reach the bottom of the world.
     {
         if(getY() >= getWorld().getHeight() -1)
         {
             getWorld().removeObject(this);
         }
     }
}

