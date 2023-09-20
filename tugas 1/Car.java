import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This Class will check to se see if the car hits anything or if the user moves the car around the screen.
 * it will also keep up with the damage done to the car.
 * @author Hubert Jackson Black III
 * @version v0.1
 */
public class Car  extends Move
{
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // instance Variables
    private int damage;
    private int gunDelay;
    private int minGunDelay;

   
    public Car()  // sets damage of the car to 0 also sets gunDelay and minGunDelay. Prob should have made minGunDelay Static in future.
      {
         damage = 0;
         gunDelay = 0;
         minGunDelay = 20;
      }
    
    public void act() // main part of the car that keeps running.
    {
            
        checkKeyPress();
        checkCollision();
    }  
   
    public void checkCollision() // increases damage of car when it hits a Vehicle.
    {
        Actor actor = getOneIntersectingObject(Vehicle.class);
        if (actor != null)
        {
            damage++;
            Greenfoot.playSound("crash.wav");
        }
        if (damage >= 100)
        {
            Greenfoot.stop();
        }
               
    }
    
    public void moveLeft() // moves car left but stops it before it runs off road.
    {
        if(getX() <= 410 && getX() >= 215)
        {
        setLocation(getX() - 2, getY());
        }
    }
    
    public void moveRight()  // moves the car right but stops it before it runs off road.
    {
        if(getX() < 400)
        {
        setLocation(getX() + 2, getY());
        }
    }
    public void moveUp()  // moves car up the screen
    {
        setLocation(getX(), getY() - 2);
    }
    public void moveDown() // moves car down the screen.
    {
        setLocation(getX(), getY() + 2);
    }
    public void fire()
    {
        if(gunDelay >= minGunDelay)   // this lets u fire the gun and sets gun dealy to 0 so it has some interuption.
        {
            Laser b = new Laser();
            getWorld().addObject(b, getX(), getY());
            b.move();
            gunDelay = 0;
        }
    }
    
    public void checkKeyPress()
    {
        if(Greenfoot.isKeyDown("left")) // move car left
        {
            moveLeft();
        }
        if(Greenfoot.isKeyDown("right")) // move car right
        {
            moveRight();
        }
        if(Greenfoot.isKeyDown("up")) // Move car up
        {
           
            moveUp();
        }
        if(Greenfoot.isKeyDown("down")) // Move car down
        {     
            moveDown();
        }
         if(Greenfoot.isKeyDown("space")) //this is my shoot key
         {
            fire();
         }        
        // work in progress i want the car to change and start playing music. it has a problem where it will keep playing the music need some sort of delay.
        String key = Greenfoot.getKey(); 
        if(key != null)
        {
            if(key.equalsIgnoreCase("e"))
            {
                Greenfoot.playSound("spyhunter.wav"); 
            }
        }
        gunDelay++;  //added this for shooting 
    }   
}
