import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class redshooter extends shooter
{  
   public redshooter()
   {
       timer = 65;
       shots = 30;
       setup();
   }
    
   public void act() 
   {
       place();
       shoot(new redegg());
   }    
}
