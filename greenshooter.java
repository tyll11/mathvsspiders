import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class greenshooter extends shooter
{   
    
    public greenshooter()
    {
        timer = 10;
        shots = 40;
        setup();
    }
    
    public void act() 
    {
        place();
        shoot(new greenegg());

    }    
}
