import greenfoot.*;  // importiert Actor, World, Greenfoot, GreenfootImage

import java.util.Random;

/**
 * Eine Welt, in der Wombats leben.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class WombatWorld extends World
{
    /**
     * Erzeugt eine neue Welt mit 8x8 Zellen,
     * wobei eine Zelle die Größe von 60x60 Pixel hat.
     */
    public WombatWorld() 
    {
        super(8, 8, 60);        
        setBackground("cell.jpg");
        setPaintOrder(Wombat.class, Leaf.class);
    }

    /**
     * Bevölkert die Welt mit einem vorgegebenen Szenario von Wombats und Blättern.
     */    
    public void populate()
    {
        Wombat w1 = new Wombat();
        addObject(w1, 3, 3);
        
        Wombat w2 = new Wombat();
        addObject(w2, 1, 7);

        Leaf l1 = new Leaf();
        addObject(l1, 5, 3);

        Leaf l2 = new Leaf();
        addObject(l2, 0, 2);

        Leaf l3 = new Leaf();
        addObject(l3, 7, 5);

        Leaf l4 = new Leaf();
        addObject(l4, 2, 6);

        Leaf l5 = new Leaf();
        addObject(l5, 5, 0);
        
        Leaf l6 = new Leaf();
        addObject(l6, 4, 7);
    }
    
    /**
     * Platziert eine Anzahl von Blättern an beliebigen Positionen in der Welt.
     * Die Anzahl der Blätter kann angegeben werden.
     */
    public void randomLeaves(int howMany)
    {
        for(int i=0; i<howMany; i++) {
            Leaf leaf = new Leaf();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(leaf, x, y);
        }
    }
}