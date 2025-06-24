import greenfoot.*;  // (World, Actor, GreenfootImage und Greenfoot)

import java.util.List;
import java.util.ArrayList;

/**
 * Wombat. Ein Wombat bewegt sich vorwärts, bis es nicht mehr weitergeht, und dreht 
 * sich dann nach links. Wenn ein Wombat ein Blatt findet, frisst er es.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Wombat extends Actor
{
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;

    private int direction;
    private int leavesEaten;

    public Wombat()
    {
        setDirection(EAST);
        leavesEaten = 0;
    }

    /**
     * Tut, was immer der Wombat im Moment gerne tun möchte.
     */
    public void act()
    {
        if(foundLeaf()) {
            eatLeaf();
        }
        else if(canMove()) {
            move();
        }
        else {
            turnLeft();
        }
    }

    /**
     * Prüft, ob in der Zelle, in der wir uns befinden, ein Blatt ist.
     */
    public boolean foundLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Frisst ein Blatt.
     */
    public void eatLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            // frisst das Blatt ...
            getWorld().removeObject(leaf);
            leavesEaten = leavesEaten + 1; 
        }
    }
    
    /**
     * Rückt eine Zelle vorwärts in die aktuelle Richtung.
     */
    public void move()
    {
        if (!canMove()) {
            return;
        }
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() + 1);
                break;
            case EAST :
                setLocation(getX() + 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() - 1);
                break;
            case WEST :
                setLocation(getX() - 1, getY());
                break;
        }
    }

    /**
     * Prüft, ob wir uns vorwärts bewegen können. Wenn ja, 
     * liefert die Methode true zurück, andernfalls false.
     */
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }
        // testet, ob der Außenrand erreicht wurde
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }
        return true;
    }

    /**
     * Wendet sich nach links.
     */
    public void turnLeft()
    {
        switch(direction) {
            case SOUTH :
                setDirection(EAST);
                break;
            case EAST :
                setDirection(NORTH);
                break;
            case NORTH :
                setDirection(WEST);
                break;
            case WEST :
                setDirection(SOUTH);
                break;
        }
    }

    /**
     * Setzt die Richtung, in die wir uns bewegen. Der Parameter 'direction' 
     * muss im Bereich[0..3] liegen.
     */
    public void setDirection(int direction)
    {
        if ((direction >= 0) && (direction <= 3)) {
            this.direction = direction;
        }
        switch(direction) {
            case SOUTH :
                setRotation(90);
                break;
            case EAST :
                setRotation(0);
                break;
            case NORTH :
                setRotation(270);
                break;
            case WEST :
                setRotation(180);
                break;
            default :
                break;
        }
    }

    /**
     * Ermittelt, wie viele Blätter wir gefressen haben.
     */
    public int getLeavesEaten()
    {
        return leavesEaten;
    }
}