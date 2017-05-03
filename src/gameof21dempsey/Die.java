package gameof21dempsey;
import java.util.Random;
/**
 * The die class simulates a six-sided die
 * @author Allie
 */
public class Die 
{
    private int sides;
    private int value;
    
    /** The constructor performs 
     * the initial roll of die
     * @param numSides 
     */
    public Die(int numSides)
    {
        sides = numSides;
        roll();
    }
    
    /** The roll method simulates the rolling
     * of a die.
     */
    public void roll()
    {
        Random rand = new Random();
        value = rand.nextInt(sides)+ 1;       
    }
    
    /** getSides method
     * @return the number of sides
     */
    public int getSides()
    {
        return sides;
    }
    
    /** getValue method
     * @return the value of the die.
     */
    public int getValue()
    {
        return value;
    }
}
